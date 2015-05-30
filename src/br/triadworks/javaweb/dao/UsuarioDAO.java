package br.triadworks.javaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.triadworks.javaweb.modelo.Usuario;

public class UsuarioDAO {

	private Connection connection;
	
	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Usuario autentica(String login, String senha) {
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from usuario where login =? and senha =?");
			stmt.setString(1, login);
			stmt.setString(2, senha);
			
			Usuario usuario = null;
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String ulogin = rs.getString("login");
				String usenha = rs.getString("senha");
				
				usuario = new Usuario();
				
				usuario.setId(id);
				usuario.setNome(nome);
				usuario.setLogin(ulogin);
				usuario.setSenha(usenha);
			}
			
			rs.close();
			stmt.close();
			
			return usuario;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
