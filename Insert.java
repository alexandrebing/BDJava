package BDJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {
    Scanner in = new Scanner(System.in);
    String sqlCmd;

    public void run() throws SQLException {
        boolean running = true;
        while (running){
            System.out.println("Ecolha a tabela onde você gostaria de inserir dados:\n 1 - Agendamentos | 2 - Pacientes | 3- Medicos | 4 - Funcionarios | 5 - Sair");
            String opt = in.next();
            switch (opt){
                case "1":
                    running = false;
                    agendamentos();
                    break;
                case "2":
                    running  =false;
                    inserePaciente();
                    break;
                case "3":
                    running = false;
                    insereMedico();
                    break;
                case "4":
                    running = false;
                    insereFuncionario();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }

    private void agendamentos() throws SQLException {
        insereAgendamento();
        System.out.println("1 - Novo Exame | 2 - Nova consulta");
        boolean running = true;
        while (running){
            String opt = in.next();
            switch (opt) {
                case "1":
                    running = false;
                    exame();
                    break;
                case "2":
                    running = false;
                    insereConsulta();
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }

    }

    private void exame() throws SQLException {
        insereExame();
        insereDescricao();
    }

    private void inserePaciente() throws SQLException {
        Connection conexao = DriverManager.getConnection(
                "jdbc:oracle:thin:@//camburi.pucrs.br:1521/facin11g",
                "bg180107", "bg180107");

        sqlCmd = "insert into Paciente values (?, ?, ?, ?)";
                            //COD_PACIENTE, NOME, EMAIL, SEXO
        PreparedStatement stmt = conexao.prepareStatement(sqlCmd);

        System.out.println("Codigo do Paciente:");
        stmt.setInt(1, in.nextInt());
        System.out.println("Nome do Paciente:");
        stmt.setString(2, in.nextLine());
        System.out.println("Email do Paciente:");
        stmt.setString(3, in.nextLine());
        System.out.println("Sexo do Paciente:");
        stmt.setString(4, in.nextLine());

        stmt.execute();

        conexao.close();
    }

    private void insereExame() throws SQLException{
        Connection conexao = DriverManager.getConnection(
                "jdbc:oracle:thin:@//camburi.pucrs.br:1521/facin11g",
                "bg180107", "bg180107");

        sqlCmd = "insert into exame values (?, ?, ?, ?, ?, ?, ?, ?)";
        //COD_EXAME, COD_CONSULTA, COD_FUNCIONARIO, DATA_HORA_INICIAL, DATA_HORA_FINAL, OBSERVACOES, DATA_HORA_INCLUSAO, _COD_DESCRICAO
        PreparedStatement stmt = conexao.prepareStatement(sqlCmd);

        System.out.println("Codigo do Exame:");
        stmt.setInt(1, in.nextInt());
        System.out.println("Codigo da Consulta:");
        stmt.setInt(2, in.nextInt());
        System.out.println("Codigo do funcionario que realizou o exame");
        stmt.setInt(3, in.nextInt());
        System.out.println("Data inicial");
        stmt.setString(4, in.nextLine());
        System.out.println("Data final");
        stmt.setString(5,in.nextLine());
        System.out.println("Observações");
        stmt.setString(6, in.nextLine());
        System.out.println("Hora da incluão no sistema");
        stmt.setString(7, in.nextLine());
        System.out.println("Código de descrição");
        stmt.setInt(8, in.nextInt());

        stmt.execute();

        conexao.close();
    }

    private void insereDescricao() throws SQLException {
        Connection conexao = DriverManager.getConnection(
                "jdbc:oracle:thin:@//camburi.pucrs.br:1521/facin11g",
                "bg180107", "bg180107");

        sqlCmd = "insert into descricao_exame values (?, ?)";
        //COD_DESCRICAO, DESCRICAO
        PreparedStatement stmt = conexao.prepareStatement(sqlCmd);

        System.out.println("Codigo de Descrição:");
        stmt.setInt(1, in.nextInt());
        System.out.println("Descrição do exame:");
        stmt.setString(2, in.nextLine());

        stmt.execute();

        conexao.close();

    }

    private void insereAgendamento() throws SQLException{
        Connection conexao = DriverManager.getConnection(
                "jdbc:oracle:thin:@//camburi.pucrs.br:1521/facin11g",
                "bg180107", "bg180107");

        sqlCmd = "insert into agendamento values (?, ?, ?, ?, ?, ?, ?, ?)";
        //COD_AGENDAMENTP, COD_MEDICO, COD_PACIENTE, COD_FUNCIONARIO, DATA_HORA_AGENDAMENTO, SITUACAO, OBSERVACOES, DATA_HORA_INCLUSAO)
        PreparedStatement stmt = conexao.prepareStatement(sqlCmd);

        System.out.println("Codigo do Agendamento:");
        stmt.setInt(1, in.nextInt());
        System.out.println("Codigo do Médico:");
        stmt.setInt(2, in.nextInt());
        System.out.println("Codigo do Paciente");
        stmt.setInt(3, in.nextInt());
        System.out.println("Código do Funcionário");
        stmt.setInt(4, in.nextInt());
        System.out.println("Data e hora do Agendamento");
        stmt.setString(5,in.nextLine());
        System.out.println("Situação");
        stmt.setString(6, in.nextLine());
        System.out.println("Observações");
        stmt.setString(7, in.nextLine());
        System.out.println("Data e hora de inclusão");
        stmt.setInt(8, in.nextInt());

        stmt.execute();

        conexao.close();
    }

    private void insereConsulta() throws SQLException{

        Connection conexao = DriverManager.getConnection(
                "jdbc:oracle:thin:@//camburi.pucrs.br:1521/facin11g",
                "bg180107", "bg180107");

        sqlCmd = "insert into consultas values (?, ?, ?, ?, ?, ?, ?, ?)";
        //COD_EXAME, COD_CONSULTA, COD_FUNCIONARIO, DATA_HORA_INICIAL, DATA_HORA_FINAL, OBSERVACOES, DATA_HORA_INCLUSAO, _COD_DESCRICAO
        PreparedStatement stmt = conexao.prepareStatement(sqlCmd);

        System.out.println("Codigo da Consulta:");
        stmt.setInt(1, in.nextInt());
        System.out.println("Codigo do Agendamento:");
        stmt.setInt(2, in.nextInt());
        System.out.println("Código do Paciente");
        stmt.setInt(3,in.nextInt());
        System.out.println("Codigo do médico que realizou a consulta");
        stmt.setInt(4, in.nextInt());
        System.out.println("Data e hora inicial");
        stmt.setString(5, in.nextLine());
        System.out.println("Data e hora final");
        stmt.setString(6,in.nextLine());
        System.out.println("Prontuário");
        stmt.setString(7, in.nextLine());
        System.out.println("Hora da incluão no sistema");
        stmt.setString(8, in.nextLine());

        stmt.execute();

        conexao.close();

    }

    private void insereFuncionario() throws SQLException{
        Connection conexao = DriverManager.getConnection(
                "jdbc:oracle:thin:@//camburi.pucrs.br:1521/facin11g",
                "bg180107", "bg180107");

        sqlCmd = "insert into funcionario values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //COD_
        PreparedStatement stmt = conexao.prepareStatement(sqlCmd);

        System.out.println("Codigo do Funcionario:");
        stmt.setInt(1, in.nextInt());
        System.out.println("Nome Completo");
        stmt.setString(2, in.nextLine());
        System.out.println("Apelido");
        stmt.setString(3, in.nextLine());
        System.out.println("Endereço Completo");
        stmt.setString(7,in.nextLine());
        System.out.println("Sexo");
        stmt.setString(13, in.nextLine());
        System.out.println("Numero da CLT");
        stmt.setString(16, in.nextLine());
        System.out.println("Data de admissao");
        stmt.setString(17, in.nextLine());
        System.out.println("Cargo ou função");
        stmt.setString(18, in.nextLine());
        System.out.println("Data de nascimento");
        stmt.setString(19, in.nextLine());
        System.out.println("Ativo?");
        stmt.setString(21, in.nextLine());

        stmt.execute();

        conexao.close();
    }

    private void insereMedico() throws SQLException{
        Connection conexao = DriverManager.getConnection(
                "jdbc:oracle:thin:@//camburi.pucrs.br:1521/facin11g",
                "bg180107", "bg180107");

        sqlCmd = "insert into medico values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //COD_
        PreparedStatement stmt = conexao.prepareStatement(sqlCmd);

        System.out.println("Codigo do Medico:");
        stmt.setInt(1, in.nextInt());
        System.out.println("Numero CRM");
        stmt.setString(2, in.nextLine());
        System.out.println("Unidade Federativa CRM");
        stmt.setString(3, in.nextLine());
        System.out.println("Nome Completo");
        stmt.setString(4, in.nextLine());
        System.out.println("Endereço Completo");
        stmt.setString(9,in.nextLine());
        System.out.println("CEP");
        stmt.setString(10, in.nextLine());
        System.out.println("Numero do RG");
        stmt.setInt(12, in.nextInt());
        System.out.println("Data de nascimento");
        stmt.setString(14, in.nextLine());
        System.out.println("Sexo");
        stmt.setString(15, in.nextLine());
        System.out.println("Ativo?");
        stmt.setString(16, in.nextLine());
        System.out.println("Número de telefone celular");
        stmt.setString(19, in.nextLine());
        System.out.println("Data de admissao");
        stmt.setString(21, in.nextLine());

        stmt.execute();

        conexao.close();

    }
}

