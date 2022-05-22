<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Registration</title>
</head>
<body>
	<h1> Form to Map Teacher-Subject and Get Record</h1>
	
	 <form action="<%= request.getContextPath() %>/TeacherSubServletWeb" method="get">
	
	 <tr>
		<td colspan="2" align="center"><input type="submit" value="Perform Mapping"/></td>
	 </tr>
	 <br> <br>
	 <br> <br>
	 </form>
	 
	 	  <form action = "DisplayMapTeacher2Sub.jsp">
	 <h1>Click Below to see the Record</h1>
	  <tr>
		<td colspan="2" align="center"><input type="submit" value="Display Record"/></td>
	 </tr>
	 
	 </form>
	
</body>
</html>