package com.dev.thesisapi.service;

import com.dev.thesisapi.entity.Screen;
import com.dev.thesisapi.repository.ScreenRepository;
import org.springframework.stereotype.Service;

@Service
public class ScreenService {

    private final ScreenRepository screenRepository;

    public ScreenService(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    public Screen getById(Integer screenId) {
        return screenRepository.findById(screenId).orElse(null);
    }
}
