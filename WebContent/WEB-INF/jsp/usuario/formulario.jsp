<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../shared.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Novo Usuário</title>
</head>
<body>
	
	<form action="<c:url value="/usuario/${acao}"/>" method="post">
		<input name="usuario.id" value="${usuario.id}" type="hidden"/>
		<label>Login</label><br />
		<input name="usuario.login" value="${usuario.login}" maxlength="100"/><br />
		<label>Senha</label><br />
		<input name="usuario.senha" value="${usuario.senha}" maxlength="20" type="password"/><br />
		<input type="submit" value="Salvar"/>
	</form>

</body>
</html>