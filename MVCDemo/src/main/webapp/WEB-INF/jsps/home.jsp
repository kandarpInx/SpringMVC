<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Hello Word!! </h1>

		<table border="1">
 
            <th>Name</th>
            <th>Address</th>
 
           <c:forEach items="${listStudent}" var="listStudent">
                <tr>
 
                    <td>${listStudent.studName}</td>
                    <td>${listStudent.studAddr}</td>
 
                </tr>
            </c:forEach>
        </table>

</body>
</html>