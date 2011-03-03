<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../shared.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Usuários</title>
</head>
<body>

<a href="<c:url value="/usuario/novo"/>">Novo</a>

<br />

<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Login</th>
			<th>Ações</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${usuarioList}" var="usuario">
			<tr>
				<td>${usuario.id}</td>
				<td>${usuario.login}</td>
				<td><a href="<c:url value="/usuario/edita/${usuario.id}"/>">Edita</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>