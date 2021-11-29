<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Usuario</title>
</head>
<body>
<jsp:include page="template/headerAdmin.jsp"></jsp:include>
	<div class="container">
		<h1>Lista de usuarios</h1>
		
		<table class="table">
					<thead >
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Email</th>
							<th>Edad</th>

						</tr>
					</thead>
					<c:forEach items="${listaUsuarios}" var="usuario">
						<tr>
							<td>${usuario.id}</td>
							<td>${usuario.nombre}</td>
							<td>${usuario.apellido}</td>
							<td>${usuario.email}</td>
							<td>${usuario.edad}</td>
							<c:if test="${!usuario.email.equals(userEmail)}">
								<td><a class="btn btn-danger" href="../usuario/eliminar/${usuario.id}">Eliminar</a></td>
							</c:if>

						</tr>
					</c:forEach>
		</table>
	<input onclick="history.go(-1)"  class="btn btn-primary" value="Volver">
	</div>
</body>
</html>