<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="upload.htm" method="post" enctype="multipart/form-data">
Select a File : <input type="file" name="files1"><br>
<input type="submit" value="UPLOAD"></form>
<p style="color: red;">
<c:if test="${message ne null }">
	<c:out value="${message}"/>
</c:if>
</p>
</body>
</html>