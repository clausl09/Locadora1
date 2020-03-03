package br.com.foursys.locadora.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.ClienteDAO;
import br.com.foursys.locadora.model.Cidade;
import br.com.foursys.locadora.model.Cliente;
import br.com.foursys.locadora.model.Estado;


public class TestaExcluirCliente {
	public static void main(String[] args) {
		
		try {
			Connection bd = ConnectionFactory.getConnection();
			Estado estado = new Estado("sao paulo", "sp");
			Cidade cidade = new Cidade("Osasco");
			Cliente al = new Cliente("Jubileu", "av,Paulista", 12, "Barueri", cidade, estado, "23232323232", "2222222222",
					"44444444", 'M', "25/54/63", 12);
			ClienteDAO dao = new ClienteDAO(bd);
			dao.excluir(al);
			System.out.println("Aluno Excluido com sucesso");
			bd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao Excluir aluno");
			e.printStackTrace();
		}
	}
}
