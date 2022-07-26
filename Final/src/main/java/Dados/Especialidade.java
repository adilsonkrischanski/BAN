package Dados;

public class Especialidade {
    private String crm;
    private int idEspecialidade;
    private String nomeEspecilidade;

    public Especialidade (String crm, int idEspecialidade, String nomeEspecilidade) {
        this.crm = crm;
        this.idEspecialidade = idEspecialidade;
        this.nomeEspecilidade = nomeEspecilidade;
    }

    @Override
    public String toString() {
        return "Teste{" + "crm=" + crm + ", idEspecialidade=" + idEspecialidade + ", nomeEspecilidade=" + nomeEspecilidade + '}';
    }
    

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public int getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(int idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getNomeEspecilidade() {
        return nomeEspecilidade;
    }

    public void setNomeEspecilidade(String nomeEspecilidade) {
        this.nomeEspecilidade = nomeEspecilidade;
    }
  
}
