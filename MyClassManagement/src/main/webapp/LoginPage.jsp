<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learners Academy Login Page</title>
</head>
<body>

<jsp:include page = "header.jsp">
	<jsp:param value = "Learner Academy Project Header" name ="header" />
</jsp:include>

<form action = "PageOptions.jsp">

	<br> <br> 
	<br> <br> 
	<div align="center">
	
	<h1> LOGIN PLEASE</h1>
	<br> <br> 
	
	
	 User Name: <input type="text" name="userName">
	 <br> <br> 
	  
	 Password : <input type="password" name="password">
	 <br> <br>
	
	 <h4> HINT: Both user name and password are "admin" </h4>
	 
	
	 
	 	 <tr>
		<td colspan="2" align="center"><input type="submit" value="Login"/></td>
	 </tr>
	 <br> <br>
	 <br> <br>
	   </div>
 </form>


<jsp:include page = "footer.jsp">
	<jsp:param value = "Learner Academy Project Footer" name ="footer" />
</jsp:include>
</body>
</html>