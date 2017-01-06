package com.niit.shoppingcart.controller;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="order1")
@Component
public class Order implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="user_id")
	private String userID;
	
	@Id
	@Column(name="ID")
	private String orderID;
	
	@OneToOne
	@JoinColumn(name="Id",updatable=false,insertable=false,nullable=false)
	private BillingAddress billing_address;
	
	@OneToOne
	@JoinColumn(name="Id",updatable=false,insertable=false,nullable=false)
	private ShippingAddress shipping_address;
	
	
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name="id",updatable=false,insertable=false,nullable=false)
		private MyCart myCart;
	
	@Column(name="total_amount")
	private long totalAmount;
	
	@Column(name="payment_method")
	private PaymentMethod  paymentMethod;
	
	public Order()
	{
	this.orderID="SHD_CRT_ORD_"+UUID.randomUUID();	
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public BillingAddress getBillingAddress() {
		return billing_address;
	}

	public void setBillingAddress(BillingAddress billing_address) {
		this.billing_address = billing_address;
	}

	public ShippingAddress getShippingAddress() {
		return shipping_address;
	}

	public void setShippingAddress(ShippingAddress shipping_address) {
		this.shipping_address = shipping_address;
	}

	public MyCart getMyCart() {
		return myCart;
	}

	public void setMyCart(MyCart myCart) {
		this.myCart = myCart;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	
	
}
