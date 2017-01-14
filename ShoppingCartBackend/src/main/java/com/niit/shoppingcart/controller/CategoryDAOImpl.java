package com.niit.shoppingcart.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	SessionFactory sessionFactory1;

	// public CategoryDAOImpl(SessionFactory sessionFactory)
	// {
	// this.sessionFactory=sessionFactory;
	// }

	@Transactional
	public boolean save(Category category) {
		try {
			if (get(category.getId()) != null) {
				sessionFactory.openSession().save(category);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Category category) {
		try {
			if (get(category.getId()) != null) {
				Session session = sessionFactory.openSession();
				session.update(category);
				session.flush();
				return true;
			}
			return false;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Category category) {
		try {
			Session session = sessionFactory1.openSession();
			Category cat = (Category) session.merge(category);
			session.delete(cat);
			session.flush();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Category get(String id) {
		return (Category) sessionFactory.openSession().get(Category.class, id);
	}

	@Transactional
	public List<Category> list() {
		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public List<Category> catlist() {
		String hql = "select c.name  from Category c";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public Category getByName(String name) {
		String hql = "select c from Category c where c.name='" + name + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (Category) query.list().get(0);
	}

	@Transactional
	public boolean saveOrUpdate(Category category) {
		try {
			Session session = sessionFactory.openSession();
			session.saveOrUpdate(category);
			session.flush();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
}