package com.dev.thesisapi.controller.qualitycontrol.result;

import com.dev.thesisapi.dto.qualitycontrol.QualityControlResultListDto;
import com.dev.thesisapi.service.QualityControlResultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/quality-control/result")
public class QualityControlResultController {

    private final QualityControlResultService service;

    public QualityControlResultController(QualityControlResultService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<QualityControlResultListDto> getAll() {
        return service.getAll();
    }

}
