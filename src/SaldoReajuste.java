import java.util.Locale;
import java.util.Scanner;

public class SaldoReajuste {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe seu saldo atual: ");
        double saldo = scanner.nextInt();
        System.out.println("O valor do saldo ajustado em 1% fica em: " + ((saldo*0.01)+saldo));
        scanner.close();

    }
}
