/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalban;

/**
 *
 * @author krischanski
 */
public class Paciente {
    private int codp;
    private String nome = new String();
    private long cpf;
    private String dtnascimento = new String(); 
    private String endereco = new String();
    private String tipoSanguineo = new String();

    public Paciente(int codp,long cpf, String nome, String dtnascimento, String endereco, String tipoSanguineo) {
        this.nome = nome;
        this.codp = codp;
        this.cpf = cpf;
        this.dtnascimento = dtnascimento;
        this.endereco = endereco;
        this.tipoSanguineo = tipoSanguineo;
               
    }
    
    

    public int getCodp() {
        return codp;
    }

    public void setCodp(int codp) {
        this.codp = codp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
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

    public void setEndereço(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    @Override
    public String toString() {
        return "-------------------\nPaciente: "+ nome + "\nCodigo: " + codp + "\nCPF: " + cpf + "\nData de nascimento: " + dtnascimento + "\nEndereco: " + endereco + "\nTipo Sanguineo: " + tipoSanguineo;
    }
    
    
    
    }
