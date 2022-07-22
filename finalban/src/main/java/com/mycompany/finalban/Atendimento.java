/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalban;

/**
 *
 * @author krischanski
 */
public class Atendimento {
    private int codp;
    private long cpfProfissional;
    private String dtentrada;
    private int tipo;
    private int idDiagnostico;

    public Atendimento(int codp, long cpfProfissional, String dtentrada, int tipo, int idDiagnostico) {
        this.codp = codp;
        this.cpfProfissional = cpfProfissional;
        this.dtentrada = dtentrada;
        this.tipo = tipo;
        this.idDiagnostico = idDiagnostico;
    }

    
    @Override
    public String toString() {
        return "Atendimento{" + "codp=" + codp + ", cpfProfissional=" + cpfProfissional + ", dtentrada=" + dtentrada + ", tipo=" + tipo + ", idDiagnostico=" + idDiagnostico + '}';
    }
   

    public int getCodp() {
        return codp;
    }

    public void setCodp(int codp) {
        this.codp = codp;
    }

    public long getCpfProfissional() {
        return cpfProfissional;
    }

    public void setCpfProfissional(long cpfProfissional) {
        this.cpfProfissional = cpfProfissional;
    }

    public String getDtentrada() {
        return dtentrada;
    }

    public void setDtentrada(String dtentrada) {
        this.dtentrada = dtentrada;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }
    
    
}
