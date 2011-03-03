<%@ include file="../shared.jsp" %>
<usuarios tamanho="${tamanho}"><c:forEach items="${usuarioList}" var="usuario"><usuario id="${usuario.id}" login="${usuario.login}"/></c:forEach></usuarios>