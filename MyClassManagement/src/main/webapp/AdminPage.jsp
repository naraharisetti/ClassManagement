<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learners Academy Admin Page</title>
</head>
<body>

<jsp:include page = "header.jsp">
	<jsp:param value = "Learner Academy Project Header" name ="header" />
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

<h3>Select the Type of Data Entry</h3>
<a href="EnterStudentData.jsp" > Click here to Enter Student Data </a> 
<br/> <br/> <br/>
<a href="EnterSubjectData.jsp" > Click here to Enter Subject Data </a> 
<br/> <br/> <br/>
<a href="EnterTeacherData.jsp" > Click here to Enter Teacher Data </a> 
<br/> <br/> <br/>
<a href="EnterClassData.jsp" > Click here to Enter Class Data </a> 
<br/> <br/>

<h3>Select the Mapping Type </h3>
<h4>(An Allocation algorithm is used to do this allocation - it would be easier to allow user to input this mapping, but I have tried to do using an algorithm)</h4>


<a href="MapClass2Student.jsp" > Automatically map Class-Student </a> 
<br/> <br/> <br/>
<a href="MapClass2Sub.jsp" > Automatically map Class-Subject </a> 
<br/> <br/> <br/>
<a href="MapTeacher2Sub.jsp" > Automatically map Teacher-Subject</a> 
<br/> <br/> <br/>
<a href="DisplayMapTeacher2Sub2Cla.jsp" > Automatically map Teacher-Subject-Class</a> 
<br/> 



<jsp:include page = "footer.jsp">
	<jsp:param value = "Learner Academy Project Footer" name ="footer" />
</jsp:include>
</body>
</html>