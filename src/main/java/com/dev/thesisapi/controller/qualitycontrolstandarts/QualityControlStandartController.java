package com.dev.thesisapi.controller.qualitycontrolstandarts;

import com.dev.thesisapi.entity.QualityControlStandard;
import com.dev.thesisapi.service.QualityControlStandartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/qualitycontrolstandart")
public class QualityControlStandartController {

    private final QualityControlStandartService qualityControlStandartService;

    public QualityControlStandartController(QualityControlStandartService qualityControlStandartService) {
        this.qualityControlStandartService = qualityControlStandartService;
    }

    @GetMapping("/all")
    public List<QualityControlStandard> getAllStandards() {
        return qualityControlStandartService.getAllStandards();
    }
}
