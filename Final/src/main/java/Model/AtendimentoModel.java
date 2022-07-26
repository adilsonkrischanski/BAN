/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dados.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author krischanski
 */
public class AtendimentoModel {
    public static void create(Atendimento at, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement(
                "INSERT INTO atendimentos (codp, cpfprofissional,dtentrada,tipo) VALUES (?,?,?,?)");
        st.setInt(1, at.getCodp());
        st.setLong(2, at.getCpfProfissional());
        st.setString(3, at.getDtentrada());
        st.setInt(4, at.getTipo());

        st.execute();
        st.close();
    }

    public static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT codp, cpfprofissional, dtentrada, tipo FROM atendimentos";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new Atendimento(result.getInt(1), result.getLong(2), result.getString(3), result.getInt(4)));
        }
        return list;
    }

    public static void AtendimentosPaciente(Connection con, String nomePaciente) throws SQLException {
        Statement st;
        String tipo;
        st = con.createStatement();
        String sqlbase = "SELECT nome, dtentrada, tipo FROM atendimentos JOIN profissionais p ON cpf = cpfprofissional WHERE cpf IN (SELECT cpfprofissional FROM atendimentos NATURAL JOIN pacientes p WHERE p.nome = ";
        String num = "'".concat(nomePaciente.concat("' )"));
        String sql = sqlbase + num;
        ResultSet result = st.executeQuery(sql);
        System.out.println();
        while (result.next()) {
            if (result.getInt(3) == 1) {
                tipo = "Especializado";
            } else {
                tipo = "Geral";
            }
            System.out.println("Medico: " + result.getString(1) + "\nData de Entrada: " + result.getString(2)
                    + "\nAtendimento " + tipo+"\n--------------------");
        }

    }

    public static void AtendimentosMedicos(Connection con, String nomeMedico) throws SQLException {
        Statement st;
        String tipo;
        st = con.createStatement();
        String sqlbase = "SELECT nome, dtentrada, tipo FROM atendimentos NATURAL JOIN pacientes WHERE codp IN (SELECT codp FROM atendimentos JOIN profissionais p ON cpfprofissional = cpf WHERE p.nome = ";
        String num = "'".concat(nomeMedico.concat("' )"));
        String sql = sqlbase + num;
        ResultSet result = st.executeQuery(sql);
        System.out.println();
        while (result.next()) {
            if (result.getInt(3) == 1) {
                tipo = "Especializado";
            } else {
                tipo = "Geral";
            }
            System.out.println("Paciente: " + result.getString(1) + "\nData de entrada: " + result.getString(2)
                    + "\nAtendimento " + tipo+"\n---------------");
        }

    }

    public static void CadastrarDiagnostico(Diagnostico d, Atendimento at, Connection con) throws SQLException {
        Statement st;
        st = con.createStatement();
        String sql = "UPDATE atendimento SET iddiagnostico = "+d.getIdDiagnostico()+" WHERE data="+at.getDtentrada()+" AND cpfprofissional="+at.getCpfProfissional()+" AND codp="+at.getCodp();
        System.out.println(sql);
        st.executeQuery(sql);
    }

    public static Atendimento acharAtendimento(Connection con, Long cpf , int codp, String data) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT codp, cpfprofissional, tipo, data FROM atendimento WHERE codp=" + codp + " AND cpfprofissional="+ cpf+ " AND dtentrada='"+data+"'";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            return (new Atendimento(result.getInt(1), result.getLong(2), result.getString(3), result.getInt(4)));
        }
        return (new Atendimento(result.getInt(1), result.getLong(2), result.getString(3), result.getInt(4)));
    }

    public static void updateAtendimento(Connection con, Long cpf , int codp, String data, int id) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "UPDATE atendimentos SET iddiagnostico="+ id +" WHERE codp=" + codp + " AND cpfprofissional="+ cpf+ " AND dtentrada='"+data+"'";
        ResultSet result = st.executeQuery(sql);
        System.out.println("Diagnostico gerado com Sucesso!");
    }

}
