<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subject Data Entry Page</title>
</head>
<body>
	<h1>Form to Edit Subject</h1>

	<h2>Edit Subject</h2>

	<form action="<%= request.getContextPath() %>/subjectServletEdit"
		method="get">

		Subject Number: <input type="number" min="0" name="subID"> <br> <br>
		
		Subject Name: <input type="text" name="subName"> <br> <br>


		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="Edit Subject" /></td>
		</tr>

		<br> <br> <br> <br> <br>
	</form>

</body>
</html>