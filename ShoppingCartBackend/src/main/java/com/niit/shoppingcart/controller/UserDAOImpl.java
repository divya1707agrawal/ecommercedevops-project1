package com.niit.shoppingcart.controller;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public User get(String id){
		//log.debug("starting of the method:get");
		String hql="from User where id="+"'"+id+"'";
		return getUserDetails(hql);
	}

	@Transactional
	public User isValidUser(String id,String password)
	{
		//log.debug("Starting of the method:isValidUser");
		//log.info("The user id:"+id);
		String hql="from User where id="+"'"+id+"'"+"and"+"password="+"'"+password+"'";
		//log.info("The query is:"+hql);
		return getUserDetails(String hql);
	}
	private User getUserDetails(String hql)
    {
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list=(List)<User> query.list();
		if(list!=null&&!list.isEmpty()){
		
			}
     }
	

}
