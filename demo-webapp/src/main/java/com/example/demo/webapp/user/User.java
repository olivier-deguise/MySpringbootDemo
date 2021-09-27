package com.example.demo.webapp.user;

import java.util.List;

import com.example.demo.webapp.invoice.Invoice;

import lombok.Data;

@Data
public class User {


	private Long id = 0L;
	
	private String name;
	
	private String city;
	
	private String gender;
	
	private String country;
	
	private String aboutYou;
	
	private Boolean mailingList;
	
	private List<Invoice> invoices;	
	
}