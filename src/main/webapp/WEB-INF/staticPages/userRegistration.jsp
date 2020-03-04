<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
    

    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
	font-style: italic;
}
</style>


</head>

<body>
<a href="/">Home</a>
	<form:form action="registerUser" method="POST" commandName="user">
		<div class="container">

			<table align="center">
				<h4 align="center">CUSTOMER REGISTRATION</h4>


				<tr>
					<td><label for="name"><b>NAME</b></label></td>
					<td><input type="text" placeholder="Enter Name" name=userName></td>
					
					<td><form:errors
						path="userName" cssClass="error"></form:errors></td>
				</tr>
				<tr>
					<td><label for="password"><b>PASSWORD</b></label></td>
					<td><input type="password" placeholder="Enter password"
						name=userPasword></td>
						<td><form:errors
						path="userPasword" cssClass="error"></form:errors></td>
				</tr>

				<tr>
					<td><label for="email"><b>EMAIL</b></td>
					</label>
					<td><input type="text" placeholder="Enter Email" name=email></td>
					<td><form:errors
						path="email" cssClass="error"></form:errors></td>
				</tr>


				<tr>
					<td><label for="address"><b>ADDRESS</b></td>
					</label>
					<td><input type="text" placeholder="Enter Address"
						name=address></td>
						<td><form:errors
						path="address" cssClass="error"></form:errors></td>
				</tr>

				<tr>
				<tr>
					<td><label for="role"><b>ROLE</b></td>
					</label>
					</td>
					<td><input type="radio" name="role" value="A"> Manager</td>
					<td><input type="radio" name="role" value="U"> User</td>
					</td>


				</tr>

				<td><input type="submit" value="submit"> <input
					type="reset" value="clear"></td>
				</tr>



			</table>
		</div>
	</form:form>
</body>
</html>