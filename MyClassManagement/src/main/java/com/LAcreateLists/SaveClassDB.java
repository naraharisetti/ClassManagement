package com.LAcreateLists;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.LAlistClasses.ListClass;

public class SaveClassDB {
	public void StartTrans (String className){
		
		Transaction tx = null;

		try {
			SessionFactory sf = AHibernateUtil.getFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			//2.Add fullName
			ListClass cla1 = new ListClass(className);
			session.save(cla1);
					
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
