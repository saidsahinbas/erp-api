package com.dev.thesisapi.controller;

import com.dev.thesisapi.service.PmmlService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pmml")
public class PmmlController {

    private final PmmlService pmmlService;

    public PmmlController(PmmlService pmmlService) {
        this.pmmlService = pmmlService;
    }

    @PostMapping("predict")
    public Double predict(@RequestBody Double[] features) {
        return pmmlService.predict(features);
    }
}
