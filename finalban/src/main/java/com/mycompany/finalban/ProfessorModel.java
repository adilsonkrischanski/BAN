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
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT nome,cpf,crm FROM professores pf JOIN profissionais p ON p.cpf = pf.cpf";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                System.out.println("nome: "+result.getString(1)+"\tcpf: "+ Long.toString(result.getLong(2))+""+result.getString(3));
            }
    }
    
}
