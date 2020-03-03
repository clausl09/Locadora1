/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.locadora.util;

import br.com.foursys.locadora.dao.CidadeDAO;
import br.com.foursys.locadora.model.Cidade;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author csleite
 */
public class TesteBuscarCidade {

    public static void main(String[] args) {
        Connection bd = ConnectionFactory.getConnection();
        CidadeDAO dao = new CidadeDAO(bd);

        try {
            List<Cidade> cidades = dao.buscarTodos();
            for (Cidade cidade : cidades) {

                System.out.println("Cidade: " + cidade.getNome());

                bd.close();
            }
        } catch (SQLException e) {

            System.out.println("Erro! nao foi possivel exibir cidades");

            e.printStackTrace();
        }
    }
}
