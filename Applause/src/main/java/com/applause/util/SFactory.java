package com.applause.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SFactory {
	public static SessionFactory sessionfactory;
	public static SessionFactory getSessionFactory() {
		System.out.println("in sessionfactory");
		if(sessionfactory==null)
		{
			Configuration configuration=new Configuration().configure();
			ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionfactory=configuration.buildSessionFactory(registry);
		}
		return sessionfactory;
	}
	public static SessionFactory closeSessionFactory()
	{
		if(sessionfactory!=null)
		{
			sessionfactory.close();
		}
		return sessionfactory;
	}
}
