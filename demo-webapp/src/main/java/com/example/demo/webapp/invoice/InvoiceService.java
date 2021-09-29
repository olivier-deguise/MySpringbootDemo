package com.example.demo.webapp.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.webapp.invoice.InvoiceService;

import lombok.Data;

@Data
@Service
public class InvoiceService {


    @Autowired
    private InvoiceRepository invoiceProxy;
    
    public Invoice getInvoice(final int id) {
        return invoiceProxy.getInvoice(id);
    }

    public Iterable<Invoice> getInvoices() {
        return invoiceProxy.getInvoices();
    }

    public void deleteInvoice(final long id) {
    	invoiceProxy.deleteInvoice(id);
    }

     public Invoice saveInvoice(Invoice invoice) {
        Invoice savedInvoice;

        if(invoice.getId() == 0) {
            // Si l'id est null, alors c'est un nouvel invoice.
        	savedInvoice = invoiceProxy.createInvoice(invoice);
        } else {
        	savedInvoice = invoiceProxy.updateInvoice(invoice);
        }
    
        return savedInvoice;
    }   
}
