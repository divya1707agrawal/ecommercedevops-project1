package com.niit.shoppingcart.controller;


import java.util.List;

public interface ProductDAO {
	public boolean save(Product product);
	public boolean update(Product product);
	public boolean delete(Product product);
	public boolean saveOrUpdate(Product product);
	public Product get(String id);
	public List<Product> list();
	public List<Product> getBycatName(String cat);
	public List<Product> getSimilarProducts(String searchText);
	public List<Product> getByName(String name);
}
