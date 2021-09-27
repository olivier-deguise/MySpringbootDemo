package com.example.demo.api.invoice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.user.User;

@RestController
public class InvoiceController {

	@Autowired InvoiceService invoiceService;
	

	@PostMapping("/invoice")
	public Invoice createInvoice(@RequestBody Invoice invoice) {
		return invoiceService.saveInvoice(invoice);
	}
	
	@GetMapping("/invoice/{id}")
	public Invoice getInvoice(@PathVariable("id") final Long id) {
		Optional<Invoice> invoice = invoiceService.getInvoice(id);
		if(invoice.isPresent()) {
			return invoice.get();
		} else {
			return null;
		}
	}	
	
	@GetMapping("/invoices")
	public Iterable<Invoice> getInvoices(){
		return invoiceService.getInvoices();
	}
	
	@DeleteMapping("/invoice/{id}")
	public void deleteInvoice(@PathVariable("id") final Long id) {
		invoiceService.deleteInvoice(id);
	}
	
	@PutMapping("/invoice/{id}")
	public Invoice updateInvoice(@PathVariable("id") final Long id, @RequestBody Invoice invoice) {
		Optional<Invoice> u = invoiceService.getInvoice(id);
		if(u.isPresent()) {
			Invoice currentInvoice = u.get();
			
			Double amount = invoice.getAmount();
			if(amount != null) {
				currentInvoice.setAmount(amount);
			}
			String memo = invoice.getMemo();
			if(memo != null) {
				currentInvoice.setMemo(memo);
			}
			String semester = invoice.getSemester();
			if(semester != null) {
				currentInvoice.setSemester(semester);
			}
			User user = invoice.getUser();
			if(user != null) {
				currentInvoice.setUser(user);;
			}
		
			invoiceService.saveInvoice(currentInvoice);
			return currentInvoice;
		} else {
			return null;
		}
	}	
	
	
}
