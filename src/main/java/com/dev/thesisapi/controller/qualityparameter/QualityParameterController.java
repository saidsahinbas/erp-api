package com.dev.thesisapi.controller.qualityparameter;

import com.dev.thesisapi.dto.qualityparameter.QualityParameterDto;
import com.dev.thesisapi.entity.QualityParameter;
import com.dev.thesisapi.service.QualityParameterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/qualityparameter")
public class QualityParameterController {

    private final QualityParameterService qualityParameterService;

    public QualityParameterController(QualityParameterService qualityParameterService) {
        this.qualityParameterService = qualityParameterService;
    }

    @GetMapping("all")
    public List<QualityParameter> getAllQualityParameters() {
        return qualityParameterService.getAll();
    }

    @PostMapping("create")
    public ResponseEntity<QualityParameter> createQualityParameter(@RequestBody QualityParameter qualityParameter) {
        qualityParameterService.createQualityParameter(qualityParameter);
        return ResponseEntity.ok(qualityParameter);
    }

    @GetMapping("by-product/{productId}")
    public List<QualityParameterDto> getQualityParametersByProduct(@PathVariable Integer productId) {
        return qualityParameterService.getByProduct(productId);
    }
}

