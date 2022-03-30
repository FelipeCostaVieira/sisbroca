/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifam.refeitorio.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jucibs
 */
public class ImportaAlunos {

    public static void main(String args[]) {
        Connection connection;
        connection = new ConnectionFactory().getConnection();
        // Efetua a leitura no arquivo texto
        String arquivo = "C:\\Users\\Aluno\\Documents\\Tundis e Vieira\\dadosIINF31.csv";
        StringBuffer sb = new StringBuffer();
         String sql = "insert into alunos "
                + "(matricula,nome,beneficiario,turma) "
                + "values (?,?,?,?)";
         
        try {
            FileReader reader = new FileReader(arquivo);
            BufferedReader bufReader = new BufferedReader(reader);
            String s[];
            String linha;
            linha=bufReader.readLine();
            while (linha != null) {
                s=linha.trim().split(";");
                System.out.println(linha);
                System.out.println(s[0]+" | "+s[1]);
                // Armazena dados na tabela
               
    
            PreparedStatement stmt = connection.prepareStatement(sql);
            // Atribui os dados
            stmt.setString(1, s[0]);
            stmt.setString(2, s[1]);
            stmt.setBoolean(3, false);
            stmt.setString(4,"IINF31");
            
            // Executa
            stmt.execute();
                
                
                linha=bufReader.readLine();
            } 
            bufReader.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(ImportaAlunos.class.getName()).log(Level.SEVERE, null, ex);
        }

       

    }
}
