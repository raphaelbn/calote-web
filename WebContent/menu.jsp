<%@ include file="/includes.jsp" %>

<html>
	<head>
		<title>Menu Sistema Caloteiro</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		<p>Seja bem vindo, ${usuarioAutenticado.nome} ao sistema caloteiros:</p>
		<p>
			<o1>
				<a href='<c:url value="/adiciona-caloteiro.jsp"/>'>Adicionar caloteiro</a>
			</o1>
		</p>
		<p>
			<o1>
				<a href='<c:url value="/sistema?logica=ListaCaloteiro"/>'>Listar caloteiro</a>
			</o1>
		</p>
		<p>
			<o1>
				<form action="sistema?logica=DeletaCaloteiro" method="post">
					Deletar caloteiro por id:
					<input type="text" name="id" value=""/>
					<input type="submit" value="Deletar"/>
				</form>
			</o1>
		</p>
		
		<hr>
		Variaveis EL:
		<p>
			1. param: ${param.nome} <br>
			2. requestScope ${requestScope.nome} <br>
			3. sessionScope: ${sessionScope.nome} <br>
			4. Sem especificar: ${nome} <br>
		</p>
		<hr>
		
		<c:import url="rodape.jsp" />
	</body>
</html>