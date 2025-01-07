package com.dev.thesisapi.entity.util;

import com.dev.thesisapi.entity.QualityControlStandard;
import com.dev.thesisapi.repository.QualityControlStandartRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializerForQualityControlStandart implements CommandLineRunner {
    private final QualityControlStandartRepository repository;

    public DataInitializerForQualityControlStandart(QualityControlStandartRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        // Check if the table already has data
        if (repository.count() == 0) {
            // Insert initial data only if the table is empty
            repository.save(new QualityControlStandard(1, 2, 8, 2, 0, 1, 3, 0, 1, 5, 0, 1, 8, 1, 2));
            repository.save(new QualityControlStandard(2, 9, 15, 2, 0, 1, 3, 0, 1, 5, 1, 2, 8, 1, 2));
            repository.save(new QualityControlStandard(3, 16, 25, 3, 0, 1, 5, 0, 2, 8, 1, 2, 13, 1, 2));
            repository.save(new QualityControlStandard(4, 26, 50, 5, 1, 2, 8, 1, 2, 13, 1, 2, 20, 2, 3));
            repository.save(new QualityControlStandard(5, 51, 90, 5, 1, 2, 8, 1, 2, 13, 2, 3, 20, 3, 4));
            repository.save(new QualityControlStandard(6, 91, 150, 8, 1, 2, 13, 2, 3, 20, 3, 4, 32, 5, 6));
            repository.save(new QualityControlStandard(7, 151, 280, 13, 2, 3, 20, 3, 4, 32, 5, 6, 50, 7, 8));
            repository.save(new QualityControlStandard(8, 281, 500, 20, 3, 4, 32, 5, 6, 50, 7, 8, 80, 10, 11));
            repository.save(new QualityControlStandard(9, 501, 1000, 32, 5, 6, 50, 7, 8, 80, 10, 11, 125, 14, 15));
            System.out.println("Initial data loaded into the database.");
        } else {
            System.out.println("Data already exists in the database. Skipping initialization.");
        }
    }
}


