<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learners Academy Login Page</title>
</head>
<body>
	<div align="center">
		<jsp:include page="header.jsp">

			<jsp:param value="Learner Academy Project Header" name="header" />

		</jsp:include>

	</div>

	<form action="PageOptions.jsp">

		<br> <br> 
		<div align="center">


			<p style="font-family: Courier; color: Blue; font-size: 50px;">
				<b> PLEASE LOGIN </b>
			</p>

			<br> User Name: <input type="text" name="userName">
			<br> <br> Password : <input type="password" name="password">
			<br> 
			<p style="font-family: Courier; color: Red; font-size: 20px;">
			<b> HINT: Both user name and password are "admin" </b>
			</p>



			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Login" /></td>
			</tr>
			<br> <br> <br> <br>
		</div>
	</form>

	<div align="center">
		<jsp:include page="footer.jsp">
			<jsp:param value="Learner Academy Project Footer" name="footer" />
		</jsp:include>
	</div>
</body>
</html>