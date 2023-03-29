package org.simplilearn.hrmapp.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.hrmapp.config.HibConfig;
import org.simplilearn.hrmapp.entities.User;

public class UserDaoImpl implements UserDao{
	@Override
	public void insertUser(User user) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	@Override
	public User getUser(int id) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		return session.get(User.class, id);
	}
	@Override
	public User getUser(String username, String password) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<User> query=session.createQuery("select u from org.simplilearn.hrmapp.entities.User u where u.username=? and u.password=?");
		return query.getSingleResult();
	}
}
