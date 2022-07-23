package com.mycompany.finalban;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;


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
      System.out.println("Insir a Data");
      String date = input.nextLine();
      
      Atendimento at = new Atendimento(codp, cpfprofissional, date, type);
      AtendimentoModel.create(at, con);
      
     }
    
    void ListAll(Connection con) throws SQLException {
        HashSet all = AtendimentoModel.listAll(con);
        Iterator<Atendimento> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
     
    static Atendimento acharAtendimento(Connection con, Long cpf , int codp, String data) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT codp, cpfprofissional, tipo, data FROM atendimento WHERE codp=" + codp + " AND cpfprofissional="+ cpf+ " AND data="+data;
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            return (new Atendimento(result.getInt(1), result.getLong(2), result.getInt(3), result.getString(4)));
        }
        return (new Atendimento(result.getInt(1), result.getLong(2), result.getInt(3), result.getString(4)));
    }

    static void updateAtendimento(Connection con, Long cpf , int codp, String data, int id) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "UPDATE atendimento SET iddiagnostico="+ id +" WHERE codp=" + codp + " AND cpfprofissional="+ cpf+ " AND data="+data;
        ResultSet result = st.executeQuery(sql);
        System.out.println("Diagnostico gerado com Sucesso!");
    }
      
}
