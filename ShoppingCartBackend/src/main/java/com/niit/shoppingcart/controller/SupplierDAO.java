package com.niit.shoppingcart.controller;

import java.util.List;

public interface SupplierDAO {

	public boolean save(Supplier category);
	public boolean update(Supplier category);
	public boolean delete(Supplier category);
	public Supplier get(String id);
	public List<Supplier> list();
	public Supplier getByName(String name);
	public boolean saveOrUpdate(Supplier supplier);
}
