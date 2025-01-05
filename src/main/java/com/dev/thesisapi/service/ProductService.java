package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.product.GetAllProductResponseDto;
import com.dev.thesisapi.dto.product.GetProductsBySupplierDto;
import com.dev.thesisapi.dto.product.GetSingleProductDetailDto;
import com.dev.thesisapi.dto.product.ProductCreateDto;
import com.dev.thesisapi.entity.*;
import com.dev.thesisapi.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;
    private final QualityParameterRepository qualityParameterRepository;
    private final ProductSupplierQualityParameterRepository productSupplierQualityParameterRepository;
    private final ProductSupplierService productSupplierService;
    private final DocumentRepository documentRepository;
    private final ProductSupplierRepository productSupplierRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository,
                          SupplierRepository supplierRepository, QualityParameterRepository qualityParameterRepository,
                          ProductSupplierQualityParameterRepository productSupplierQualityParameterRepository,
                          ProductSupplierService productSupplierService, DocumentRepository documentRepository,
                          ProductSupplierRepository productSupplierRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
        this.qualityParameterRepository = qualityParameterRepository;
        this.productSupplierQualityParameterRepository = productSupplierQualityParameterRepository;
        this.productSupplierService = productSupplierService;
        this.documentRepository = documentRepository;
        this.productSupplierRepository = productSupplierRepository;
    }

    public void create(ProductCreateDto productCreateDto) {
        Product product = new Product();
        product.setProductName(productCreateDto.getName());
        product.setCode(productCreateDto.getCode());
        product.setPurchasePrice(productCreateDto.getPurchasePrice());
        product.setSalePrice(productCreateDto.getSalePrice());
        product.setDescription(productCreateDto.getDescription());
        product.setCategory(categoryRepository.findById(productCreateDto.getCategoryId()).get());
        product.setImage1(productCreateDto.getImage1());
        product.setImage2(productCreateDto.getImage2());
        product.setProductStatuses(productCreateDto.getProductStatuses());

        var createdProduct = productRepository.save(product);

        for (Document document : productCreateDto.getDocuments()) {
            document.setProduct(createdProduct);
            documentRepository.save(document);
        }

        for (var supplierId : productCreateDto.getSupplierId()) {
            ProductSupplier productSupplier = new ProductSupplier();
            productSupplier.setProduct(createdProduct);
            productSupplier.setSupplier(supplierRepository.findById(supplierId).get());
            var cretedProductSupplier = productSupplierRepository.save(productSupplier);

            for (var qparams : productCreateDto.getQualityParameterDtoSet()) {
                ProductSupplierQualityParameter productSupplierQualityParameter = new ProductSupplierQualityParameter();
                productSupplierQualityParameter.setCustomValue(qparams.getCustomValue());
                productSupplierQualityParameter.setProductSupplier(cretedProductSupplier);
                if (qparams.getId() != null) {
                    productSupplierQualityParameter.setQualityParameter(qualityParameterRepository.findById(qparams.getId()).get());
                } else {
                    var qparam = new QualityParameter();
                    qparam.setDefaultValue(qparams.getDefaultValue());
                    qparam.setDescription(qparams.getDescription());
                    qparam.setMaxValue(qparams.getMaxValue());
                    qparam.setMinValue(qparams.getMinValue());
                    qparam.setName(qparams.getName());
                    qparam.setProduct(createdProduct);
                    qparam.setValueType(qparams.getValueType());
                    var createdQparam = qualityParameterRepository.save(qparam);

                    productSupplierQualityParameter.setQualityParameter(createdQparam);
                }
                productSupplierQualityParameterRepository.save(productSupplierQualityParameter);
            }
        }
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
                .stream().map(Supplier::getName).collect(Collectors.toSet()));
        return dto;
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    public GetProductsBySupplierDto getProductsBySupplier(String supplierName) {
        var supplierId = supplierRepository.findSupplierIdByName(supplierName);
        var productIds = productSupplierRepository.findProductIdsBySupplierId(supplierId);

        GetProductsBySupplierDto dto = new GetProductsBySupplierDto();
        dto.setSupplierId(supplierId);
        dto.setSupplierName(supplierName);

        List<GetProductsBySupplierDto.ProductListDto> products = productIds.stream().map(productId -> {
            var product = productRepository.findById(productId).get();
            return new GetProductsBySupplierDto.ProductListDto()
                    .setProductId(product.getId())
                    .setProductName(product.getProductName())
                    .setPurchasePrice(product.getPurchasePrice())
                    .setSalePrice(product.getSalePrice())
                    .setCategoryName(product.getCategory().getCategoryName());
        }).toList();
        dto.setProducts(products);
        return dto;
    }
}
