package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.exceptions.CaloteiroServletException;
import br.triadworks.javaweb.modelo.Caloteiro;

@WebServlet("/adicionaCaloteiro")
public class AdicionaCaloteiro extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String devendo = request.getParameter("devendo");
		String dataDivida = request.getParameter("dataDivida");
		
		Calendar dataDividaConvertida = null;
		
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataDivida);
			dataDividaConvertida = Calendar.getInstance();
			dataDividaConvertida.setTime(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			out.println("Erro de conversao da data");
			throw new CaloteiroServletException();
		}
		
		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setNome(nome);
		caloteiro.setEmail(email);
		caloteiro.setDevendo(new Integer(devendo));
		caloteiro.setDataDivida(dataDividaConvertida);
		
		Connection connection = (Connection)request.getAttribute("connection");
		
		CaloteiroDAO dao = new CaloteiroDAO(connection);
		dao.adiciona(caloteiro);
		
		RequestDispatcher rd = request.getRequestDispatcher("/caloteiro-adicionado.jsp?nome="+caloteiro.getNome());
		rd.forward(request,response);
		
	}
}
