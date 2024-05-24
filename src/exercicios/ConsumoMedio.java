package exercicios;

import java.util.Locale;
import java.util.Scanner;

public class ConsumoMedio {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira a distância percorrida em km:");
        double km = scanner.nextDouble();
        System.out.println("Insira a quantidade de combustivel gasto:");
        double gasolina = scanner.nextDouble();
        System.out.println("O consumo médio do automóvel é de " + (km/gasolina) + " km/l");
        scanner.close();
    }
}
