package com.dev.thesisapi.controller.qualitycontrol.result;

import com.dev.thesisapi.dto.qualitycontrol.QualityControlResultListDto;
import com.dev.thesisapi.dto.qualitycontrol.QualityTestResultInfoFromFrontendDto;
import com.dev.thesisapi.service.QualityControlResultService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save-result")
    public void saveResult(@RequestBody QualityTestResultInfoFromFrontendDto qualityTestResultInfoFromFrontendDto) {
        service.saveResult(qualityTestResultInfoFromFrontendDto);
    }
}
