package com.LAcreateLists;

import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.*;
import org.hibernate.*;

public class ServletStudent extends HttpServlet{

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
		
//		phoneno = Math.abs(phoneno);
//		String password=(String) request.getParameter("password");
		
				

		/*Enhancement:
		 * 1.Read the remaining attribute
		 * 2. Display back the same in to web page
		 * */

		System.out.println("Full Name - "+fullName);
//		System.out.println("Last Name - "+lastName);
		System.out.println("Email - "+emailId);
		System.out.println("Phone No - "+ phoneno);

		/*2. Save the data in to table*/
//		if (fullName !="" && emailId !="" && phoneno !=0) {
		if (fullName !="") {
		SaveStuDB saveStuDB = new SaveStuDB();
		saveStuDB.StartTrans(fullName, emailId, phoneno );
		}else {
			response.setContentType("text/html");
			PrintWriter printWriter = response.getWriter();
			printWriter.print("<html>");
			printWriter.print("<body>");
			printWriter.print("<h1> Registration Form Data</h1>");
			printWriter.print("<p> Name/Phone/Email ID must be provided  </p>");
			printWriter.print("</body>");
			printWriter.print("</html>");
			printWriter.close();			
		}

		//		/*3.Response back the same data to the User*/
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.print("<html>");
		printWriter.print("<body>");
		printWriter.print("<h1>Simplilearn Registration Form Data</h1>");
		printWriter.print("<h2>Form submited Successfully</h2>");
		printWriter.print("<p> Full Name :: " + fullName + "</p>");
		printWriter.print("<p> Phone No :: " + phoneno + "</p>");
		printWriter.print("<p> Email :: " + emailId + "</p>");
//		printWriter.print("<p> Password :: " + password + "</p>");
		printWriter.print("</body>");
		printWriter.print("</html>");
		printWriter.close();


		System.out.println("******* END- This is doGet() ******* ");
	}
	

}


