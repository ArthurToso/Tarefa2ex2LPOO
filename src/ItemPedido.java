public class ItemPedido {
    private String nome;
    private double preco;
    private int quantidade;

    public ItemPedido(String nome, double preco, int quantidade){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome nao pode ser vazio nem nulo");
        }
        if(preco < 0){
            throw new IllegalArgumentException("O preco nao pode ser negativo");
        }
        if(quantidade <=0){
            throw new IllegalArgumentException("Quantidade deve ser maior q zero");
        }
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome nao pode ser vazio nem nulo");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(preco < 0){
            throw new IllegalArgumentException("O preco nao pode ser negativo");
        }
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade <=0){
            throw new IllegalArgumentException("Quantidade deve ser maior q zero");
        }
        this.quantidade = quantidade;
    }

    public double getTotalItem(){
        return preco * quantidade;
    }

    @Override
    public String toString() {
        return String.format("%s | Preço: %.2f | Quantidade: %d", nome, preco, quantidade);
    }
}
