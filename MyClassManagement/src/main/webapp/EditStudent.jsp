<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Data Entry Page</title>
</head>
<body>
	<h1>Form to Edit Student</h1>

	<h2>Edit Student</h2>

	<form action="<%= request.getContextPath() %>/studentServletEdit"
		method="get">

		Student Number: <input type="number" min="0" name="StuID"> <br> <br>
		
		Full Name: <input type="text" name="fullName"> <br> <br>

		Phone Number: <input type="number" min="0" name="phoneno"> <br>
		<br> Email ID: <input type="email" name="emailId"> <br>
		<br>

		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="Edit Student" /></td>
		</tr>

		<br> <br> <br> <br> <br>
	</form>

</body>
</html>