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
@Table(name = "order1")
@Component
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	private String userID;

	@Id
	@Column(name = "id")
	private String orderID;

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="Id",updatable=false,insertable=false,nullable=false)
	 * private BillingAddress billing_address;
	 * 
	 * @OneToOne
	 * 
	 * @JoinColumn(name="Id",updatable=false,insertable=false,nullable=false)
	 * private ShippingAddress shipping_address;
	 */

	@Column(name = "cart_id")
	private int cartId;

	@Column(name = "total_amount")
	private double totalAmount;

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="id", updatable=false,insertable=false,nullable=false)
	 * private PaymentMethod payment_Method;
	 */

	public Order() {
		this.orderID = "SHD_CRT_ORD_" + UUID.randomUUID();
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

	/*
	 * public BillingAddress getBillingAddress() { return billing_address; }
	 * 
	 * public void setBillingAddress(BillingAddress billing_address) {
	 * this.billing_address = billing_address; }
	 * 
	 * public ShippingAddress getShippingAddress() { return shipping_address; }
	 * 
	 * public void setShippingAddress(ShippingAddress shipping_address) {
	 * this.shipping_address = shipping_address; }
	 */

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/*
	 * public PaymentMethod getPaymentMethod() { return payment_Method; }
	 * 
	 * public void setPaymentMethod(PaymentMethod payment_Method) {
	 * this.payment_Method = payment_Method; }
	 */

}
