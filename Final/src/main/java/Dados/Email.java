package Dados;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author krischanski
 */
public class Email {
    private String email = new String();
    int codp = -1;
    long cpf = -1;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Email(String email,int codp) {
        this.email = email;
        this.codp=codp;
    }
    
    public Email(String email,long cpf) {
       this.email = email;
       this.cpf=cpf;
    }

    public long getCpf() {
        return cpf;
    }

    public int getCodp() {
        return codp;
    }

    @Override
    public String toString() {
        if(codp == -1){
            return "Email: " + email + "\tCPF: " + cpf;
        }else{
            return "Email: " + email + "\tCodigo do Paciente: " + codp;
        } 
    }


}
