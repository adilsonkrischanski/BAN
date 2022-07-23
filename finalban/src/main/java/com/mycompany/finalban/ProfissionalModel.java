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
public class ProfissionalModel {
    public static void create(Profissional p, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO profissionais (cpf, nome, dtnascimento, endereco) VALUES (?,?,?,?)");
        st.setLong(1, p.getCpf());
        st.setString(2, p.getNome());
        st.setString(3, p.getDtnascimento());
        st.setString(4, p.getEndereco());

        st.execute();
        st.close();
    }

    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT cpf, nome, dtnascimento, endereco FROM profissionais";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(
                    new Profissional(result.getLong(1), result.getString(2), result.getString(3), result.getString(4)));
        }
        return list;
    }

    static Profissional AcharProfissional(Connection con, String nome) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT cpf, nome, dtnascimento, endereco FROM profissionais WHERE nome=" + nome;
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            return (new Profissional(result.getLong(1), result.getString(2), result.getString(3), result.getString(4)));
        }
        return (new Profissional(result.getLong(1), result.getString(2), result.getString(3), result.getString(4)));
    }

}
