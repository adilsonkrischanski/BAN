/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalban;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author krischanski
 */
public class ProfessorController {
    public void create(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para a cadastrar um novo Professor: ");
        System.out.print("Nome: ");
        String nome = input.nextLine().toUpperCase();
        
        System.out.print("CPF: ");
        long cpf = input.nextLong();
        input.nextLine();
        
        System.out.print("Data de Nascimento (DD/MM/AAAA): "); 
        String dataNascimento = input.nextLine();
        
        System.out.print("Endereco (Rua nº, bairro, cidade): ");
        String endereco = input.nextLine();
        
        new Profissional(cpf, nome, dataNascimento, endereco);
//      ProfissionalModel.create(pf, con);
        
     
         
        System.out.print("Crm:");
        String crm = input.nextLine();
        
        Professor prof = new Professor(crm,cpf);
        ProfessorModel.create(prof, con);
      
        
        System.out.print("Telefone: ");
        String telefone = input.nextLine();
        Telefone t = new Telefone(telefone ,cpf);
        TelefoneModel.createProfissionais(t, con);
        
        System.out.println("Deseja informa Telefone para recado ? (S/N) ");
        char check = input.nextLine().toUpperCase().charAt(0);
       
        
        if(check =='S'){
            System.out.print("Informe o Telefone: ");
            String telefone2 = input.nextLine();
            t.setTelefone(telefone2);
            TelefoneModel.createProfissionais(t, con);
        }
        
        System.out.println("Deseja Cadastrar um Email?");
        char checkemail = input.nextLine().toUpperCase().charAt(0);
        
        String email  = new String();       
        if(checkemail =='S'){
           System.out.print("Informe o email: ");
           email = input.nextLine();
           Email e = new Email(email,cpf );
           EmailModel.createProfissionais(e, con);
        }
   
        System.out.println("Professor cadastrado com sucesso!!");
    }  
    
    public void acharPaciente(Connection con,String nome) throws SQLException{
        System.out.println(PacienteModel.AcharPaciente(con, nome));
    }

}
