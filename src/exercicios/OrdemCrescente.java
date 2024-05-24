package exercicios;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
public class OrdemCrescente {
    public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner scanner = new Scanner(System.in);     
    System.out.println("Digite o primeiro valor:");
    int valor1 = scanner.nextInt();
    System.out.println("Digite o segundo valor:");
    int valor2 = scanner.nextInt();
    System.out.println("Digite o terceiro valor:");
    int valor3 = scanner.nextInt();
    int valores[] = {valor1, valor2, valor3};
    Arrays.sort(valores);//metodo para colocar os valores em ordem crescente
    System.out.println("A ordem crescente dos valores é: " + valores[0] + ", " + valores[1] + ", " + valores[2]);
    scanner.close();
  }
}
