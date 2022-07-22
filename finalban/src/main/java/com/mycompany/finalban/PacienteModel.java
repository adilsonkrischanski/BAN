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
 * @author adilson
 */
public class PacienteModel {
     public static void create(Paciente p, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO paciente (cpf,codp, tiposanguineo, nome, dtnascimento, endereco) VALUES (?,?,?,?,?,?)");
            st.setLong(1,p.getCpf());
            st.setInt(2,p.getCodp());
            st.setString(3,p.getTipoSanguineo());
            st.setString(4,p.getNome()); 
            st.setString(5,p.getDtnascimento());
            st.setString(6,p.getEndereco());

            st.execute();
            st.close();  
    }
    
    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT cpf,codp, tiposanguineo, nome, dtnascimento,endereco FROM pacientes";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new Paciente(result.getInt(1), result.getInt(2), result.getString(3),result.getString(4),result.getString(5),result.getString(6)));
            }
        return list;
    }
    
     static int maxCodp(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT max(codp) FROM paciente";
            ResultSet result = st.executeQuery(sql);
            while(result.next()){
               return result.getInt(1);
            }
            return result.getInt(1);
    
    }
    
}
