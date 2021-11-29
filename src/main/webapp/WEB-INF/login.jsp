<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Login</title>
</head>
<body>
	<div class="vh-70">
		<div class="container py-5 h-100">
			<div class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card bg-dark text-white" style="border-radius: 1rem;">
						<div class="card-body p-5 text-center">
							<div class="mb-md-5 mt-md-4 pb-5">
								<h2 class="fw-bold mb-2 text-uppercase">Login</h2>
								<br>
								<form action="../login" method="post">
									<div class="form-outline form-white mb-4">
										<input type="text" id="email" name="email" class="form-control form-control-lg"/> 
										<label class="form-label" for="email">Email</label>
									</div>
									<div class="form-outline form-white mb-4">
										<input type="password" name="password" id="password" class="form-control form-control-lg"/> 
										<label	class="form-label" for="password">Password</label>
									</div>
									<div align="center">
										<c:if test="${param.error}">
											<p style="color: red;">Check email or password field</p>
										</c:if>
									</div>	 
									<button class="btn btn-dark btn-outline-light" name="Submit" type="Submit" value="Login">Login</button>
								</form>
								
							</div>

							<div>
								<p class="mb-0"><a href="../registro" class="text-white">Registrarse</a>
								</p>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>