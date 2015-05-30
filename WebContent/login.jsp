<%@ include file="/includes.jsp" %>

<html>
	<head>
		<title>Acessar Caloteiro</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		
		<form action="sistema?logica=AutenticaUsuario&nome=Parametro" method="post">
			Login: <input type="text" name="login" value=""/>
			Senha: <input type="password" name="senha" value=""/>
			
			<input type="submit" value="Logar"/>
		</form>
		<p>${msgUsuario}</p>
		
		<c:import url="rodape.jsp" />
	</body>
</html>