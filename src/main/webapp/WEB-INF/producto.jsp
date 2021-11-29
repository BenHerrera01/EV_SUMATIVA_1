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
	<jsp:include page="template/headerAdmin.jsp"></jsp:include>
	<div class="container">
	<br>
	<div class="row">
		<div class="col">
			<h2>Registro de productos</h2>
				<form action="producto/add" method="post">
					<table class="table table-bordered">
						<tr>
							<td><label for="nombre">Nombre: </label></td>
							<td><input type="text" name="nombre" id="nombre" required></td>
		
						</tr>
						<tr>
							<td><label for="marca">Marca: </label></td>
							<td><input type="text" name="marca" id="marca" required></td>
		
						</tr>
						<tr>
							<td><label for="precio">Precio: </label></td>
							<td><input type="number" name="precio" id="precio" required></td>
		
						</tr>
						<tr>
							<td><label for="descripcion">Descripcion: </label></td>
							<td><input type="text" name="descripcion" id="descripcion" required></td>
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
							<td></td>
							<td><input type="reset" value="limpiar" class="btn btn-warning"> <input type="submit" value="enviar" class="btn btn-success"></td>
							
						</tr>
					</table>
				</form>

		<c:forEach items="${errores}" var="error">
			<span style="color:red;">${error}</span><br>
		</c:forEach>
		</div>
		
	<div class="col">
		<h2>Registro de categorias</h2>
				<form action="categoria/add" method="post">
					<table class="table table-bordered">
						<tr>
							<td><label for="nombre">Nombre: </label></td>
							<td><input type="text" name="nombre" id="nombre" required></td>
						</tr>
						<tr>
							<td><label for="productos">Producto: </label></td>
							<td><select class="form-select" name="productos" multiple>
									<c:forEach items="${listaProductos}" var="producto">
										<option value="${producto.id}">${producto.nombre}</option>
									</c:forEach>
							</select>
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
		

	</div>
</body>
</html>