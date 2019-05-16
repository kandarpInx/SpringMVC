<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br/>
<br/>
	<table border="2" align="center">
	
		<tr>
			<th>Item Id</th>
			<th>Item Name</th>
			<th>Price</th>
		</tr>

		<c:forEach var="items" items="${items}">

			 <!-- construct an "update" link with item id -->
			<c:url var="updateLink" value="/item/updateForm">
				<c:param name="itemId" value="${items.itemId}" />
			</c:url>

			<!-- construct an "delete" link with item id -->
			<c:url var="deleteLink" value="/item/delete">
				<c:param name="itemId" value="${items.itemId}" />
			</c:url>

			<tr>
				<td>${items.itemId}</td>
				<td>${items.itemName}</td>
				<td>${items.itemPrice}</td>
				<td>
					<a href="${updateLink}">Update</a>
					<%-- <input type="button" value="Update Item" onclick="window.location.href='${updateLink}'; return false;" /> --%>
				</td>
				<td>
					<a href="${deleteLink}"
					onclick="if (!(confirm('Are you sure you want to delete this item?'))) return false">Delete</a>
				</td>

			</tr>

		</c:forEach>

	</table>
	<br/>

	<input type="button" value="Add Item"
		onclick="window.location.href='showForm'; return false;" />

</body>
</html>