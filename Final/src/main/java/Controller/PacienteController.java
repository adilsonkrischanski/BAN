/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author krischanski
 */
import Dados.*;
import Model.*;
import Conexao.*;
import Dados.Paciente;
import Model.EmailModel;
import Dados.Email;
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




public class PacienteController {
    
    public void create(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para a cadastrar um novo paciente: ");
        System.out.print("Nome: ");
        String nome = input.nextLine().toUpperCase();
        
        System.out.print("CPF: ");
        long cpf = input.nextLong();
        input.nextLine();
        
        int codp = PacienteModel.maxCodp(con)+1;
        
        System.out.print("Data de Nascimento (DD/MM/AAAA): "); 
        String dataNascimento = input.nextLine();
        
        System.out.print("Tipo Sanguineo (O+, O-, A+, A-, B+, B-, AB+,AB-): ");
        String tipoSanguineo = input.nextLine().toUpperCase();
        
        System.out.print("Endereco (Rua nº, bairro, cidade): ");
        String endereco = input.nextLine().toUpperCase();
        
        Paciente pc = new Paciente(codp, cpf, nome, dataNascimento,endereco,tipoSanguineo);
        PacienteModel.create(pc, con);
        
        System.out.print("Telefone: ");
        String telefone = input.nextLine();
        Telefone t = new Telefone(telefone ,codp);
        TelefoneModel.createPaciente(t, con);
        
        System.out.println("Deseja informa Telefone para recado ? (S/N) ");
        char check = input.nextLine().toUpperCase().charAt(0);
       
        
     
        
        if(check =='S'){
            System.out.print("Informe o Telefone: ");
            String telefone2 = input.nextLine();
            t.setTelefone(telefone2);
            TelefoneModel.createPaciente(t, con);
        }
        
        System.out.println("Deseja Cadastrar um Email?");
        char checkemail = input.nextLine().toUpperCase().charAt(0);
        
        String email  = new String();       
        if(checkemail =='S'){
           System.out.print("Informe o email: ");
           email = input.nextLine().toUpperCase();
           Email e = new Email(email,codp );
           EmailModel.createPaciente(e, con);
        }
      
        
        System.out.println("Paciente cadastrado com sucesso!!");
    }

    public void listarPaciente(Connection con) throws SQLException {
        PacienteModel.listAll(con);

    }
    
    public void FindPaciente(Connection con, String nome) throws SQLException {
        Paciente p  = PacienteModel.AcharPaciente(con, nome);
        System.out.println(p.toString());
    }
}
