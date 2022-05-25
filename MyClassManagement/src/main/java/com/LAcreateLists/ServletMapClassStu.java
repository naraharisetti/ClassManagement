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

public class ServletMapClassStu extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Transaction tx = null;
		Transaction tx1 = null;
		
		int nStu=0;
		double nCL=0;
		int factor = 0;
		int count =0;
		
		try {
			SessionFactory sf = AHibernateUtil.getFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			SQLQuery query = session.createSQLQuery("drop table Class_Stu");

//			String sql = "Select count(*) FROM ListStudents";
//			List list = session.createQuery(sql).list();
//			//			Query countQuery = session.createSQLQuery(sql);						
//			Object o=list.get(0);
//			nStu=Integer.valueOf((o.toString()));
//			//			System.out.println(o.getClass().getSimpleName());				
//
//			String sql2 = "Select count(*) FROM ListClass";
//			List list2 = session.createQuery(sql2).list();	
//			Object o2=list2.get(0);
//			nCL=Integer.valueOf((o2.toString()));	
			
			System.out.println(" I am starting and ending  ");
			String sqlC = "Select cid FROM ListClass";
			List listC = session.createQuery(sqlC).list();
			int nClaStart = (int)listC.get(0);
			nCL= (int)listC.get(listC.size()-1); 
			System.out.println(nClaStart +" I am starting and ending  " + nCL);
			
			System.out.println(" I am starting and ending  of Tea");
			String sqlS = "Select cid FROM ListStudents";
			List listS = session.createQuery(sqlS).list();
			int nStuStart = (int)listS.get(0);
			nStu= (int)listS.get(listS.size()-1); 
			System.out.println(nStuStart +" I am starting and ending  " + nStu);

			factor = (int)Math.ceil(nStu/nCL);
			
			System.out.println("nCL" + nCL + "nStu" + nStu);

			for (int i = 1; i <=nCL; i++){	
				SessionFactory sf1 = AHibernateUtil.getFactory();
				Session session1 = sf1.openSession();
				tx1 = session1.beginTransaction();

				Set<ListStudents> stuL=new HashSet<ListStudents>();
				
				if (i > (int)Math.floorMod(nStu,(int) nCL)) {
					factor = (int)Math.floorDiv(nStu,(int) nCL);
				}

				for (int j=1; j<=factor; j++) {

					count=count+1;
					try {
						ListStudents stu1 = (ListStudents) session1.load(ListStudents.class,count);
						System.out.println(i + " i am line 80 " + stu1);
						stuL.add(stu1);
						System.out.println(i + " i am line 82 " + stuL);
					}
					catch(Exception e) {
					}
				}
				try {

				ListClass CL = (ListClass) session1.load(ListClass.class,i);									
				CL.setListStudents(stuL);	
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
