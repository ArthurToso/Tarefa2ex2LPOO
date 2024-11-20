import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String cliente;
    private double limiteTotal;
    private List<ItemPedido> itens;

    public Pedido(String cliente, double limiteTotal){
        if(cliente == null || cliente.trim().isEmpty()){
            throw new IllegalArgumentException("nome nao pode ser nulo ou vazio");
        }
        if(limiteTotal <= 0){
            throw new IllegalArgumentException("Valor total deve ser maior que zero");
        }
        this.cliente = cliente;
        this.limiteTotal = limiteTotal;
        this.itens = new ArrayList<>();
    }

    public String getCliente(){
        return cliente;
    }

    public List<ItemPedido> getItens(){
        return itens;
    }

    public double getTotal(){
        return itens.stream().mapToDouble(ItemPedido::getTotalItem).sum();
    }

    public void addItem(ItemPedido item){
        if (item == null){
            throw new IllegalArgumentException("O item nao pode ser nulo");
        }
        double novoTotal = item.getTotalItem();
        if(novoTotal > limiteTotal){
            throw new RuntimeException("Item nao incluido, valor total excedido");
        }
        for(ItemPedido existente : itens){
            if(existente.getNome().equalsIgnoreCase(item.getNome())){
                existente.setQuantidade(existente.getQuantidade() + item.getQuantidade());
                return;
            }
        }
        itens.add(item);
    }

    public void retiraItem(String nome){
        boolean removido = itens.removeIf(item -> item.getNome().equalsIgnoreCase(nome));

        if (!removido) {
            throw new RuntimeException("Item não encontrado no pedido.");
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do Cliente: ").append(cliente).append("\n");
        sb.append("Total do Pedido: R$").append(String.format("%.2f", getTotal())).append("\n");
        for (ItemPedido item : itens){
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }

}

