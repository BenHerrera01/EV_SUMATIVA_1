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
	<div>
		<jsp:include page="template/header.jsp"></jsp:include>
		<br>
		<div class="container">
			<div class="row">
				<div  class="col-4">
					<form class="form-inline" action="/busquedaCategoria" method="get">
						<input class="form-control" type="search" placeholder="Buscar por categoria" name="categoria">
						<button class="btn btn-outline-primary form-control" type="submit">Buscar</button>
					</form>
				</div>
				<div class="col-4">
					<form class="form-inline" action="/busquedaCategoriaDinamica" method="get">
						<select class="form-control" name="nombreCategoria">
							<option selected>Buscar por categoria dinamica</option>
							<c:forEach items="${listaCategorias}" var="categoria">
								<option value="${categoria.nombre}">${categoria.nombre}</option>
							</c:forEach>
						</select>
						<button class="btn btn-outline-primary form-control" type="submit">Buscar</button>
						<br><br>
						<a href="../home" class="btn btn-outline-primary form-control">Resetear Busqueda</a>
					</form>
					
				</div>
				<div  class="col-4">
					<form class="form-inline" action="/busquedaKeyword" method="get">
						<input class="form-control" type="search" placeholder="Buscar por palabra clave" name="keyword">
						<button class="btn btn-outline-primary form-control" type="submit">Buscar</button>
					</form>
				</div>
			</div>
		</div>
		<br><br>
		<div class="container">
		<div class="row">
			<c:if test="${listaProductos.isEmpty()}">
					<span>No se ha encontrado nada</span>
			</c:if>
			<c:forEach var="producto" items="${listaProductos}">				
				<div class="col-3">
					<div class="card">
						<div class="card-header">
							<label>${producto.marca}</label>
						</div>
						<div class="card-body">
							<h5 class="card-title">${producto.nombre}</h5>
							<p class="card-text">${producto.descripcion}</p>
							<p class="card-text">$ ${producto.precio}</p>
							<c:forEach items="${producto.categorias}" var="categoria" varStatus="loop">
								<span class="card-text">	
									<small class="text-muted">
										${categoria.nombre}
									</small>
								<c:if test="${loop.index+1 != producto.categorias.size()}">
									<small class="text-muted"> - </small>
								</c:if>	
								</span>
							</c:forEach>
						</div>
						<div class="card-footer">
							<div>
								<a class="btn btn-primary" href="../carrito/agregar/${producto.id}">Agregar al carro</a>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
		</div>
		</div>

	</div>	
	

		

</body>
</html>