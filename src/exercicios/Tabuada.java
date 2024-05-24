package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    System.out.println("Digite um número e receba a tabuada deste valor em questão:");
    int numero = scanner.nextInt();
        
    System.out.println(numero + " X 1 = " + (numero*1) + "\n" + numero + " X 2 = " + (numero*2) + "\n" +
        numero + " X 3 = " + (numero*3) + "\n" + numero + " X 4 = " + (numero*4) + "\n" + numero + " X 5 = " + (numero*5) + "\n" +
        numero + " X 6 = " + (numero*6) + "\n" + numero + " X 7 = " + (numero*7) + "\n" + numero + " X 8 = " + (numero*8) + "\n" +
        numero + " X 9 = " + (numero*9) + "\n" + numero + " X 10 = " + (numero*10));
        scanner.close();
    }
}
