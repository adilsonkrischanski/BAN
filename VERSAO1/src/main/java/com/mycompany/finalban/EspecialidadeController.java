package com.mycompany.finalban;
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

public class EspecialidadeController {
    public void create(Connection con) throws SQLException {
    Scanner input = new Scanner(System.in);

    System.out.println("Insira o CRM do medico");
    String crm = input.nextLine();
    System.out.println("Insira o Nome Da Especialidade");
    String especialidade = input.nextLine().toUpperCase();

    int idEspecialidade = EspecialidadeModel.maxCod(con)+1;
    Especialidade e = new Especialidade(crm, idEspecialidade, especialidade);
    EspecialidadeModel.create(e, con);

    }
    void ListAll(Connection con) throws SQLException {
        HashSet all = EspecialidadeModel.listAll(con);
        Iterator<Especialidade> it = all.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
            
        }
    }
    
    void listMedEspecialidade(Connection con) throws SQLException {
        EspecialidadeModel.espMedicos(con);
    }
    
}
