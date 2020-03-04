<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

    

  

    

    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    

    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

</head>

<body>

<table class="table">

				<thead>

					<tr>

						<th scope="col">Item ID</th>

						<th scope="col">Item name</th>

						<th scope="col">price</th>

						<th scope="col">quantity</th>

					</tr>

					<c:forEach items="${listItems}" var="inv">

						<tr>

							<td>${inv.itemId}</td>

							<td>${inv.itemName}</td>

							<td>${inv.price}</td>

							<td>${inv.quantity}</td>

							<td><a href="<%=request.getContextPath()%>/edit?itemId=${inv.itemId}">Edit</a></td>
							<td><a href="<%=request.getContextPath()%>/delete?itemId=${inv.itemId}">Delete</a></td>
						</tr>

					</c:forEach>

			</table>





</body>

</html>