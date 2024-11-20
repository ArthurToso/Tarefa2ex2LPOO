import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaPedidos {
    private List<Pedido> pedidos;

    public SistemaPedidos(){
        this.pedidos = new ArrayList<>();
    }

    public void incluirPedido(Scanner scanner){
        System.out.println("Nome do Cliente: ");
        String cliente = scanner.nextLine();

        System.out.println("Limite do pedido: ");
        double limite = scanner.nextDouble();

        Pedido pedido = new Pedido(cliente, limite);
        pedidos.add(pedido);
        System.out.println("Pedido criado!");
    }

    public void excluirPedido(Scanner scanner){
        System.out.println("Nome do Cliente: ");
        String cliente = scanner.nextLine();

        pedidos.removeIf(p -> p.getCliente().equalsIgnoreCase(cliente));
        System.out.println("Pedido removido com sucesso");
    }

    public void listarPedidos(){
        for(Pedido pedido : pedidos){
            System.out.println(pedido);
        }
    }

    public void incluirItem(Scanner scanner){
        System.out.println("Nome do Cliente: ");
        String cliente = scanner.nextLine();

        Pedido pedido = pedidos.stream().filter(p -> p.getCliente().equalsIgnoreCase(cliente)).findFirst().orElseThrow(() -> new RuntimeException("Pedido nao encontrado"));
        System.out.println("Nome do Item: ");
        String nomeItem = scanner.nextLine();
        System.out.println("Preco do item: ");
        double preco = scanner.nextDouble();
        System.out.println("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        ItemPedido item = new ItemPedido(nomeItem, preco, quantidade);
        pedido.addItem(item);
        System.out.println("item adicionado com sucesso");
    }

    public void excluirItem(Scanner scanner){
        System.out.println("Nome do Cliente: ");
        String cliente = scanner.nextLine();

        Pedido pedido = pedidos.stream().filter(p -> p.getCliente().equalsIgnoreCase(cliente)).findFirst().orElseThrow(() -> new RuntimeException("Pedido nao encontrado"));

        System.out.println("Nome do Item: ");
        String nomeItem = scanner.nextLine();

        pedido.retiraItem(nomeItem);
        System.out.println("Item removido com sucesso");
    }

}
