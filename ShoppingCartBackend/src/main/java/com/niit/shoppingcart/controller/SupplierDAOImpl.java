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
public class SupplierDAOImpl implements SupplierDAO{
	 
	@Autowired
	SessionFactory sessionFactory;
	
	

	
	
	@Transactional
	public boolean save(Supplier supplier) 
	{
		try
		{
			if(get(supplier.getId())!=null)
			{
				return false;
			}
			sessionFactory.openSession().save(supplier);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		return false;
		}
	}
    
	@Transactional
	public boolean update(Supplier supplier) {
		try
		{
			if(get(supplier.getId())!=null)
			{
				return false;
			}
			sessionFactory.openSession().update(supplier);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		return false;
		}
	}
	
	@Transactional
	public boolean saveOrUpdate(Supplier supplier)
	{
		try
		{
			/*if(get(supplier.getId())!=null)
			{*/
				//sessionFactory.openSession().saveOrUpdate(supplier);
				Session session=sessionFactory.openSession();
				session.saveOrUpdate(supplier);
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
	public boolean delete(Supplier supplier) {
		try
		{
			if(get(supplier.getId())!=null)
			{
				return false;
			}
			sessionFactory.openSession().delete(supplier);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		return false;
		}
	}
	
	@Transactional
	public Supplier get(String id) {
		return (Supplier) sessionFactory.openSession().get(Supplier.class,id);
	}
	@Transactional

	public List<Supplier> list() {
		String hql="from Supplier";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public Supplier getByName(String name)
	{
		String hql="select s from Supplier s where s.name='"+name+"'";
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);
	
		 return (Supplier)query.list().get(0);
	}
	

}
