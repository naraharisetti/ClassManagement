<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Data Entry Options</title>
</head>
<body>

<%
String user=request.getParameter("userName");
String password=request.getParameter("password");
if (user.equals("admin") && password.equals("admin"))
{
%>
<jsp:forward page = "AdminPage.jsp">
	<jsp:param value = "AdminPage" name ="AdminPage" />
</jsp:forward>
<%
}
else {
	%>
	<jsp:forward page = "ShowError.jsp">
		<jsp:param value = "ShowError" name ="ShowError" />
	</jsp:forward>
	<%
}





%>

</body>
</html>