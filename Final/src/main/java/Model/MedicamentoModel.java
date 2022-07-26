/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dados.Medicamento;
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
public class MedicamentoModel {
    public static void create(Medicamento m, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO medicamentos (idmedicamento, nomemedicamento, fornecedor, dosagem) VALUES (?,?,?,?)");
            st.setInt(1,m.getIdmedicamento());
            st.setString(2,m.getNomeMedicamento());
            st.setString(3,m.getFornecedor());
            st.setDouble(4,m.getDosagem());
            
            st.execute();
            st.close();  
    }
    
    public static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT idmedicamento, nomemedicamento, fornecedor, dosagem FROM medicamentos";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new Medicamento(result.getInt(1), result.getString(2), result.getString(3), result.getDouble(4)));
            }
        return list;
    }
    
    
    public static int maxCod(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT max(idmedicamento) FROM medicamentos";

            ResultSet result = st.executeQuery(sql);
            while(result.next()){
                return result.getInt(1);
            }
            return result.getInt(1);
    
    }
    
}
