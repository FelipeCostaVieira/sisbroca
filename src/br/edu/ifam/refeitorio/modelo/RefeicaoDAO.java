/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifam.refeitorio.modelo;

import br.edu.ifam.refeitorio.visao.ValidarTicket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class RefeicaoDAO {

    private final Connection connection;

    public RefeicaoDAO() {
        this.connection = new ConnectionFactory().getConnection();

    }

    public Refeicao getPesquisaRefData(Refeicao ref) throws SQLException, ParseException {

        String sql = "SELECT * FROM refeicao WHERE data = ? AND idaluno = ?;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new Date(ref.getDataRefeicao().getTimeInMillis()));
            stmt.setString(2, ref.getIdAluno());

            try (ResultSet rs = stmt.executeQuery()) {
                Refeicao refBanco = new Refeicao();

                int x = 0;

                while (rs.next()) {
                    x += 1;
                }

                if (x == 0) {
                    this.setInsereRegistro(ref);
                }

                if (x == 1) {
                    rs.first();

                    refBanco.setCafe(rs.getInt("cafe"));
                    refBanco.setAlmoco(rs.getInt("almoco"));
                    refBanco.setJantar(rs.getInt("jantar"));
                    Calendar data = Calendar.getInstance();
                    data.setTime(rs.getDate("data"));
                    refBanco.setDataRefeicao(data);
                    refBanco.setIdAluno(rs.getString("idaluno"));

                    if (refBanco.getCafe() == ref.getCafe() && refBanco.getAlmoco() == ref.getAlmoco() && refBanco.getJantar() == ref.getJantar()) {
                        JOptionPane.showMessageDialog(null, "A refeição solicitada já foi retirada");
                    } else {
                        this.setInsereRegistro(ref);
                    }

                }

                if (x >= 2) {
                    JOptionPane.showMessageDialog(null, "Número máximo de refeições diárias atingido: 2.");
                    return null;
                }

                rs.close();
                stmt.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return ref;
    }

    public void setInsereRegistro(Refeicao ref) throws SQLException {

        String sql = "insert into refeicao (data,idaluno,cafe,almoco,jantar) values (?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new Date(ref.getDataRefeicao().getTimeInMillis()));
            stmt.setString(2, ref.getIdAluno());
            stmt.setInt(3, ref.getCafe());
            stmt.setInt(4, ref.getAlmoco());
            stmt.setInt(5, ref.getJantar());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Refeição registrada.\nFicha liberada!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Vector<Refeicao> getTabelaCompleta() {
        try {
            Vector<Refeicao> refs;
            try (Connection con = new ConnectionFactory().getConnection()) {
                String query = "SELECT * FROM refeicao ";
                PreparedStatement cmd;
                cmd = con.prepareStatement(query);
                try (ResultSet rs = cmd.executeQuery()) {
                    refs = new Vector<Refeicao>();
                    while (rs.next()) {
                        Refeicao ref = new Refeicao();
                        Calendar data = Calendar.getInstance();
                        data.setTime(rs.getDate("data"));

                        ref.setDataRefeicao(data);

                        ref.setIdAluno(rs.getString("idaluno"));
                        ref.setCafe(rs.getInt("cafe"));
                        ref.setAlmoco(rs.getInt("almoco"));
                        ref.setJantar(rs.getInt("jantar"));

                        refs.add(ref);
                    }
                }
            }

            return refs;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Vector<Refeicao> getTabelaData(String dataEmtexto) throws ParseException {

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date dataDate = new java.sql.Date(format.parse(dataEmtexto).getTime());
            Vector<Refeicao> listaRef;
            try (Connection con = new ConnectionFactory().getConnection()) {
                String query = "SELECT * FROM refeicao where data = ? ";
                PreparedStatement cmd;
                cmd = con.prepareStatement(query);
                cmd.setDate(1,dataDate);
                try (ResultSet rs = cmd.executeQuery()) {
                    listaRef = new Vector<Refeicao>();
                    while (rs.next()) {
                        Refeicao ref = new Refeicao();
                        Calendar data = Calendar.getInstance();
                        data.setTime(rs.getDate("data"));

                        ref.setDataRefeicao(data);

                        ref.setIdAluno(rs.getString("idaluno"));
                        ref.setCafe(rs.getInt("cafe"));
                        ref.setAlmoco(rs.getInt("almoco"));
                        ref.setJantar(rs.getInt("jantar"));

                        listaRef.add(ref);
                        
                    }
                    
                }
            }

            return listaRef;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
