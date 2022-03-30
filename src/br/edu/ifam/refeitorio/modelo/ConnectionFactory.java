/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifam.refeitorio.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Aluno
 */
public class ConnectionFactory {
    public Connection getConnection() {
      try {
	  //Class.forName(driver);
         return DriverManager.getConnection("jdbc:mysql://localhost:3306/teste", "root", "root");
	} catch (SQLException e) {
	   throw new RuntimeException(e);
	}
   }  

    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}