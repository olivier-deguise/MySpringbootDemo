package com.example.demo.webapp.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.webapp.configuration.CustomProperties;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class InvoiceRepository {
	
    @Autowired
    private CustomProperties props;
    
    public Iterable<Invoice> getInvoices() {
        String baseApiUrl = props.getApiUrl();
        String getInvoicesUrl = baseApiUrl + "/invoices";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Invoice>> response = restTemplate.exchange(
        		getInvoicesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Invoice>>() {}
                );

        log.debug("Get Invoices call " + response.getStatusCode().toString());
        
        return response.getBody();
    }
    
	public Invoice getInvoice(int id) {
		String baseApiUrl = props.getApiUrl();
		String getInvoicesUrl = baseApiUrl + "/invoice/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Invoice> response = restTemplate.exchange(
				getInvoicesUrl, 
				HttpMethod.GET, 
				null,
				Invoice.class
			);
		
		log.debug("Get Invoice call " + response.getStatusCode().toString());
		
		return response.getBody();
	}    
    
    public Invoice createInvoice(Invoice u) {
        String baseApiUrl = props.getApiUrl();
        String createInvoiceUrl = baseApiUrl + "/invoice";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Invoice> request = new HttpEntity<Invoice>(u);
        ResponseEntity<Invoice> response = restTemplate.exchange(
        	createInvoiceUrl,
            HttpMethod.POST,
            request,
            Invoice.class);

        log.debug("Create Invoice call " + response.getStatusCode().toString());

        return response.getBody();
    }
    
	public Invoice updateInvoice(Invoice u) {
		String baseApiUrl = props.getApiUrl();
		String updateInvoiceUrl = baseApiUrl + "/invoice/" + u.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Invoice> request = new HttpEntity<Invoice>(u);
		ResponseEntity<Invoice> response = restTemplate.exchange(
				updateInvoiceUrl, 
				HttpMethod.PUT, 
				request, 
				Invoice.class);
		
		log.debug("Update Invoice call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public void deleteInvoice(long id) {
		String baseApiUrl = props.getApiUrl();
		String deleteInvoiceUrl = baseApiUrl + "/invoice/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteInvoiceUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		log.debug("Delete Invoice call " + response.getStatusCode().toString());
	}	    

}
