
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


public class PacienteController {
    
    public void createPaciente(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para a cadastrar um novo paciente: ");
        System.out.print("Nome: ");
        String nome = input.nextLine();
        
        System.out.println("Data de Nascimento DD-MM-AAAA"); 
        String dataNascimento = input.nextLine();
        
        System.out.println("Tipo Sanguineo (O+, O-, A+, A-, B+, B-, AB+,AB-)");
        String tipoSanguineo = input.nextLine();
        
        System.out.println("Endereco: Rua nº, bairro, cidade");
        String endereco = input.nextLine();
        
        System.out.println("Telefone ");
        String telefone = input.nextLine();
        
        System.out.println("Deseja informa Telefone para recado ? (S/N) ");
        char check = input.nextLine().toUpperCase().charAt(0);
        String telefone2 = new String();
        
        if(check =='S'){
            System.out.println("Informe o Telefone ");
            telefone2 = input.nextLine();
        }
        
        System.out.println("Deseja Informar um Email");
        
        
        
        System.out.println("CPF: ");
        long cpf = input.nextLong();
        
        
        
     
                
        AmbulatoriosBean ab = new AmbulatoriosBean(nroa, capacidade, andar);
        AmbulatoriosModel.create(ab, con);
        System.out.println("Ambulatório criado com sucesso!!");
    }

    void listarAmbulatorio(Connection con) throws SQLException {
        HashSet all = AmbulatoriosModel.listAll(con);
        Iterator<AmbulatoriosBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
