package exercicios;
import java.util.*;
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
class Carrinho{
    private ArrayList<Estoque> itens = new ArrayList<>();
    private ArrayList<Integer> quantidades = new ArrayList<>();
    public void adicionarItem(Estoque produto, int quantidade){
        itens.add(produto);
        quantidades.add(quantidade);
    }
    public void mostrarCarrinho(){
        for(int i = 0; i < itens.size(); i++){
            Estoque produto = itens.get(i);
            int quantidade = quantidades.get(i);
            System.out.println("Produto: " + produto.getNome() + " | Quantidade: " + quantidade + " | Preço unitário: " + produto.getPreco() + " | Preço total: " + (produto.getPreco() * quantidade));
        }
    }
    public double calcularTotal(){
        double total = 0;
        for(int i = 0; i < itens.size(); i++){
            Estoque produto = itens.get(i);
            int quantidade = quantidades.get(i);
            total += produto.getPreco() * quantidade;
        }
        return total;
    }
    public void esvaziarCarrinho(){
        itens.clear();
        quantidades.clear();
    }
}
public class GestaoEstoque{
    private static ArrayList<Estoque> estoque = new ArrayList<>();
    private static Carrinho carrinho = new Carrinho();
    private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    public static void main(String[] args){
        try{
            int opcao;
            do{
                System.out.println("\nEstoque:");
                System.out.println("1. Adicionar novo produto ao estoque");
                System.out.println("2. Atualizar preço do produto");
                System.out.println("3. Visualizar estoque");
                System.out.println("4. Atualizar quantidade do produto no estoque");
                System.out.println("5. Adicionar / Visualizar itens do carrinho");
                System.out.println("6. Vender produto");
                System.out.println("7. Deletar produto");
                System.out.println("8. Sair");
                System.out.print("Selecione uma das opções do sistema: ");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch(opcao){
                    case 1:adicionarNovoProduto();break;
                    case 2:atualizarPrecoProduto();break;
                    case 3:listaDeEstoque();break;
                    case 4:atualizarQntdEstoque();break;
                    case 5:carrinhoProdutos();break;
                    case 6:venderProduto();break;
                    case 7:deletarProduto();break;
                    case 8:System.out.println("Saindo do sistema, até mais!");break;
                    default:System.out.println("Opção inválida!");
                }
            } 
            while (opcao != 8);
        } 
        catch(InputMismatchException e){
            System.err.println("Escolha uma das opções acima, a partir de seu número!");
        }
    }
    private static void adicionarNovoProduto(){
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
    private static void deletarProduto(){
        System.out.println("Insira o código do produto no qual deseja deletar:");
        int codProd = scanner.nextInt();
        for(int i = 0; i < estoque.size(); i++){
            Estoque produto = estoque.get(i);
            if(produto.getProdId() == codProd){
                estoque.remove(i);
                System.out.println("Produto " + produto.getNome() + " removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }
    private static void carrinhoProdutos(){
        System.out.println("1. Adicionar novo produto ao carrinho\n2. Visualizar itens no carrinho");
        int fazerCarrinho = scanner.nextInt();
        scanner.nextLine();
        if(fazerCarrinho == 1){
            System.out.println("Insira o código do produto para ser adicionado ao carrinho:");
            int codProd = scanner.nextInt();
            System.out.println("Insira a quantidade do produto para ser adicionado ao carrinho:");
            int quantidade = scanner.nextInt();
            scanner.nextLine();
            Estoque produtoSelecionado = null;
            for(Estoque produto : estoque){
                if(produto.getProdId() == codProd){
                    produtoSelecionado = produto;
                    break;
                }
            }
            if(produtoSelecionado != null){
                if(quantidade <= produtoSelecionado.getQntdInicial()){
                    carrinho.adicionarItem(produtoSelecionado, quantidade);
                    produtoSelecionado.setQntdInicial(produtoSelecionado.getQntdInicial() - quantidade);
                    System.out.println("Produto adicionado ao carrinho com sucesso!");
                    System.out.println("\nDeseja finalizar a compra?\n1. Finalizar compra\n2. Continuar comprando");
                    int respostas = scanner.nextInt();
                    if(respostas == 1){
                        double totalFinal = opcoesDePgmt();
                        System.out.println("Deseja confirmar sua compra?\n1. Sim\n2. Não");
                        int escolha = scanner.nextInt();
                        if(escolha == 1){
                        finalizarCompra(totalFinal);
                        }
                        else{
                            return;
                        }
                    } 
                    else if(respostas == 2){
                        return;
                    } 
                    else{
                        System.out.println("Insira uma das opções.");
                    }
                } 
                else{
                    System.out.println("Quantidade solicitada não disponível em estoque.");
                }
            } 
            else{
                System.out.println("Produto não encontrado.");
            }
        } 
        else{
            carrinho.mostrarCarrinho();
            System.out.println("Valor total: R$ " + carrinho.calcularTotal());
            System.out.println("\nDeseja finalizar a compra?\n1. Finalizar compra\n2. Continuar comprando");
            int respostas = scanner.nextInt();
            if(respostas == 1){
                double totalFinal = opcoesDePgmt();
                finalizarCompra(totalFinal);
            } 
            else if(respostas == 2){
                return;
            } 
            else{
                System.out.println("Insira uma das opções.");
            }
        }
    }
    private static void finalizarCompra(double total){
        if(total > 0){
            System.out.println("Compra realizada com sucesso, no valor de R$ " + total);
            carrinho.esvaziarCarrinho();
        } 
        else{
            System.out.println("Nenhum produto foi inserido no carrinho.");
        }
    }
    private static double opcoesDePgmt(){
        System.out.println("Escolha uma forma de pagamento:");
        System.out.println("1. Dinheiro ou Pix.");
        System.out.println("2. Cartão de débito.");
        System.out.println("3. Cartão de crédito à vista.");
        System.out.println("4. Cartão de crédito em duas vezes.");
        System.out.println("5. Cartão de crédito em três ou mais vezes.");
        System.out.print("Digite sua escolha:");
        int formaEscolhida = scanner.nextInt();
        double total = carrinho.calcularTotal();
        switch(formaEscolhida){
            case 1:return dinheiroPix(total);
            case 2:return cartaoDebito(total);
            case 3:return cartaoCreditoaVista(total);
            case 4:return cartaoCreditoDuasVezes(total);
            case 5:return cartaoCreditoTresOuMais(total);
            default:System.out.println("Escolha uma forma de pagamento válida!");
            return total;
        }
    }
    private static double dinheiroPix(double total){
        total = total - (total * 0.15);
        System.out.printf("O valor total a ser pago por esse produto é de %.2f\n", total);
        return total;
    }
    private static double cartaoDebito(double total){
        total = total - (total * 0.12);
        System.out.printf("O valor total a ser pago por esse produto é de %.2f\n", total);
        return total;
    }
    private static double cartaoCreditoaVista(double total){
        total = total - (total * 0.10);
        System.out.printf("O valor total a ser pago por esse produto é de %.2f\n", total);
        return total;
    }
    private static double cartaoCreditoDuasVezes(double total){
        double totalP = total / 2.0;
        System.out.printf("O valor total a ser pago por esse produto é de %.2f\nFicando assim 2x de: %.2f\n", total, totalP);
        return total;
    }
    private static double cartaoCreditoTresOuMais(double total){
        total = total + (total * 0.10);
        double totalP = total / 3.0;
        System.out.printf("O valor total a ser pago por esse produto é de %.2f\nFicando assim 3x de: %.2f\n", total, totalP);
        return total;
    }
    private static void venderProduto(){
        System.out.print("Insira o código do produto que deseja vender: ");
        int codProd = scanner.nextInt();
        scanner.nextLine();
        Estoque produtoVendido = null;
        for(Estoque produto : estoque){
            if(produto.getProdId() == codProd){
                produtoVendido = produto;
                break;
            }
        }
        if(produtoVendido != null){
            System.out.print("Insira a quantidade vendida: ");
            int qntdVendida = scanner.nextInt();
            if(qntdVendida <= produtoVendido.getQntdInicial()){
                produtoVendido.setQntdInicial(produtoVendido.getQntdInicial() - qntdVendida);
                double valorVenda = produtoVendido.getPreco() * qntdVendida;
                System.out.println("Venda registrada com sucesso, no valor total de R$ " + valorVenda);
            } 
            else{
                System.out.println("Quantidade solicitada não disponível em estoque.");
            }
        } 
        else{
            System.out.println("Produto não encontrado.");
        }
    }
    private static void atualizarPrecoProduto(){
        System.out.print("Envie o código do produto que deseja atualizar o preço: ");
        int codProd = scanner.nextInt();
        scanner.nextLine();
        Estoque produtoSelecionado = null;
        for(Estoque produto : estoque){
            if(produto.getProdId() == codProd){
                produtoSelecionado = produto;
                break;
            }
        }
        if(produtoSelecionado != null){
            System.out.print("Insira o novo preço do produto: ");
            double novoPreco = scanner.nextDouble();
            produtoSelecionado.setPreco(novoPreco);
            System.out.println("Preço do produto atualizado com sucesso!");
        } 
        else{
            System.out.println("Produto não encontrado.");
        }
    }
    private static void atualizarQntdEstoque(){
        System.out.print("Envie o código do produto que deseja atualizar a quantidade em estoque: ");
        int codProd = scanner.nextInt();
        scanner.nextLine();
        Estoque produtoSelecionado = null;
        for(Estoque produto : estoque){
            if(produto.getProdId() == codProd){
                produtoSelecionado = produto;
                break;
            }
        }
        if(produtoSelecionado != null){
            System.out.print("Insira a nova quantidade do produto em estoque: ");
            int novaQntd = scanner.nextInt();
            produtoSelecionado.setQntdInicial(novaQntd);
            System.out.println("Quantidade do produto em estoque atualizada com sucesso!");
        } 
        else{
            System.out.println("Produto não encontrado.");
        }
    }
    private static void listaDeEstoque(){
        for(Estoque produto : estoque){
            produto.displayProduto();
        }
    }
}
