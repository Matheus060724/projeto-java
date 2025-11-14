import model.Cliente;
import model.ClientePremium;
import model.ClienteRegular;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();

        int opc;
        do{
            System.out.println("\n====== Menu ======");
            System.out.println("\n1- Cadastrar cliente");
            System.out.println("\n2- listar clientes");
            System.out.println("\n0- Sair");

            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> {
                    System.out.println("\n====== Cadastrar Cliente ======");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Saldo: ");
                    Double saldo = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Tipo de clinte: ");
                    System.out.println("1- Regular");
                    System.out.println("2- Premium");
                    System.out.println("Escolha: ");

                    int tipo = sc.nextInt();
                    sc.nextLine();

                    Cliente novoCliente;

                    if(tipo == 1) {
                        novoCliente = new ClienteRegular(nome, email, saldo);
                    } else if (tipo == 2) {
                        novoCliente = new ClientePremium(nome, email, saldo);
                    } else {
                        System.out.println("Opção invalida !!");
                        break;
                    }

                    clientes.add(novoCliente);
                    System.out.println("Cliente cadastrado!");
                }

                case 2 -> {
                    System.out.println("\n--- Lista de cliente ---");

                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado");
                    } else {
                        for (Cliente c : clientes) {
                            System.out.println(c);
                        }
                    }
                }

                case 0 -> {
                    System.out.println("Encerrado!!");
                }

                default -> {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            }
        }while(opc != 0);
        
        sc.close();
    }
}