package br.com.foursys.locadora.util;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.EstadoDAO;
import br.com.foursys.locadora.model.Estado;

public class TestaBuscarEstado {
	public static void main(String[] args) {
		Connection bd = ConnectionFactory.getConnection();
		EstadoDAO dao = new EstadoDAO(bd);
		
		try {
			List<Estado> estados = dao.buscarTodos();
			for(Estado estado : estados) {
				
				System.out.println("Cidade: "+estado.getNome());
				System.out.println("UF: "+estado.getUf());
				
				bd.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro! nao foi possivel exibir Estado");
			
			e.printStackTrace();
		}
	}
}
