import java.util.Locale;
import java.util.Scanner;
public class AreaTerreno {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira a altura do terreno:");
        double altura = scanner.nextDouble();
        System.out.println("Insira a largura do terreno:");
        double largura = scanner.nextDouble();
        System.out.println("A área do triângulo é " + (altura*largura) + " metros");
        scanner.close();
    }
}
