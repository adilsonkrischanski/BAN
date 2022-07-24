package com.mycompany.finalban;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class AvaliacaoModel {
    public static void create(Avaliacao av, Connection con) throws SQLException {

        PreparedStatement st;
        st = con.prepareStatement(
                "INSERT INTO avaliacoes (idavaliacao, nomeavaliador, nota, comentario, dtavaliacao, matricula) VALUES (?,?,?,?,?,?)");
        st.setInt(1, av.getIdAvalidacao());
        st.setString(2, av.getNomeAvalidor());
        st.setDouble(3, av.getNota());
        st.setString(4, av.getComentario());
        st.setString(5, av.getDataAvaliacao());
        st.setLong(6, av.getMatricula());

        st.execute();
        st.close();
    }

    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT idavaliacao, nomeavaliador, nota, comentario, dtavaliacao, matricula FROM avaliacoes";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new Avaliacao(result.getInt(1), result.getString(2), result.getDouble(3), result.getString(4),
                    result.getString(5), result.getLong(6)));
        }
        return list;
    }

    static void AvaliacoesAlunos(Connection con) throws SQLException {
        Statement st;
        st = con.createStatement();
        String sql = "SELECT p.nome, nomeavaliador, nota, comentario FROM avaliacoes NATURAL JOIN alunos a LEFT JOIN profissionais p on a.cpf=p.cpf ";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            System.out.println("------------------\nAluno: " + result.getString(1) + " \nNota: " + result.getDouble(3) + " \nAvaliador: "
                    + result.getString(2) + " \nComentario: " + result.getString(4));
        }
        System.out.println("-------------------");

    }

    static int maxCodp(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT max(idavaliacao) FROM avaliacoes";
        ResultSet result = st.executeQuery(sql);
        while(result.next()){
            return result.getInt(1);
        }
        return result.getInt(1);

    }
    
    static void AvaliacoesMaiorNota(Connection con) throws SQLException {
        Statement st;
        st = con.createStatement();
        String sql = "SELECT p.nome, nomeavaliador, nota, comentario FROM avaliacoes NATURAL JOIN alunos a LEFT JOIN profissionais p on a.cpf=p.cpf Where nota in ("
                + "SELECT MAX(nota) FROM avaliacoes)";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            System.out.println("------------------\nAluno: " + result.getString(1) + " \nNota: " + result.getDouble(3) + " \nAvaliador: "
                    + result.getString(2) + " \nComentario: " + result.getString(4));
        }
        System.out.println("-------------------");
    
    }
    static void AvaliacoesMenorNota(Connection con) throws SQLException {
        Statement st;
        st = con.createStatement();
        String sql = "SELECT p.nome, nomeavaliador, nota, comentario FROM avaliacoes NATURAL JOIN alunos a LEFT JOIN profissionais p on a.cpf=p.cpf Where nota in ("
                + "SELECT MIN(nota) FROM avaliacoes)";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            System.out.println("------------------\nAluno: " + result.getString(1) + " \nNota: " + result.getDouble(3) + " \nAvaliador: "
                    + result.getString(2) + " \nComentario: " + result.getString(4));
        }
        System.out.println("-------------------");
    
    }

}
