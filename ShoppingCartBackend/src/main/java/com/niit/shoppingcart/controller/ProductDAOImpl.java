package com.niit.shoppingcart.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
//	public ProductDAOImpl(){
//	}
	
	
//	public ProductDAOImpl(SessionFactory sessionFactory)
//	{
//		this.sessionFactory=sessionFactory;	
//	}
	//@Override
	@Transactional
	public boolean save(Product Product) 
	{
		try
		{
			if(get(Product.getId())!=null)
			{
			sessionFactory.openSession().save(Product);
			return true;
			}
			return false;
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
			{sessionFactory.openSession().update(Product);
			return true;
				
			}
			return false;
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
				sessionFactory.openSession().delete(Product);
				return true;
				
			}return false;
			
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
	
	@Transactional
	public boolean saveOrUpdate(Product product)
	{
		try
		{
			/*if(get(product.getId())!=null)
			{*/
				//sessionFactory.openSession().saveOrUpdate(product);
				Session session=sessionFactory.openSession();
				session.saveOrUpdate(product);
                session.flush();
				return true;
			/*}*/
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		return false;
		}
	}
	
	@Transactional
	public List<Product> getSimilarProducts(String searchText){
    String hql="from Product where name like%"+searchText+"%";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
}

	
	
}