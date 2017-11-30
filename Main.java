package BDJava;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Consultas consultas = new Consultas();
        Insert insert = new Insert();
        Scanner in = new Scanner(System.in);
        String opt;

        while (true){
            System.out.println("Escolha o que você quer fazer:\n 1- Consultar tabelas | 2 - Inserir dados | 3 - Encerrar");
            opt = in.next();
            switch (opt){
                case "1":
                    consultas.run();
                    break;
                case "2":
                    insert.run();
                    break;
                case "3":
                    System.out.println("Execução do programa encerrada.");
                    System.exit(0);
                    break;
                default:

                        System.out.println("Opção inválida");

            }
        }
    }

}
