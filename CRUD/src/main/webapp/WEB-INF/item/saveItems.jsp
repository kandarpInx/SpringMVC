<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false" %>

<html>
<body>

<form action="saveItems" method="post">
							<input type="hidden" name="itemId" value="${items.itemId}">
							Item Name :: <input type="text" name="itemName" value="${items.itemName}"><br><br>
							Price :: <input type="text" name="itemPrice" value="${items.itemPrice}"> <br><br>
					<%-- <c:choose>
						<c:when test="${items.itemName ne null or ''}">
							Item Name :: <input type="text" name="itemName" value="${items.itemName}"><br><br>
							Price :: <input type="text" name="itemPrice" value="${items.itemPrice}"> <br><br>
						</c:when>
						<c:otherwise>
							Item Name :: <input type="text" name="itemName"><br><br>
							Price :: <input type="text" name="itemPrice"> <br><br>
						</c:otherwise>
					</c:choose> --%>

<button type="submit"> Submit </button>
</form>
</body>
</html>
