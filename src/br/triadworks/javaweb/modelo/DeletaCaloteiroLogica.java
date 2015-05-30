package br.triadworks.javaweb.modelo;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.dao.CaloteiroDAO;

public class DeletaCaloteiroLogica implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		
		Caloteiro caloteiro = new Caloteiro();
		
		Connection connection = (Connection)request.getAttribute("connection");
		
		CaloteiroDAO dao = new CaloteiroDAO(connection);
		
		caloteiro = dao.getCaloteiro(Long.parseLong(id));
		
		String nome = caloteiro.getNome();
		
		System.out.println(caloteiro.getNome());
		
		dao.deleta(caloteiro);
		
		RequestDispatcher rd = request.getRequestDispatcher("/caloteiro-deletado.jsp?nome="+nome);
		rd.forward(request,response);
		
	}

}
