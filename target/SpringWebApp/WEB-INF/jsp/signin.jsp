<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="userdetails.htm" method="post" modelAttribute="loginFormBackingObject">
First Name : <f:input path="fname"/><f:errors path="fname"/><br>
Last  Name : <f:input path="lname"/><f:errors path="lname"/><br>
Username   : <f:input path="uname"/><p style="color: red;"><f:errors path="uname"/></p><br>
Password   : <f:password path="pwd"/><p style="color: red;"><f:errors path="pwd"/></p><br>
<input type="submit" value="submit"/>
</f:form>
</body>
</html>