package br.com.foursys.locadora.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {
	// Classe responsalvel por efetuar conecção com o banco de dados
	public static Connection getConnection() {
		String local = "jdbc:mysql://localhost/locadora";
		String login = "root";
		String senha = "root";

		Connection conexao = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver carregado com sucesso");
			conexao = (Connection) DriverManager.getConnection(local, login, senha);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Falha ao carregar o drive");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao conectar");
		}
		return conexao;
	}

}

