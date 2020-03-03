package br.com.foursys.locadora.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.model.Filme;



public class TestaAlterarFilme {
public static void main(String[] args) {
		
		try {
			Connection bd = ConnectionFactory.getConnection();
			Filme filme = new Filme(12, "Isaac", "comedia", 5.00, true, false, 1.30);
			FilmeDAO dao = new FilmeDAO(bd);
			dao.alterar(filme);
			System.out.println("Aluno alterado com sucesso");
			bd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao alterado aluno");
			
			e.printStackTrace();
		}
	}
}
