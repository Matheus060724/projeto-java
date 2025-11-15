import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciadorJogos {

    public static void cadastrarJogo(ArrayList<Jogo> jogos, Scanner sc) {
        try {
            System.out.println("\n=== CADASTRAR JOGO ===");

            System.out.print("ID do jogo: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Título: ");
            String titulo = sc.nextLine();

            System.out.print("Gênero: ");
            String genero = sc.nextLine();

            System.out.print("Ano de lançamento: ");
            int ano = sc.nextInt();

            System.out.print("Preço: ");
            double preco = sc.nextDouble();
            sc.nextLine();

            System.out.print("Disponível? (s/n): ");
            String dispStr = sc.nextLine();
            boolean disponivel = dispStr.equalsIgnoreCase("s");

      
            Jogo jogo = new Jogo(id, titulo, genero, ano, preco, disponivel);
            jogos.add(jogo);

            System.out.println("Jogo cadastrado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar jogo: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Tente novamente.");
            sc.nextLine();
        }
    }

    public static void editarJogo(ArrayList<Jogo> jogos, Scanner sc) {
        System.out.println("\n=== EDITAR JOGO ===");
        System.out.print("Informe o ID do jogo que deseja editar: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        Jogo jogo = buscarPorId(jogos, id);

        if (jogo == null) {
            System.out.println("Jogo não encontrado.");
            return;
        }

        try {
            System.out.println("Editando: " + jogo);

            System.out.print("Novo título (enter para manter o atual): ");
            String novoTitulo = sc.nextLine();
            if (!novoTitulo.isBlank()) {
                jogo.setTitulo(novoTitulo);
            }

            System.out.print("Novo gênero (enter para manter o atual): ");
            String novoGenero = sc.nextLine();
            if (!novoGenero.isBlank()) {
                jogo.setGenero(novoGenero);
            }

            System.out.print("Novo ano de lançamento (0 para manter o atual): ");
            int novoAno = sc.nextInt();
            sc.nextLine();
            if (novoAno != 0) {
                jogo.setAnoLancamento(novoAno);
            }

            System.out.print("Novo preço (-1 para manter o atual): ");
            double novoPreco = sc.nextDouble();
            sc.nextLine();
            if (novoPreco >= 0) {
                jogo.setPreco(novoPreco);
            }

            System.out.println("Jogo atualizado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao editar jogo: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Tente novamente.");
            sc.nextLine();
        }
    }

  
    public static void atualizarStatusJogo(ArrayList<Jogo> jogos, Scanner sc) {
        System.out.println("\n=== ATUALIZAR STATUS DO JOGO ===");
        System.out.print("Informe o ID do jogo: ");
        int id = sc.nextInt();
        sc.nextLine();

        Jogo jogo = buscarPorId(jogos, id);

        if (jogo == null) {
            System.out.println("Jogo não encontrado.");
            return;
        }

        System.out.println("Status atual: " + (jogo.isDisponivel() ? "Disponível" : "Indisponível"));
        System.out.print("Deseja marcar como disponível? (s/n): ");
        String resp = sc.nextLine();

        boolean novoStatus = resp.equalsIgnoreCase("s");
        jogo.setDisponivel(novoStatus);

        System.out.println("Status atualizado com sucesso!");
    }

   
    public static void deletarJogo(ArrayList<Jogo> jogos, Scanner sc) {
        System.out.println("\n=== DELETAR JOGO ===");
        System.out.print("Informe o ID do jogo: ");
        int id = sc.nextInt();
        sc.nextLine();

        Jogo jogo = buscarPorId(jogos, id);

        if (jogo == null) {
            System.out.println("Jogo não encontrado.");
            return;
        }

        jogos.remove(jogo);
        System.out.println("Jogo removido com sucesso!");
    }

  
    public static void listarJogos(ArrayList<Jogo> jogos) {
        System.out.println("\n=== LISTA DE JOGOS ===");

        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        for (Jogo j : jogos) {
            System.out.println(j);
        }
    }

    
    private static Jogo buscarPorId(ArrayList<Jogo> jogos, int id) {
        for (Jogo j : jogos) {
            if (j.getId() == id) {
                return j;
            }
        }
        return null;
    }
}
