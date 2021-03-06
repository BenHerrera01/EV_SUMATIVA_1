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
		<h1>Edicion de productos</h1>
		<form action="../editarProducto" method="post">
			<table class="table table-bordered">
				<tr>
					<td><label for="nombre">Nombre: </label></td>
					<td><input type="text" name="nombre" id="nombre" value="${producto.nombre}" required></td>

				</tr>
				<tr>
					<td><label for="marca">Marca: </label></td>
					<td><input type="text" name="marca" id="marca" value="${producto.marca}" required></td>

				</tr>
				<tr>
					<td><label for="precio">Precio: </label></td>
					<td><input type="number" name="precio" id="precio" value="${producto.precio}" required></td>

				</tr>
				<tr>
					<td><label for="descripcion">Descripcion: </label></td>
					<td><input type="text" name="descripcion" id="descripcion" value="${producto.descripcion}"
						required></td>
				</tr>
				<tr>
					<td><label for="categoria">Categoria: </label></td>
					<td><select class="form-select" name="categorias" multiple>
							<c:forEach items="${listaCategorias}" var="categoria">
								<option value="${categoria.id}">${categoria.nombre}</option>
							</c:forEach>
					</select>
				</tr>
				<tr>
					<td><input type="hidden" name="id" id="id"
						value="${producto.id}"></td>
					<td><input type="submit" value="Editar"
						class="btn btn-success"></td>

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