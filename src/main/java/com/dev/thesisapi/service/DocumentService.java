package com.dev.thesisapi.service;

import com.dev.thesisapi.entity.Document;
import com.dev.thesisapi.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> getDocumentsByProduct(Integer productId) {
        return documentRepository.findAllByProductId(productId);
    }
}
