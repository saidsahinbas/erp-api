package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.qualitycontrol.SampleApproveAndRejectSizeByProductDto;
import com.dev.thesisapi.entity.Level;
import com.dev.thesisapi.entity.OrderLine;
import com.dev.thesisapi.entity.QualityControlLevel;
import com.dev.thesisapi.entity.QualityParameter;
import com.dev.thesisapi.repository.QualityControlLevelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QualityControlLevelService {

    private final QualityControlLevelRepository repository;
    private final OrderService orderService;
    private final ProductService productService;
    private final QualityParameterService qualityParameterService;

    public QualityControlLevelService(QualityControlLevelRepository repository, OrderService orderService, ProductService productService, QualityParameterService qualityParameterService) {
        this.repository = repository;
        this.orderService = orderService;
        this.productService = productService;
        this.qualityParameterService = qualityParameterService;
    }


    public List<QualityControlLevel> getAll() {
        return repository.findAll();
    }

    public List<SampleApproveAndRejectSizeByProductDto> defineQualityParametersSampleApproveAndRejectSize(Integer orderId) {
        List<SampleApproveAndRejectSizeByProductDto> sampleApproveAndRejectSizeByProductDtos = new ArrayList<>();

        // Retrieve order and supplier level
        var order = orderService.getOrderById(orderId);
        var supplierLevel = order.getSupplier().getCurrentQualityLevel();

        for (OrderLine orderLine : order.getOrderLineList()) {
            // Ürün ve miktar bilgilerini al
            var quantity = orderLine.getQuantity();
            var product = orderLine.getProduct();

            // Ürün için kalite parametrelerini al
            var qualityParameters = qualityParameterService.getByProduct(product.getId());

            // Miktar 1000'den fazlaysa 1000 gibi davran
            int effectiveQuantity = Math.min(quantity, 1000);

            // Tedarikçi seviyesi ve miktara göre kalite kontrol seviyesini al
            QualityControlLevel qualityControlLevel = repository.findByLevelAndQuantity(supplierLevel, effectiveQuantity);

            if (qualityControlLevel == null) {
                throw new IllegalArgumentException("Quality control level could not be found for quantity: " + effectiveQuantity);
            }

            // Veriyi DTO'ya map et
            SampleApproveAndRejectSizeByProductDto dto = new SampleApproveAndRejectSizeByProductDto();
            dto.setProductId(product.getId());
            dto.setProductName(product.getProductName());
            dto.setSampleSize(qualityControlLevel.getSampleSize());
            dto.setApproveSize(qualityControlLevel.getAcceptedLimit());
            dto.setRejectSize(qualityControlLevel.getRejectedLimit());
            dto.setSupplierLevel(supplierLevel);
            dto.setProductQuantity(quantity); // Orijinal miktarı set ediyoruz
            dto.setQualityParameters(qualityParameters);

            // DTO'yu listeye ekle
            sampleApproveAndRejectSizeByProductDtos.add(dto);
        }

        return sampleApproveAndRejectSizeByProductDtos;
    }

}
