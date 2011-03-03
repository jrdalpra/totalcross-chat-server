<%@ include file="../shared.jsp" %>
<mensagens tamanho="${tamanho}"><c:forEach items="${mensagemList}" var="mensagem"><mensagem id="${mensagem.id}" texto="${mensagem.texto}"/></c:forEach></mensagens>