package br.triadworks.javaweb.modelo;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.triadworks.javaweb.dao.ConnectionFactory;
import br.triadworks.javaweb.dao.UsuarioDAO;

public class AutenticaUsuarioLogica implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Usuario usuarioAutenticado = null;
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Connection connection = (Connection)request.getAttribute("connection");
		
		UsuarioDAO dao = new UsuarioDAO(connection);
		usuarioAutenticado = dao.autentica(login, senha);
		
		if(usuarioAutenticado != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/menu.jsp");
			
			HttpSession session = request.getSession();
			
			request.setAttribute("nome", "RequestScope");
			session.setAttribute("nome", "SessionScope");
			
			session.setAttribute("usuarioAutenticado", usuarioAutenticado);
			
			response.sendRedirect("menu.jsp");
			//rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			request.setAttribute("msgUsuario", "Login ou Senha invalidos");
			
			response.sendRedirect("login.jsp");
			//rd.forward(request, response);
		}
		
	}

}
