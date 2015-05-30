<!DOCTYPE html>
<%@ include file="/includes.jsp" %>
<html>
	<c:import url="cabecalho.jsp"/>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Adiciona Caloteiro</title>
	</head>
	<body>
		<hr>
			Usuario ${usuarioAutenticado.nome} logado com sucesso.
		<hr>
		<form action="sistema" method="post" id="formAdicionaCaloteiro">
			
			Nome:<input type="text" name="nome" id="labelNome" ><br>
			Email:<input type="text" name="email" id="labelEmail" ><br>
			Devendo:<input type="text" name="devendo" id="labelDevendo" ><br>
			Data da Divida<input type="text" name="dataDivida" id="labelData" ><br>
			
			<input type="hidden" name="logica" value="AdicionaCaloteiro">
			
			<input type="submit" value="Salvar" id="button">
		</form>
		<c:import url="rodape.jsp"/>
	</body>
	<script></script>
	<script src="js/jquery-1.13.3.min.js"></script>
	<script src="js/jquery-maskMoney.min.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/jquery-maskInput.min.js"></script>
	<script src="js/mascara-validacoes.js"></script>
</html>