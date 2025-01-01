package com.dev.thesisapi.controller.document;

import com.dev.thesisapi.entity.Document;
import com.dev.thesisapi.service.DocumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/document")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/by-product/{productId}")
    public List<Document> getDocumentsByProduct(@PathVariable Integer productId) {
        return documentService.getDocumentsByProduct(productId);
    }
}
