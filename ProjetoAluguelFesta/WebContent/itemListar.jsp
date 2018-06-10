<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="modelo.dominio.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Festas</title>
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">
</head>
<script type="text/javascript">
	function confirmar(id, nome) {
		if (confirm('Deseja realmente excluir o item [' + nome + ']?')) {
			// modelo DOM
			window.location = 'excluirItem?id=' + id;
		}
	}
</script>

<script type="text/javascript">
	function alterar(id, status, nome) {
		if (confirm('Deseja realmente alterar o status do item [' + nome + ']?')) {
			// modelo DOM
			window.location = 'statusItem?id=' + id+ '&status=' + status;
		}
	}
</script>

<%
	//    TYPE CAST  /  CASTING
	List<Item> lista = (List<Item>) request.getAttribute("lista");
	Item it = null;
%>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<%
		if ((session.getAttribute("username") == null) || (session.getAttribute("password") == null)) {
			response.sendRedirect("login.jsp");
		}
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "0");
	%>

	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="index.html">FESTAS</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Dashboard"><a class="nav-link" href="index.jsp"> <i
						class="fa fa-fw fa-dashboard"></i> <span class="nav-link-text">Dashboard</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Tables"><a class="nav-link" href="listarTemas"> <i
						class="fa fa-fw fa-table"></i> <span class="nav-link-text">Temas</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Components"><a
					class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
					href="#collapseComponents" data-parent="#exampleAccordion"> <i
						class="fa fa-fw fa-wrench"></i> <span class="nav-link-text">Itens</span>
				</a>
					<ul class="sidenav-second-level collapse" id="collapseComponents">
						<li><a href="listarItensAtivos">Itens ativos</a></li>
						<li><a href="listarItensInativos">Itens inativos</a></li>
					</ul></li>
			</ul>
			<ul class="navbar-nav sidenav-toggler">
				<li class="nav-item"><a class="nav-link text-center"
					id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
				</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" data-toggle="modal"
					data-target="#exampleModal"> <i class="fa fa-fw fa-sign-out"></i>Sair
				</a></li>
			</ul>
		</div>
	</nav>

	<!-- AREA EDITAVEL -->
	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Itens</a></li>
				<li class="breadcrumb-item active">Itens cadastrados</li>
				<li class="breadcrumb-item active">Itens inativos</li>
			</ol>
			<!-- Area Chart Example-->
			<div class="card mb-3">
				<div class="card-header">
					<a class="btn btn-success" href="abrirInclusaoItem"
						id="toggleNavPosition">Adicionar Item</a>
				</div>
			</div>
			<!-- AREA EDITAVEL -->
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<tr>
					<th>Opções</th>
					<th>Código</th>
					<th>Status</th>
					<th>Nome</th>
					<th>Tema</th>
				</tr>
				<c:forEach var="it" items="${lista}">
					<tr>
						<td style="height: 35px; width: 326px;">
							<a class="btn btn-primary" href="editarItem?id=${it.id}">Alterar</a>
							<a class="btn btn-warning" href="javascript:alterar('${it.id}', '${it.status}', '${it.nome}')">Alterar status</a>
							<a class="btn btn-danger" href="javascript:confirmar('${it.id}', '${it.nome}')">Excluir</a>
						</td>
						<td>${it.id}</td>
						<td>${it.status}</td>
						<td>${it.nome}</td>
						<td>${it.tema.nome}</td>
					</tr>
				</c:forEach>
			</table>

			<!-- /.content-wrapper-->
			<footer class="sticky-footer">
				<div class="container">
					<div class="text-center">
						<small>Copyright © Equipe do projeto do sistema Festas da Rafaela</small>
					</div>
				</div>
			</footer>
			<!-- Scroll to Top Button-->
			<a class="scroll-to-top rounded" href="#page-top"> <i
				class="fa fa-angle-up"></i>
			</a>
			<!-- Logout Modal-->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Pronto para
								sair?</h5>
							<button class="close" type="button" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true"> X </span>
							</button>
						</div>
						<div class="modal-body">Clique em "Sair" para encerrar sua
							sessão.</div>
						<div class="modal-footer">
							<button class="btn btn-secondary" type="button"
								data-dismiss="modal">Cancelar</button>
							<a class="btn btn-primary" href="logout">Sair</a>
						</div>
					</div>
				</div>
			</div>
			<!-- Bootstrap core JavaScript-->
			<script src="vendor/jquery/jquery.min.js"></script>
			<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
			<!-- Core plugin JavaScript-->
			<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
			<!-- Custom scripts for all pages-->
			<script src="js/sb-admin.min.js"></script>
			<!-- Custom scripts for this page-->
			<script src="js/sb-admin-datatables.min.js"></script>
			<script src="js/sb-admin-charts.min.js"></script>
		</div>
</body>

</html>
