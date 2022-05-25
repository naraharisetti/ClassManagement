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

public class ServletTeacherEdit extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("******* START- This is doGet() ******* ");

		/* Get the data from Request parameter*/

		String fullName = null;

		if(request.getParameter("fullName")!=null) {
			fullName=(String) request.getParameter("fullName");
		}
		//		Long phoneno=(Long) request.getParameter("phoneno");
		Long phoneno = (long)0;

		if(request.getParameter("phoneno")!="") {
			phoneno = Long.parseLong(request.getParameter("phoneno"));	
		}
		String emailId=null;

		if(request.getParameter("emailId")!=null) {
			emailId = (String) request.getParameter("emailId");
		}

		Long teaID = (long)0;
		if(request.getParameter("teaID")!="") {
			teaID = Long.parseLong(request.getParameter("teaID"));	
		}


		int teaIDint =0;
		teaIDint = teaID.intValue();

		/*Enhancement:
		 * 1.Read the remaining attribute
		 * 2. Display back the same in to web page
		 * */

		System.out.println("teaIDint No - "+ teaIDint);

		/*2. Edit the data in to table*/

		Transaction tx = null;

		try {
			SessionFactory sf = AHibernateUtil.getFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();


			String updateRow = "UPDATE ListTeachers set tname=:fullName, phone=:phoneno,  email=:emailId where cid = :teaIDint";

			Query query = session.createQuery(updateRow);
			query.setParameter("teaIDint", teaIDint);
			query.setParameter("fullName",fullName);
			query.setParameter("phoneno",phoneno);
			query.setParameter("emailId",emailId);
			query.executeUpdate(); 


			int result = query.executeUpdate();

			if (result > 0) {
				System.out.println("Teacher was Edited");
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



