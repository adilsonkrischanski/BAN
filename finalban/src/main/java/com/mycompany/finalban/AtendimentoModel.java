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
                "INSERT INTO atendimento (codp, cpfprofissional,dtentrada,idddiagnostico,tipo) VALUES (?,?,?,?,?)");
        st.setInt(1, at.getCodp());
        st.setLong(2, at.getCpfProfissional());
        st.setString(3, at.getDtentrada());
        st.setInt(4, at.getIdDiagnostico());
        st.setInt(5, at.getTipo());

        st.execute();
        st.close();
    }

    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT codp, cpfprofissional,dtentrada,idddiagnostico,tipo FROM atendimento";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new Atendimento(result.getInt(1), result.getLong(2), result.getString(3), result.getInt(4),
                    result.getInt(5)));
        }
        return list;
    }

    static void AtendimentosPaciente(Connection con, String nomePaciente) throws SQLException {
        Statement st;
        String tipo;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sqlbase = "SELECT nome, dtentrada, tipo FROM atendimento JOIN profissionais p ON cpf = cpfprofissional WHERE cpf IN (SELECT cpfprofissional FROM atendimento NATURAL JOIN paciente p WHERE p.nome = ";
        String num = "'".concat(nomePaciente.concat("' )"));
        String sql = sqlbase + num;
        System.out.println(sql);
        ResultSet result = st.executeQuery(sql);
        System.out.println();
        while (result.next()) {
            if (result.getInt(3) == 1) {
                tipo = "Especializado";
            } else {
                tipo = "Geral";
            }
            System.out.println("Medico: " + result.getString(1) + "\tData de Entrada: " + result.getString(2)
                    + "Atendimento " + tipo);
        }

    }

    static void AtendimentosMedicos(Connection con, String nomeMedico) throws SQLException {
        Statement st;
        String tipo;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sqlbase = "SELECT nome, dtentrada, tipo FROM atendimento NATURAL JOIN pacientes WHERE codp IN (SELECT codp FROM atendimento JOIN profissionais p ON cpfprofissional = cpf WHERE p.nome = ";
        String num = "'".concat(nomeMedico.concat("' )"));
        String sql = sqlbase + num;
        System.out.println(sql);
        ResultSet result = st.executeQuery(sql);
        System.out.println();
        while (result.next()) {
            if (result.getInt(3) == 1) {
                tipo = "Especializado";
            } else {
                tipo = "Geral";
            }
            System.out.println("Paciente: " + result.getString(1) + "\tData de entrada: " + result.getString(2)
                    + "\tAtendimento " + tipo);
        }

    }

}