<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Registro</title>
</head>
<body>
	<div class="vh-70">
		<div class="container py-5 h-100">
			<div class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card bg-dark text-white" style="border-radius: 1rem;">
						<div class="card-body p-5 text-center">
							<div class="mb-md-5 mt-md-4 pb-5">
								<h3 class="fw-bold mb-2 text-uppercase">Registro</h3>
								<br>
								<form action="../registro" method="post">
									<div class="form-outline form-white mb-4">
										<input type="text" id="nombre" name="nombre" class="form-control form-control-lg"/> 
										<label class="form-label" for="nombre">Nombre</label>
									</div>
									<div class="form-outline form-white mb-4">
										<input type="text"  id="apellido" name="apellido" class="form-control form-control-lg"/> 
										<label	class="form-label" for="apellido">Apellido</label>
									</div>
									<div class="form-outline form-white mb-4">
										<input type="email"  id="email" name="email" class="form-control form-control-lg"/> 
										<label	class="form-label" for="email">Email</label>
									</div>
									<div class="form-outline form-white mb-4">
										<input type="text"  id="edad" name="edad" class="form-control form-control-lg"/> 
										<label	class="form-label" for="edad">Edad</label>
									</div>
									<div class="form-outline form-white mb-4">
										<input type="password"  id="password" name="password" class="form-control form-control-lg"/> 
										<label	class="form-label" for="password">Password</label>
									</div>
									<div class="form-outline form-white mb-4">
										<input type="password"  id="passwordConfirmation" name="passwordConfirmation" class="form-control form-control-lg"/> 
										<label	class="form-label" for="passwordConfirmation">Confirmar Password</label>
									</div>
									<div class="form-outline form-white mb-4">
										<select class="form-control form-control-sm" id="role" name="role">
											  <option value="USER_ROLE">User</option>
											  <option value="ADMIN_ROLE">Admin</option>
										</select>
										<label	class="form-label" for="role">Rol</label>
									</div>
									<button class="btn btn-dark btn-outline-light" type="submit">Registrarse</button>
								</form>
								<span style="color:red">${error}</span><br>
							</div>
							<div>
								<p class="mb-0"><a href="../login" class="text-white">Login</a></p>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>