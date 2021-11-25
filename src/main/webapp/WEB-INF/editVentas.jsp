<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Venta</title>
</head>
<body>
	<div class="container">
		<h1>Edicion de ventas</h1>
		<form action="../editarVenta" method="post">
			<table class="table table-bordered">
				<tr>
					<td><label for="nombre_venta">Nombre Venta: </label></td>
					<td><input type="text" name="nombre_venta" id="nombre_venta" value="${venta.nombre_venta}" required></td>

				</tr>
				<tr>
					<td><label for="fecha">Fecha: </label></td>
					<td><input type="date" name="fecha" id="fecha" value="${venta.fecha}" required></td>

				</tr>
				<tr>
					<td><label for="cliente">Cliente: </label></td>
					<td><input type="text" name="cliente" id="cliente" value="${venta.cliente}" required></td>

				</tr>
				<tr>
					<td><label for="producto">Producto: </label></td>
					<td><input type="text" name="producto" id="producto" value="${venta.producto}" required></td>

				</tr>
				<tr>
					<td><input type="hidden" name="id" id="id" value="${venta.id}"></td>
					<td><input type="submit" value="Editar" class="btn btn-success"></td>
					
				</tr>
			</table>
			<c:forEach items="${errores}" var="error">
				<span style="color:red;">${error}</span><br>
			</c:forEach>
			
		</form>
		<br>
		<a href="../lista" class="btn btn-primary">Volver</a>	
	</div>
</body>
</html>