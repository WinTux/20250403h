<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Carreras</h3>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>Nombre</td>
			<td>Edificio</td>
		</tr>
		<c:forEach var="ca" items="${carrs}">
			<tr>
				<td>${ca.carreraID}</td>
				<td>${ca.nombre}</td>
				<td>${ca.edificio}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>