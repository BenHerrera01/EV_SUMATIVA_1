<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<title>Tienda</title>
</head>
<body>

	<jsp:include page="template/header.jsp"></jsp:include>
	<br>
	<div class="container">
		<table class="table">
					<thead >
						<tr>
							<th>Nombre</th>
							<th>Precio</th>
							<th></th>
						</tr>
					</thead>
					<c:forEach items="${productos}" var="producto">
						<tr>
							<td>${producto.nombre}</td>
							<td>${producto.precio}</td>
							<td><a class="btn btn-danger" href="../carrito/eliminar/${producto.id}">Eliminar</a></td>
						</tr>
					</c:forEach>
		</table>
		<h2>Total: ${total}</h2>
		<br><hr>
		<c:if test="${productos.size()>0}">
			<form action="../carrito/pagar" method="post">
			<input type="hidden" name="total" value="${total}">
			<input type="hidden" name="productos" >
			<button type=submit class="btn btn-primary">pagar</button>
			</form>
		</c:if>
		
	
	</div>
	




</body>
</html>