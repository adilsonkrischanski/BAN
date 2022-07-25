/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalban;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

/**
 *
 * @author krischanski
 */
public class ProfessorModel {
     public static void create(Professor p , Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO professores (cpf,crm) VALUES (?,?)");
            st.setLong(1,p.getCpf());
            st.setString(2,p.getCrm());
            
            st.execute();
            st.close();  
    }
    
    static void listAll(Connection con) throws SQLException {
        Statement st;
            st = con.createStatement();
            String sql = "SELECT nome,cpf,crm FROM professores pf JOIN profissionais p ON p.cpf = pf.cpf";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                System.out.println("nome: "+result.getString(1)+"\nCPF: "+ Long.toString(result.getLong(2))+"\nEspecialidade: "+result.getString(3));
                EmailModel.EmailProfissionalPrint(con,Long.toString(result.getLong(2))); 
                System.out.println("Telefones(s):");
                TelefoneModel.TelefoneProfissionalPrint(con,Long.toString(result.getLong(1)));
                System.out.println("-------------------");
                
                 }
        
        }
    
        static String NomeCRM(Connection con,String crm) throws SQLException {
        Statement st;
        st = con.createStatement();
        String sql2 = "SELECT pr.nome FROM profissionais pr JOIN professores prof on pr.cpf=prof.cpf WHERE prof.crm='"+crm+"'";
        ResultSet result2 = st.executeQuery(sql2);
        while(result2.next()){
            return result2.getString(1);
            }
        return result2.getString(1);
    }
    
}
