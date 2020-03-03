package br.com.foursys.locadora.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.model.Cidade;

public class CidadeDAO {

    private Connection bd;

    public CidadeDAO(Connection bd) {
        this.bd = bd;

    }

    public List<Cidade> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM cidade ORDER BY nome";
        PreparedStatement comando = bd.prepareStatement(sql);
        ResultSet cursor = comando.executeQuery();
        List<Cidade> listaCidade = new ArrayList<Cidade>();

        while (cursor.next()) {
            Cidade cidade = new Cidade();
            cidade.setNome(cursor.getString("nome"));
            listaCidade.add(cidade);
        }
        return listaCidade;
    }

}
