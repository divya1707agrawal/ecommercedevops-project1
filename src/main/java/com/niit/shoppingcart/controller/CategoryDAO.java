package com.niit.shoppingcart.controller;

import java.util.List;

public interface CategoryDAO {
	public boolean save(Category category);
	public boolean update(Category category);
	public boolean delete(Category category);
	public Category get(String id);
	public List<Category> list();
	public List<Category> catlist();
	public Category getByName(String name);
	public boolean saveOrUpdate(Category category);
}
