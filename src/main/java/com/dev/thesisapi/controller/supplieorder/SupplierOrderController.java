package com.dev.thesisapi.controller.supplieorder;

import com.dev.thesisapi.dto.supplierorder.SupplierOrderFilteredResponseDto;
import com.dev.thesisapi.entity.SupplierOrder;
import com.dev.thesisapi.service.SupplierOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/supplier-order")
public class SupplierOrderController {

    private final SupplierOrderService supplierOrderService;

    public SupplierOrderController(SupplierOrderService supplierOrderService) {
        this.supplierOrderService = supplierOrderService;
    }

    @PostMapping("/filter")
    public List<SupplierOrderFilteredResponseDto> getSupplierOrdersBySupplierAndProduct(@RequestBody Map<String, String> filters) {
        String supplierId = filters.get("supplierId");
        String productId = filters.get("productId");
        if (supplierId == null || productId == null || supplierId.isEmpty() || productId.isEmpty()) {
          return supplierOrderService.getAll();
        }
        Integer supplierIdInt = Integer.parseInt(supplierId);
        Integer productIdInt = Integer.parseInt(productId);
        return supplierOrderService.getSupplierOrdersBySupplierAndProduct(supplierIdInt, productIdInt);
    }

    @GetMapping("/all")
    public List<SupplierOrderFilteredResponseDto> getAll() {
        return supplierOrderService.getAll();
    }
}
