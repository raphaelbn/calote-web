package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class ServletContador extends HttpServlet{

	private int contador = 0;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		contador++;
		
		PrintWriter sysout = response.getWriter();
		sysout.println("<html>");
		sysout.println("<body>");
		sysout.println("Servlet Numero:" + contador);
		sysout.println("</body>");
		sysout.println("</html>");
	}
}
