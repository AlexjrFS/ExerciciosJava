package exercicios;
import java.util.ArrayList;
import java.util.List;
class Carrinho {
    private List<ItemCarrinho> itens;
    public Carrinho(){
        this.itens = new ArrayList<>();
    }
    public void adicionarItem(Estoque produto, int quantidade){
        for (ItemCarrinho item : itens){
            if (item.getProduto().getProdId() == produto.getProdId()){
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }
        itens.add(new ItemCarrinho(produto, quantidade));
    }
    public void mostrarCarrinho(){
        if (itens.isEmpty()){
            System.out.println("O carrinho está vazio.");
        } 
        else{
            System.out.println("Itens no carrinho:");
            for (ItemCarrinho item : itens){
                System.out.println("Produto: " + item.getProduto().getNome() + " | Quantidade: " + item.getQuantidade() + " | Preço Unitário: R$ " + item.getProduto().getPreco() + " | Total: R$ " + item.getQuantidade() * item.getProduto().getPreco());
            }
        }
    }
    public double calcularTotal(){
        double total = 0;
        for(ItemCarrinho item : itens){
            total += item.getQuantidade() * item.getProduto().getPreco();
        }
        return total;
    }
    public List<ItemCarrinho> getItens(){
        return itens;
    }
    public void esvaziarCarrinho(){
        itens.clear();
    }
}
class ItemCarrinho{
    private Estoque produto;
    private int quantidade;
    public ItemCarrinho(Estoque produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public Estoque getProduto(){
        return produto;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
}
