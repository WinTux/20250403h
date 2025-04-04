package com.wintux.jakarta;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = construirSessionFactory();
	private static SessionFactory construirSessionFactory() {
		SessionFactory sessionFactory = null;
		try {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}
