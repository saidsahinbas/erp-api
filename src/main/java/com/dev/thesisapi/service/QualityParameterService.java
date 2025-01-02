package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.qualityparameter.QualityParameterDto;
import com.dev.thesisapi.entity.ProductSupplier;
import com.dev.thesisapi.entity.QualityParameter;
import com.dev.thesisapi.repository.ProductSupplierQualityParameterRepository;
import com.dev.thesisapi.repository.ProductSupplierRepository;
import com.dev.thesisapi.repository.QualityParameterRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QualityParameterService {

    private final QualityParameterRepository qualityParameterRepository;
    private final ProductSupplierRepository productSupplierRepository;
    private final ProductSupplierQualityParameterRepository productSupplierQualityParameterRepository;

    public QualityParameterService(QualityParameterRepository qualityParameterRepository,
                                   ProductSupplierRepository productSupplierRepository,
                                   ProductSupplierQualityParameterRepository productSupplierQualityParameterRepository) {
        this.qualityParameterRepository = qualityParameterRepository;
        this.productSupplierRepository = productSupplierRepository;
        this.productSupplierQualityParameterRepository = productSupplierQualityParameterRepository;
    }

    public List<QualityParameter> getAll() {
        return qualityParameterRepository.findAll();
    }


    public QualityParameter getQualityParameter(Integer id) {
        return qualityParameterRepository.findById(id).orElse(null);
    }

    public void createQualityParameter(QualityParameter qualityParameter) {
        qualityParameterRepository.save(qualityParameter);
    }

    public List<QualityParameterDto> getByProduct(Integer productId) {
        // Step 1: Fetch all product_supplier_ids for the given productId
        List<Integer> productSupplierIds = productSupplierRepository.findByProductId(productId)
                .stream()
                .map(ProductSupplier::getId)
                .collect(Collectors.toList());

        if (productSupplierIds.isEmpty()) {
            return Collections.emptyList();
        }

        // Step 2: Fetch all quality_parameter_ids from product_supplier_quality_parameter table
        List<Integer> qualityParameterIds = productSupplierQualityParameterRepository.findByProductSupplierIdIn(productSupplierIds)
                .stream()
                .map(productSupplierQualityParameter -> productSupplierQualityParameter.getQualityParameter().getId())
                .collect(Collectors.toList());

        if (qualityParameterIds.isEmpty()) {
            return Collections.emptyList();
        }

        return qualityParameterRepository.findAllById(qualityParameterIds)
                .stream()
                .map(qp -> new QualityParameterDto(
                        qp.getId(),
                        qp.getName(),
                        qp.getDescription(),
                        qp.getDefaultValue(),
                        qp.getMinValue(),
                        qp.getMaxValue()
                ))
                .collect(Collectors.toList());
    }


}
