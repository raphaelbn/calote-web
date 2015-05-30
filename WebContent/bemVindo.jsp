<% String msg = "seja bem vindo ao meu JSP!"; %>
<html>
	<head>
		<title><%=msg %></title>
	</head>
	<body>
		Olá <%=request.getParameter("nome") %>, <%=msg %>
	</body>
</html>