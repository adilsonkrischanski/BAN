package com.mycompany.finalban;

public class Plantao {
    private String crm;
    private String horaDeInicio;
    private int duracao;
    private String diaSemana;
    
    public Plantao(String crm, String horaDeInicio, int duracao, String diaSemana) {
        this.crm = crm;
        this.horaDeInicio = horaDeInicio;
        this.duracao = duracao;
        this.diaSemana = diaSemana;
    }

    @Override
    public String toString() {
        return "Teste{" + "crm=" + crm + ", horaDeInicio=" + horaDeInicio + ", duracao=" + duracao + ", diaSemana=" + diaSemana + '}';
    }
    
    

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getHoraDeInicio() {
        return horaDeInicio;
    }

    public void setHoraDeInicio(String horaDeInicio) {
        this.horaDeInicio = horaDeInicio;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
}
