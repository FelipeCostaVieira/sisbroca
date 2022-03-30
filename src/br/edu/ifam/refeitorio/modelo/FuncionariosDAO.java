/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifam.refeitorio.modelo;

import br.edu.ifam.refeitorio.visao.Principal;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class FuncionariosDAO {

    Connection con;

    public FuncionariosDAO() {
      con = new ConnectionFactory().getConnection();
    }

    public void setInsere(Funcionarios func) throws SQLException {
        try {

            String sql = "INSERT INTO funcionario"
                    + " (nomefuncionario,loginfuncionario,senhalogin)"
                    + " values (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, func.getNomefuncionario());
            pst.setString(2, func.getLoginfuncionario());
            pst.setString(3, func.getSenhalogin());

            pst.executeUpdate();
            pst.close();

            JOptionPane.showMessageDialog(null, "Salvo!");
            con.close();
        } catch (Exception e) {

        }
    }

    public boolean pesquisaFuncLoginSenha(String login, String senha) throws SQLException {

        boolean achou = false;

        String query = "SELECT * FROM funcionario WHERE loginfuncionario = ? AND senhalogin = ?";
        PreparedStatement cmd;
        cmd = con.prepareStatement(query);
        cmd.setString(1, login);
        cmd.setString(2, senha);

        ResultSet rs = cmd.executeQuery();
        if (rs.next()) {
            achou = true;
        } else {
            achou = false;
        }
        return achou;
    }

    public void setAlteraLogin(String novoLogin, String novaSenha, String atualLogin, String atualSenha) throws SQLException {
        String sql = "UPDATE funcionario SET  loginfuncionario = ?,senhalogin = ? WHERE loginfuncionario = ? AND senhalogin = ?";

        PreparedStatement stmt = con.prepareStatement(sql);

        //seta os valores
        stmt.setString(1, novoLogin);
        stmt.setString(2, novaSenha);
        stmt.setString(3, atualLogin);
        stmt.setString(4, atualSenha);

        //executa o codigo
        stmt.executeUpdate();
        stmt.execute();
        stmt.close();
        JOptionPane.showMessageDialog(null, "Alterado");

    }

    public boolean pesquisaFuncLogin(String loginfuncionario) throws SQLException {

        boolean achou = false;

        String query = "SELECT * FROM funcionario WHERE loginfuncionario = ?";
        PreparedStatement cmd;
        cmd = con.prepareStatement(query);
        cmd.setString(1, loginfuncionario);

        ResultSet rs = cmd.executeQuery();
        if (rs.next()) {
            achou = true;
        } else {
            achou = false;
        }
        return achou;
    }

}
