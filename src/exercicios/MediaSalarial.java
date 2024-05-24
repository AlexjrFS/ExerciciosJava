package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class MediaSalarial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Digite o salario do funcionario 1:");
        double func1 = scanner.nextDouble();
        System.out.println("Digite o salario do funcionario 2:");
        double func2 = scanner.nextDouble();
        System.out.println("Digite o salario do funcionario 3:");
        double func3 = scanner.nextDouble();
        System.out.println("Digite o salario do funcionario 4:");
        double func4 = scanner.nextDouble();
        double mediaSalarial = (func1+func2+func3+func4)/4;
        System.out.printf("A média salarial dos funcionarios de sua empresa é de R$ %.2f", mediaSalarial);
        scanner.close();
    }
}
