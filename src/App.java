import model.Cliente;
import model.ClientePremium;
import model.ClienteRegular;
import model.Jogo;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Cliente> clientes = new ArrayList<>();
        ArrayList<Jogo> jogos = new ArrayList<>();

        int opc;

        do {
            System.out.println("\n====== Menu Principal ======");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Jogo");
            System.out.println("3 - Editar Cliente");
            System.out.println("4 - Atualizar Saldo Cliente");
            System.out.println("5 - Deletar Cliente");
            System.out.println("6 - Listar Clientes");
            System.out.println("7 - Editar Jogo");
            System.out.println("8 - Atualizar Status do Jogo");
            System.out.println("9 - Deletar Jogo");
            System.out.println("10 - Listar Jogos");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {

                // ========================
                // CLIENTES
                // ========================
                case 1 -> {
                    System.out.println("\n=== CADASTRAR CLIENTE ===");

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Saldo: ");
                    double saldo = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Tipo de Cliente");
                    System.out.println("1 - Regular");
                    System.out.println("2 - Premium");
                    System.out.print("Escolha: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    Cliente novoCliente;

                    if (tipo == 1) {
                        novoCliente = new ClienteRegular(nome, email, saldo);
                    } else if (tipo == 2) {
                        novoCliente = new ClientePremium(nome, email, saldo);
                    } else {
                        System.out.println("Tipo inválido!");
                        break;
                    }

                    clientes.add(novoCliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                }


                case 3 -> {
                    System.out.print("ID do cliente para editar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Cliente cli = buscarClientePorId(clientes, id);

                    if (cli == null) {
                        System.out.println("Cliente não encontrado!");
                        break;
                    }

                    System.out.print("Novo nome (enter para manter): ");
                    String novoNome = sc.nextLine();
                    if (!novoNome.isBlank()) cli.setNome(novoNome);

                    System.out.print("Novo email (enter para manter): ");
                    String novoEmail = sc.nextLine();
                    if (!novoEmail.isBlank()) cli.setEmail(novoEmail);

                    System.out.println("Cliente atualizado!");
                }


                case 4 -> {
                    System.out.print("ID do cliente para atualizar saldo: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Cliente cli = buscarClientePorId(clientes, id);

                    if (cli == null) {
                        System.out.println("Cliente não encontrado!");
                        break;
                    }

                    System.out.print("Valor para adicionar: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();

                    cli.adicionarSaldo(valor);
                    System.out.println("Saldo atualizado!");
                }


                case 5 -> {
                    System.out.print("ID do cliente para deletar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Cliente cli = buscarClientePorId(clientes, id);

                    if (cli == null) {
                        System.out.println("Cliente não encontrado!");
                        break;
                    }

                    clientes.remove(cli);
                    System.out.println("Cliente removido!");
                }


                case 6 -> {
                    System.out.println("\n--- Lista de Clientes ---");
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        for (Cliente c : clientes) System.out.println(c);
                    }
                }


                case 2 -> {
                    System.out.println("\n=== CADASTRAR JOGO ===");

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Gênero: ");
                    String genero = sc.nextLine();

                    System.out.print("Ano de lançamento: ");
                    int ano = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Disponível (s/n): ");
                    boolean disponivel = sc.nextLine().equalsIgnoreCase("s");

                    Jogo jogo = new Jogo(titulo, genero, ano, preco, disponivel);
                    jogos.add(jogo);

                    System.out.println("Jogo cadastrado!");
                }


                case 7 -> {
                    System.out.print("ID do jogo para editar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Jogo jogo = buscarJogoPorId(jogos, id);

                    if (jogo == null) {
                        System.out.println("Jogo não encontrado!");
                        break;
                    }

                    System.out.print("Novo título (enter para manter): ");
                    String nt = sc.nextLine();
                    if (!nt.isBlank()) jogo.setTitulo(nt);

                    System.out.print("Novo gênero (enter para manter): ");
                    String ng = sc.nextLine();
                    if (!ng.isBlank()) jogo.setGenero(ng);

                    System.out.print("Novo ano (0 para manter): ");
                    int ano = sc.nextInt();
                    sc.nextLine();
                    if (ano != 0) jogo.setAnoLancamento(ano);

                    System.out.print("Novo preço (-1 para manter): ");
                    double preco = sc.nextDouble();
                    sc.nextLine();
                    if (preco >= 0) jogo.setPreco(preco);

                    System.out.println("Jogo atualizado!");
                }


                case 8 -> {
                    System.out.print("ID do jogo: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Jogo jogo = buscarJogoPorId(jogos, id);

                    if (jogo == null) {
                        System.out.println("Jogo não encontrado!");
                        break;
                    }

                    System.out.println("Status atual: " + (jogo.isDisponivel() ? "Disponível" : "Indisponível"));
                    System.out.print("Marcar como disponível? (s/n): ");
                    boolean disp = sc.nextLine().equalsIgnoreCase("s");

                    jogo.setDisponivel(disp);
                    System.out.println("Status atualizado!");
                }


                case 9 -> {
                    System.out.print("ID do jogo para deletar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Jogo jogo = buscarJogoPorId(jogos, id);

                    if (jogo == null) {
                        System.out.println("Jogo não encontrado!");
                        break;
                    }

                    jogos.remove(jogo);
                    System.out.println("Jogo removido!");
                }


                case 10 -> {
                    System.out.println("\n--- Lista de Jogos ---");
                    if (jogos.isEmpty()) {
                        System.out.println("Nenhum jogo cadastrado.");
                    } else {
                        for (Jogo j : jogos) System.out.println(j);
                    }
                }


                case 0 -> System.out.println("Sistema encerrado!");

                default -> System.out.println("Opção inválida!");
            }

        } while (opc != 0);

        sc.close();
    }



    private static Cliente buscarClientePorId(List<Cliente> lista, int id) {
        for (Cliente c : lista)
            if (c.getId() == id) return c;
        return null;
    }

    private static Jogo buscarJogoPorId(List<Jogo> lista, int id) {
        for (Jogo j : lista)
            if (j.getId() == id) return j;
        return null;
    }
}
