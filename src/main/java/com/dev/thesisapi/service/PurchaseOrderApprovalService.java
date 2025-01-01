package com.dev.thesisapi.service;

import com.dev.thesisapi.entity.PurchaseOrderApproval;
import com.dev.thesisapi.repository.PurchaseOrderApprovalRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderApprovalService {
    private final PurchaseOrderApprovalRepository purchaseOrderApprovalRepository;

    public PurchaseOrderApprovalService(PurchaseOrderApprovalRepository purchaseOrderApprovalRepository) {
        this.purchaseOrderApprovalRepository = purchaseOrderApprovalRepository;
    }

    public void save(PurchaseOrderApproval purchaseOrderApproval) {
        purchaseOrderApprovalRepository.save(purchaseOrderApproval);
    }
}
