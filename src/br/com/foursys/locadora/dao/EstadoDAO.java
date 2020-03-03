package br.com.foursys.locadora.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.model.Cidade;
import br.com.foursys.locadora.model.Estado;

public class EstadoDAO {

    private Connection bd;

    public EstadoDAO(Connection bd) {
        this.bd = bd;

    }

    public List<Estado> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM estado ORDER BY nome";
        PreparedStatement comando = bd.prepareStatement(sql);
        ResultSet cursor = comando.executeQuery();
        List<Estado> listaEstado = new ArrayList<Estado>();

        while (cursor.next()) {
            Estado estado = new Estado();
            estado.setNome(cursor.getString("nome"));
            estado.setUf(cursor.getString("uf"));
            listaEstado.add(estado);
        }
        return listaEstado;
    }

}
