/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dados.*;
import Model.*;
import Conexao.*;
import Dados.Telefone;
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
public class TelefoneController {
    
    public void createPaciente(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Deseja Cadastrar Telefone para profissional(0) ou paciente(1) ");
        int check = input.nextInt();
        if(check==0){
            System.out.println("Insira o CPF do profissional");
            long cpf = input.nextLong();
            input.nextLine(); //buffer
            System.out.println("Informe o Telefone ");
            String telefone = input.nextLine();
            Telefone t = new Telefone(telefone, cpf);
            TelefoneModel.createProfissionais(t, con);
            
        }
        else{
            System.out.println("Insira o codigo do Paciente");
            int codp = input.nextInt();
            input.nextLine(); //buffer
            System.out.println("Informe o Telefone ");
            String telefone = input.nextLine();
            Telefone t = new Telefone(telefone, codp);
            TelefoneModel.createPaciente(t, con);
            
        }

    
    }
    
    public void listarTelefoneProfissionais(Connection con) throws SQLException {
        HashSet all = TelefoneModel.listAllProfissionais(con);
        Iterator<Telefone> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    public void listarTelefonePaciente(Connection con) throws SQLException {
        HashSet all = TelefoneModel.listAllPacientes(con);
        Iterator<Telefone> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    
}
