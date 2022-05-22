<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Teacher Data Entry Page</title>
</head>
<body>
		<h1> Form to Add New Teacher and Get List of Teachers</h1>
	
	<h2> Add New Teacher </h2>
	
	 <form action="<%= request.getContextPath() %>/teacherServletWeb" method="get">
	
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
		<td colspan="2" align="center"><input type="submit" value="Add New Teacher"/></td>
	 </tr>
	 
	 	 <br> <br>
	 <br> <br>
	 <br> <br>
	 </form>
	 
	 
	  <form action = "DisplayTeachers.jsp">
	 <h1>Click Below to see the Teacher List</h1>
	  <tr>
		<td colspan="2" align="center"><input type="submit" value="Teacher List"/></td>
	 </tr>
	 
	 </form>
	
</body>
</html>