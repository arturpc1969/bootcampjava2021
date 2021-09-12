<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Autores</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body class="container">
	<h1 class="text-center">Cadastro de Autores</h1>
	<form action="<c:url value="/autores"></c:url>" method="post">
		<div class="form-group row">
			<label for="nome" class="col-sm-2 col-form-label">Nome</label>
			<div class="col-sm-10">
				<input id="nome" name="nome" class="form-control form-control-sm">
			</div>
		</div>
		<div class="form-group row">
			<label for="email" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-10">
				<input id="email" name="email" class="form-control form-control-sm">
			</div>
		</div>
		<div class="form-group row">
			<label for="dataDeNascimento" class="col-sm-2 col-form-label">Data
				de Nascimento</label>
			<div class="col-sm-10">
				<input id="dataDeNascimento" name="dataDeNascimento"
					class="form-control form-control-sm">
			</div>
		</div>
		<div class="form-group row">
			<label for="miniCurriculo" class="col-sm-2 col-form-label">Mini
				Currículo</label>
			<div class="col-sm-10">
				<textarea id="miniCurriculo" name="miniCurriculo"
					class="form-control form-control-sm" rows="3"></textarea>
			</div>
		</div>
		<input type="submit" value="Cadastrar" class="mt-2 btn-primary">
	</form>
	<h1 class="text-center">Lista de Autores</h1>
	<table class="table table-hover table-striped table-bordered table-sm">
		<thead class="thead-dark">
			<tr>
				<th>NOME</th>
				<th>EMAIL</th>
				<th>DATA DE NASCIMENTO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${autores}" var="t">
				<tr>
					<td>${t.nome}</td>
					<td>${t.email}</td>
					<td><fmt:parseDate value="${t.dataDeNascimento}"
							pattern="yyyy-MM-dd" var="formatada" type="date" /> <fmt:formatDate
							value="${formatada}" pattern="dd/MM/yyyy" type="date" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>