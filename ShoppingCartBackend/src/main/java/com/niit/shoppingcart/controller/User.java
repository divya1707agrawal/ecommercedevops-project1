package com.niit.shoppingcart.controller;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "user")
@Component
public class User implements Serializable {

	// @OneToOne(mappedBy="MyCart",fetch=FetchType.EAGER)
	// private MyCart myCart;

	@Id
	private int Id;

	// @Min(5)
	// @Max(15)
	private String password;

	@NotEmpty(message = "please enter your name")
	private String name;

	@NotEmpty(message = "please enter your mail id")
	private String mail;

	private String contact;

	private String role;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
