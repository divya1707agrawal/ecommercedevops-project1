package com.niit.shoppingcart;


import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.niit.shoppingcart.controller.BillingAddress;
import com.niit.shoppingcart.controller.Order;
import com.niit.shoppingcart.controller.OrderDAO;
import com.niit.shoppingcart.controller.PaymentMethod;
import com.niit.shoppingcart.controller.Product;
import com.niit.shoppingcart.controller.ShippingAddress;
@Controller
public class OrderWebflow {

	
	
	@Autowired
	Product product;
    
	@Autowired
	Order order;
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Order initFlow(){
		order=new Order();
		return order;
	}
	
	public String addShippingAddress(Order order,ShippingAddress shippingAddress){
		order.setShippingAddress(shippingAddress);
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(shippingAddress);
		session.flush();
		System.out.println(shippingAddress.getCity());
		System.out.println(shippingAddress.getId());
		return "success";
	}
	
	public String addBillingAddress(Order order,BillingAddress billingAddress){
		order.setBillingAddress(billingAddress);
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(billingAddress);
		session.flush();
		System.out.println(billingAddress.getCity());
		System.out.println(billingAddress.getId());
		
		return "success";
	}
	
	public String addPaymentMethod(Order order,PaymentMethod paymentMethod){
		order.setPaymentMethod(paymentMethod);
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(order);
		session.flush();
		return "success";
		
		
	}
	
}
