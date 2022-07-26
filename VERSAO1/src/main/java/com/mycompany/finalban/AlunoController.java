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
 * @author adilson
 */
public class AlunoController {
     public void create(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para a cadastrar um novo Aluno: ");
        System.out.print("Nome: ");
        String nome = input.nextLine().toUpperCase();
        
        System.out.print("CPF: ");
        long cpf = input.nextLong();
        input.nextLine();
        
        int codp = 1;
        
        System.out.print("Data de Nascimento (DD/MM/AAAA): "); 
        String dataNascimento = input.nextLine();
        
        System.out.print("Endereco (Rua nº, bairro, cidade): ");
        String endereco = input.nextLine().toUpperCase();
        
        Profissional pf = new Profissional(cpf, nome, dataNascimento, endereco);
        ProfissionalModel.create(pf, con);
        
        System.out.print("Matricula:");
        long matricula = input.nextLong();
        input.nextLine();//buffer
        
        System.out.print("Data de inicio:");
        String dtinicio= input.nextLine();
         
        System.out.print("Crm Orientador:");
        String crmOrientador = input.nextLine().toUpperCase();
        
        Aluno an = new Aluno(cpf, matricula ,dtinicio,crmOrientador);
        AlunoModel.create(an, con);
      
        
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
           email = input.nextLine().toUpperCase();
           Email e = new Email(email,cpf );
           EmailModel.createProfissionais(e, con);
        }
        
         
        
        System.out.println("Aluno cadastrado com sucesso!!");
    }

    void listarAlunos(Connection con) throws SQLException {
        AlunoModel.listAll(con);
        
    }
}
