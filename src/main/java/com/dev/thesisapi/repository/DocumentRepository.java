package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.Document;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface DocumentRepository extends CrudRepository<Document, Integer> {
    List<Document> findAllByProductId(Integer productId);
}
