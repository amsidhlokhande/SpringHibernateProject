package com.amsidh.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amsidh.model.Circle;
import com.amsidh.service.CircleDao;

@Repository
public class CircleDaoImpl implements CircleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Circle circle) {
		Session session = sessionFactory.openSession();
		Transaction tn = session.beginTransaction();
		session.save(circle);
		tn.commit();
	}

	@Override
	public void delete(Integer id) {

		Session session = sessionFactory.openSession();
		Transaction tn = session.beginTransaction();
		String hql = "from Circle where id=:id";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		Circle circle = (Circle) query.uniqueResult();
		//Circle circle = (Circle)session.load(Circle.class, id);
		
		session.delete(circle);
		session.flush();
		tn.commit();
	}

	@Override
	public void updateCircle(Circle circle) {
		Session session = sessionFactory.openSession();
		Transaction tn = session.beginTransaction();
		session.update(circle);
		session.flush();
		tn.commit();

	}

	@Override
	public Circle getCircleById(Integer id) {
		String hql = "from Circle where id=:id";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setInteger("id", id);
		return (Circle) query.uniqueResult();
	}

	@Override
	public Long getCircleCount() {
		String hql = "select count(*) from Circle";
		Query query = sessionFactory.openSession().createQuery(hql);
		return (Long) query.uniqueResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Circle> getAllCircles() {
		String hql = "from Circle";
		Query query = sessionFactory.openSession().createQuery(hql);
		return (List<Circle>) query.list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
