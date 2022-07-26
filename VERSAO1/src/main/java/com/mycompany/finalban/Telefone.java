/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalban;

/**
 *
 * @author krischanski
 */
public class Telefone {
    private String telefone = new String();
    int codp = -1;
    long cpf = -1;
    
    
    public Telefone(String telefone,int codp) {
        this.telefone = telefone;
        this.codp=codp;
    }
    
    public Telefone(String telefone,long cpf) {
       this.telefone= telefone;
       this.cpf=cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getCodp() {
        return codp;
    }

    public void setCodp(int codp) {
        this.codp = codp;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        if (codp == -1){
            return "Telefone: "+ telefone +"\tCPF: " + cpf;    
        }else{
            return "Telefone: "+ telefone + "\tCodigo do Paciente: " + codp;
        }
    }
    
    
    
    
}
