package br.triadworks.javaweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.exceptions.CaloteiroServletException;
import br.triadworks.javaweb.modelo.Logica;

@WebServlet("/sistema")
public class ServletSistema extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("logica");
		String cl = "br.triadworks.javaweb.modelo."+action+"Logica";
		
		try {
			Class classe = Class.forName(cl);
			Object obj = classe.newInstance();
			
			Logica logica = (Logica) obj;
			logica.executa(request, response);
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				throw new CaloteiroServletException(e.getMessage());
			} catch (InstantiationException e) {
				// TODO: handle exception
				throw new CaloteiroServletException(e.getMessage());
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getCause());
				throw new CaloteiroServletException(e.getMessage());
			}
			
		
	}
}
