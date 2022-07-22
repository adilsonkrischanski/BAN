package com.mycompany.finalban;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;


/**
 *
 * @author krischanski
 */
public class Finalban {
    
     public static void main(String[] args) throws SQLException {
        Conexao c = new Conexao();
        Connection con = c.getConnection();
        int op = 0;
        do{
            op = menu();
            try {
                switch (op) {
                    case 1 :new PacienteController().create(con);
                        break;
                    case 2: new MedicamentoController().create(con);
                    break;
                    case 3: new AlunoController().create(con);
                    break;
                    case 4: new ProfessorController().create(con);
                    break;
                    case 5:new MedicamentoController().listarAll(con);
                    break;
                    case 6: new AlergiaController().create(con);
                    break;
                    case 7: new AlergiaController().listarAll(con);
                    break;
                    
                   
                           
                }
            }catch(SQLException ex) {
                //ex.printStackTrace();
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<15);  
        con.close();
    }    
    
    public static int menu(){
        System.out.println("1 - Cadastrar Profissional");
        System.out.println("2 - Cadastrar Paciente");
        System.out.println("3 - Cadastrar Medicamento");
        System.out.println("4 - Cadastrar Email");
        System.out.println("5 - Cadastrar Telefone");
        System.out.println("6 - Listar Proficionais");
        System.out.println("7 - Listar Pacientes");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
        
    }
    
}
