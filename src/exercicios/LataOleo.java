package exercicios;

import java.util.Locale;
import java.util.Scanner;

public class LataOleo {
    public static void main(String[] args) {
        double pi = 3.14159;
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Dê o valor do raio:");
        double raio = scanner.nextDouble();
        System.out.println("Dê o valor da altura:");
        double altura = scanner.nextDouble();
        double volume = pi * Math.pow(raio, 2) * altura;
        System.out.printf("O volume da lata de óleo é = %.2f", volume);
        scanner.close();
    }
}
