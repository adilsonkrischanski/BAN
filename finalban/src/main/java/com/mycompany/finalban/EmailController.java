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



public class EmailController {
    
    public void createPaciente(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Deseja Cadastrar email para profissional(0) ou paciente(1) ");
        int check = input.nextInt();
        if(check==0){
            System.out.println("Insira o CPF do profissional");
            long cpf = input.nextLong();
            input.nextLine(); //buffer
            System.out.println("Informe o email ");
            String email = input.nextLine();
            Email e = new Email(email, cpf);
            EmailModel.createProfissionais(e, con);         
            
        }
        else{
            System.out.println("Insira o codigo do paciente");
            int codp = input.nextInt();
            input.nextLine(); //buffer
            System.out.println("Informe o email ");
            String email = input.nextLine();
            Email e = new Email(email, codp);
            EmailModel.createPaciente(e, con);
            
        }

    
    }
    
    void listarEmailProfissionais(Connection con) throws SQLException {
        HashSet all = EmailModel.listAllProfissionais(con);
        Iterator<Email> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    void listarEmailPaciente(Connection con) throws SQLException {
        HashSet all = EmailModel.listAllPacientes(con);
        Iterator<Email> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
