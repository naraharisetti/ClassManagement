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

public class ServletClassEdit extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("******* START- This is doGet() ******* ");

		/* Get the data from Request parameter*/

		String claName = null;

		if(request.getParameter("claName")!=null) {
			claName=(String) request.getParameter("claName");
		}
		Long claID = (long)0;
		if(request.getParameter("claID")!="") {
			claID = Long.parseLong(request.getParameter("claID"));	
		}


		int claIDint =0;
		claIDint = claID.intValue();

		/*Enhancement:
		 * 1.Read the remaining attribute
		 * 2. Display back the same in to web page
		 * */

		System.out.println("claIDint No - "+ claIDint);

		/*2. Edit the data in to table*/

		Transaction tx = null;

		try {
			SessionFactory sf = AHibernateUtil.getFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction(); 


			String updateRow = "UPDATE ListClass set cname=:cname  where cid = :claIDint";

			Query query = session.createQuery(updateRow);
			query.setParameter("claIDint", claIDint);
			query.setParameter("cname",claName);
			query.executeUpdate(); 


			int result = query.executeUpdate();

			if (result > 0) {
				System.out.println("Class was Edited");
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




