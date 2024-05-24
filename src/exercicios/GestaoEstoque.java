package exercicios;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
class Estoque{
    private String nome;
    private double preco;
    private int qntdInicial;
    private int prodId;
    private static int nextId = 1;
    public Estoque(String nome, double preco, int qntdInicial){
        this.nome = nome;
        this.preco = preco;
        this.qntdInicial = qntdInicial;
        this.prodId = nextId++;
    }
    public String getNome(){
        return nome;
    }
    public int getProdId(){
        return prodId;
    }
    public double getPreco(){
        return preco;
    }
    public int getQntdInicial(){
        return qntdInicial;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public double setPreco(double preco){
        return this.preco = preco;
    }
    public void setQntdInicial(int qntdInicial){
        this.qntdInicial = qntdInicial;
    }
    public void displayProduto(){
        System.out.println("Código: " + prodId + " | Produto: " + nome + " | Preço R$ " + preco + " | Quantidade no estoque: " + qntdInicial);
    }
}
public class GestaoEstoque{
    private static ArrayList<Estoque> estoque = new ArrayList<>();
    public static void main(String[] args){
        try{
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int opcao;
        do{
            System.out.println("\nEstoque:");
            System.out.println("1. Adicionar novo produto ao estoque");
            System.out.println("2. Atualizar preço do produto");
            System.out.println("3. Visualizar estoque");
            System.out.println("4. Atualizar quantidade do produto no estoque");
            System.out.println("5. Vender produto");
            System.out.println("6. Deletar produto");
            System.out.println("7. Sair");
            System.out.print("Selecione uma das opções do sistema: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch(opcao){
                case 1:adicionarNovoProduto(scanner);break;
                case 2:atualizarPrecoProduto(scanner);break;
                case 3:listaDeEstoque();break;
                case 4:atualizarQntdEstoque(scanner);break;
                case 5:venderProduto(scanner);break;
                case 6:deletarProduto(scanner);break;
                case 7:System.out.println("Saindo do sistema, até mais!");break;
                default:System.out.println("Opção inválida!");
            }
        } while(opcao != 7);
        scanner.close();
    }
    catch(InputMismatchException e){
        System.err.println("Escolha uma das opções acima, apartir de seu numero!");
    }
    }
    private static void adicionarNovoProduto(Scanner scanner){
        System.out.print("Insira o nome deste produto: ");
        String nome = scanner.nextLine();
        System.out.print("Insira o preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Insira a quantidade inicial deste produto no estoque: ");
        int qntdInicial = scanner.nextInt();
        Estoque novoProduto = new Estoque(nome, preco, qntdInicial);
        estoque.add(novoProduto);
        System.out.println("Produto de código " + novoProduto.getProdId() + " adicionado com sucesso!");
    }
    private static void deletarProduto(Scanner scanner){
        System.out.println("Insira o código do produto no qual deseja deletar:");
        int codProd = scanner.nextInt();
        for(int i =0; i < estoque.size(); i++){
            Estoque produto = estoque.get(i);
            if(produto.getProdId() == codProd){
                estoque.remove(i);
                System.out.println("Produto " + produto.getNome() + " removido com sucesso!");
            }
        }
    }
    private static void venderProduto(Scanner scanner){
        System.out.print("Envie o código do produto que foi vendido: ");
        int codProd = scanner.nextInt();
        scanner.nextLine();
        Estoque produtoVendido = null;
        for(Estoque produto : estoque){
            if(produto.getProdId() == codProd){
                produtoVendido = produto;
                break;
            }
        }
        if(produtoVendido != null) {
            System.out.print("Quantidade vendida: ");
            int qntdVendida = scanner.nextInt();
            if(qntdVendida <= produtoVendido.getQntdInicial()){
                produtoVendido.setQntdInicial(produtoVendido.getQntdInicial() - qntdVendida);
               double valorVenda =  produtoVendido.setPreco(produtoVendido.getPreco() * qntdVendida);
                System.out.println("Venda registrada com sucesso, no valor total de R$" + valorVenda);
            } 
            else{
                System.out.println("Não há quantidade suficiente em estoque para esta venda.");
            }
        } 
        else{
            System.out.println("Produto não encontrado.");
        }
    }
    private static void atualizarPrecoProduto(Scanner scanner){
        System.out.print("Insira o código do produto para atualizar: ");
        int prodId = scanner.nextInt();
        scanner.nextLine();
        for(Estoque produto : estoque){
            if(produto.getProdId() == prodId){
                System.out.print("Novo preço do produto: ");
                double novoPreco = scanner.nextDouble();
                produto.setPreco(novoPreco);
                System.out.println("Preço do produto atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }
    private static void atualizarQntdEstoque(Scanner scanner){
        System.out.print("Insira o código do produto para atualizar: ");
        int prodId = scanner.nextInt();
        scanner.nextLine();
        for(Estoque produto : estoque){
            if(produto.getProdId() == prodId){
                System.out.print("Quantidade adicionada ao estoque: ");
                int qntdAdd = scanner.nextInt();
                produto.setQntdInicial(produto.getQntdInicial() + qntdAdd);
                System.out.println("Quantidade atualizada com sucesso!, foram adicionados " + qntdAdd);
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }
    private static void listaDeEstoque(){
        if(estoque.isEmpty()){
            System.out.println("Não há produtos no estoque.");
        } 
        else{
            System.out.println("Lista de Produtos no Estoque:");
            for(Estoque produto : estoque) {
                produto.displayProduto();
            }
        }
    }
}
