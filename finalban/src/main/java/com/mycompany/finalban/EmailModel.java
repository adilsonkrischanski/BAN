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


public class EmailModel {
    
     public static void createPaciente(Email e, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO email (email, codp) VALUES (?,?)");
            st.setString(1, e.getEmail());
            st.setInt(2, e.getCodp());
            st.execute();
            st.close();  
    }
     public static void createProfissionais(Email e, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO email (email, cpf) VALUES (?,?)");
            st.setString(1, e.getEmail());
            st.setLong(2, e.getCpf());
            st.execute();
            st.close();  
    }

    static HashSet listAllPacientes(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT email, codp FROM email";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new Email(result.getString(1), result.getInt(2)));
            }
        return list;
    }
    static HashSet listAllProfissionais(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT email, cpf FROM email";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new Email(result.getString(1), result.getLong(2)));
            }
        return list;
    }
    
    
    static void EmailPacientePrint(Connection con,String codp)throws SQLException{
            Statement st;
            st = con.createStatement();
            String sql = "SELECT email, codp FROM email WHERE codp= "+codp;
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                System.out.println(result.getString(1));
            }
    }
    static void EmailProfissionalPrint(Connection con, String cpf)throws SQLException{
            Statement st;
            st = con.createStatement();
            String sql = "SELECT email, cpf FROM email WHERE cpf= "+cpf;
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                System.out.println(result.getString(1));
            }
    }
}
