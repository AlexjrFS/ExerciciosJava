package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class SalarioFinal {
    public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite o nome do vendedor:");
    String nome = scanner.nextLine();
    System.out.println("Insira o seu salario fixo: ");
    double salario = scanner.nextDouble();
    System.out.println("Insira o total de vendas realizadas no mês em valores: ");
    double vendas = scanner.nextDouble();
    double salarioGeral = (vendas*0.15) + salario;
    System.out.println("O vendedor " + nome);
    System.out.println("Com o salario fixo de R$ " + salario);
    System.out.println("Adicionando a comissão de vendas realiazadas por ele, o salario final é de R$ " + salarioGeral);
    scanner.close();

    }
}
