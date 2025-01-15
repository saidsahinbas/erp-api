package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.supplier.SupplierDetailDto;
import com.dev.thesisapi.entity.AuthorityGroup;
import com.dev.thesisapi.entity.Document;
import com.dev.thesisapi.entity.DocumentType;
import com.dev.thesisapi.entity.Supplier;
import com.dev.thesisapi.repository.DocumentRepository;
import com.dev.thesisapi.repository.SupplierRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;
    private final DocumentRepository documentRepository;

    public SupplierService(SupplierRepository supplierRepository, DocumentRepository documentRepository) {
        this.supplierRepository = supplierRepository;
        this.documentRepository = documentRepository;
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier findById(Integer supplierId) {
        return supplierRepository.findById(supplierId).orElse(null);
    }

    public void createSupplier(Supplier supplier, MultipartFile[] documents) throws IOException {
        // Save the supplier to the database
        Supplier savedSupplier = supplierRepository.save(supplier);

        // Process and save documents
        if (documents != null) {
            for (MultipartFile document : documents) {
                Document doc = new Document();
                doc.setName(document.getOriginalFilename());
                doc.setContent(document.getBytes());
                doc.setSupplier(savedSupplier);
                doc.setType(determineDocumentType(Objects.requireNonNull(document.getOriginalFilename())));
                documentRepository.save(doc);
            }
        }
    }


    private DocumentType determineDocumentType(String filename) {
        // Logic to determine the document type based on the file extension or name
        if (filename.endsWith(".pdf")) {
            return DocumentType.PDF;
        } else if (filename.endsWith(".xlsx") || filename.endsWith(".xls")) {
            return DocumentType.XLSX;
        }
        else if (filename.endsWith(".docx") || filename.endsWith(".doc")) {
            return DocumentType.DOCX;
        }
        return DocumentType.TEXT;
    }

}
