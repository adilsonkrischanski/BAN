/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dados.Aluno;
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
public class AlunoModel {
    public static void create(Aluno a, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO alunos (cpf, matricula, datainicio, crmorientador) VALUES (?,?,?,?)");
            st.setLong(1,a.getCpf());
            st.setLong(2,a.getMatricula());
            st.setString(3,a.getDataInicio());
            st.setString(4,a.getCrmOrientador());
            
            st.execute();
            st.close();  
    }
    
    public static void listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT cpf, matricula, datainicio, crmorientador, nome FROM alunos NATURAL JOIN profissionais order by nome";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
//                list.add(new Aluno(result.getLong(1), result.getLong(2), result.getString(3), result.getString(4), result.getString(5)));
                
                System.out.println("------------------\nNome: "+result.getString(5)+"\nCPF: "+result.getLong(1)+"\nMatricula: "+ result.getLong(2)+"\nData Inicio: "+result.getString(3)+"\nNome Orientador: "+ProfessorModel.NomeCRM(con, result.getString(4))+"\nCRM Orientador: "+result.getString(4));
                EmailModel.EmailProfissionalPrint(con,Long.toString(result.getLong(2))); 
                System.out.println("Telefones(s):");
                TelefoneModel.TelefoneProfissionalPrint(con,Long.toString(result.getLong(1)));
                
                 }
                System.out.println("-------------------");
            }
    

    
}
