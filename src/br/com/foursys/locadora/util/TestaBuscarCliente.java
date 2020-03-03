package br.com.foursys.locadora.util;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.ClienteDAO;
import br.com.foursys.locadora.model.Cliente;

public class TestaBuscarCliente {
	public static void main(String[] args) {
		Connection bd = ConnectionFactory.getConnection();
		ClienteDAO dao = new ClienteDAO(bd);
		try {
			List<Cliente> clientes = dao.buscarTodos();
			
			for (Cliente cliente : clientes) {

				System.out.println("Nome: " + cliente.getNome());
				System.out.println("Logradouro: " + cliente.getLogradouro());
				System.out.println("Numero logradouro: " + cliente.getNumeroLogradouro());
				System.out.println("Bairro: " + cliente.getBairro());
				
				System.out.println("Cidade: " + cliente.getCidade().toString());
				System.out.println("Estado: " + cliente.getEstado().toString());
				System.out.println("Telefone: " + cliente.getTelefone());
				System.out.println("Cpf: " + cliente.getCpf());
				System.out.println("RG: " + cliente.getRg());
				System.out.println("Sexo: " + cliente.getSexo());
				System.out.println("Data Nascimento: " + cliente.getDataNascimento());
				System.out.println("Idade: " + cliente.getIdade()+"\n");

				bd.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro! nao foi possivel exibir Clientes");

			e.printStackTrace();
		}
	}
}
