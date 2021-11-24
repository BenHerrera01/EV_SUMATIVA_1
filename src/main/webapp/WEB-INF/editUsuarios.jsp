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
	<div class="container">
		<h1>Edicion de usuarios</h1>
		<form action="../editarUsuario" method="post">
			<table class="table table-bordered">
				<tr>
					<td><label for="nombre">Nombre: </label></td>
					<td><input type="text" name="nombre" id="nombre" value="${usuario.nombre}" required></td>

				</tr>
				<tr>
					<td><label for="apellido">Apellido: </label></td>
					<td><input type="text" name="apellido" id="apellido" value="${usuario.apellido}" required></td>

				</tr>
				<tr>
					<td><label for="email">Email: </label></td>
					<td><input type="text" name="email" id="email" value="${usuario.email}" required></td>

				</tr>
				<tr>
					<td><label for="edad">Edad: </label></td>
					<td><input type="number" name="edad" id="edad" value="${usuario.edad}" required></td>

				</tr>
				<tr>
					<td><input type="hidden" name="id" id="id" value="${usuario.id}"></td>
					<td><input type="submit" value="Editar" class="btn btn-success"></td>
					
				</tr>
			</table>
		<span style="color: red;">${mensaje}</span>
		</form>
		<a href="../lista" class="btn btn-primary">Volver</a>	
	</div>
</body>
</html>