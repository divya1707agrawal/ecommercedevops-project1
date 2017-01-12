package com.niit.shoppingcart.controller;

public interface OrderDAO {

	public boolean save(Order order);
	public Order get(String id);
}
