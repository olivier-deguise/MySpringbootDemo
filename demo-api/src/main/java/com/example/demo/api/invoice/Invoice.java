package com.example.demo.api.invoice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.api.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;


@Data
@Entity
@Table(name="Invoice")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope=Invoice.class)
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="invoiceID")
	private Long id=0L;
	
	@Column(name="semester")
	private String semester;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="memo")
	private String memo;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userID", nullable=false)
    @JsonBackReference
	private User user;
    
}
