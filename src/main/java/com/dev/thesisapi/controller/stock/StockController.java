package com.dev.thesisapi.controller.stock;

import com.dev.thesisapi.dto.stock.CreateStockRequestDto;
import com.dev.thesisapi.entity.Stock;
import com.dev.thesisapi.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }
}
