package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.supplierorder.SupplierOrderFilteredResponseDto;
import com.dev.thesisapi.entity.OrderStatus;
import com.dev.thesisapi.entity.SupplierOrder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PredictionService {

    private final SupplierOrderService supplierOrderService;

    public PredictionService(SupplierOrderService supplierOrderService) {
        this.supplierOrderService = supplierOrderService;
    }

    public Object filterAndCalculate(String supplierId, String productId) {
        if (supplierId != null && productId != null) {
            // İki parametre verilirse tek bir sonuç döndür
            return processSupplierAndProduct(Integer.parseInt(supplierId), Integer.parseInt(productId));
        } else if (productId != null) {
            // Sadece ürün ID'si verilirse liste döndür
            return processByProduct(Integer.parseInt(productId));
        } else if (supplierId != null) {
            // Sadece tedarikçi ID'si verilirse liste döndür
            return processBySupplier(Integer.parseInt(supplierId));
        } else {
            throw new IllegalArgumentException("Either supplierId or productId must be provided");
        }
    }


    private Map<String, Object> processSupplierAndProduct(Integer supplierId, Integer productId) {
        // Siparişleri al
        List<SupplierOrderFilteredResponseDto> orders = supplierOrderService.getSupplierOrdersBySupplierAndProduct(supplierId, productId);

        if (orders.isEmpty()) {
            throw new IllegalArgumentException("No orders found for the given supplierId and productId");
        }

        // Tüm siparişlerin metriklerini toplayarak tek bir sonuç üret
        return calculateMetricsForSingleResult(orders);
    }

    private List<Map<String, Object>> processByProduct(Integer productId) {
        List<SupplierOrder> orders = supplierOrderService.getOrdersByProduct(productId);
        return groupAndCalculateMetrics(orders, SupplierOrder::getSupplier, this::calculateMetricsForSupplier);
    }

    private List<Map<String, Object>> processBySupplier(Integer supplierId) {
        List<SupplierOrder> orders = supplierOrderService.getOrdersBySupplier(supplierId);
        return groupAndCalculateMetrics(orders, SupplierOrder::getProduct, this::calculateMetricsForProduct);
    }

    private <T> List<Map<String, Object>> groupAndCalculateMetrics(List<SupplierOrder> orders,
                                                                   java.util.function.Function<SupplierOrder, T> classifier,
                                                                   java.util.function.Function<List<SupplierOrder>, Map<String, Object>> calculator) {
        return orders.stream()
                .collect(Collectors.groupingBy(classifier))
                .values()
                .stream()
                .map(calculator)
                .toList();
    }

    // Yeni bir metrik hesaplama metodu (tek sonuç için)
    private Map<String, Object> calculateMetricsForSingleResult(List<SupplierOrderFilteredResponseDto> orders) {
        int totalOrderCount = orders.size();
        int totalSuccessOrderCount = (int) orders.stream()
                .filter(order -> order.getSupplierOrder().getTotalOrderAcceptedCount() > 0)
                .count();
        int sampleSize = orders.stream()
                .mapToInt(order -> order.getSupplierOrder().getSampleSize())
                .sum();
        int successSampleSize = orders.stream()
                .mapToInt(order -> order.getSupplierOrder().getAcceptedSize())
                .sum();

        // "Order status" hesaplaması (örnek olarak son siparişe bakılabilir)
        int orderStatus1 = totalSuccessOrderCount > 0 ? 1 : 0;
        int orderStatus2 = totalSuccessOrderCount > 1 ? 1 : 0;
        int orderStatus3 = totalSuccessOrderCount > 2 ? 1 : 0;

        return Map.of(
                "total_order_count", totalOrderCount,
                "total_success_order_count", totalSuccessOrderCount,
                "sample_size", sampleSize,
                "success_sample_size", successSampleSize,
                "order_status_1", orderStatus1,
                "order_status_2", orderStatus2,
                "order_status_3", orderStatus3
        );
    }

    private Map<String, Object> calculateMetrics(SupplierOrderFilteredResponseDto order) {
        return Map.of(
                "total_order_count", order.getSupplierOrder().getTotalOrderCount(),
                "total_success_order_count", order.getSupplierOrder().getTotalOrderAcceptedCount(),
                "sample_size", order.getSupplierOrder().getSampleSize(),
                "success_sample_size", order.getSupplierOrder().getAcceptedSize(),
                "order_status_1", order.getSupplierOrder().getTotalOrderAcceptedCount() > 0 ? 1 : 0,
                "order_status_2", order.getSupplierOrder().getTotalOrderAcceptedCount() > 1 ? 1 : 0,
                "order_status_3", order.getSupplierOrder().getTotalOrderAcceptedCount() > 2 ? 1 : 0
        );
    }

    private Map<String, Object> calculateMetricsForSupplier(List<SupplierOrder> orders) {
        return Map.of(
                "supplier_name", orders.get(0).getSupplier().getName(),
                "total_order_count", orders.size(),
                "total_success_order_count", orders.stream().filter(o -> OrderStatus.COMPLETED.equals(o.getStatus())).count(),
                "sample_size", orders.stream().mapToInt(SupplierOrder::getSampleSize).sum(),
                "success_sample_size", orders.stream().mapToInt(SupplierOrder::getAcceptedSize).sum()
        );
    }

    private Map<String, Object> calculateMetricsForProduct(List<SupplierOrder> orders) {
        return Map.of(
                "product_name", orders.get(0).getProduct().getProductName(),
                "total_order_count", orders.size(),
                "total_success_order_count", orders.stream().filter(o -> OrderStatus.COMPLETED.equals(o.getStatus())).count(),
                "sample_size", orders.stream().mapToInt(SupplierOrder::getSampleSize).sum(),
                "success_sample_size", orders.stream().mapToInt(SupplierOrder::getAcceptedSize).sum()
        );
    }
}