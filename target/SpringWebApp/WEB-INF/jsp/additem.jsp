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
<f:form action="addeditem.htm" method="post" modelAttribute="itemsbackingobject">
Item Name : <f:input path="itemName"/><f:errors path="itemName"/><br>
Item Price   : <f:input path="itemPrice"/><p style="color: red;"><f:errors path="itemPrice"/></p><br>
Item Quantity   : <f:input path="Quantity"/><p style="color: red;"><f:errors path="Quantity"/></p><br>
<input type="submit" value="Add"/>
</f:form>
</body>
</html>