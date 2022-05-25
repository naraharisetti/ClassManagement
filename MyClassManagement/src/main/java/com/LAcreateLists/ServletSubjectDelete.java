package com.LAcreateLists;

import java.io.IOException;
import com.LAlistClasses.ListSubjects;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.*;
import org.hibernate.*;

public class ServletSubjectDelete extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("******* START- This is doGet() ******* ");

		/* Get the data from Request parameter*/
		
//		Long phoneno=(Long) request.getParameter("phoneno");
		Long SubID = (long)0;
		System.out.println(request.getParameter("SubID"));
		if(request.getParameter("SubID")!="") {
			SubID = Long.parseLong(request.getParameter("SubID"));	
		}
		int SubIDint =0;
		SubIDint = SubID.intValue();

		/*Enhancement:
		 * 1.Read the remaining attribute
		 * 2. Display back the same in to web page
		 * */

		System.out.println("SubID No - "+ SubIDint);

		/*2. Delete the data in to table*/
		
		Transaction tx = null;

		try {
			SessionFactory sf = AHibernateUtil.getFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			//2.Delete fullName
			
			Query query = session.createQuery("delete ListSubjects where cid = :SubIDint");
			query.setParameter("SubIDint", SubIDint);
			 
			int result = query.executeUpdate();
			 
			if (result > 0) {
			    System.out.println("Subject was removed");
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
		printWriter.print("<p> Query Processed - Subject deleted if exists, else nothing is done  </p>");
		printWriter.print("</body>");
		printWriter.print("</html>");
		printWriter.close();	


		//		/*3.Response back the same data to the User*/

		System.out.println("******* END- This is doGet() ******* ");
	}
	

}


