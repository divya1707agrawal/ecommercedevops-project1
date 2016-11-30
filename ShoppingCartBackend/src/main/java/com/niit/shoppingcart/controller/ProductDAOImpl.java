package com.niit.shoppingcart.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository

public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	/*public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;	
	}*/
	
	@Transactional
	public boolean save(Product Product) 
	{
		try
		{
			if(get(Product.getId())!=null)
			{
				return false;
			}
			sessionFactory.openSession().save(Product);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		return false;
		}
	}
    
	@Transactional
	public boolean update(Product Product) {
		try
		{
			if(get(Product.getId())!=null)
			{
				return false;
			}
			sessionFactory.openSession().update(Product);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		return false;
		}
	}
	
	@Transactional
	public boolean delete(Product Product) {
		try
		{
			if(get(Product.getId())!=null)
			{
				return false;
			}
			sessionFactory.openSession().delete(Product);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		return false;
		}
	}
	
	@Transactional
	public Product get(String id) {
		return (Product) sessionFactory.openSession().get(Product.class,id);
	}

	@Transactional
	public List<Product> list() {
		String hql="from Product";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	@Transactional
	public List<Product> getBycatName(String cat)
	{
		String hql ="select p.name,p.price,p.description from Product p where category.id='"+cat+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	public boolean saveorupdate(Product product)
	{
		try
		{
			if(get(product.getId())!=null)
			{
				return false;
			}
			sessionFactory.openSession().saveOrUpdate(product);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		return false;
		}
	}
}
