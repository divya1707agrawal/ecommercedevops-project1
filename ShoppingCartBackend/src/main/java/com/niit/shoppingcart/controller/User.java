package com.niit.shoppingcart.controller;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="User")
@Component
public class User {

	@Id
	private String id;
	
	@Min(5)
	@Max(15)
	private String password;
	
	@NotEmpty(message="please enter your name")
	private String name;
	
	@NotEmpty(message="please enter your mail id")
	private String mail;
	private String contact;
	private String role;
	
	public String getRole(){
		return role;
	}
	public void setRole(String role){
		this.role=role;
	}
	public String getPassword(){
		return password;
	}
}
