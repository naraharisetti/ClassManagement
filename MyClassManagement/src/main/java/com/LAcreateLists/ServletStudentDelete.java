package com.LAcreateLists;

import java.io.IOException;
import com.LAcreateLists.SaveStuDB;
import com.LAlistClasses.ListSubjects;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.*;
import org.hibernate.*;

import com.LAlistClasses.ListStudents;

public class ServletStudentDelete extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("******* START- This is doGet() ******* ");

		/* Get the data from Request parameter*/
		
//		Long phoneno=(Long) request.getParameter("phoneno");
		Long StuID = (long)0;
		System.out.println(request.getParameter("StuID"));
		if(request.getParameter("StuID")!="") {
			StuID = Long.parseLong(request.getParameter("StuID"));	
		}
		int StuIDint =0;
		StuIDint = StuID.intValue();

		/*Enhancement:
		 * 1.Read the remaining attribute
		 * 2. Display back the same in to web page
		 * */

		System.out.println("StuID No - "+ StuIDint);

		/*2. Delete the data in to table*/
		
		Transaction tx = null;

		try {
			SessionFactory sf = AHibernateUtil.getFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			//2.Add fullName
//			ListStudents stu1 = new ListStudents();
//			stu1.setCid(StuIDint); 
//			session.delete(StuIDint);
			
//			Serializable id = StuIDint;
//			Object persistentInstance = session.load(ListStudents.class, id);
//			if (persistentInstance != null) {
//			    session.delete(persistentInstance);
//			}
			
//			Query query = session.createQuery("delete ListStudents where cid > :del");
//			query.setParameter("del",StuIDint);
			
			Query query = session.createQuery("delete ListStudents where cid = :StuIDint");
			query.setParameter("StuIDint", StuIDint);
			 
			int result = query.executeUpdate();
			 
			if (result > 0) {
			    System.out.println("Student was removed");
			}
			
			
			
			tx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
	
		
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.print("<html>");
		printWriter.print("<body>");
		printWriter.print("<p> Query Processed - Student deleted if exists, else nothing is done  </p>");
		printWriter.print("</body>");
		printWriter.print("</html>");
		printWriter.close();	


		//		/*3.Response back the same data to the User*/

		System.out.println("******* END- This is doGet() ******* ");
	}
	

}


