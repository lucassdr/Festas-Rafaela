<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Login</title>
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Login</div>
			<div class="card-body">
				<form action="login" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Nome de usuário</label> <input
							class="form-control" name="username" id="exampleInputEmail1"
							type="text" aria-describedby="emailHelp"
							placeholder="joaozinho@email.com">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Senha</label> <input
							class="form-control" name="pass" id="exampleInputPassword1"
							type="password" placeholder="*******">
					</div>
					
					<button class="btn btn-primary btn-block">Login</button>
				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="cadastrar.jsp">Criar conta</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
