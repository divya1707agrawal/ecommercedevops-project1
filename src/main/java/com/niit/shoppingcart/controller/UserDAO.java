package com.niit.shoppingcart.controller;

public interface UserDAO {

	public User get(String id);
	public User isValidUser(String id,String password);
     public  User getUserDetails(String hql);
     public boolean saveOrUpdate(User user);
	public Integer getId(String name);
	
}
