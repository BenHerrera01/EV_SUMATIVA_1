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
		<h1>Lista de ventas</h1>
		
		<table class="table">
					<thead >
						<tr>
							<th>Id</th>
							<th>Nombre Venta</th>
							<th>Fecha</th>
							<th>Cliente</th>
							<th>Producto</th>
							<th></th>
						</tr>
					</thead>
					<c:forEach items="${listaVentas}" var="venta">
						<tr>
							<td>${venta.id}</td>
							<td>${venta.nombre_venta}</td>
							<td>${venta.fecha}</td>
							<td>${venta.cliente}</td>
							<td>${venta.producto}</td>
							<td><a class="btn btn-primary" href="../venta/editar/${venta.id}">Editar</a> <a class="btn btn-danger" href="../venta/eliminar/${venta.id}">Eliminar</a></td>
						</tr>
					</c:forEach>
		</table>
	<a href="../venta" class="btn btn-primary">Volver</a>	
	</div>
</body>
</html>