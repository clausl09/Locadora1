package br.com.foursys.locadora.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.VendedorDAO;
import br.com.foursys.locadora.model.Cidade;
import br.com.foursys.locadora.model.Estado;
import br.com.foursys.locadora.model.Vendedor;


public class TestaAlterarVendedor {
	public static void main(String[] args) {
		
		Connection bd = ConnectionFactory.getConnection();
		VendedorDAO dao = new VendedorDAO(bd);
		Estado estado = new Estado("sao paulo", "sp");
		Cidade cidade = new Cidade("Osasco");
		Vendedor vendedor = new Vendedor("gol", "sss", cidade, estado, 'M', 45,5555);
	try {
		
		
		dao.alterar(vendedor);
		System.out.println("Vendedor alterado com sucesso");
		bd.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Erro ao alterado Vendedor");

		e.printStackTrace();
	}
}
}
