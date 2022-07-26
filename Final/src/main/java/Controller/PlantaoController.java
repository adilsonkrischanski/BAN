package Controller;


import Dados.*;
import Model.*;
import Conexao.*;
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

public class PlantaoController {
    public void create(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o CRM do medico de Plantao");
        String crm = input.nextLine().toUpperCase();
        System.out.println("Insira o Horario de Inicio do Plantao");
        String inicio = input.nextLine().toUpperCase();
        System.out.println("Insira a Duracao do plantao(8-12-24)");
        int duracao = input.nextInt();
        input.nextLine();// buffer
        System.out.println("Insira o dia da semana do Plantao");
        String diaSemana = input.nextLine().toUpperCase();

        Plantao p = new Plantao(crm, inicio, duracao, diaSemana);
        PlantaoModel.create(p, con);

    }

    public void showPlantoes(Connection con) throws SQLException {
        PlantaoModel.Plantoes(con);
    }

}
