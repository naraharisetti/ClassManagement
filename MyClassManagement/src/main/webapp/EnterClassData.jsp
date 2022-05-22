<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Class Data Entry Page</title>
</head>
<body>
	<h1> Form to Add New Class and Get List of Classes</h1>
	
	<h2> Add New Class </h2>
	 <form action="<%= request.getContextPath() %>/classServletWeb" method="get">
	
	 Class Name: <input type="text" name="className">
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
		<td colspan="2" align="center"><input type="submit" value="Add New Class"/></td>
	 </tr>
	 <br> <br>
	 <br> <br>
	 </form>
	 
	 <form action = "DisplayClasses.jsp">
	 	 <h1>Click Below to see the Class List</h1>
	  <tr>
		<td colspan="2" align="center"><input type="submit" value="Class List"/></td>
	 </tr>
	 
	 </form>
	
</body>
</html>