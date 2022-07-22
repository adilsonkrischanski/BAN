/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalban;

/**
 *
 * @author adilson
 */
public class Aluno extends Profissional{
    private Long matricula;
    private String dataInicio = new String();
    private String crmOrientador = new String();

    public Aluno(Long cpf, Long matricula, String dataInicio, String crmOrientador) {
        super();
        this.cpf = cpf;
        this.matricula = matricula;
        this.crmOrientador = crmOrientador;
        this.dataInicio = dataInicio;
    }
    

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getCrmOrientador() {
        return crmOrientador;
    }

    public void setCrmOrientador(String crmOrientador) {
        this.crmOrientador = crmOrientador;
    }

    @Override
    public String toString() {
        return "Aluno{" + "cpf=" + cpf + ", matricula=" + matricula + ", dataInicio=" + dataInicio + ", crmOrientador=" + crmOrientador + '}';
    }
    
    
}
