<%@page import="br.triadworks.javaweb.dao.ConnectionFactory"%>
<%@page import="java.util.List"%>
<%@page import="br.triadworks.javaweb.dao.CaloteiroDAO"%>
<%@page import="br.triadworks.javaweb.modelo.Caloteiro"%>

<html>
	<head>
		<title>Lista de Caloteiros</title>
	</head>
	<body>
		Lista de Caloteiros:<br>
		<% CaloteiroDAO dao = new CaloteiroDAO(new ConnectionFactory().getConnection());
		   List<Caloteiro> lista = dao.getLista();
		   
		   for(Caloteiro c : lista) {
		%>
		<li>
			<%=c.getNome() %> - <%=c.getEmail() %>
		</li>
		<%} %>
	</body>
</html>