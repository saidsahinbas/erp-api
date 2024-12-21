package com.dev.thesisapi.controller.screen;

import com.dev.thesisapi.entity.Screen;
import com.dev.thesisapi.service.ScreenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/screen")
public class ScreenController {
    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @GetMapping("all")
    public List<Screen> getAllScreens() {
        return screenService.getAllScreens();
    }
}
