<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   

<%@ page errorPage = "ShowError.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> List Class Records</title>
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/classmanagement"
        user="root" password="root12345"
    />
     
    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM ListSubjects;
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Subjects</h2></caption>
            <tr>
                <th>ID</th>
                <th>Subject Name</th>
                <th>Edit Button</th>
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.cid}" /></td>
                    <td><c:out value="${user.subname}" /></td>
                    <td><a href="EditSubject.jsp" > Edit </a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
        <div align="center"><h3>You can also click the below link to edit</h3>
  <div align="center">  <a href="EditSubject.jsp" > Click here to Edit Subjects Data </a> </td>
  
</body>
</html>