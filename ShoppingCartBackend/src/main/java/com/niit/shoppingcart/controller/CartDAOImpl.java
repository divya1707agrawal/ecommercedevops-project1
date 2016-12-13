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
public List<MyCart> list(String id){
	String hql="from MyCart where userID="+"'"+id+"' and status="+"'N'";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<MyCart> list=(List<MyCart>) query.list();
	return list;
}
@Transactional
public void update(MyCart myCart)
{
	sessionFactory.getCurrentSession().update(myCart);
}

@Transactional
public void save(MyCart myCart)
{
	myCart.setId(getMaxId());
	sessionFactory.openSession().save(myCart);
}

@Transactional
public String delete(String id){
	MyCart myCart=new MyCart();
	myCart.setUserID(id);
	try{
	  sessionFactory.openSession().delete(id);
	}
	catch(HibernateException e)
	{
		e.printStackTrace();
		return e.getMessage();
	}
	return null;
}

@Transactional
public Long getTotalAmount(String id){
	String hql="select sum(price) from MyCart where user_ID="+"'"+id+"'"+" and status="+"'N'";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	Long sum=(Long) query.uniqueResult();
	return sum;
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
	String hql="from MyCart where userID="+"'"+id+"' and status="+"'N'";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<MyCart> list=(List<MyCart>) query.list();
	if(list!=null &&!list.isEmpty()){
		return list.get(0);
	}
	return null;
}

}



