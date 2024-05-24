package exercicios;

import java.util.Locale;
import java.util.Scanner;

public class ParedeAzulejo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Digite a altura da parede:");
        double hp = scanner.nextDouble();
        System.out.println("Digite a largura da parede:");
        double lp = scanner.nextDouble();
        System.out.println("Digite a altura do azulejo:");
        double ha = scanner.nextDouble();
        System.out.println("Digite a largura do azulejo:");
        double la = scanner.nextDouble();
        double azulejos = (hp*lp)/(ha*la);
        System.out.printf("Serão necessarios %.2f azulejos, para cobrir toda a parede!", azulejos);
        scanner.close();
    }
}
