<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- "<c:url value='/dang-nhap'/>" -->
<div class="container">
	<div class="d-flex justify-content-center h-100">
	<form action ="dang-nhap" id="formLogin" method="POST" >  	
		<div class="card">
			<div class="card-header">
				<h3>Sign In</h3>
				<div class="d-flex justify-content-end social_icon">
					<span><i class="fab fa-facebook-square"></i></span>
					<span><i class="fab fa-google-plus-square"></i></span>
					<span><i class="fab fa-twitter-square"></i></span>
				</div>
			</div>
			 
			 	
			<div class="card-body">
			
			
			<div class="alert alert-${alert}">
 			 <strong>${message}</strong> 
			</div>
			
					 <div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="userName" id ="userName" name ="userName" >
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" class="form-control" placeholder="password" id="password" name="password">
					</div>
					<div class="row align-items-center remember">
						<input type="checkbox">Remember Me
					</div> 
					<div class="form-group">
						<input type="hidden" value="login" name="action" >
						<button type="submit" class="btn float-right login_btn">Login</button>
					</div>
					</div>			
				
			
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Don't have an account?<a href="#">Sign Up</a>
				</div>
				<div class="d-flex justify-content-center">
					<a href="#">Forgot your password?</a>
				</div>
			</div>
		</div>
		</form>
	</div>
</div>

</body>
</html>