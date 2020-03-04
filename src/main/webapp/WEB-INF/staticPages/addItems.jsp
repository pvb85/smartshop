<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<style type="text/css">
.error {
	color: red;
	font-style: italic;
}
</style>



</head>

<body>


	<form:form action="saveitem" method="POST" commandName="item">


		<table>

			<tr>
				<td>Item Name:</td>
				<td><input type="text" name="itemName"
					placeholder="Enter Item Name" /></td>
				<td><form:errors path="itemName" cssClass="error"></form:errors></td>
			</tr>

			<tr>
				<td>Item Price:</td>
				<td><input type="text" name="price"
					placeholder="Enter Item price" /></td>
				<td><form:errors path="price" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Item Quanty:</td>
				<td><input type="text" name="quantity"
					placeholder="Enter Item Quanty" /></td>
				<td><form:errors path="quantity" cssClass="error"></form:errors></td>
			</tr>

			<td><input type="submit" name="" value="saveItem" /></td>

		</table>


	</form:form>

</body>
</html>