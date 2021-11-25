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
		<h1>Registro de usuarios</h1>
		<form action="usuario/add" method="post">
			<table class="table table-bordered">
				<tr>
					<td><label for="nombre">Nombre: </label></td>
					<td><input type="text" name="nombre" id="nombre" required></td>

				</tr>
				<tr>
					<td><label for="apellido">Apellido: </label></td>
					<td><input type="text" name="apellido" id="apellido" required></td>

				</tr>
				<tr>
					<td><label for="email">Email: </label></td>
					<td><input type="text" name="email" id="email" required></td>

				</tr>
				<tr>
					<td><label for="edad">Edad: </label></td>
					<td><input type="number" name="edad" id="edad" required></td>

				</tr>
				<tr>
					<td></td>
					<td><input type="reset" value="limpiar" class="btn btn-warning"> <input type="submit" value="enviar" class="btn btn-success"></td>
				</tr>
			</table>
		</form>
		<c:forEach items="${errores}" var="error">
			<span style="color:red;">${error}</span><br>
		</c:forEach>
		
	</div>
</body>
</html>