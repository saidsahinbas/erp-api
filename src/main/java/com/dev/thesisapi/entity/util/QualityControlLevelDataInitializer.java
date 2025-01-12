package com.dev.thesisapi.entity.util;

import com.dev.thesisapi.entity.Level;
import com.dev.thesisapi.entity.QualityControlLevel;
import com.dev.thesisapi.repository.QualityControlLevelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QualityControlLevelDataInitializer implements CommandLineRunner {
    private final QualityControlLevelRepository repository;

    public QualityControlLevelDataInitializer(QualityControlLevelRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            // 2-8 arası
            repository.save(new QualityControlLevel(2, 8, Level.LEVEL_1, 2, 0, 1));
            repository.save(new QualityControlLevel(2, 8, Level.LEVEL_2, 3, 0, 1));
            repository.save(new QualityControlLevel(2, 8, Level.LEVEL_3, 5, 0, 1));
            repository.save(new QualityControlLevel(2, 8, Level.LEVEL_4, 8, 1, 2));

            // 9-15 arası
            repository.save(new QualityControlLevel(9, 15, Level.LEVEL_1, 2, 0, 1));
            repository.save(new QualityControlLevel(9, 15, Level.LEVEL_2, 3, 0, 1));
            repository.save(new QualityControlLevel(9, 15, Level.LEVEL_3, 5, 1, 2));
            repository.save(new QualityControlLevel(9, 15, Level.LEVEL_4, 8, 1, 2));

            // 16-25 arası
            repository.save(new QualityControlLevel(16, 25, Level.LEVEL_1, 3, 0, 1));
            repository.save(new QualityControlLevel(16, 25, Level.LEVEL_2, 5, 0, 2));
            repository.save(new QualityControlLevel(16, 25, Level.LEVEL_3, 8, 1, 2));
            repository.save(new QualityControlLevel(16, 25, Level.LEVEL_4, 13, 1, 2));

            // 26-50 arası
            repository.save(new QualityControlLevel(26, 50, Level.LEVEL_1, 5, 1, 2));
            repository.save(new QualityControlLevel(26, 50, Level.LEVEL_2, 8, 1, 2));
            repository.save(new QualityControlLevel(26, 50, Level.LEVEL_3, 13, 1, 2));
            repository.save(new QualityControlLevel(26, 50, Level.LEVEL_4, 20, 2, 3));

            // 51-90 arası
            repository.save(new QualityControlLevel(51, 90, Level.LEVEL_1, 5, 1, 2));
            repository.save(new QualityControlLevel(51, 90, Level.LEVEL_2, 8, 1, 2));
            repository.save(new QualityControlLevel(51, 90, Level.LEVEL_3, 13, 2, 3));
            repository.save(new QualityControlLevel(51, 90, Level.LEVEL_4, 20, 3, 4));

            // 91-150 arası
            repository.save(new QualityControlLevel(91, 150, Level.LEVEL_1, 8, 1, 2));
            repository.save(new QualityControlLevel(91, 150, Level.LEVEL_2, 13, 2, 3));
            repository.save(new QualityControlLevel(91, 150, Level.LEVEL_3, 20, 3, 4));
            repository.save(new QualityControlLevel(91, 150, Level.LEVEL_4, 32, 5, 6));

            // 151-280 arası
            repository.save(new QualityControlLevel(151, 280, Level.LEVEL_1, 13, 2, 3));
            repository.save(new QualityControlLevel(151, 280, Level.LEVEL_2, 20, 3, 4));
            repository.save(new QualityControlLevel(151, 280, Level.LEVEL_3, 32, 5, 6));
            repository.save(new QualityControlLevel(151, 280, Level.LEVEL_4, 50, 7, 8));

            // 281-500 arası
            repository.save(new QualityControlLevel(281, 500, Level.LEVEL_1, 20, 3, 4));
            repository.save(new QualityControlLevel(281, 500, Level.LEVEL_2, 32, 5, 6));
            repository.save(new QualityControlLevel(281, 500, Level.LEVEL_3, 50, 7, 8));
            repository.save(new QualityControlLevel(281, 500, Level.LEVEL_4, 80, 10, 11));

            // 501-1000 arası
            repository.save(new QualityControlLevel(501, 1000, Level.LEVEL_1, 32, 5, 6));
            repository.save(new QualityControlLevel(501, 1000, Level.LEVEL_2, 50, 7, 8));
            repository.save(new QualityControlLevel(501, 1000, Level.LEVEL_3, 80, 10, 11));
            repository.save(new QualityControlLevel(501, 1000, Level.LEVEL_4, 125, 14, 15));

            System.out.println("Initial quality control levels data loaded into the database.");
        } else {
            System.out.println("Data already exists in the database. Skipping initialization.");
        }
    }
}

