package com.niit.shoppingcart.controller;

import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Transactional;

public class CartDAOImpl {
	
	
	
	
	public CartDAOImpl(sessionFactory sessionfactory){
		this.sessionFactory=sessionFactory;
	}
	
@Transactional
public List<MyCart> list(MyCart myCart){
	sessionFactory.getCurrentSession().update(myCart);
}

@Transactional
public void save(MyCart myCart)
{
	myCart.setId(getMaxId());
}

@Transactional
public String dalete(String id){
	
}

@Transactional
public Long getTotalAmount(String id){
	String hql="select sem(price) from MyCart where user_ID=333";
	Query query=SessionFactory.getCurrentSession().createQuery(hql);
	return sum;
}

private Long getMaxId()
{
	Long maxId=100l;
	try{
		String hql="select max(id) from MyCart";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		maxID=(Long)query.uniqueReault();
	}
	catch(HibernateException e){
		maxId=100l;
		e.printStackTrace();
	}
	return maxID+1;
	
	}
}

