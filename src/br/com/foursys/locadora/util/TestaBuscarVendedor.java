package br.com.foursys.locadora.util;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.VendedorDAO;
import br.com.foursys.locadora.model.Vendedor;

public class TestaBuscarVendedor {
	
	public static void main(String[] args) {
		
		Connection bd = ConnectionFactory.getConnection();
		VendedorDAO dao = new VendedorDAO(bd);
		try {
			List<Vendedor> vendedores = dao.buscarTodos();
			for (Vendedor vendedor : vendedores) {

				System.out.println("nome: " + vendedor.getNome());
				System.out.println("area_venda: " + vendedor.getAreaVenda());				
				System.out.println("cidade: " + vendedor.getCidade().toString());
				System.out.println("estado: " + vendedor.getEstado().toString());
				System.out.println("sexo: " + vendedor.getSexo());
				System.out.println("salario: " + vendedor.getSalario());
				System.out.println("idade: " + vendedor.getIdade()+"\n");

				bd.close();
			}
		} catch (SQLException e) {
			
			System.out.println("Erro! nao foi possivel exibir Vendedores");

			e.printStackTrace();
		}
	}

}
