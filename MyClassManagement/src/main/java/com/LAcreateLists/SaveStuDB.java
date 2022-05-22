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

public class SaveStuDB {

	public void StartTrans (String fullName, String email, Long phoneno){
	
		Transaction tx = null;

		try {
			SessionFactory sf = AHibernateUtil.getFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			//2.Add fullName
			ListStudents stu1 = new ListStudents(fullName, email, phoneno);
			session.save(stu1);
					
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
