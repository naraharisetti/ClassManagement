package com.LAcreateLists;

import java.io.IOException;

import com.LAlistClasses.ListSubjects;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.*;
import org.hibernate.*;

import com.LAlistClasses.ListClass;

public class ServletClassDelete extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("******* START- This is doGet() ******* ");

		/* Get the data from Request parameter*/

		Long claID = (long)0;
		System.out.println(request.getParameter("claID"));
		if(request.getParameter("claID")!="") {
			claID = Long.parseLong(request.getParameter("claID"));	
		}
		int claIDint =0;
		claIDint = claID.intValue();

		/*Enhancement:
		 * 1.Read the remaining attribute
		 * 2. Display back the same in to web page
		 * */

		System.out.println("ClaID No - "+ claIDint);

		/*2. Delete the data in to table*/

		Transaction tx = null;

		try {
			SessionFactory sf = AHibernateUtil.getFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			//2.Delete Class

			Query query = session.createQuery("delete from ListClass where cid = :claIDint");
			query.setParameter("claIDint", claIDint);
			
			int result=0;

			try {
				 result = query.executeUpdate();
			} catch (Exception e) {
				response.setContentType("text/html");
				PrintWriter printWriter = response.getWriter();
				printWriter.print("<html>");
				printWriter.print("<body>");
				printWriter.print("<p> <h2> You cannot delete once mapping is one ; try addding a new Class which is unmapped and then try to delete it  </h2> </p>");
				printWriter.print("</body>");
				printWriter.print("</html>");
				printWriter.close();	

			}

			if (result > 0) {
				System.out.println("Class was removed");
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
		printWriter.print("<p> Query Processed - Class deleted if exists, else nothing is done  </p>");
		printWriter.print("</body>");
		printWriter.print("</html>");
		printWriter.close();	


		//		/*3.Response back the same data to the User*/

		System.out.println("******* END- This is doGet() ******* ");
	}


}



