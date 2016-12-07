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
	return list(myCart);
}

@Transactional
public void save(MyCart myCart)
{
	myCart.setId(getMaxId());
}

@Transactional
public String delete(String id){
	sessionFactory.openSession().delete(id);
	return null;
}

@Transactional
public Long getTotalAmount(String id){
	String hql="select sum(price) from MyCart where user_ID=333";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	return (Long)query.list().get(0);
}

private Long getMaxId()
{
	Long maxId=100l;
	try{
		String hql="select max(id) from MyCart";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		maxId=(Long)query.uniqueResult();
	}
	catch(HibernateException e){
		maxId=100l;
		e.printStackTrace();
	}
	return maxId+1;
	}


public MyCart get(String id) {
	
	return null;
}

public void update(MyCart myCart) {
	
	
}

public List<MyCart> list(String id) {
	// TODO Auto-generated method stub
	return null;
}

}

