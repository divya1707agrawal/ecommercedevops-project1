package com.niit.shoppingcart.controller;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name="my_cart")
@Component
public class MyCart implements Serializable{
	
@Id
@GeneratedValue(strategy=Generation Type.AUTO)
private int id;
@Column(name="product_name")
private String productName;
private char status;
@Transient
@Column(name="add_date")
private Date addedDate;
@Column(name="user_id")
private String userID;
private int price;

public int getId(){
	return id;
}
 public void setId(int id){
	 this.id=id;
 }
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public char getStatus() {
	return status;
}
public void setStatus(char status) {
	this.status = status;
}
public Date getAddedDate() {
	return addedDate;
}
public void setAddedDate(Date addedDate) {
	this.addedDate = addedDate;
}
 public String getUserID(){
	 return userID;
 }
 public void serUserID(String userID){
	 this.userID=userID;
 }
 public int getPrice(){
	 return price;
 }
 public void setPrice(int price){
	 this.price=price;
 }

}
