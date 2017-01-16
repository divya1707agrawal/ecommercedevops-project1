package com.niit.shoppingcart.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentMethodDAOImpl implements PaymentMethodDAO {

	@Autowired
	SessionFactory factory;
	@Autowired
	ProductDAO pr;

	public List getPaymentStatus() {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Query query = session.createQuery("from PaymentMethod");
		return query.list();

	}

	PaymentMethod paymentmethod;

	public String update(String id) {
		try {
			Session session = factory.openSession();
			paymentmethod = (PaymentMethod) session.get(PaymentMethod.class, id);
			paymentmethod.setStatus("amount received");
			session.saveOrUpdate(paymentmethod);
			System.out.println("here");
			session.flush();
			String sid = paymentmethod.getOrderid();
			System.out.println("sid " + sid);
			Order order = (Order) session.get(Order.class, sid);
			int cartid = order.getCartId();
			System.out.println("cart id " + cartid);
			System.out.println("update 1.1");
			MyCart cart = (MyCart) session.get(MyCart.class, cartid);
			
			String name = cart.getProductName();
			List<Product> pl = pr.getByName(name);
			Product p = pl.get(0);
			int stock = Integer.parseInt(p.getStock());
			p.setStock((stock - 1) + "");
			System.out.println("update 1.2");
			Session session1 = factory.openSession();
			session1.saveOrUpdate(p);
			session1.flush();
		Session session2=factory.openSession();
		cart.setStatus('Y');
session2.saveOrUpdate(cart);
session2.flush();
		} catch (Exception e) {
			System.out.println("exception  " + e);
			e.printStackTrace();
			return e.getMessage();
		}
		return "Status Updated  for " + paymentmethod.getId();

	}
}
