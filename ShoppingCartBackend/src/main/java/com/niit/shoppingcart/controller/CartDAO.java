package com.niit.shoppingcart.controller;

import java.util.List;

public interface CartDAO {

	public List<MyCart> list(String id);
	public MyCart get(String id);
	public void save(MyCart myCart);
	public void update(MyCart myCart);
	public String delete(String id);
	public Long getTotalAmount(String id);
}
