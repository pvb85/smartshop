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

<style type="text/css">
.error {
	color: red;
	font-style: italic;
}
</style>
</head>
<center>
<h4>LOGIN</h4>
</center>
<body>


<a href="/">Home</a>

	<form:form action="login" method="POST" commandName="user">


<table align="center" >
<tr>
<td><label for="userName"><b>USERNAME</b></label></td>
<td><input type="text"  name=userName  placeholder="Enter Name" ></td>
<td><form:errors path="userName" cssClass="error"></form:errors></td>
</tr>

<tr>
<td><label for="userPasword"><b>PASSWORD</b></label></td>
<td><input type="password"  name=userPasword  placeholder="Enter Password" ></td>
<td><form:errors path="userPasword" cssClass="error"></form:errors></td>
</tr>
<center>
<tr>

<td><input type="submit" value="LOGIN" ></td>
</tr>
<h1>${result}</h1>

</center>
</table>
</form:form>
</body>
</html>