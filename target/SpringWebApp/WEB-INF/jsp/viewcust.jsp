<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table  border="1" cellpadding="2" cellspacing = "2" align="center">
	<tbody>
		<tr height="150">
			<th>Customer ID</th>
			<th>Customer Name</th>
			<th>Customer Address</th>
		</tr>
		<c:forEach items="${custList}" var="custList">
		<tr>
			<td><c:out value="${custList[0]}"></c:out></td>
			<td><c:out value="${custList[1]}"></c:out></td>
			<td><c:out value="${custList[2]}"></c:out></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>