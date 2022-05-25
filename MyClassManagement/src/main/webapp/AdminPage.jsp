<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">
<title>Learners Academy Admin Page</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>

	<jsp:include page="header.jsp">
		<jsp:param value="Learner Academy Project Header" name="header" />
	</jsp:include>


	<!--  
<form action = "PageOptions.jsp">
<h3>Select the Type of Data Entry</h3>
<select name = "EntryDataType" >
<option value = "StudentData"> Goto Student Data Entry Page </option>
<option value = "ClassData"> Goto Class Data Entry Page </option>
<option value = "TeacherData"> Goto Teacher Data Entry Page </option>
<option value = "SubjectData"> Goto Subject Data Entry Page </option>
<option value = "C2StudentMap"> Goto "Map Class-to-Student" Page </option>
<option value = "C2SubjectMap"> Goto "Map Class-to-Subject" Page </option>
<option value = "Teacher2SubjectMap"> Goto Map Teacher-to-Subject Page </option>
</select>

<input type ="submit" value = "Submit" />

</form>
-->
	<div align="center">

		<h2>Select the Type of Data Entry</h2>

		<table border="1" cellpadding="5">


			<tr>
				<td><a href="EnterStudentData.jsp"> Click here to Enter
						Student Data </a></td>
			</tr>
			<tr>
				<td><a href="EnterSubjectData.jsp"> Click here to Enter
						Subject Data </a></td>
			</tr>
			<tr>
				<td><a href="EnterTeacherData.jsp"> Click here to Enter
						Teacher Data </a></td>
			</tr>
			<tr>
				<td><a href="EnterClassData.jsp"> Click here to Enter Class
						Data </a></td>
			</tr>
		</table>
		<br /> <br /> <br /> <br />

		<h3>Select the Automatic Mapping Type</h3>
		<h4>(An Allocation algorithm is used to do this allocation - it
			would be easier to allow user to input this mapping, but I have tried
			to do using an algorithm)</h4>

			<table border="1" cellpadding="5">
			<tr>
				<td><a href="MapClass2Student.jsp"> Map Class-Student </a></td>
			</tr>

			<tr>
				<td><a href="MapClass2Sub.jsp"> Map Class-Subject </a></td>
			</tr>

			<tr>
				<td><a href="MapTeacher2Sub.jsp"> Map Teacher-Subject</a></td>
			</tr>

			<tr>
				<td><a href="DisplayMapTeacher2Sub2Cla.jsp"> Map
						Teacher-Subject-Class</a>
		</table>
	</div>


	<jsp:include page="footer.jsp">
		<jsp:param value="Learner Academy Project Footer" name="footer" />
	</jsp:include>
</body>
</html>