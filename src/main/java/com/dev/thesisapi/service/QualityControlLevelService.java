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

    public List<SampleApproveAndRejectSizeByProductDto>     defineQualityParametersSampleApproveAndRejectSize(Integer orderId) {
        List<SampleApproveAndRejectSizeByProductDto> sampleApproveAndRejectSizeByProductDtos = new ArrayList<>();

        // Retrieve order and supplier level
        var order = orderService.getOrderById(orderId);
        var supplierLevel = order.getSupplier().getCurrentQualityLevel();

        for (OrderLine orderLine : order.getOrderLineList()) {
            var quantity = orderLine.getQuantity();
            var product = orderLine.getProduct();

            // Retrieve quality parameters for the product
            var qualityParameters = qualityParameterService.getByProduct(product.getId());

            // Retrieve the quality control level for the supplier level and quantity
            QualityControlLevel qualityControlLevel = repository.findByLevelAndQuantity(supplierLevel, quantity);

            if (qualityControlLevel != null) {
                // Map the retrieved data to the DTO
                SampleApproveAndRejectSizeByProductDto dto = new SampleApproveAndRejectSizeByProductDto();
                dto.setProductId(product.getId());
                dto.setProductName(product.getProductName());
                dto.setSampleSize(qualityControlLevel.getSampleSize());
                dto.setApproveSize(qualityControlLevel.getAcceptedLimit());
                dto.setRejectSize(qualityControlLevel.getRejectedLimit());
                dto.setSupplierLevel(supplierLevel);
                dto.setProductQuantity(quantity);
                dto.setQualityParameters(qualityParameters);
                sampleApproveAndRejectSizeByProductDtos.add(dto);
            }
        }

        return sampleApproveAndRejectSizeByProductDtos;
    }
}
