package com.mycompany.finalban;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;

public class AvaliacaoController {
    public void create(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);

        System.out.println("Insira a Data da avaliacao");
        String dataAvaliacao = input.nextLine();

        System.out.print("Insira a Matricula do Aluno");
        long matricula = input.nextLong();
        input.nextLine();// buffer

        System.out.println("Insira o Nome do Avaliador");
        String avaliador = input.nextLine();

        System.out.println("Insira um Comentario");
        String comentario = input.nextLine();

        System.out.println("Insira a nota");
        double nota = input.nextInt();

        int idavaliacao = AvaliacaoModel.maxCodp(con) + 1;

        Avaliacao av = new Avaliacao(idavaliacao, avaliador, nota, comentario, dataAvaliacao, matricula);
        AvaliacaoModel.create(av, con);
    }

    void listarAvaliacoes(Connection con) throws SQLException {
        HashSet all = AvaliacaoModel.listAll(con);
        Iterator<Avaliacao> it = all.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    void ListAlunosNotas(Connection con) throws SQLException {
        AvaliacaoModel.AvaliacoesAlunos(con);
    }

}
