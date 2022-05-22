<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Subject Data Entry Page</title>
</head>
<body>
	<h1> Form to Add New Subject and Get List of Subjects</h1>
	<br> <br> 
	<br> <br> 
	<h2> Add New Subject </h2>
	 <form action="<%= request.getContextPath() %>/subServletWeb" method="get">
	
	 Subject Name: <input type="text" name="subName">
	 <br> <br> 
	 
	 	  <!-- 
	  
	 Phone Number: <input type="number" min="0" name="phoneno">
	 <br> <br> 

	
	 Email ID: <input type="email" name="emailId">
	 <br> <br> 
	  

	 Password: <input type="password" name="password">
	 <br> <br>
	  -->
	
	 <tr>
		<td colspan="2" align="center"><input type="submit" value="Add New Subject"/></td>
	 </tr>
	 
	 <br> <br>
	 <br> <br>
	 <br> <br>
	 </form>
	 
	  <form action = "DisplaySubjects.jsp">
	 <h1>Click Below to see the Subject List</h1>
	  <tr>
		<td colspan="2" align="center"><input type="submit" value="Subject List"/></td>
	 </tr>
	 
	 </form>
	
</body>
</html>