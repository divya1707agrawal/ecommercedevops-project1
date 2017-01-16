package com.niit.shoppingcart.controller;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
@Component
public class Supplier {

	@Id
	private String id;

	private String name;

	private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@JsonManagedReference
	@OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
	private Set<Product> productlist;

	public Set<Product> getProductList() {
		return productlist;
	}

	public void setProduct(Set<Product> productlist) {
		this.productlist = productlist;
	}
}
