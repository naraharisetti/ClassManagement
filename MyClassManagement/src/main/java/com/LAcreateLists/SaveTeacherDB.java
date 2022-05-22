package com.LAcreateLists;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.LAlistClasses.ListTeachers;


public class SaveTeacherDB {
	public void StartTrans (String fullName, String email, Long phoneno){
		
		Transaction tx = null;

		try {
			SessionFactory sf = AHibernateUtil.getFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			//2.Add fullName
			ListTeachers tea1 = new ListTeachers(fullName, email, phoneno);
			session.save(tea1);
					
			tx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
	}


}
