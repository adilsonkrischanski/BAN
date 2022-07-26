package Model;


import Dados.Plantao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

public class PlantaoModel {
    public static void create(Plantao p, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO plantoes (crm, horarioinicio, duracao,diasemana) VALUES (?,?,?,?)");
        st.setString(1, p.getCrm());
        st.setString(2, p.getHoraDeInicio());
        st.setInt(3, p.getDuracao());
        st.setString(4, p.getDiaSemana());

        st.execute();
        st.close();
    }

    public static void Plantoes(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT f.nome, pl.crm, horarioinicio, duracao,diasemana  FROM plantoes pl JOIN professores p on  p.crm=pl.crm JOIN profissionais f on p.cpf=f.cpf ";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            System.out.println("Plantonista: "
                    + (result.getString(1) + "\nCRM:" + result.getString(2) + "\nHora Inicio: "
                            + result.getString(3) + "\nDuracao: " + result.getInt(4) + "\nDia Semana: "
                            + result.getString(5)+"\n------------------------"));
        }
    }

}
