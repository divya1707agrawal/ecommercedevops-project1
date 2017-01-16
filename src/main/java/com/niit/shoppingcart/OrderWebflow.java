package com.niit.shoppingcart;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.niit.shoppingcart.controller.BillingAddress;
import com.niit.shoppingcart.controller.MyCart;
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
	Order dataorder;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	HttpServletRequest request;
	
	public Order initFlow(){
		dataorder=new Order();
		return dataorder;
	}
	
	Order orderdata;
	public String addShippingAddress(Order order,ShippingAddress shippingAddress){
		//order.setShippingAddress(shippingAddress);
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(shippingAddress);
		
		session.flush();
		System.out.println(shippingAddress.getCity());
		System.out.println(shippingAddress.getId());
		//dataorder.setShippingAddress(order.getShippingAddress());
		HttpSession s=request.getSession();
		   if(s!=null){
			 s.setAttribute("shippingaddress",shippingAddress);
			 System.out.println("shipping address "+shippingAddress);
		   }
		   
		return "success";
	}
	String pid;
	public String addBillingAddress(Order order,BillingAddress billingAddress){
	//	order.setBillingAddress(billingAddress);
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(billingAddress);
		session.flush();
		System.out.println(billingAddress.getCity());
		System.out.println(billingAddress.getId());
		pid=billingAddress.getId();
	//	dataorder.setBillingAddress(order.getBillingAddress());
		
		//dataorder.setShippingAddress(order.getShippingAddress());
				HttpSession s=request.getSession();
				   if(s!=null){
					 s.setAttribute("billingaddress",billingAddress);
					 System.out.println("billing address "+billingAddress);
				   }
				   
		return "success";
	}
	
    String user;
    Integer cart;
    double total;
   ShippingAddress ship;
   BillingAddress bill;
	public String addPaymentMethod(Order order,PaymentMethod paymentMethod)
	{
		System.out.println(paymentMethod.getId());

		HttpSession s=request.getSession();
	   if(s!=null){
		   Integer i=(Integer)s.getAttribute("uid");
		  user=i.toString();
		  cart=(Integer)s.getAttribute("cart_id");
		  total=(Double)s.getAttribute("totalamount");
		  ship=(ShippingAddress)s.getAttribute("shippingaddress");
		bill=(BillingAddress)s.getAttribute("billingaddress");
	   }
	//	paymentMethod.setId(pid);
		paymentMethod.setOrderid(order.getOrderID());
		ship.setOrderid(order.getOrderID());
		bill.setOrderid(order.getOrderID());
		System.out.println(paymentMethod.getOrderid());
		System.out.println(paymentMethod.getMethodtype());
		//order.setPaymentMethod(paymentMethod);
	
		//dataorder.setPaymentMethod(order.getPaymentMethod());
        dataorder.setOrderID(order.getOrderID());
        dataorder.setUserID(user);
        dataorder.setCartId(cart);
		dataorder.setTotalAmount(total);
   //    dataorder.setShippingAddress(ship);
       System.out.println(ship);
		Session session=sessionFactory.openSession();

		session.saveOrUpdate(paymentMethod);
        session.saveOrUpdate(ship);
        session.saveOrUpdate(bill);

		session.saveOrUpdate(dataorder);
		session.flush();
		s.setAttribute("orderconfirmed",paymentMethod.getMethodtype());
		return "success";
		
		
	}
	
}
