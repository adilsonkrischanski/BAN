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
public class DiagnosticoModel {
     public static void create(Diagnostico d , Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO diagnostico (iddiagnostico, nomedoenca, sintomas) VALUES (?,?,?)");
            st.setInt(1,d.getIdDiagnostico());
            st.setString(2,d.getNomeDoenca());
            st.setString(3,d.getSintomas());
            
            st.execute();
            st.close();  
    }
    
    static HashSet listAllHashSet(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT iddiagnostico, nomedoenca, sintomas FROM diagnostico";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new Diagnostico(result.getInt(1), result.getString(2),result.getString(3)));
            }
        return list;
    }

    void AcharDiagnostico(Connection con, String nomePaciente, String data) throws SQLException {
        Statement st;
        String tipo;
        st = con.createStatement();
        String sql = "SELECT iddiagnostico, nomedoenca, sintomas FROM diagnostico WHERE iddiagnostico IN (SELECT iddiagnostico FROM atendimento NATURAL JOIN paciente WHERE data="+data+" AND nome="+nomePaciente;
        System.out.println(sql);
        ResultSet result = st.executeQuery(sql);
        System.out.println();
        while (result.next()) {
            System.out.println("Diagnostico: " + result.getString(2) + "\tSintomas: " + result.getString(3));
        }
    }
    
}
