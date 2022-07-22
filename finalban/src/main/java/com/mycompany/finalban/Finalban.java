package com.mycompany.finalban;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;


/**
 *
 * @author krischanski
 */
public class Finalban {
    
     public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String nome;
        Conexao c = new Conexao();
        Connection con = c.getConnection();
        int op = 0;
        do{
            op = menu();
            try {
                switch (op) {
                    case 1 :
                        System.out.println("1 - Paciente\n2 - Aluno\n3 - Professor\n4 - Medicamento\n5 - Especialidade");
                        op = sc.nextInt();
                        switch (op) {
                            case 1: 
                                new PacienteController().create(con);
                                break;
                            case 2:
                                new AlunoController().create(con);
                                break;
                            case 3:
                                new ProfessorController().create(con);
                                break;
                            case 4:
                                new MedicamentoController().create(con);
                                break;
                            case 5:
                                new EspecialidadeController().create(con);
                                break;
                        }
                        break;
                    case 2: new PacienteController().listarPaciente(con);
                        break;
                    case 3: new EspecialidadeController().listMedEspecialidade(con);
                        break;
                    case 4: new AlunoController().listarAlunos(con);
                        break;
                    case 5:new MedicamentoController().listarAll(con);
                        break;
                    case 6:
                        System.out.print("Nome Completo do Paciente: ");
                        nome = sc.nextLine().toUpperCase();
                        new AtendimentoModel().AtendimentosPaciente(con, nome);
                        break;
                    case 7:
                        System.out.print("Nome Completo do Medico: ");
                        nome = sc.nextLine().toUpperCase();
                        new AtendimentoModel().AtendimentosMedicos(con, nome);
                        break;
                    case 8:
                        System.out.print("Nome Completo do Paciente: ");
                        nome = sc.nextLine().toUpperCase();
                        break;
                    case 9:
                        System.out.print("Nome Completo do Medico: ");
                        nome = sc.nextLine().toUpperCase();
                        break;
                    case 10:
                        System.out.println("1 - Cadastrar Avaliacao\n2 - Listar Avaliacoes");
                        op = sc.nextInt();
                        switch (op) {
                            case 1:
                                new AvaliacaoController().create(con);
                                break;
                        
                            case 2:
                                new AvaliacaoController().ListAlunosNotas(con);
                                break;
                        }
                        break;          
                }
            }catch(SQLException ex) {
                //ex.printStackTrace();
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<15);  
        con.close();
    }    
    
    public static int menu(){
        System.out.println("1 - Realizar Cadastros");
        System.out.println("2 - Listagem de Pacientes");
        System.out.println("3 - Listagem de Especialistas");
        System.out.println("4 - Listagem de Estudantes");
        System.out.println("5 - Listagem de Medicamentos");
        System.out.println("6 - Atendimentos ao Paciente");
        System.out.println("7 - Atendimentos pelo Medico");
        System.out.println("8 - Informacoes sobre o Paciente");
        System.out.println("9 - Informacoes sobre o Médico");
        System.out.println("10 - Avaliacoes");
        System.out.println();
        Scanner input = new Scanner(System.in);
        return input.nextInt();   
    }
    
}
