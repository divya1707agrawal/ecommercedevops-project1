package com.niit.shoppingcart;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingcart.controller.BillingAddress;
import com.niit.shoppingcart.controller.Order;
import com.niit.shoppingcart.controller.PaymentMethod;
import com.niit.shoppingcart.controller.Product;
import com.niit.shoppingcart.controller.ShippingAddress;

public class OrderWebflow {

	@Autowired
	 HttpSession httpSession;
	
	@Autowired
	Product product;
	Order order;
	public Order initFlow(){
		order=new Order();
		return order;
	}
	
	public String addShippingAddress(Order order,ShippingAddress shippingAddress){
		order.setShippingAddress(shippingAddress);
		return "success";
	}
	
	public String addBillingAddress(Order order,BillingAddress billingAddress){
		order.setBillingAddress(billingAddress);
		return "success";
	}
	
	public String addpaymentMethod(Order order,PaymentMethod paymentMethod){
		order.setPaymentMethod(paymentMethod);
		return "success";
	}
}
