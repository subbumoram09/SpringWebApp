package com.spring.mvc.example.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
	private static SessionFactory factory;
	private HibernateUtil() {}
	public static synchronized SessionFactory getSessionfactory()
	{
		if(factory == null)
		{
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}
}
