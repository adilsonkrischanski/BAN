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
public class AlergiaModel {
    public static void create(Alergia a, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO alergia (idmedicamento, codp) VALUES (?,?)");
            st.setInt(1,a.getIdmedicamento());
            st.setInt(2,a.getCodp());

            st.execute();
            st.close();  
    }
    
    static void listAll(Connection con, String codp) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sqlbase = "SELECT idmedicamento,nomemedicamento FROM alergia NATURAL JOIN medicamentos WHERE codp=";
            String num = codp;
            String sql = sqlbase+num;
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                System.out.println(Integer.toString(result.getInt(1))+' '+result.getString(2));
            }

     
    }
    
    
}
