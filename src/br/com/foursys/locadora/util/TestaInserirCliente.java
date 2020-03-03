package br.com.foursys.locadora.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.ClienteDAO;
import br.com.foursys.locadora.model.Cidade;
import br.com.foursys.locadora.model.Cliente;
import br.com.foursys.locadora.model.Estado;

public class TestaInserirCliente {

	public static void main(String[] args) {
		Connection bd = ConnectionFactory.getConnection();
		Estado estado = new Estado("Sao Paulo" , "SP");
		Cidade cidade = new Cidade("Osasco");
		Cliente al = new Cliente("Douglas", "Rua bezerra de menezes",173, "Osasco", cidade, estado, "123123123123", "12312312312312", "123123123123", 'M', "28/03/70", 50);
		ClienteDAO dao = new ClienteDAO(bd);
		try { 
			dao.inserir(al);
			System.out.println("Cliente inserido com sucesso");
			bd.close();
		} catch (SQLException e) {
			
			System.out.println("Erro ao inserir Cliente");
			e.printStackTrace();
		}
	}

}
