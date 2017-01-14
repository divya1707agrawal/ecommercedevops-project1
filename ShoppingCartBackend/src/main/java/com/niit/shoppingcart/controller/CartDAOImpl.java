package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	HttpServletRequest request;

	/*
	 * public CartDAOImpl(sessionFactory sessionfactory){
	 * this.sessionFactory=sessionFactory; }
	 */

	@Transactional
	public List<MyCart> list(String id) {
		String hql = "from MyCart where userID=" + "'" + id + "' and status=" + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<MyCart> list = (List<MyCart>) query.list();
		return list;
	}

	@Transactional
	public void update(MyCart myCart) {
		sessionFactory.getCurrentSession().update(myCart);
	}

	@Transactional
	public Integer save(MyCart myCart) {
		System.out.println(myCart.getId());
		Integer i = (Integer) sessionFactory.openSession().save(myCart);
		System.out.println("id "+i);
		return i;
	}

	@Transactional
	public String delete(int id) {
		try {
			Session session = sessionFactory.openSession();
			MyCart myCart = (MyCart) session.get(MyCart.class, id);
			session.delete(myCart);
			session.flush();
		}

		catch (HibernateException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return null;
	}

	@Transactional
	public double getTotalAmount(String id) {
		String hql = "select sum(price) from MyCart where user_ID=" + "'" + id + "'" + " and status=" + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("totalamount");
		double sum = Double.parseDouble(query.uniqueResult().toString());

		return sum;
	}

	@Transactional
	private int getMaxId() {
		int maxId = 100;
		try {
			String hql = "select max(m.id) from MyCart m";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			maxId = Integer.parseInt(query.list().get(0).toString());

		} catch (Exception e) {
			maxId = 100;
			e.printStackTrace();
			System.out.println(e);
		}
		return maxId + 1;
	}

	@Transactional
	public MyCart get(String id) {
		String hql = "from MyCart m where m.userID=" + "'" + id + "' and m.status=" + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<MyCart> list = (List<MyCart>) query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
