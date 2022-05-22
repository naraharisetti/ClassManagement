<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Student Data Entry Page</title>
</head>
<body>
		<h1> Form to Add New Student and Get List of Students</h1>
	
	<h2> Add New Student </h2>
	
	 <form action="<%= request.getContextPath() %>/studentServletWeb" method="get">
	
	 Full Name: <input type="text" name="fullName">
	 <br> <br> 
	  
	 Phone Number: <input type="number" min="0" name="phoneno">
	 <br> <br> 

	
	 Email ID: <input type="email" name="emailId">
	 <br> <br> 
	  
	  <!-- 
	 Password: <input type="password" name="password">
	 <br> <br>
	  -->
	
	 <tr>
		<td colspan="2" align="center"><input type="submit" value="Add New Student"/></td>
	 </tr>
	 
	 	 <br> <br>
	 <br> <br>
	 <br> <br>
	 </form>
	 
	  <!--  <form action="<%= request.getContextPath() %>/studentServletWebGetDB" method="get">
	  -->
	  <form action = "DisplayStudents.jsp">
	 <h1>Click Below to see the Students List</h1>
	  <tr>
		<td colspan="2" align="center"><input type="submit" value="Students List"/></td>
	 </tr>
	 
	 </form>
	
</body>
</html>