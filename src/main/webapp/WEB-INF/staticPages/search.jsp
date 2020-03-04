<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/search" method="GET">
<input type="text" name="itemName" width=70%>
    <input type ="submit" value="Search"></form>
    
<h1> ${result} </h1>


	<table border="1" align="center">
	<c:if test="${ not empty lists}">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			
		</tr>
		</c:if>
		<c:forEach var="object" items="${lists}">
			<tr>
				<td><c:out value="${object.itemId}" /></td>
				<td><c:out value="${object.itemName}" /></td>
				<td><c:out value="${object.price}" /></td>
				<td><c:out value="${object.quantity}" /></td>
				
				<td>
					<%-- <a href="/addcart=<c:out value='${object.id}' />">AddtoCart</a> --%>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>