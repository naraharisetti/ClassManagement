<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Data Entry Page</title>
</head>
<body>
	<h1>Form to Edit Teacher</h1>

	<h2>Edit Teacher</h2>

	<form action="<%= request.getContextPath() %>/teacherServletEdit"
		method="get">

		Teacher Number: <input type="number" min="0" name="teaID"> <br> <br>
		
		Full Name: <input type="text" name="fullName"> <br> <br>

		Phone Number: <input type="number" min="0" name="phoneno"> <br>
		<br> Email ID: <input type="email" name="emailId"> <br>
		<br>

		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="Edit Teacher" /></td>
		</tr>

		<br> <br> <br> <br> <br>
	</form>

</body>
</html>