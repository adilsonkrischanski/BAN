/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalban;

/**
 *
 * @author krischanski
 */
public class Alergia {
    private int codp;
    private int idmedicamento;

    public Alergia(int codp, int idmedicamento) {
        this.codp = codp;
        this.idmedicamento = idmedicamento;
    }
    

    public int getCodp() {
        return codp;
    }

    public void setCodp(int codp) {
        this.codp = codp;
    }

    public int getIdmedicamento() {
        return idmedicamento;
    }

    public void setIdmedicamento(int idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    @Override
    public String toString() {
        return "Alergia ao medicamento ID: " + idmedicamento + "\tCodigo do Paciente: " + codp;
    }
    
    
    
}
