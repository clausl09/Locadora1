/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.locadora.controller;

import br.com.foursys.locadora.dao.CidadeDAO;
import br.com.foursys.locadora.dao.EstadoDAO;
import br.com.foursys.locadora.model.Cidade;
import br.com.foursys.locadora.model.Estado;
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
class EstadoController {

    public List<Estado> buscarEstados() {

        Connection bd = ConnectionFactory.getConnection();
        EstadoDAO dao = new EstadoDAO(bd);
        List<Estado> listaEstado = new ArrayList<Estado>();
        
        try {
            listaEstado = dao.buscarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(EstadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaEstado;
    }

}
