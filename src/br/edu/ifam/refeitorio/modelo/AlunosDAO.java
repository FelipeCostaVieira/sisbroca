/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifam.refeitorio.modelo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class AlunosDAO {

    private final Connection connection;

    public AlunosDAO() {
        this.connection = new ConnectionFactory().getConnection();

    }

    public Vector<Alunos> getPesquisaPorNomeVector(String nome) {
        // pega a conexão e o Statement
        try {
            Connection con = new ConnectionFactory().getConnection();

            String query = "SELECT * FROM alunos WHERE nome like ?";
            PreparedStatement cmd;
            cmd = con.prepareStatement(query);
            cmd.setString(1, '%' + nome + '%');

            ResultSet rs = cmd.executeQuery();
            Vector<Alunos> alunos = new Vector<Alunos>();
            while (rs.next()) {
                Alunos aluno = new Alunos();
                aluno.setNome(rs.getString("nome"));
                aluno.setNomatricula(rs.getString("nomatricula"));
                aluno.setTurma(rs.getString("turma"));
                aluno.setBeneficiario(rs.getString("beneficiario"));

                alunos.add(aluno);
            }
            rs.close();

            con.close();

            return alunos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Vector<Alunos> getPesquisaPorNoMatriculaVector(String nomatricula) {
        // pega a conexão e o Statement
        try {
            Vector<Alunos> alunos;
            try (Connection con = new ConnectionFactory().getConnection()) {
                String query = "SELECT * FROM alunos WHERE nomatricula like ?";
                PreparedStatement cmd;
                cmd = con.prepareStatement(query);
                cmd.setString(1, "%"+nomatricula+"%");
                try (ResultSet rs = cmd.executeQuery()) {
                    alunos = new Vector<Alunos>();
                    while (rs.next()) {
                        Alunos aluno = new Alunos();
                        aluno.setNomatricula(rs.getString("nomatricula"));
                        aluno.setNome(rs.getString("nome"));
                        aluno.setTurma(rs.getString("turma"));
                        aluno.setBeneficiario(rs.getString("beneficiario"));
                        alunos.add(aluno);
                    }
                }
            }

            return alunos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Alunos reg) throws SQLException {
        String sql = "UPDATE alunos SET  beneficiario = ?,nome = ?,turma = ?,nomatricula = ? WHERE nomatricula = ?";
        //seta os valores
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            //seta os valores
            stmt.setString(1, reg.getBeneficiario());
            stmt.setString(2, reg.getNome());
            stmt.setString(3, reg.getTurma());
            stmt.setString(4, reg.getNomatricula());
            stmt.setString(5, reg.getNomatricula());
            //stmt.setBoolean(3,reg.getBeneficiario.isSelected());

            //executa o codigo
            stmt.executeUpdate();
            stmt.execute();
        }
        JOptionPane.showMessageDialog(null, "Alterado");

    }

    public Vector<Alunos> getTabelaCompleta() throws SQLException {
        try {
            Vector<Alunos> alunos;
            try (Connection con = new ConnectionFactory().getConnection()) {
                String query = "SELECT * FROM alunos ";
                PreparedStatement cmd;
                cmd = con.prepareStatement(query);
                try (ResultSet rs = cmd.executeQuery()) {
                    alunos = new Vector<Alunos>();
                    while (rs.next()) {
                        Alunos aluno = new Alunos();
                        aluno.setNome(rs.getString("nome"));
                        aluno.setNomatricula(rs.getString("nomatricula"));
                        aluno.setTurma(rs.getString("turma"));
                        aluno.setBeneficiario(rs.getString("beneficiario"));

                        alunos.add(aluno);
                    }
                }
            }

            return alunos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Alunos getPesquisaPorMat(String noMatricula) throws SQLException {   
        Alunos aluno = new Alunos();
        try (Connection con = new ConnectionFactory().getConnection()) {

            String query = "SELECT nomatricula,nome,turma,beneficiario FROM alunos WHERE nomatricula = ?";
            PreparedStatement cmd;
            cmd = con.prepareStatement(query);
            cmd.setString(1, noMatricula);

            ResultSet rs = cmd.executeQuery();

                if (rs.first()) {
                    
                    aluno.setNomatricula(rs.getString("nomatricula"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setTurma(rs.getString("turma"));
                    aluno.setBeneficiario(rs.getString("beneficiario"));

                } else { 
                    JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
                }    
        } catch (SQLException | HeadlessException e) {
            throw new RuntimeException(e);
        }
        return aluno;
    }

}
