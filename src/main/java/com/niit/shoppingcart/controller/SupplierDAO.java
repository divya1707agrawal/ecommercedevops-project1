package com.niit.shoppingcart.controller;

import java.util.List;

public interface SupplierDAO {

	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier get(String id);
	public List<Supplier> list();
	public Supplier getByName(String name);
	public boolean saveOrUpdate(Supplier supplier);
}
