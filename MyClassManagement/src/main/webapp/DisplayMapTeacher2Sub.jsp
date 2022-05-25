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
<title> List Teacher-Subject Records</title>
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/classmanagement"
        user="root" password="root12345"
    />
     
   
            <sql:query var="Class_Stu_List"   dataSource="${myDS}">
       select * from Teacher_Sub ts, ListTeachers t,  ListSubjects  s where ts.cid_teach=t.cid AND ts.cid_subname=s.cid;
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Teacher-Subject Records</h2></caption>
            <tr>
                <th>Teacher Name</th>
                <th>Subject Name</th>
            </tr>
            <c:forEach var="user" items="${Class_Stu_List.rows}">
                <tr>
                    <td><c:out value="${user.tname}" /></td>
                    <td><c:out value="${user.subname}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>