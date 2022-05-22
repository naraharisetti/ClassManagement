package com.LAcreateLists;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;


public class AHibernateUtil {

	static SessionFactory factory;

	static {
		AnnotationConfiguration afg = new AnnotationConfiguration();

		afg = (AnnotationConfiguration) afg.configure();
		factory = afg.buildSessionFactory();

	}

	public static SessionFactory getFactory() {
//		System.out.println("getsessionFactory");
		return factory;
	}
}
