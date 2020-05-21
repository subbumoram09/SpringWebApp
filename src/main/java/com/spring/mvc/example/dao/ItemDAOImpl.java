package com.spring.mvc.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.spring.mvc.example.utils.HibernateUtil;

@Repository
public class ItemDAOImpl implements ItemDAO
{
	/*private static SessionFactory factory = HibernateUtil.getSessionfactory();
	@Override
	public void save(Object o) 
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(o);
		tx.commit();
		session.close();
	}
	
	@Override
	public void update(Object o) 
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(o);
		tx.commit();
		session.close();
	}*/
}
