/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifam.refeitorio.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "alunos", catalog = "teste", schema = "")
@NamedQueries({
    @NamedQuery(name = "Alunos.findAll", query = "SELECT a FROM Alunos a"),
    @NamedQuery(name = "Alunos.findByNomatricula", query = "SELECT a FROM Alunos a WHERE a.nomatricula = :nomatricula"),
    @NamedQuery(name = "Alunos.findByNome", query = "SELECT a FROM Alunos a WHERE a.nome = :nome"),
    @NamedQuery(name = "Alunos.findByBeneficiario", query = "SELECT a FROM Alunos a WHERE a.beneficiario = :beneficiario"),
    @NamedQuery(name = "Alunos.findByTurma", query = "SELECT a FROM Alunos a WHERE a.turma = :turma")})
public class Alunos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nomatricula")
    private String nomatricula;
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "beneficiario")
    private String beneficiario;
    @Column(name = "turma")
    private String turma;

    public Alunos() {
    }

    public Alunos(String nomatricula) {
        this.nomatricula = nomatricula; 
    }

    public Alunos(String nomatricula, String beneficiario) {
        this.nomatricula = nomatricula;
        this.beneficiario = beneficiario; 
    }

    public String getNomatricula() {
        return nomatricula;
    }

    public void setNomatricula(String newNomatricula) {
   
        nomatricula = newNomatricula;
       
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String newNome) {
        nome = newNome;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String newBeneficiario) { 
       beneficiario = newBeneficiario;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String newTurma) {
        this.turma = newTurma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomatricula != null ? nomatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alunos)) {
            return false;
        }
        Alunos other = (Alunos) object;
        if ((this.nomatricula == null && other.nomatricula != null) || (this.nomatricula != null && !this.nomatricula.equals(other.nomatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " nomatricula=" + nomatricula + " "+beneficiario + " nome "+ nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    List<Alunos> pesquisarPorNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
