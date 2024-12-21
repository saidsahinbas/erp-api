package com.dev.thesisapi.service;

import com.dev.thesisapi.entity.Screen;
import com.dev.thesisapi.repository.ScreenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenService {

    private final ScreenRepository screenRepository;

    public ScreenService(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    public Screen getById(Integer screenId) {
        return screenRepository.findById(screenId).orElse(null);
    }

    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }
}
