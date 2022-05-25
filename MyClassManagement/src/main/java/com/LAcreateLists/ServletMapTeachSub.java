package com.LAcreateLists;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.*;
import org.hibernate.*;

import com.LAlistClasses.ListClass;
import com.LAlistClasses.ListStudents;
import com.LAlistClasses.ListSubjects;
import com.LAlistClasses.ListTeachers;

public class ServletMapTeachSub extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Transaction tx = null;
		Transaction tx1 = null;

		int nSub=0;
		double nTea=0;
		int factor = 0;
		int count =0;

		try {
			SessionFactory sf = AHibernateUtil.getFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			


			SQLQuery query = session.createSQLQuery("drop table Teacher_Sub");

//			String sql = "Select count(*) FROM ListSubjects";
//			List list = session.createQuery(sql).list();
//			//			Query countQuery = session.createSQLQuery(sql);						
//			Object o=list.get(0);
//			nSub=Integer.valueOf((o.toString()));
//			//			System.out.println(o.getClass().getSimpleName());				
//
//			String sql2 = "Select count(*) FROM ListTeachers";
//			List list2 = session.createQuery(sql2).list();	
//			Object o2=list2.get(0);
//			nTea=Integer.valueOf((o2.toString()));
			
			System.out.println(" I am starting and ending  ");
			String sqlS = "Select cid FROM ListSubjects";
			List listS = session.createQuery(sqlS).list();
			int nSubStart = (int)listS.get(0);
			nSub= (int)listS.get(listS.size()-1); 
			System.out.println(nSubStart +" I am starting and ending  " + nSub);
			
			System.out.println(" I am starting and ending  of Tea");
			String sqlT = "Select cid FROM ListTeachers";
			List listT = session.createQuery(sqlT).list();
			int nTeaStart = (int)listT.get(0);
			nTea= (int)listT.get(listT.size()-1); 
			System.out.println(nTeaStart +" I am starting and ending  " + nTea);
			

			factor = (int)Math.ceil(nSub/nTea);

			System.out.println(nSub + "  " + nTea);


			for (int i = 1; i <=nTea; i++){	
				SessionFactory sf1 = AHibernateUtil.getFactory();
				Session session1 = sf1.openSession();
				tx1 = session1.beginTransaction();

				Set<ListSubjects> subL=new HashSet<ListSubjects>();

				if (i > (int)Math.floorMod(nSub,(int) nTea)) {
					factor = (int)Math.floorDiv(nSub,(int) nTea);
				}

				for (int j=1; j<=factor; j++) {

					count=count+1;
					System.out.println(i + " i am i and j " + j);
					try {
						ListSubjects sub1 = (ListSubjects) session1.load(ListSubjects.class,count);
						System.out.println(i + " i am line 87 " + sub1);
						subL.add(sub1);
						System.out.println(i + " i am line 89 " + subL);
					}
					catch(Exception e) {
					}
				}
				
				try {

					ListTeachers TEA = (ListTeachers) session1.load(ListTeachers.class,i);
					TEA.setListSubjects(subL);	
				}
				catch(Exception e) {
				}

				tx1.commit();
				session1.close();
			}

			tx.commit();
			session.close();

			//		/*3.Response back the same data to the User*/
			response.setContentType("text/html");
			PrintWriter printWriter = response.getWriter();
			printWriter.print("<html>");
			printWriter.print("<body>");
			printWriter.print("<h2>Form submited Successfully</h2>");
			printWriter.print("</body>");
			printWriter.print("</html>");
			printWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html");
			PrintWriter printWriter = response.getWriter();
			printWriter.print("<html>");
			printWriter.print("<body>");
			printWriter.print("<h2>No Data</h2>");
			printWriter.print("</body>");
			printWriter.print("</html>");
			printWriter.close();
			if (tx != null) {
				tx.rollback();
			}
		}
	}
}


