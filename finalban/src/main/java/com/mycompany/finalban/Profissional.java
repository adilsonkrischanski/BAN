/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalban;

/**
 *
 * @author adilson
 */
public class Profissional {
    protected Long cpf;
    protected String nome = new String();
    protected String dtnascimento = new String();
    protected String endereco = new String();
    
    Profissional(){
        
    }

    public Profissional(Long cpf, String nome, String dtnascimento, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.dtnascimento = dtnascimento;
        this.endereco = endereco;
    }
    
    

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(String dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Profissional{" + "cpf=" + cpf + ", nome=" + nome + ", dtnascimento=" + dtnascimento + ", endereco=" + endereco + '}';
    }
    
    
}
