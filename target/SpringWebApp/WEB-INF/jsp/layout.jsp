<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" cellpadding="2" cellspacing = "2" align="center">
	<tr>
		<td height="30" colspan="2">
			<tiles:insertAttribute name="header"/>
		</td>
	</tr>
	<tr>
		<%-- <td height="250">
		<tiles:insertAttribute name="indexpage" />
		</td> --%>
		<td height="350">
		<tiles:insertAttribute name="body" />
		</td>
	</tr>
	<tr>
		<td height="30" colspan="2">
		<tiles:insertAttribute name="footer"/>
		</td>
	</tr>
</table>
</body>
</html>