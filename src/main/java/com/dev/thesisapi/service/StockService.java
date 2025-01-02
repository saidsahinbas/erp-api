package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.stock.CreateStockRequestDto;
import com.dev.thesisapi.entity.*;
import com.dev.thesisapi.repository.ProductSupplierRepository;
import com.dev.thesisapi.repository.StockRepository;
import com.dev.thesisapi.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

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

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
}

