<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Producto</title>
</head>
<body>
	<div class="container">
		<h1>Lista de productos</h1>
		
		<table class="table">
					<thead >
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Precio</th>
							<th>Descripcion</th>
							<th>Cantidad</th>
							<th></th>
						</tr>
					</thead>
					<c:forEach items="${listaProductos}" var="producto">
						<tr>
							<td>${producto.id}</td>
							<td>${producto.nombre}</td>
							<td>${producto.precio}</td>
							<td>${producto.descripcion}</td>
							<td>${producto.cantidad}</td>
							<td><a class="btn btn-primary" href="../producto/editar/${producto.id}">Editar</a> <a class="btn btn-danger" href="../producto/eliminar/${producto.id}">Eliminar</a></td>
						</tr>
					</c:forEach>
		</table>
	<a href="../producto" class="btn btn-primary">Volver</a>	
	</div>
</body>
</html>