package com.example.demo.webapp.loginuser;

import java.util.List;

import com.example.demo.webapp.role.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
public class LoginUser {

	private String userName;
	
	private String password;
	
	@JsonManagedReference
	private List<Role> roles;	
	
	public String[] getRolesToStringArray() {
		String[] stringArray = new String[this.roles.size()];
		int i = 0;
		for(Role role : this.roles) {
			stringArray[i] = role.getRole();
			i++;
		}
		return stringArray;
	}
}
