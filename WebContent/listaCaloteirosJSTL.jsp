<%@ include file="/includes.jsp" %>

<html>
<c:import url="cabecalho.jsp"/>
	<head>
		<title>Lista de Caloteiros</title>
	</head>
	<body>
		<table border="1">
			<p>Lista de Caloteiros:</p>
			<c:forEach var="caloteiro" items="${lista}" varStatus="id">
				<tr bgcolor=#${id.count % 2 == 0 ? 'ff0000' : 'ffffff' }">
				<td>${caloteiro.id}</td>
				<c:choose>
					<c:when test="${not empty caloteiro.nome}">
						<td>${caloteiro.nome}</td>
					</c:when>
					<c:otherwise>
						<td>Nome não preenchido.</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${not empty caloteiro.email}">
						<td><a href="${caloteiro.email}">${caloteiro.email}</a></td>
					</c:when>
					<c:otherwise>
						<td>Email não preenchido.</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${not empty caloteiro.devendo}">
						<td>${caloteiro.devendo}</td>
					</c:when>
					<c:otherwise>
						<td>Devendo não preenchido.</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${not empty caloteiro.dataDivida}">
						<td><fmt:formatDate value="${caloteiro.dataDivida.time}" pattern="dd/MM/yyyy"/></td>
					</c:when>
					<c:otherwise>
						<td>Data da Divida não preenchido.</td>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</table>
		<c:import url="rodape.jsp"/>
	</body>
</html>