package Model;

import Dados.Especialidade;
import Model.EmailModel;
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

public class EspecialidadeModel {

    public static void create(Especialidade e, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO especialidades (crm, idespecialidade, nomeespecialidade) VALUES (?,?,?)");
        st.setString(1, e.getCrm());
        st.setInt(2, e.getIdEspecialidade());
        st.setString(3, e.getNomeEspecilidade());
        st.execute();
        st.close();
    }

    public static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT crm, idespecialidade, nomeespecialidade FROM especialidades";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new Especialidade(result.getString(1), result.getInt(2), result.getString(3)));
        }
        return list;

    }

    public static int maxCod(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT max(idespecialidade) FROM especialidades";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            return result.getInt(1);
        }
        return result.getInt(1);

    }

    public static void espMedicos(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT f.nome, p.crm, nomeespecialidade, f.cpf FROM especialidades e JOIN professores p on  p.crm=e.crm JOIN profissionais f on p.cpf=f.cpf ";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            System.out.println("Professor: "
                    + (result.getString(1) + "\nCRM:" + result.getString(2) + "\nEspecialidade: "
                            + result.getString(3)));
                System.out.println("Email(s):");
                EmailModel.EmailProfissionalPrint(con,Long.toString(result.getLong(4))); 
                System.out.println("Telefones(s):");
                TelefoneModel.TelefoneProfissionalPrint(con,Long.toString(result.getLong(4)));
                System.out.println("-------------------");
                
                 }
            
        }

}
