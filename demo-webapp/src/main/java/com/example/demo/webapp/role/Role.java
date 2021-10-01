package com.example.demo.webapp.role;

import com.example.demo.webapp.loginuser.LoginUser;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
public class Role {

    @JsonBackReference
	private LoginUser loginUser;
	
	private String role;
}
