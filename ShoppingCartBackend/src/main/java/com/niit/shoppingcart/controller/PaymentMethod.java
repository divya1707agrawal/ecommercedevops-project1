package com.niit.shoppingcart.controller;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class PaymentMethod implements Serializable{

private String methodType;

public String getMethodType() {
	return methodType;
}

public void setMethodType(String methodType) {
	this.methodType = methodType;
}	


}
