package br.triadworks.javaweb.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.triadworks.javaweb.dao.ConnectionFactory;
import br.triadworks.javaweb.exceptions.CaloteiroServletException;

@WebFilter(filterName="FiltroConexão", urlPatterns="/sistema")
public class FiltroConexao implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		Connection connection = new ConnectionFactory().getConnection();
		
		request.setAttribute("connection", connection);
		
		chain.doFilter(request, response);
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CaloteiroServletException("Erro ao tentar fechar conexão com o banco.");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
