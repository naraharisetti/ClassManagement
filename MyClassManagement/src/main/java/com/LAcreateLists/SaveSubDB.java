package com.LAcreateLists;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.*;
import org.hibernate.*;


import com.LAlistClasses.ListClass;
import com.LAlistClasses.ListStudents;
import com.LAlistClasses.ListSubjects;
import com.LAlistClasses.ListTeachers;

public class SaveSubDB {
public void StartTrans (String subName){
		
		Transaction tx = null;

		try {
			SessionFactory sf = AHibernateUtil.getFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			//2.Add fullName
			ListSubjects sub1 = new ListSubjects(subName);
			session.save(sub1);
					
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
