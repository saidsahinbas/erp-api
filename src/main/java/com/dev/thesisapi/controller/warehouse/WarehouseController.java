package com.dev.thesisapi.controller.warehouse;

import com.dev.thesisapi.entity.Warehouse;
import com.dev.thesisapi.service.WarehouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping("/all")
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }
}
