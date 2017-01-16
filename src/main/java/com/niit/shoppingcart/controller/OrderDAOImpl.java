package com.niit.shoppingcart.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrderDAOImpl implements OrderDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean save(Order order) {
		try
		{
			if(get(order.getOrderID())!=null)
			{
				Session session=sessionFactory.openSession();
				session.save(order);
				session.flush();
				return true;
			}
			return false;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		return false;
		}
	}

	@Transactional
	public Order get(String id) {
		return (Order) sessionFactory.openSession().get(Order.class,id);
	}

}
