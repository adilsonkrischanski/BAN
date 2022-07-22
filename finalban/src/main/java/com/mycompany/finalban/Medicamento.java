/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalban;

/**
 *
 * @author adilson
 */
public class Medicamento {
    private int idmedicamento =0;
    private String fornecedor = new String();
    private String nomeMedicamento = new String();
    private double dosagem  = 0.0;

    public Medicamento(int idmedicamento,String fornecedor,String nomeMedicamento,double dosagem) {
        this.idmedicamento = idmedicamento;
        this.fornecedor = fornecedor;
        this.nomeMedicamento = nomeMedicamento;
        this.dosagem = dosagem;
    }


    public int getIdmedicamento() {
        return idmedicamento;
    }

    public void setIdmedicamento(int idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    public double getDosagem() {
        return dosagem;
    }

    public void setDosagem(double dosagem) {
        this.dosagem = dosagem;
    }    

    @Override
    public String toString() {
        return "Medicamento: "+ nomeMedicamento + "\tID: " + idmedicamento + "\tFornecedor: " + fornecedor + "\tDosagem=" + dosagem + " mg";
    }
    
    
}
