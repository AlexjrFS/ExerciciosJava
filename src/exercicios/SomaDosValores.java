package exercicios;

import java.util.Locale;
import java.util.Scanner;

public class SomaDosValores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Insira o primeiro valor:");
        int numero1 = scanner.nextInt();
        System.out.println("Insira o segundo valor:");
        int numero2 = scanner.nextInt();
        System.out.println("O resultado da soma é = " + ( numero1 + numero2 ));
        scanner.close();

    }
}
