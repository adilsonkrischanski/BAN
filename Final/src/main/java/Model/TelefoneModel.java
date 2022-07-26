/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dados.Telefone;
import Dados.Email;
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
            st = con.prepareStatement("INSERT INTO telefones (telefone, codp) VALUES (?,?)");
            st.setString(1, t.getTelefone());
            st.setInt(2, t.getCodp());
            st.execute();
            st.close();  
    }
    public static void createProfissionais(Telefone t, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO telefones (telefone, cpf) VALUES (?,?)");
            st.setString(1, t.getTelefone());
            st.setLong(2, t.getCpf());
            st.execute();
            st.close();  
    }

    public static HashSet listAllPacientes(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT telefone, codp FROM telefones";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new Email(result.getString(1), result.getInt(2)));
            }
        return list;
    }
    public static HashSet listAllProfissionais(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT telefone, cpf FROM telefones";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new Email(result.getString(1), result.getLong(2)));
            }
        return list;
    }
    
    public static void TelefonePacientePrint(Connection con,String codp)throws SQLException{
            Statement st;
            st = con.createStatement();
            String sql = "SELECT telefone, codp FROM telefones WHERE codp= +"+codp;
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                System.out.println(result.getString(1));
            }
    }
    
    public static void TelefoneProfissionalPrint(Connection con,String cpf)throws SQLException{
            Statement st;
            st = con.createStatement();
            String sql = "SELECT telefone, cpf FROM telefones WHERE cpf= +"+cpf;
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                System.out.println(result.getString(1));
            }
    }
    
}
