package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.product.GetAllProductResponseDto;
import com.dev.thesisapi.dto.product.GetSingleProductDetailDto;
import com.dev.thesisapi.dto.product.ProductCreateDto;
import com.dev.thesisapi.entity.Product;
import com.dev.thesisapi.entity.ProductStatus;
import com.dev.thesisapi.entity.ProductSupplier;
import com.dev.thesisapi.entity.Supplier;
import com.dev.thesisapi.repository.CategoryRepository;
import com.dev.thesisapi.repository.ProductRepository;
import com.dev.thesisapi.repository.ProductSupplierRepository;
import com.dev.thesisapi.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    private final ProductSupplierService productSupplierService;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository,
                          SupplierRepository supplierRepository, ProductSupplierService productSupplierService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
        this.productSupplierService = productSupplierService;
    }

    public void create(ProductCreateDto productCreateDto) {
        // Create a new Product object
        Product product = new Product();
        product.setProductName(productCreateDto.getName());
        product.setCode(productCreateDto.getCode());
        product.setPurchasePrice(productCreateDto.getPurchasePrice());
        product.setSalePrice(productCreateDto.getSalePrice());
        product.setDescription(productCreateDto.getDescription());
        product.setCategory(categoryRepository.findById(productCreateDto.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found: " + productCreateDto.getCategoryId())));

        // Set product statuses
        product.setProductStatuses(productCreateDto.getProductStatuses());

        // Handle images
        product.setImage1(productCreateDto.getImage1());
        product.setImage2(productCreateDto.getImage2());

        // Save the product first to generate an ID
        Product savedProduct = productRepository.save(product);

        // Create ProductSupplier relationships
        Set<Supplier> suppliers = new HashSet<>();
        for (Integer supplierId : productCreateDto.getSupplierId()) {
            Supplier supplier = supplierRepository.findById(supplierId)
                    .orElseThrow(() -> new IllegalArgumentException("Supplier not found: " + supplierId));
            suppliers.add(supplier);

            // Create ProductSupplier and save
            ProductSupplier productSupplier = new ProductSupplier(savedProduct, supplier);
            productSupplierService.create(productSupplier); // Use ProductSupplierService to save
        }

        // Set suppliers to product (optional, for consistency in memory)
        savedProduct.setSuppliers(suppliers);
    }


    public List<GetAllProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> {
            GetAllProductResponseDto dto = new GetAllProductResponseDto();
            dto.setId(product.getId());
            dto.setProductName(product.getProductName());
            dto.setCode(product.getCode());
            dto.setPurchasePrice(product.getPurchasePrice());
            dto.setSalePrice(product.getSalePrice());
            dto.setDescription(product.getDescription());
            dto.setCategoryName(product.getCategory().getCategoryName()); // Map category name
            dto.setProductStatuses(product.getProductStatuses()
                    .stream().map(ProductStatus::name).collect(Collectors.toSet())); // Map statuses
            dto.setSupplierNames(product.getSuppliers()
                    .stream().map(Supplier::getName).collect(Collectors.toSet())); // Map suppliers
            return dto;
        }).collect(Collectors.toList());
    }

    public GetSingleProductDetailDto getProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
        GetSingleProductDetailDto dto = new GetSingleProductDetailDto();
        dto.setId(product.getId());
        dto.setProductName(product.getProductName());
        dto.setCode(product.getCode());
        dto.setPurchasePrice(product.getPurchasePrice());
        dto.setSalePrice(product.getSalePrice());
        dto.setDescription(product.getDescription());
        dto.setImage1(product.getImage1());
        dto.setImage2(product.getImage2());
        dto.setCategoryName(product.getCategory().getCategoryName()); // Map category name
        dto.setProductStatuses(product.getProductStatuses()
                .stream().map(ProductStatus::name).collect(Collectors.toSet())); // Map statuses
        dto.setSupplierNames(product.getSuppliers()
                .stream().map(Supplier::getName).collect(Collectors.toSet())); // Map suppliers
        return dto;
    }
}
