package br.com.foursys.locadora.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.VendedorDAO;
import br.com.foursys.locadora.model.Cidade;

import br.com.foursys.locadora.model.Estado;
import br.com.foursys.locadora.model.Vendedor;

public class TestaInserirVendedor {
	public static void main(String[] args) {
	try{
		Connection bd = ConnectionFactory.getConnection();
		Estado estado = new Estado("sao paulo", "sp");
		Cidade cidade = new Cidade("Osasco");
		Vendedor al = new Vendedor("gol", "teste", cidade, estado, 'M', 45,5555);
		VendedorDAO dao = new VendedorDAO(bd);
		
		dao.inserir(al);
		System.out.println("Vendedor inserido com sucesso");
		bd.close();
	}catch(
	SQLException e)
	{
		// TODO Auto-generated catch block
		System.out.println("Erro ao inserir Vendedor");

		e.printStackTrace();
	}
}
}
