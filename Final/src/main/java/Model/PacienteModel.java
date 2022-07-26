/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dados.Paciente;
import Model.EmailModel;
import Model.AlergiaModel;
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
        st = con.prepareStatement(
                "INSERT INTO pacientes (cpf,codp, tiposanguineo, nome, dtnascimento, endereco) VALUES (?,?,?,?,?,?)");
        st.setLong(1, p.getCpf());
        st.setInt(2, p.getCodp());
        st.setString(3, p.getTipoSanguineo());
        st.setString(4, p.getNome());
        st.setString(5, p.getDtnascimento());
        st.setString(6, p.getEndereco());

        st.execute();
        st.close();
    }

    public static void listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT codp, cpf,nome,dtnascimento, endereco, tiposanguineo FROM pacientes";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            System.out.println(new Paciente(result.getInt(1), result.getLong(2), result.getString(3), result.getString(4),
                    result.getString(5), result.getString(6)));
            System.out.println("Email(s):");
            EmailModel.EmailPacientePrint(con,Integer.toString(result.getInt(1))); 
            System.out.println("Telefones(s):");
            TelefoneModel.TelefonePacientePrint(con,Integer.toString(result.getInt(1)));
            System.out.println("Alergia(s):");
            AlergiaModel.listAll(con,Integer.toString(result.getInt(1)));
        }
        System.out.println("-------------------");
        
        
    }

    public static int maxCodp(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT max(codp) FROM pacientes";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            return result.getInt(1);
        }
        return result.getInt(1);

    }

    public static Paciente AcharPaciente(Connection con, String nome) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT codp, cpf,nome,dtnascimento,endereco, tiposanguineo FROM pacientes  WHERE nome= '" + nome
                + "'";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {

            return (new Paciente(result.getInt(1), result.getLong(2), result.getString(3), result.getString(4),
                    result.getString(5), result.getString(6)));
        }
        return (new Paciente(result.getInt(1), result.getLong(2), result.getString(3), result.getString(4),
                    result.getString(5), result.getString(6)));

    }

}
