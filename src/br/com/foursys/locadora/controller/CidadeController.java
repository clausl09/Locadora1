/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.locadora.controller;

import br.com.foursys.locadora.dao.CidadeDAO;
import br.com.foursys.locadora.model.Cidade;
import br.com.foursys.locadora.util.ConnectionFactory;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author csleite
 */
class CidadeController {

    public List<Cidade> buscarCidades() {

        Connection bd = ConnectionFactory.getConnection();
        CidadeDAO dao = new CidadeDAO(bd);
        List<Cidade> listaCidade = new ArrayList<Cidade>();
        
        try {
            listaCidade = dao.buscarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(CidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaCidade;
    }

}
