import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaPedidos sistema = new SistemaPedidos();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Incluir Pedido");
            System.out.println("2 - Excluir Pedido");
            System.out.println("3 - Listar Pedidos");
            System.out.println("4 - Incluir Item");
            System.out.println("5 - Excluir Item");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> sistema.incluirPedido(scanner);
                case 2 -> sistema.excluirPedido(scanner);
                case 3 -> sistema.listarPedidos();
                case 4 -> sistema.incluirItem(scanner);
                case 5 -> sistema.excluirItem(scanner);
                case 6 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 6);

        scanner.close();
    }
}