/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalban.dados;

/**
 *
 * @author adilson
 */
public class Pessoa {
    private String name = new String();
    private int idade = 0;
    private long cpf  = 0;
    private String danasciemnto = new String();
    
    
    public Pessoa(){
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getDanasciemnto() {
        return danasciemnto;
    }

    public void setDanasciemnto(String danasciemnto) {
        this.danasciemnto = danasciemnto;
    }
    
    
}
