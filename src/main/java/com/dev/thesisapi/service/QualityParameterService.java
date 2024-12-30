package com.dev.thesisapi.service;

import com.dev.thesisapi.entity.QualityParameter;
import com.dev.thesisapi.repository.QualityParameterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualityParameterService {

    private final QualityParameterRepository qualityParameterRepository;

    public QualityParameterService(QualityParameterRepository qualityParameterRepository) {
        this.qualityParameterRepository = qualityParameterRepository;
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

}
