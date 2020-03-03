package br.com.foursys.locadora.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.model.Filme;

public class TestaInserirFilme {
	public static void main(String[] args) {
		Connection bd = ConnectionFactory.getConnection();
		Filme al = new Filme(12, "teste", "comedia", 5.00, true, true, 1.30);
		FilmeDAO dao = new FilmeDAO(bd);
		try {
			dao.inserir(al);
			System.out.println("Aluno inserido com sucesso");
			bd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao inserir Filme");

			e.printStackTrace();
		}
	}
}
