package br.com.foursys.locadora.util;
import java.sql.SQLException;
import java.util.List;
import com.mysql.jdbc.Connection;
import br.com.foursys.locadora.dao.CidadeDAO;
import br.com.foursys.locadora.model.Cidade;


public class TestasCidadeBuscar {
	public static void main(String[] args) {
		Connection bd = ConnectionFactory.getConnection();
		CidadeDAO dao = new CidadeDAO(bd);
		
		try {
			List<Cidade> cidades = dao.buscarTodos();
			for(Cidade cidade : cidades) {
				
				System.out.println("Cidade: "+cidade.getNome());
				
				bd.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro! nao foi possivel exibir alunos");
			
			e.printStackTrace();
		}
	}
}
