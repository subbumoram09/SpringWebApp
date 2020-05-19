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
<f:form action="added.htm" method="post" modelAttribute="customerObject">
Customer ID : <f:input path="custId"/><f:errors path="custId"/><br>
Customer Name : <f:input path="custName"/><f:errors path="custName"/><br>
Customer Address   : <f:input path="custAdd"/><p style="color: red;"><f:errors path="custAdd"/></p><br>
<input type="submit" value="Add"/>
</f:form>
</body>
</html>