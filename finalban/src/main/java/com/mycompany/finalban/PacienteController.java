/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalban;

/**
 *
 * @author krischanski
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;




public class PacienteController {
    
    public void create(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para a cadastrar um novo paciente: ");
        System.out.print("Nome: ");
        String nome = input.nextLine().toUpperCase();
        
        System.out.print("CPF: ");
        long cpf = input.nextLong();
        input.nextLine();
        
        int codp = PacienteModel.maxCodp(con)+1;
        
        System.out.print("Data de Nascimento (DD/MM/AAAA): "); 
        String dataNascimento = input.nextLine();
        
        System.out.print("Tipo Sanguineo (O+, O-, A+, A-, B+, B-, AB+,AB-): ");
        String tipoSanguineo = input.nextLine();
        
        System.out.print("Endereco (Rua nº, bairro, cidade): ");
        String endereco = input.nextLine();
        
        Paciente pc = new Paciente(codp, cpf, nome, dataNascimento,endereco,tipoSanguineo);
        PacienteModel.create(pc, con);
        
        System.out.print("Telefone: ");
        String telefone = input.nextLine();
        Telefone t = new Telefone(telefone ,codp);
        TelefoneModel.createPaciente(t, con);
        
        System.out.println("Deseja informa Telefone para recado ? (S/N) ");
        char check = input.nextLine().toUpperCase().charAt(0);
       
        
     
        
        if(check =='S'){
            System.out.print("Informe o Telefone: ");
            String telefone2 = input.nextLine();
            t.setTelefone(telefone2);
            TelefoneModel.createPaciente(t, con);
        }
        
        System.out.println("Deseja Cadastrar um Email?");
        char checkemail = input.nextLine().toUpperCase().charAt(0);
        
        String email  = new String();       
        if(checkemail =='S'){
           System.out.print("Informe o email: ");
           email = input.nextLine();
           Email e = new Email(email,codp );
           EmailModel.createPaciente(e, con);
        }
      
        
        System.out.println("Paciente cadastrado com sucesso!!");
    }

    void listarPaciente(Connection con) throws SQLException {
        HashSet all = PacienteModel.listAll(con);
        Iterator<Paciente> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}