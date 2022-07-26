package Dados;



public class Avaliacao {
    private int idAvalidacao;
    private String nomeAvalidor;
    private double nota;
    private String Comentario;
    private String dataAvaliacao;
    private long Matricula;

    public Avaliacao(int idAvalidacao, String nomeAvalidor, double nota, String Comentario, String dataAvaliacao, long Matricula) {
        this.idAvalidacao = idAvalidacao;
        this.nomeAvalidor = nomeAvalidor;
        this.nota = nota;
        this.Comentario = Comentario;
        this.dataAvaliacao = dataAvaliacao;
        this.Matricula = Matricula;
    }

    @Override
    public String toString() {
        return "------------------\nID Avaliacao: " + idAvalidacao + "\nNome do Avaliador: " + nomeAvalidor + "\nNota: " + nota + "\nComentario: " + Comentario + "\nData da Prova: " + dataAvaliacao + "\nMatricula do Aluno: " + Matricula;
    }

    public int getIdAvalidacao() {
        return idAvalidacao;
    }

    public void setIdAvalidacao(int idAvalidacao) {
        this.idAvalidacao = idAvalidacao;
    }

    public String getNomeAvalidor() {
        return nomeAvalidor;
    }

    public void setNomeAvalidor(String nomeAvalidor) {
        this.nomeAvalidor = nomeAvalidor;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public String getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(String dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public long getMatricula() {
        return Matricula;
    }

    public void setMatricula(long Matricula) {
        this.Matricula = Matricula;
    }

    
}
