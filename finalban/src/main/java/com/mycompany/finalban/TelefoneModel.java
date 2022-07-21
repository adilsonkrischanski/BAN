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
public class TelefoneModel {
    
     public static void createPaciente(Telefone t, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO telefone (telefone, codp) VALUES (?,?)");
            st.setString(1, t.getTelefone());
            st.setInt(2, t.getCodp());
            st.execute();
            st.close();  
    }
     public static void createProfissionais(Telefone t, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO telefone (telefone, cpf) VALUES (?,?)");
            st.setString(1, t.getTelefone());
            st.setLong(2, t.getCpf());
            st.execute();
            st.close();  
    }

    static HashSet listAllPacientes(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT telefone, codp FROM telefone";
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
            String sql = "SELECT telefone, cpf FROM telefone";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new Email(result.getString(1), result.getLong(2)));
            }
        return list;
    }
    
}
