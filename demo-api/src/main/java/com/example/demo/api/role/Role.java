package com.example.demo.api.role;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.api.loginuser.LoginUser;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name="Role")
public class Role implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="username", nullable=false)
    @JsonBackReference
    @Id
	private LoginUser loginUser;
	
	@Column(name="role")
	@Id
	private String role;

}
