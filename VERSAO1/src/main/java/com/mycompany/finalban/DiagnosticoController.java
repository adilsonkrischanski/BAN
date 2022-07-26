/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalban;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.SQLException;

/**
 *
 * @author krischanski
 */
public class DiagnosticoController {
    
    public void create(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enfermidade: ");
        String nome = input.nextLine().toUpperCase();
        System.out.print("Sintomas: ");
        String sintomas = input.nextLine().toUpperCase();
        System.out.print("Identificador: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Dados do atendimento");
        System.out.print("Data: ");
        String data = input.nextLine();
        System.out.print("Codigo do Paciente: ");
        int codp = input.nextInt();
        System.out.print("CPF do Profissional: ");
        Long cpf = input.nextLong();

        Diagnostico d = new Diagnostico(id, nome, sintomas);
        DiagnosticoModel.create(d, con);
        new AtendimentoModel().updateAtendimento(con, cpf, codp, data, d.getIdDiagnostico());

    }

    void AcharDiagnostico(Connection con, String nomePaciente, String data) throws SQLException {
        DiagnosticoModel.AcharDiagnostico(con, nomePaciente, data); 
    }
    
}