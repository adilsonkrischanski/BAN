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
public class AlergiaController {
     public void create(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o codigo do Paciente ");
        int codp = input.nextInt();
        input.nextLine();
        System.out.print("Insira o Id do medicamento ");
        int idmed = input.nextInt();
        
        Alergia a = new Alergia(codp,idmed);
        AlergiaModel.create(a, con);
     }
     
     public void listarAll(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o codigo do Paciente ");
        String codp = input.nextLine();
        AlergiaModel.listAll(con, codp);
       
        }
   
    }
    
    

