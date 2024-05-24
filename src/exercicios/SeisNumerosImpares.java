package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class SeisNumerosImpares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int numero = scanner.nextInt();
        if(numero % 2 == 0){
            numero++;
        }
        for(int n = 0; n < 6; n++ ){
            System.out.println(numero + 2 *n);
        }
        scanner.close();
    }
}
