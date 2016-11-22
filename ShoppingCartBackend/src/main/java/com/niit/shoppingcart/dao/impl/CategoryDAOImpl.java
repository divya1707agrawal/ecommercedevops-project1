package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;	
	}
	
	@Transactional
	public boolean save(Category category) 
	{
		try
		{
			if(get(category.getId())!=null)
			{
				return false;
			}
			sessionFactory.openSession().save(category);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		return false;
		}
	}
    
	@Transactional
	public boolean update(Category category) {
		try
		{
			if(get(category.getId())!=null)
			{
				return false;
			}
			sessionFactory.openSession().update(category);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		return false;
		}
	}
	
	@Transactional
	public boolean delete(Category category) {
		try
		{
			if(get(category.getId())!=null)
			{
				return false;
			}
			sessionFactory.openSession().delete(category);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		return false;
		}
	}
	
	@Transactional
	public Category get(String id) {
		return (Category) sessionFactory.openSession().get(Category.class,id);
	}

	public List<Category> list() {
		String hql="from Category";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
