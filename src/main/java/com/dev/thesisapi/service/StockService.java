package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.stock.CreateStockRequestDto;
import com.dev.thesisapi.dto.stock.GetAllStockResponseDto;
import com.dev.thesisapi.entity.*;
import com.dev.thesisapi.repository.ProductSupplierRepository;
import com.dev.thesisapi.repository.StockRepository;
import com.dev.thesisapi.repository.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {

    private final StockRepository stockRepository;
    private final ProductSupplierRepository productSupplierRepository;
    private final SupplierRepository supplierRepository;

    public StockService(StockRepository stockRepository, ProductSupplierRepository productSupplierRepository, SupplierRepository supplierRepository) {
        this.stockRepository = stockRepository;
        this.productSupplierRepository = productSupplierRepository;
        this.supplierRepository = supplierRepository;
    }

    public void createStock(CreateStockRequestDto createStockForProductsRequestDto) {

        for (CreateStockRequestDto.ProductDetailDto productDetailDto : createStockForProductsRequestDto.getProductDetails()) {
            // Tedarikçi adını al
            String supplierName = productDetailDto.getSupplierName();

            if (supplierName == null || supplierName.isEmpty()) {
                throw new IllegalArgumentException("Tedarikçi adı boş veya null olamaz: Ürün ID = " + productDetailDto.getProductId());
            }

            // Tedarikçi ID'sini al
            Integer supplier = supplierRepository.findSupplierIdByName(supplierName);

            if (supplier == null) {
                throw new IllegalArgumentException("Tedarikçi bulunamadı: " + supplierName);
            }

            // ProductSupplier eşleşmesini al
            var productSupplier = productSupplierRepository.findByProductIdAndSupplierId(productDetailDto.getProductId(), supplier);

            if (productSupplier == null) {
                throw new IllegalArgumentException("Ürün ve tedarikçi eşleşmesi bulunamadı: Ürün ID = "
                        + productDetailDto.getProductId() + ", Tedarikçi ID = " + supplier);
            }

            // Stock nesnesini oluştur
            Stock stock = new Stock();
            stock.setProductSupplier(productSupplier);
            stock.setQuantity(productDetailDto.getQuantity());
            stock.setCriticalLevel(productDetailDto.getCriticalLevel());

            // Stok durumu belirle
            if (productDetailDto.getQuantity() <= productDetailDto.getCriticalLevel()) {
                stock.setStatus(StockStatus.CRITICAL);
            } else {
                stock.setStatus(StockStatus.NORMAL);
            }
            if (productDetailDto.getQuantity() == 0) {
                stock.setStatus(StockStatus.OUT_OF_STOCK);
            }

            stock.setWarehouse(createStockForProductsRequestDto.getWarehouse());
            stock.setLastUpdated(Instant.now());

            // Stock'u kaydet
            stockRepository.save(stock);
        }
    }


    public List<GetAllStockResponseDto> getStocksByFilter(String productName, String productCode,
                                                          String categoryName, String supplierName,
                                                          String warehouseName) {
        var stocks = stockRepository
                .findBYProductNameAndProductCodeAndCategoryNameAndSupplierNameAndWarehouseName(productName,
                        productCode, categoryName, supplierName, warehouseName);
        return stocks.stream().map(stock -> {
            var productSupplier = stock.getProductSupplier();
            var product = productSupplier.getProduct();
            var category = product.getCategory();
            var supplier = productSupplier.getSupplier();
            var warehouse = stock.getWarehouse();

            return new GetAllStockResponseDto()
                    .setBillNumber(stock.getId())
                    .setWarehouseName(warehouse.getName())
                    .setProductName(product.getProductName())
                    .setQuantity(stock.getQuantity())
                    .setCriticalLevel(stock.getCriticalLevel())
                    .setSupplierName(supplier.getName())
                    .setStatus(stock.getStatus())
                    .setCategoryName(category.getCategoryName());
        }).collect(Collectors.toList());
    }

    public Stock getFirstStockByProductSupplier(ProductSupplier productSupplier) {
        return stockRepository.findFirstByProductSupplier(productSupplier);
    }

    @Transactional
    public void save(Stock stock) {
        stockRepository.save(stock);
    }
}

