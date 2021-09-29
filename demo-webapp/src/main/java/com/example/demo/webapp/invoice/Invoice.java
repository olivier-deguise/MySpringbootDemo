package com.example.demo.webapp.invoice;


import lombok.Data;
import com.example.demo.webapp.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
public class Invoice {


	private Long id=0L;
	
	private String semester;
	
	private Double amount;
	
	private String memo;
	
	@JsonBackReference
	private User user;
    
}
