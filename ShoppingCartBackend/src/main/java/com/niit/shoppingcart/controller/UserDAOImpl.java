package com.niit.shoppingcart.controller;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public User get(String id) {
		// log.debug("starting of the method:get");
		String hql = "from User where id=" + "'" + id + "'";
		return getUserDetails(hql);
	}

	@Transactional
	public User isValidUser(String id, String password) {
		// log.debug("Starting of the method:isValidUser");
		// log.info("The user id:"+id);
		String hql = "from User where id=" + "'" + id + "'" + "and" + "password=" + "'" + password + "'";
		// log.info("The query is:"+hql);
		return getUserDetails(hql);
	}

	@Transactional
	public User getUserDetails(String hql) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		java.util.List<User> list = query.list();
		if (list != null && !list.isEmpty()) {
			return (User) list.get(0);
		}
		return null;
	}
	@Transactional
public Integer getId(String name)
{
	SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select u.id from User u where name='"+name+"'");

   java.util.List lst=query.list();
   System.out.println(lst);
  return (Integer)lst.get(0);
}
	@Transactional
	public boolean saveOrUpdate(User user) {
		System.out.println("save");
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(user);
		System.out.println("save");
		session.flush();
		return true;

	}

}
