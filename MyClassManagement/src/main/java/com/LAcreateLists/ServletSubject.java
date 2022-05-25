package com.LAcreateLists;

import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.*;
import org.hibernate.*;

public class ServletSubject extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
System.out.println("******* START- This is doGet() in ServletClass ******* ");
		
		/* Get the data from Request parameter*/

		String subName=(String) request.getParameter("subName");
//		Long phoneno=(Long) request.getParameter("phoneno");
		
//		Long phoneno = Long.parseLong(request.getParameter("phoneno"));
//		String emailId=(String) request.getParameter("emailId");
		
//		phoneno = Math.abs(phoneno);
//		String password=(String) request.getParameter("password");
		
				
		if (subName !="") {
			SaveSubDB saveSubDB = new SaveSubDB();
		saveSubDB.StartTrans(subName);
		}else {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.print("<html>");
		printWriter.print("<body>");
		printWriter.print("<h1> Registration Form Data</h1>");
		printWriter.print("<p> Subject Name must be provided  </p>");
		printWriter.print("</body>");
		printWriter.print("</html>");
		printWriter.close();			
	}
		
		/*Enhancement:
		 * 1.Read the remaining attribute
		 * 2. Display back the same in to web page
		 * */

		System.out.println("ClassName - "+subName);
//		System.out.println("Last Name - "+lastName);
//		System.out.println("Email - "+emailId);
//		System.out.println("Phone No - "+ phoneno);
		
		
		//		/*3.Response back the same data to the User*/
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.print("<html>");
		printWriter.print("<body>");
		printWriter.print("<h1>Simplilearn Registration Form Data</h1>");
		printWriter.print("<h2>Form submited Successfully</h2>");
		printWriter.print("<p> Subject Name :: " + subName + "</p>");
//		printWriter.print("<p> Password :: " + password + "</p>");
		printWriter.print("</body>");
		printWriter.print("</html>");
		printWriter.close();

		
	}

}
