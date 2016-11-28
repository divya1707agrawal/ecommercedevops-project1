package com.niit.shoppingcart.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
@Component
public class Product {
	
	@Id
	private String Id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
   private String description;
	
	@Column(name="price")
	private String price;
	
	@Column(name="stock")
	private String stock;
	
public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
@JsonBackReference
	@ManyToOne
	@JoinColumn(name="category_id",updatable=false,insertable=false,nullable=false)
	private Category category;
	
	
	@ManyToOne
	@JoinColumn(name="supplier_id",updatable=false,insertable=false,nullable=false)
	private Supplier supplier;
	
	/*Transient
	 * private MultipartFile image;
	 * 
	 * public MultipartFile getImage(){
	 return image;
	 }
	 public void getImage(MultipartFile image)
	 {
	  this.image=image;
	  }
	  public supplier getSupplier()
	  {*/
	
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
	public Category getCategory()
	{
		return category;
	}
	public void setCategory(Category category)
	{
		this.category=category;
	}
	public void setSupplier(Supplier supplier)
	{
		this.supplier=supplier;
	}
	public Supplier getSupplier()
	{
	return supplier;
	}
}
