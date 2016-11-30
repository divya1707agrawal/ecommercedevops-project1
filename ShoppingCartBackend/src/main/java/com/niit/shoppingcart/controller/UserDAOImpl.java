package com.niit.shoppingcart.controller;

import org.springframework.transaction.annotation.Transactional;

public class UserDAOImpl {
	
	
	
	
	
	
	@Transactional
	public User get(String id){
		log.debug("starting of the method:get");
		String hql="from User where id="+"'"+id+"'";
		return getUserDetails(hql);
	}

	@Transactional
	public User isValidUser(String id,String password)
	{
		log.debug("Starting of the method:isValidUser");
		log.info("The user id:"+id);
		String hql="from User where id="+"'"+id+"'"+"and"+"password="+"'"+password+"'";
		log.info("The query is:"+hql);
		return getUserDetails(String hql)
	}
	private User getUserDetails(String hql)
    {
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list=(List<User>)
		if(list!=null&&!list.isEmpty()){
		
			}
     }
	

}
