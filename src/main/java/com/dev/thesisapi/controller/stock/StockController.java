package com.dev.thesisapi.controller.stock;

import com.dev.thesisapi.dto.stock.CreateStockRequestDto;
import com.dev.thesisapi.dto.stock.GetAllStockResponseDto;
import com.dev.thesisapi.entity.Stock;
import com.dev.thesisapi.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/create")
    public ResponseEntity<Stock> createStock(@RequestBody CreateStockRequestDto createStockForProductsRequestDto) {
        stockService.createStock(createStockForProductsRequestDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/filter")
    public List<GetAllStockResponseDto> getStocksByFilter(@RequestBody Map<String, String> filters) {
        String productName = filters.get("productName");
        String productCode = filters.get("productCode");
        String categoryName = filters.get("categoryName");
        String supplierName = filters.get("supplierName");
        String warehouseName = filters.get("warehouseName");

        return stockService.getStocksByFilter(productName, productCode, categoryName, supplierName, warehouseName);
    }
}
