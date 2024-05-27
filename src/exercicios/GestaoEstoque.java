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
public class GestaoEstoque{
    private static ArrayList<Estoque> estoque = new ArrayList<>();
    private static Carrinho carrinho = new Carrinho();
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
            System.out.println("5. Adicionar / Visualizar itens do carrinho");
            System.out.println("6. Vender produto");
            System.out.println("7. Deletar produto");
            System.out.println("8. Sair");
            System.out.print("Selecione uma das opções do sistema: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch(opcao){
                case 1:adicionarNovoProduto(scanner);break;
                case 2:atualizarPrecoProduto(scanner);break;
                case 3:listaDeEstoque();break;
                case 4:atualizarQntdEstoque(scanner);break;
                case 5:carrinhoProdutos(scanner);break;
                case 6:venderProduto(scanner);break;
                case 7:deletarProduto(scanner);break;
                case 8:System.out.println("Saindo do sistema, até mais!");break;
                default:System.out.println("Opção inválida!");
            }
        } while(opcao != 8);
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
        for(int i = 0; i < estoque.size(); i++){
            Estoque produto = estoque.get(i);
            if(produto.getProdId() == codProd){
                estoque.remove(i);
                System.out.println("Produto " + produto.getNome() + " removido com sucesso!");
            }
        }
    }
    private static void carrinhoProdutos(Scanner scanner){
        System.out.println("1. Adicionar novo produto ao carrinho\n2. Visualizar itens no carrinho");
        int fazerCarrinho = scanner.nextInt();
        if(fazerCarrinho == 1){
            System.out.println("Insira o código do produto para ser adicionado ao carrinho:");
            int codProd = scanner.nextInt();
            System.out.println("Insira a quantidade do produto para ser adicionado ao carrinho:");
            int quantidade = scanner.nextInt();
            scanner.nextLine();
            Estoque produtoSelecionado = null;
            for(Estoque produto : estoque){
                if (produto.getProdId() == codProd){
                    produtoSelecionado = produto;
                    break;
                }
            }
            if(produtoSelecionado != null){
                if(quantidade <= produtoSelecionado.getQntdInicial()){
                    carrinho.adicionarItem(produtoSelecionado, quantidade);
                    produtoSelecionado.setQntdInicial(produtoSelecionado.getQntdInicial() - quantidade);
                    System.out.println("Produto adicionado ao carrinho com sucesso!");                   
                    System.out.println("\nDeseja finalizar a compra?\n1. Finalizar compra\n2. Continar comprando");
                    int respostas = scanner.nextInt();
                    if(respostas == 1){
                        opcoesDePgmt();
                       //finalizarCompra();
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
            System.out.println("\nDeseja finalizar a compra?\n1. Finalizar compra\n2. Continar comprando");
            int respostas = scanner.nextInt();
            if(respostas == 1){
               finalizarCompra();
            }
            else if(respostas == 2){
                return;
            }
            else{
                System.out.println("Insira uma das opções.");
            }
        }
    }
    private static void finalizarCompra(){
        double total = carrinho.calcularTotal();
        if(total>0){
        System.out.println("Compra realizada com sucesso, no valor de R$ " + total);
        carrinho.esvaziarCarrinho();
        }
        else{
            System.out.println("Nenhum produto foi inserido no carrinho.");
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
        if(produtoVendido != null){
            System.out.print("Quantidade vendida: ");
            int qntdVendida = scanner.nextInt();
            if(qntdVendida <= produtoVendido.getQntdInicial()){
                produtoVendido.setQntdInicial(produtoVendido.getQntdInicial() - qntdVendida);
               double valorVenda =  produtoVendido.setPreco(produtoVendido.getPreco() * qntdVendida);
                System.out.println("Venda registrada com sucesso, no valor total de R$ " + valorVenda);
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
    private static void opcoesDePgmt(){
        Scanner formaPgmt = new Scanner(System.in);
            System.out.println("Escolha uma forma de pagamento:");
            System.out.println("1. Dinheiro ou Pix.");
            System.out.println("2. Cartão de débito.");
            System.out.println("3. Cartão de crédito à vista.");
            System.out.println("4. Cartão de crédito em duas vezes.");
            System.out.println("5. Cartão de crédito em três ou mais vezes.");
            System.out.print("Digite sua escolha:");
            int formaEscolhida = formaPgmt.nextInt();
            switch(formaEscolhida){
                case 1:dinheiroPix();break;
                case 2:cartaoDebito();break;
                case 3:cartaoCreditoaVista();break;
                case 4:cartaoCreditoDuasVezes();break;
                case 5:cartaoCreditoTresOuMais();break;
            default:System.out.println("Escolha uma forma de pagamento válida!");break;
            }
    }
    private static void dinheiroPix(){
        double total = carrinho.calcularTotal() - (carrinho.calcularTotal() * 0.15 );
        System.out.printf("O valor total a ser pago por esse produto é de %.2f\n", total);
        return;
    }
    private static void cartaoDebito(){
        double total = carrinho.calcularTotal() - (carrinho.calcularTotal() * 0.12 );
        System.out.printf("O valor total a ser pago por esse produto é de %.2f\n", total);
        return;
    }
    private static void cartaoCreditoaVista(){
        double total = carrinho.calcularTotal() - (carrinho.calcularTotal() * 0.10 );
        System.out.printf("O valor total a ser pago por esse produto é de %.2f\n", total);
        return;
    }
    private static void cartaoCreditoDuasVezes(){
        double total = carrinho.calcularTotal();
        double totalP = carrinho.calcularTotal() / 2.0;
        System.out.printf("O valor total a ser pago por esse produto é de %.2f\nFicando assim 2x de: %.2f\n", total, totalP);
        return;
    }
    private static void cartaoCreditoTresOuMais(){
        double total = carrinho.calcularTotal() + (carrinho.calcularTotal() * 0.10 );
        double totalP = carrinho.calcularTotal() / 3.0;
        System.out.printf("O valor total a ser pago por esse produto é de %.2f\nFicando assim 3x de: %.2f\n", total, totalP);
        return;
    }
}
