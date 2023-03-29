package org.simplilearn.hrmapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.hrmapp.config.HibConfig;
import org.simplilearn.hrmapp.entities.Subject;

public class SubjectDaoImpl implements SubjectDao{
	@Override
	public void addSubject(Subject subject) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(subject);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	@Override
	public Subject getSubject(int sid) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		return session.get(Subject.class, sid);
	}
	@Override
	public List<Subject> getSubjects() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<Subject> query=session.createQuery("select s from org.simplilearn.hrmapp.entities.Subject s");
		return query.list();
	}
}
