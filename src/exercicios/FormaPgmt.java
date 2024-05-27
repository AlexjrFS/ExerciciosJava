package exercicios;
import java.util.Scanner;
public class FormaPgmt {
    final static double VALORPRODUTO = 2599.99;
    public static void main(String[] args){
        Scanner formaPgmt = new Scanner(System.in);
            System.out.println("Escolha uma forma de pagamento:");
            System.out.println("1. Dinheiro ou Pix.");
            System.out.println("2. Cartão de débito.");
            System.out.println("3. Cartão de crédito à vista.");
            System.out.println("4. Cartão de crédito em duas vezes.");
            System.out.println("5. Cartão de crédito em três ou mais vezes.");
            System.out.println("6. Sair.");
            System.out.print("Digite sua escolha:");
            int formaEscolhida = formaPgmt.nextInt();
            formaPgmt.close();
            switch(formaEscolhida){
                case 1:dinheiroPix();break;
                case 2:cartaoDebito();break;
                case 3:cartaoCreditoaVista();break;
                case 4:cartaoCreditoDuasVezes();break;
                case 5:cartaoCreditoTresOuMais();break;
                case 6:System.out.println("Saindo do programa...");break;
                default:System.out.println("Escolha uma forma de pagamento válida!");break;
            }
        }
    static void dinheiroPix(){
        double valorFinal = VALORPRODUTO - (VALORPRODUTO * 0.15);
        System.out.printf("O valor total a ser pago por esse produto é de %.2f%n", valorFinal);
    }
    static void cartaoDebito(){
        double valorFinal = VALORPRODUTO - (VALORPRODUTO * 0.12);
        System.out.printf("O valor total a ser pago por esse produto é de %.2f%n", valorFinal);
    }
    static void cartaoCreditoaVista(){
        double valorFinal = VALORPRODUTO - (VALORPRODUTO * 0.10);
        System.out.printf("O valor total a ser pago por esse produto é de %.2f%n", valorFinal);
    }
    static void cartaoCreditoDuasVezes(){
        double valorFinal = VALORPRODUTO;
        double valorParcelado = valorFinal/2;
        System.out.printf("O valor total a ser pago por esse produto é de %.2f\nFicando assim 2x de: %.2f", valorFinal, valorParcelado);
    }
    static void cartaoCreditoTresOuMais(){
        double valorFinal = VALORPRODUTO + (VALORPRODUTO * 0.10);
        double valorParcelado = valorFinal/3;
        System.out.printf("O valor total a ser pago por esse produto é de %.2f\nFicando assim 3x de: %.2f", valorFinal, valorParcelado);
    }
    public static int nextInt() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nextInt'");
    }
}
