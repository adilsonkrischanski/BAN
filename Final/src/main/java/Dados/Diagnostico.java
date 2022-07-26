package Dados;

public class Diagnostico {
    private int idDiagnostico;
    private String nomeDoenca;
    private String sintomas;


    public Diagnostico(int idDiagnostico, String nomeDoenca, String sintomas) {
        this.idDiagnostico = idDiagnostico;
        this.nomeDoenca = nomeDoenca;
        this.sintomas = sintomas;
    }

    
    
    @Override
    public String toString() {
        return "Diagnostico: " + nomeDoenca + "\tID: " + idDiagnostico + "\tSintomas: " + sintomas;
    }
    

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getNomeDoenca() {
        return nomeDoenca;
    }

    public void setNomeDoenca(String nomeDoenca) {
        this.nomeDoenca = nomeDoenca;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }
    
    
}