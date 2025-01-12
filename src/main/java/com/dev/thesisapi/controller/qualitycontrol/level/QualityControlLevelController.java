package com.dev.thesisapi.controller.qualitycontrol.level;

import com.dev.thesisapi.dto.qualitycontrol.SampleApproveAndRejectSizeByProductDto;
import com.dev.thesisapi.entity.QualityControlLevel;
import com.dev.thesisapi.service.QualityControlLevelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quality-control/level")
public class QualityControlLevelController {

    private final QualityControlLevelService service;

    public QualityControlLevelController(QualityControlLevelService service) {
        this.service = service;
    }

    @GetMapping("/table")
    public List<QualityControlLevel> getAll() {
        return service.getAll();
    }

    @GetMapping("/define/{orderId}")
    public List<SampleApproveAndRejectSizeByProductDto> defineQualityParametersSampleApproveAndRejectSize(@PathVariable Integer orderId) {
        return service.defineQualityParametersSampleApproveAndRejectSize(orderId);
    }
}