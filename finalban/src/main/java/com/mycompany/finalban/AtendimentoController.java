package com.mycompany.finalban;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author krischanski
 */
public class AtendimentoController {
     public void create(Connection con) throws SQLException {
      Scanner input = new Scanner(System.in);
      
      System.out.println("Insira o CPF do profissional");
      long cpfprofissional = input.nextLong();
      System.out.println("Insira o Codigo do Paciente");
      int codp = input.nextInt();
      System.out.println("Insira o Tipo do Atendimento geral(0) especializado(1)");
      int type = input.nextInt();
      input.nextLine();//buffer
      System.out.println("Insira a Data");
      String date = input.nextLine();
      System.out.println("Insira o numero do Diagnostico");
      int diagnistico = input.nextInt();
      
      Atendimento at = new Atendimento(codp, cpfprofissional, date, type, diagnistico);
      AtendimentoModel.create(at, con);
      
     }
     void ListAll(Connection con) throws SQLException {
        HashSet all = AtendimentoModel.listAll(con);
        Iterator<Atendimento> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
     
     
     
     
}
