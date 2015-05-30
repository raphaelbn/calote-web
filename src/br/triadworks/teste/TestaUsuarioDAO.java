package br.triadworks.teste;

import java.sql.Connection;

import br.triadworks.javaweb.dao.ConnectionFactory;
import br.triadworks.javaweb.dao.UsuarioDAO;
import br.triadworks.javaweb.modelo.Usuario;

public class TestaUsuarioDAO {

	public static void main(String[] args) {
		Connection connection = new ConnectionFactory().getConnection();
		
		UsuarioDAO dao = new UsuarioDAO(connection);
		
		Usuario usuarioLogado = dao.autentica("rnascimento", "admin");
		
		if(usuarioLogado !=null) {
			System.out.println(usuarioLogado.getNome());
		}
		
		Usuario usuarioErrado = dao.autentica("raphael", "890");
		
		if(usuarioErrado == null) {
			System.out.println("Usuario não Existe");
		}
		
	}
}
