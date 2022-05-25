<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class Data Entry Page</title>
</head>
<body>
	<h1>Form to Edit Class</h1>

	<h2>Edit Class</h2>

	<form action="<%= request.getContextPath() %>/classServletEdit"
		method="get">

		Class Number: <input type="number" min="0" name="claID"> <br> <br>
		
		Class Name: <input type="text" name="claName"> <br> <br>

		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="Edit Class" /></td>
		</tr>

		<br> <br> <br> <br> <br>
	</form>

</body>
</html>