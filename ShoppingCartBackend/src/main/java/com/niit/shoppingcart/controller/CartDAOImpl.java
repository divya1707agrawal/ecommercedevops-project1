package com.niit.shoppingcart.controller;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CartDAOImpl implements CartDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	/*public CartDAOImpl(sessionFactory sessionfactory){
		this.sessionFactory=sessionFactory;
	}*/
	
@Transactional
public List<MyCart> list(MyCart myCart){
	sessionFactory.getCurrentSession().update(myCart);
	return list;
}

@Transactional
public void save(MyCart myCart)
{
	myCart.setId(getMaxId());
}

@Transactional
public String delete(String id){
	
}

@Transactional
public Long getTotalAmount(String id){
	String hql="select sem(price) from MyCart where user_ID=333";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
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


public MyCart get(String id) {
	
	return null;
}

public void update(MyCart myCart) {
	
	
}

}

