<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Criar conta</title>
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">
<link rel="icon" type="images/png" sizes="192x192"  href="images/fav.png">
<meta name="theme-color" content="#FFA500">
</head>

<body class="bg-dark">

	<div class="container">
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Criar conta</div>
			<div class="card-body">
				<form action="salvarUsuario" method="post">
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleInputName">Nome</label> <input name="nome"
									class="form-control" id="exampleInputName" type="text"
									aria-describedby="nameHelp" placeholder="Ex.: Dolores"
									value="${usuario.nome}">
							</div>
							<div class="col-md-6">
								<label for="exampleInputLastName">Sobrenome</label> <input
									name="sobrenome" class="form-control" id="exampleInputLastName"
									type="text" aria-describedby="nameHelp"
									placeholder="Ex.: Fuertes de Barriga" value="${usuario.sobrenome}">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="cpf">CPF</label> <input
							class="form-control" id="cpf" type="text"
							aria-describedby="emailHelp" name="cpf"
							placeholder="123.456.789-10" value="${usuario.cpf}">
							<small>pontuações são dispensáveis</small>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Nome de usuário</label> <input
							class="form-control" id="exampleInputEmail1" type="text"
							aria-describedby="emailHelp" name="nomeUsuario"
							placeholder="Ex.: doloresfuertes" value="${usuario.nomeUsuario}">
					</div>


					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleInputPassword1">Senha</label> <input
									class="form-control" id="exampleInputPassword1" type="password"
									name="senha" placeholder="Cadastre uma senha"
									autocomplete="new-password" value="${usuario.senha}"> <small>A
									senha deve conter no mínimo 5 caracteres</small>
							</div>
							<div class="col-md-6">
								<label for="exampleConfirmPassword">Senha administrador</label>
								<input class="form-control" id="exampleConfirmPassword"
									type="password" name="pass" placeholder="Ex.: FESTAS123"
									autocomplete="off" value="${usario.pass}"> <small>Insira
									a senha disponibilizada pelo administrador</small>
							</div>
						</div>
					</div>
					<button class="btn btn-primary btn-block" href="login.jsp">Criar
						conta</button>
				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="login.jsp">Página de login</a>
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
