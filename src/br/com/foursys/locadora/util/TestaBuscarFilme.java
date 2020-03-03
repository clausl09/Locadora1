package br.com.foursys.locadora.util;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.model.Filme;

public class TestaBuscarFilme {
	public static void main(String[] args) {
		Connection bd = ConnectionFactory.getConnection();
		FilmeDAO dao = new FilmeDAO(bd);
		try {
			List<Filme> filmes = dao.buscarTodos();
			for (Filme filme : filmes) {

				System.out.println("Codigo: " + filme.getCodigo());
				System.out.println("Nome: " + filme.getNome());
				System.out.println("Genero: " + filme.getGenero());
				System.out.println("Valor: " + filme.getValor());
				System.out.println("Disponivel: " + filme.getDisponivel());
				System.out.println("Promocao: " + filme.getPromocao());
				System.out.println("valor Promocao: " + filme.getValorPromocao());
				System.out.println("\n");
				bd.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro! nao foi possivel exibir filme");

			e.printStackTrace();
		}
	}
}
