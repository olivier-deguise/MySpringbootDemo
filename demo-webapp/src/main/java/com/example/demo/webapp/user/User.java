package com.example.demo.webapp.user;

import java.util.List;

import com.example.demo.webapp.invoice.Invoice;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class User {


	private Long id=0L;
	
	@NotEmpty(message = "{username.required}")
	@NotNull(message = "{username.required}")
	private String name;
	
	@NotEmpty(message = "{city.required}")
	@NotNull(message = "{city.required}")
	private String city;
	
	private String gender;
	
	private String country;
	
	private String aboutYou;
	
	private Boolean mailingList;
	
	@JsonManagedReference
	private List<Invoice> invoices;	
	
}