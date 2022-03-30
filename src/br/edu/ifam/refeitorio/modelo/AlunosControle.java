/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifam.refeitorio.modelo;

import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Aluno
 */
public class AlunosControle {
    
    
     public Vector<Alunos> pesquisarPorNomeVector(String nome)  throws SQLException {

        // Olha que enxuto que ficou. A sua View não se comunicará com o DAO, mas poderá executar os métodos dele através de chamadas do Controller, como esse método aqui.
        AlunosDAO alunoDAO = new AlunosDAO();
        return alunoDAO.getPesquisaPorNomeVector(nome);
    } 
     
    public Vector<Alunos> pesquisarPorNoMatriculaVector(String nomatricula)  throws SQLException {

        // Olha que enxuto que ficou. A sua View não se comunicará com o DAO, mas poderá executar os métodos dele através de chamadas do Controller, como esse método aqui.
        AlunosDAO alunoDAO = new AlunosDAO();
        return alunoDAO.getPesquisaPorNoMatriculaVector(nomatricula);
    }

    public Vector<Alunos> pesquisarTabelaAlunos(String text) throws SQLException {
        AlunosDAO alunoDAO = new AlunosDAO();
         return alunoDAO.getTabelaCompleta();
        
    }
      
}
