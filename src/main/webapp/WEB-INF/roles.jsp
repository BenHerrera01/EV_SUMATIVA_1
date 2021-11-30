<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Roles</title>
</head>
<body>
	<jsp:include page="template/headerAdmin.jsp"></jsp:include>
	<div class="container">
	<br>
	<div class="row">
		<div class="col">
			<h2>Registro de Roles</h2>
				<form action="../role/insertar" method="post">
					<table class="table table-bordered">
						<tr>
							<td><label for="nombre">Nombre: </label></td>
							<td><input type="text" name="nombre" id="nombre" required></td>
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
	</div>
	
	<table class="table">
					<thead >
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th></th>
						</tr>
					</thead>
					<c:forEach items="${listaRoles}" var="rol">
						<tr>
							<td>${rol.id}</td>
							<td>${rol.nombre}</td>
						</tr>
					</c:forEach>
		</table>			

	</div>
</body>
</html>