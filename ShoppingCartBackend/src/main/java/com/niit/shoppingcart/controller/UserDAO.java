package com.niit.shoppingcart.controller;

public interface UserDAO {

	public User get(String id);
	public User isValidUser(String id,String password);
	private User getUserDetails(String hql);
	
}
