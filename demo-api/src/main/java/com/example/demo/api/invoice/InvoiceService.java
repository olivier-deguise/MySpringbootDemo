package com.example.demo.api.invoice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class InvoiceService {
	
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Optional<Invoice> getInvoice(final Long id) {
        return invoiceRepository.findById(id);
    }

    public Iterable<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    public void deleteInvoice(final Long id) {
        invoiceRepository.deleteById(id);
    }

    public Invoice saveInvoice(Invoice invoice) {
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return savedInvoice;
    }
}
