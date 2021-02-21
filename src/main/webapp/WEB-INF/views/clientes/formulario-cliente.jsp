<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
	<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
	<style>
		label.error {
			color: #d9534f;
		}
		input.error {
			border: 1px solid #d9534f;
		}
	</style>
</head>
<body>

	<c:if test="${not empty mensagem_sucesso}">
		<div class="alert alert-success alert-dismissible fade show" role="alert">
  			<strong>Sucesso!</strong> ${mensagem_sucesso}
  			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	</c:if>

	<c:if test="${not empty mensagem_erro}">
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
  			<strong>Erro!</strong> ${mensagem_erro}
  			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	</c:if>

	<div class="container mt-4">
		<h1>Cadastro de Cliente</h1>
		<a href="/springproject01/" class="btn btn-light">Página inicial</a>
		<hr>

		<div class="row">
			<div class="col-md-4">
				<form id="form-cadastro" action="cadastrar-cliente" method="post">
					<div class="mb-4">
						<label>Nome do Cliente:</label>
						<form:input path="cliente.nome"
							class="form-control" autocomplete="off"
							placeholder="Ex: João da Silva" />
					</div>

					<div class="mb-4">
						<label>Email:</label>
						<form:input path="cliente.email"
							class="form-control"
							autocomplete="off" placeholder="Ex: joaosilva@gmail.com" />
					</div>
					<div>
						<button type="submit" class="btn btn-success">Cadastrar Cliente</button>
					</div>
				</form>
			</div>
		</div>

	</div>

	<script src="resources/js/jquery-3.5.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery.validate.min.js"></script>
	<script src="resources/js/messages_pt_BR.min.js"></script>

	<script>
		$(document).ready(function(){
			$("#form-cadastro").validate({
				rules : {
					'nome' : {
						required : true,
						minlength : 8,
						maxlength : 100
					},
					'email' : {
						required : true,
						email : true
					}
				}
			});
		})
	</script>
</body>
</html>









