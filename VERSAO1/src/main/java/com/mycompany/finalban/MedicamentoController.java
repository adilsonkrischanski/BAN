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
public class MedicamentoController {
    
    public void create(Connection con) throws SQLException {
      Scanner input = new Scanner(System.in);
      int idmedicamento = MedicamentoModel.maxCod(con)+1;
      
      System.out.println("Insira o Nome do Novo Medicamento");
      String nome = input.nextLine().toUpperCase();
      System.out.println("Insira o fornecedor do Novo Medicamento");
      String fornecedor = input.nextLine().toUpperCase();
      
      System.out.println("Insira a dosagem ");
      double dosagem = input.nextDouble();
      
      Medicamento m = new Medicamento(idmedicamento, nome,fornecedor,dosagem);
      MedicamentoModel.create(m, con);
     
      
      }
    
     void listarAll(Connection con) throws SQLException {
        HashSet all = MedicamentoModel.listAll(con) ;
        Iterator<Medicamento> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
   
    }
    
}
