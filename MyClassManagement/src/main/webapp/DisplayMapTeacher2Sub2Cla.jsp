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
<title> List Class-Student Records</title>
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/classmanagement"
        user="root" password="root12345"
    />
     
   
            <sql:query var="Class_Stu_List"   dataSource="${myDS}">
		      select * from Teacher_Sub ts, Class_Sub cs,  ListClass c, ListTeachers t, ListSubjects s
		where ts.cid_subname=cs.cid_subname 
		AND   t.cid = ts.cid_teach
		AND   s.cid = ts.cid_subname
		AND   c.cid = cs.cid_class
		;
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Teacher-Class-Subject Records</h2></caption>
            <tr>
                <th>Class Name</th>
                <th>Teacher Name</th>                
                <th>Subject Name</th>
            </tr>
            <c:forEach var="user" items="${Class_Stu_List.rows}">
                <tr>
                    <td><c:out value="${user.cname}" /></td>
                    <td><c:out value="${user.tname}" /></td>
                    <td><c:out value="${user.subname}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>