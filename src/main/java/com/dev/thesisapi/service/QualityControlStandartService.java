package com.dev.thesisapi.service;

import com.dev.thesisapi.entity.QualityControlStandard;
import com.dev.thesisapi.repository.QualityControlStandartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualityControlStandartService {

    private final QualityControlStandartRepository qualityControlStandartRepository;

    public QualityControlStandartService(QualityControlStandartRepository qualityControlStandartRepository) {
        this.qualityControlStandartRepository = qualityControlStandartRepository;
    }


    public List<QualityControlStandard> getAllStandards() {
        return qualityControlStandartRepository.findAll();
    }
}
