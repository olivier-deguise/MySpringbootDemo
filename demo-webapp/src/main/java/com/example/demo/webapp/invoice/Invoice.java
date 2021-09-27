package com.example.demo.webapp.invoice;


import lombok.Data;
import com.example.demo.webapp.user.User;

@Data
public class Invoice {


	private Long id;
	
	private String semester;
	
	private Double amount;
	
	private String memo;
	
	private User user;
    
}
