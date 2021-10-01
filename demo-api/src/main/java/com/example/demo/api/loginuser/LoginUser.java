package com.example.demo.api.loginuser;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.api.role.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name="LoginUser")
public class LoginUser {
	
	@Id
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy="loginUser", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	@JsonManagedReference
	private List<Role> roles;

}
