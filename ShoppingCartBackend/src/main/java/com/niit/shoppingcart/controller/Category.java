package com.niit.shoppingcart.controller;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;




@Entity
@Table
@Component
public class Category {
	@Id
	private String Id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
   private String description;
	@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
private Set<Product> product;

	public Set<Product> getProducts(){
		return product;
	
	}
 public void setProducts(Set<Product> product){
	 this.product=product;
 }
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString()
	{
		 return "{"+Id+","+name+","+description+"}";
	}
	}
	

