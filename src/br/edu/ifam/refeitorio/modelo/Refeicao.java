/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifam.refeitorio.modelo;


import java.util.Calendar;

/**
 *
 * @author Aluno
 */
public class Refeicao {

    private Calendar dataRefeicao;
    private String idAluno;
    private int cafe;
    private int almoco;
    private int jantar;

    public Refeicao() {
    }
    

    public Refeicao(String idaluno) {
        this.idAluno = idaluno;
    }

    public Refeicao(String idAluno, Calendar datarefeicao) {
        this.idAluno = idAluno;
        this.dataRefeicao = datarefeicao;
    }

    ////////////////////// 
    //métodos get e set para dataRefeicao, idAluno, cafe,almoco,jantar.
    //////////////////////
    public Calendar getDataRefeicao() {
        return this.dataRefeicao;
    }

    public String getIdAluno() {
        return this.idAluno;
    }

    public int getCafe() {
        return cafe;
    }

    public int getAlmoco() {
        return almoco;
    }

    public int getJantar() {
        return jantar;
    }
/////////////////////////////////////////////////////
    public void setDataRefeicao(Calendar data) {
        this.dataRefeicao = data;
    }

    public void setIdAluno(String id) {
        this.idAluno = id;
    }

    public void setCafe(int tipo) {
        this.cafe = tipo;
    }

    public void setAlmoco(int tipo) {
        this.almoco = tipo;
    }

    public void setJantar(int tipo) {
        this.jantar = tipo;
    }
    
    public String toString(){
    String toStr;
        toStr="Número de matrícula: "+this.getIdAluno();
        toStr+=(String)"Cafe :"+this.getCafe();
        toStr+=(String)"Almoço: "+this.getAlmoco();
        toStr+=(String)"Jantar: "+this.getJantar();
        return toStr;
    }
    
}
