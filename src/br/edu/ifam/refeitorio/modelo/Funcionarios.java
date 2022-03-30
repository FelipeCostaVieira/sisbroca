/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifam.refeitorio.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
@Table(name = "funcionario", catalog = "bancoteste", schema = "")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByIdfuncionario", query = "SELECT f FROM Funcionario f WHERE f.idfuncionario = :idfuncionario"),
    @NamedQuery(name = "Funcionario.findByNomefuncionario", query = "SELECT f FROM Funcionario f WHERE f.nomefuncionario = :nomefuncionario"),
    @NamedQuery(name = "Funcionario.findByLoginfuncionario", query = "SELECT f FROM Funcionario f WHERE f.loginfuncionario = :loginfuncionario"),
    @NamedQuery(name = "Funcionario.findBySenhalogin", query = "SELECT f FROM Funcionario f WHERE f.senhalogin = :senhalogin")})
public class Funcionarios implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idfuncionario")
    private String  idfuncionario;
    @Basic(optional = false)
    @Column(name = "nomefuncionario")
    private String nomefuncionario;
    @Basic(optional = false)
    @Column(name = "loginfuncionario")
    private String loginfuncionario;
    @Basic(optional = false)
    @Column(name = "senhalogin")
    private String senhalogin;
    

    public Funcionarios() {
    }

    

    public Funcionarios( String nomefuncionario, String loginfuncionario, String senhalogin) {
        
        this.nomefuncionario = nomefuncionario;
        this.loginfuncionario = loginfuncionario;
        this.senhalogin = senhalogin;
    }

    

    public String getNomefuncionario() {
        return nomefuncionario;
    }

    public void setNomefuncionario(String nomefuncionario) {
       
        this.nomefuncionario = nomefuncionario;
       
    }

    public String getLoginfuncionario() {
        return loginfuncionario;
    }

    public void setLoginfuncionario(String loginfuncionario) {
       
        this.loginfuncionario = loginfuncionario;
       
    }

    public String getSenhalogin() {
        return senhalogin;
    }

    public void setSenhalogin(String senhalogin) {
        
        this.senhalogin = senhalogin;
        
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncionario != null ? idfuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionarios)) {
            return false;
        }
        Funcionarios other = (Funcionarios) object;
        if ((this.idfuncionario == null && other.idfuncionario != null) || (this.idfuncionario != null && !this.idfuncionario.equals(other.idfuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifam.refeitorio.visao.Funcionario[ idfuncionario=" + idfuncionario + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
