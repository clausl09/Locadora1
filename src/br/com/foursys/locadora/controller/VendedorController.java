/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.locadora.controller;

import br.com.foursys.locadora.dao.VendedorDAO;
import br.com.foursys.locadora.model.Cidade;
import br.com.foursys.locadora.model.Vendedor;
import br.com.foursys.locadora.model.Estado;
import br.com.foursys.locadora.model.Vendedor;
import br.com.foursys.locadora.util.ConnectionFactory;
import br.com.foursys.locadora.view.VendedorView;
import br.com.foursys.locadora.view.VendedorView;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author csleite
 */
public class VendedorController {

    private VendedorView viewVendedor;
    private Vendedor vendedor = new Vendedor();
    private List<Vendedor> listaVendedors;
    private List<Cidade> cidades;
    private List<Estado> estados;
    private boolean alterar;

    public VendedorController(VendedorView viewVendedor) {
        this.viewVendedor = viewVendedor;
    }

    public void alterarVendedor() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewVendedor.getTabelaVendedor().getModel();
        if (this.viewVendedor.getTabelaVendedor().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um vendedor");
        } else {
            vendedor = listaVendedors.get(this.viewVendedor.getTabelaVendedor().getSelectedRow());

            this.viewVendedor.getCbSexo().setSelectedItem(vendedor.getSexo() + "");
            this.viewVendedor.getJtfIdade().setText(vendedor.getIdade() + "");
            this.viewVendedor.getJtfNome().setText(vendedor.getNome());
            this.viewVendedor.getCbCidade().setSelectedItem(vendedor.getCidade().toString());
            this.viewVendedor.getCbEstado().setSelectedItem(vendedor.getEstado().toString());
            this.alterar = true;
            acaoBotaoAlterar();
        }
    }

    public void excluirVendedor() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewVendedor.getTabelaVendedor().getModel();
        if (this.viewVendedor.getTabelaVendedor().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um vendedor");
        } else {
            vendedor = listaVendedors.get(this.viewVendedor.getTabelaVendedor().getSelectedRow());
            int opcao = JOptionPane.showConfirmDialog(null, "Confirma em excluir este registro?", "Atenção",
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                Connection bd = ConnectionFactory.getConnection();
                VendedorDAO dao = new VendedorDAO(bd);
                try {
                    dao.excluir(vendedor);
                    JOptionPane.showMessageDialog(null, "Vendedor excluido com sucesso!");
                    listarVendedor();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir o vendedor!");
                    Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void salvarVendedor() {
        if (this.alterar == false) {
            //inserir um registro
            if (validarSalvar()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setNome(this.viewVendedor.getJtfNome().getText());
                vendedor.setLogradouro(this.viewVendedor.getJtfLogradouro().getText());
                vendedor.setNumeroLogradouro(Integer.parseInt(this.viewVendedor.getJtfNumeroLogradouro().getText()));
                vendedor.setBairro(this.viewVendedor.getJtfBairro().getText());
                Cidade cidade = new Cidade(this.viewVendedor.getCbCidade().getSelectedItem().toString());
                vendedor.setCidade(cidade);
                Estado estado = new Estado(this.viewVendedor.getCbEstado().getSelectedItem().toString(), "");
                vendedor.setEstado(estado);
                vendedor.setTelefone(this.viewVendedor.getJtfTelefone().getText());
                vendedor.setCpf(this.viewVendedor.getJtfCpf().getText());
                vendedor.setRg(this.viewVendedor.getJtfRg().getText());
                vendedor.setSexo(this.viewVendedor.getCbSexo().getSelectedItem().toString().charAt(0));
                vendedor.setDataNascimento(this.viewVendedor.getJtfDataNascimento().getText());
                vendedor.setIdade(Integer.parseInt(this.viewVendedor.getJtfIdade().getText()));
                Connection bd = ConnectionFactory.getConnection();
                VendedorDAO dao = new VendedorDAO(bd);
                try {
                    dao.inserir(vendedor);
                    JOptionPane.showMessageDialog(null, "Vendedor inserido com sucesso!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir o vendedor.");
                    Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                bloqueioInicial();
                listarVendedors();
            }
        } else {
            //alterando o registro
            if (validarSalvar()) {
                vendedor.setLogradouro(this.viewVendedor.getJtfLogradouro().getText());
                vendedor.setNumeroLogradouro(Integer.parseInt(this.viewVendedor.getJtfNumeroLogradouro().getText()));
                vendedor.setBairro(this.viewVendedor.getJtfBairro().getText());
                Cidade cidade = new Cidade(this.viewVendedor.getCbCidade().getSelectedItem().toString());
                vendedor.setCidade(cidade);
                Estado estado = new Estado(this.viewVendedor.getCbEstado().getSelectedItem().toString(), "");
                vendedor.setEstado(estado);
                vendedor.setTelefone(this.viewVendedor.getJtfTelefone().getText());
                Connection bd = ConnectionFactory.getConnection();
                VendedorDAO dao = new VendedorDAO(bd);
                try {
                    dao.alterar(vendedor);
                    JOptionPane.showMessageDialog(null, "Vendedor alterado com sucesso!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterado o vendedor.");
                    Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                bloqueioInicial();
                listarVendedors();
            }
        }
    }

    public boolean validarSalvar() {
        if (this.viewVendedor.getJtfCpf().equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(null, "Informe o CPF, campo obrigatório.");
            return false;
        }

        if (this.viewVendedor.getCbSexo().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Informe o sexo, campo obrigatório.");
            return false;
        }

        return true;
    }

    public void listarVendedor() {
        Connection bd = ConnectionFactory.getConnection();
        VendedorDAO dao = new VendedorDAO(bd);
        try {
            listaVendedors = dao.buscarTodos();
            carregarTabela();
        } catch (SQLException ex) {
            Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewVendedor.getTabelaVendedor().getModel();
        modelo.setRowCount(0);
        for (Vendedor listaVendedor : listaVendedors) {
            modelo.addRow(new String[]{listaVendedor.getNome(), listaVendedor.getCidade().toString(), listaVendedor.getTelefone(), listaVendedor.getIdade() + " anos"});
        }
    }

    public void carregarComboCidade() {
        CidadeController controller = new CidadeController();
        cidades = controller.buscarCidades();
        this.viewVendedor.getCbCidade().removeAllItems();
        this.viewVendedor.getCbCidade().addItem("-Escolha Cidade-");
        for (Cidade listaCidade : cidades) {
            this.viewVendedor.getCbCidade().addItem(listaCidade.getNome());
        }
    }

    public void carregarComboEstado() {
        EstadoController controller = new EstadoController();
        estados = controller.buscarEstados();
        this.viewVendedor.getCbEstado().removeAllItems();
        this.viewVendedor.getCbEstado().addItem("-Escolha UF-");
        for (Estado listaEstado : estados) {
            this.viewVendedor.getCbEstado().addItem(listaEstado.getNome());
        }
    }

    public void bloqueioInicial() {
        this.viewVendedor.getJbtNovo().setEnabled(true);
        this.viewVendedor.getJbtAlterar().setEnabled(true);
        this.viewVendedor.getJbtExcluir().setEnabled(true);
        this.viewVendedor.getJbtSair().setEnabled(true);
        this.viewVendedor.getJbtSalvar().setEnabled(false);
        this.viewVendedor.getJbtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.viewVendedor.getJtfPesquisarNome().setEditable(true);
        this.viewVendedor.getJtfPesquisarNome().grabFocus();
        this.viewVendedor.getJtfCpf().setEditable(false);
        this.viewVendedor.getJtfRg().setEditable(false);
        this.viewVendedor.getJtfIdade().setEditable(false);
        this.viewVendedor.getCbSexo().setEnabled(false);
        this.viewVendedor.getJtfNome().setEditable(false);
        this.viewVendedor.getJtfLogradouro().setEditable(false);
        this.viewVendedor.getJtfNumeroLogradouro().setEditable(false);
        this.viewVendedor.getJtfBairro().setEditable(false);
        this.viewVendedor.getCbCidade().setEnabled(false);
        this.viewVendedor.getCbEstado().setEnabled(false);
        this.viewVendedor.getJtfTelefone().setEditable(false);
        this.viewVendedor.getJtfDataNascimento().setEditable(false);
    }

    public void liberarCampos() {
        this.viewVendedor.getJtfPesquisarNome().setEditable(false);
        this.viewVendedor.getJtfCpf().grabFocus();
        this.viewVendedor.getJtfCpf().setEditable(true);
        this.viewVendedor.getJtfRg().setEditable(true);
        this.viewVendedor.getJtfIdade().setEditable(true);
        this.viewVendedor.getCbSexo().setEnabled(true);
        this.viewVendedor.getJtfNome().setEditable(true);
        this.viewVendedor.getJtfLogradouro().setEditable(true);
        this.viewVendedor.getJtfNumeroLogradouro().setEditable(true);
        this.viewVendedor.getJtfBairro().setEditable(true);
        this.viewVendedor.getCbCidade().setEnabled(true);
        this.viewVendedor.getCbEstado().setEnabled(true);
        this.viewVendedor.getJtfTelefone().setEditable(true);
        this.viewVendedor.getJtfDataNascimento().setEditable(true);
    }

    public void limparCampos() {
        this.viewVendedor.getJtfCpf().setText(null);
        this.viewVendedor.getJtfRg().setText(null);
        this.viewVendedor.getJtfIdade().setText(null);
        this.viewVendedor.getCbSexo().setSelectedIndex(0);
        this.viewVendedor.getJtfNome().setText(null);
        this.viewVendedor.getJtfLogradouro().setText(null);
        this.viewVendedor.getJtfNumeroLogradouro().setText(null);
        this.viewVendedor.getJtfBairro().setText(null);
        this.viewVendedor.getCbCidade().setSelectedIndex(0);
        this.viewVendedor.getCbEstado().setSelectedIndex(0);
        this.viewVendedor.getJtfTelefone().setText(null);
        this.viewVendedor.getJtfDataNascimento().setText(null);
    }

    public void acaoBotaoCancelar() {
        this.viewVendedor.getJbtNovo().setEnabled(true);
        this.viewVendedor.getJbtAlterar().setEnabled(true);
        this.viewVendedor.getJbtExcluir().setEnabled(true);
        this.viewVendedor.getJbtSair().setEnabled(true);
        this.viewVendedor.getJbtSalvar().setEnabled(false);
        this.viewVendedor.getJbtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void acaoBotaoAlterar() {
        this.viewVendedor.getJbtNovo().setEnabled(false);
        this.viewVendedor.getJbtAlterar().setEnabled(false);
        this.viewVendedor.getJbtExcluir().setEnabled(false);
        this.viewVendedor.getJbtSair().setEnabled(false);
        this.viewVendedor.getJbtSalvar().setEnabled(true);
        this.viewVendedor.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.viewVendedor.getJtfCpf().setEditable(false);
        this.viewVendedor.getJtfRg().setEditable(false);
        this.viewVendedor.getJtfNome().setEditable(false);
        this.viewVendedor.getJtfIdade().setEditable(false);
        this.viewVendedor.getJtfLogradouro().grabFocus();
        this.viewVendedor.getCbSexo().setEnabled(false);
    }

    public void acaoBotaoNovo() {
        this.viewVendedor.getJbtNovo().setEnabled(false);
        this.viewVendedor.getJbtAlterar().setEnabled(false);
        this.viewVendedor.getJbtExcluir().setEnabled(false);
        this.viewVendedor.getJbtSair().setEnabled(false);
        this.viewVendedor.getJbtSalvar().setEnabled(true);
        this.viewVendedor.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.alterar = false;
    }

}
