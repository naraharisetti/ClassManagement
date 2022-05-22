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

public class ServletMapClassSub extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Transaction tx = null;
		Transaction tx1 = null;
		
		int nSub=0;
		double nCL=0;
		int factor = 0;
		int count =0;

		try {
			SessionFactory sf = AHibernateUtil.getFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			SQLQuery query = session.createSQLQuery("drop table Class_Sub");

			String sql = "Select count(*) FROM ListSubjects";
			List list = session.createQuery(sql).list();
			//			Query countQuery = session.createSQLQuery(sql);						
			Object o=list.get(0);
			nSub=Integer.valueOf((o.toString()));
			//			System.out.println(o.getClass().getSimpleName());				

			String sql2 = "Select count(*) FROM ListClass";
			List list2 = session.createQuery(sql2).list();	
			Object o2=list2.get(0);
			nCL=Integer.valueOf((o2.toString()));	

			factor = (int)Math.ceil(nSub/nCL);
			
			System.out.println(nSub + "  " + nCL);
			
//			Set<ListSubjects> subL=new HashSet<ListSubjects>();
//			ListSubjects sub1 = (ListSubjects) session.load(ListSubjects.class,1);
//			subL.add(sub1);
//			ListClass CL = (ListClass) session.load(ListClass.class,1);
//			CL.setListSubjects(subL);
			

			for (int i = 1; i <=nCL; i++){	
				SessionFactory sf1 = AHibernateUtil.getFactory();
				Session session1 = sf1.openSession();
				tx1 = session1.beginTransaction();

				Set<ListSubjects> subL=new HashSet<ListSubjects>();
				
				if (i > (int)Math.floorMod(nSub,(int) nCL)) {
					factor = (int)Math.floorDiv(nSub,(int) nCL);
				}

				for (int j=1; j<=factor; j++) {

					count=count+1;
					try {
						ListSubjects sub1 = (ListSubjects) session1.load(ListSubjects.class,count);
						subL.add(sub1);
					}
					catch(Exception e) {
					}
				}

				ListClass CL = (ListClass) session1.load(ListClass.class,i);
				CL.setListSubjects(subL);																															

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

