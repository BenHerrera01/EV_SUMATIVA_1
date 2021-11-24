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
		<h1>Registro de ventas</h1>
		<form action="venta/add" method="post">
			<table class="table table-bordered">
				<tr>
					<td><label for="nombre_venta">Nombre Venta: </label></td>
					<td><input type="text" name="nombre_venta" id="nombre_venta" required></td>

				</tr>
				<tr>
					<td><label for="fecha">fecha: </label></td>
					<td><input type="date" name="fecha" id="fecha" required></td>

				</tr>
				<tr>
					<td><label for="cliente">Cliente: </label></td>
					<td><input type="text" name="cliente" id="cliente" required></td>

				</tr>
				<tr>
					<td><label for="producto">Producto: </label></td>
					<td><input type="text" name="producto" id="producto" required></td>

				</tr>
				<tr>
					<td></td>
					<td><input type="reset" value="limpiar" class="btn btn-warning"> <input type="submit" value="enviar" class="btn btn-success"></td>
					
				</tr>
			</table>
		</form>

		<span style="color:red;">${mensaje}</span>

	</div>
</body>
</html>