import java.util.Locale;
import java.util.Scanner;

public class TiposDeMedia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        //"Calculo de média, media ponderada considerando pesos 2, 2, 3 e media ponderada considerando os pesos 1, 2, 2"
        System.out.println("Digite o primeiro de 3 valores:");
        double n1 = scanner.nextDouble();
        System.out.println("Digite o segundo valor:");
        double n2 = scanner.nextDouble();
        System.out.println("Digite o terceiro e ultimo numero");
        double n3 = scanner.nextDouble();
        double media = (n1+n2+n3)/3;
        double mediaPonderada = ((n1*2)+(n2*2)+(n3*3))/7;
        double mediaPonderada2 = ((n1*1)+(n2*2)+(n3*2))/5;
        System.out.println("Valores: "+n1+", "+n2+", "+n3+"\nMédia entre eles: "+media+"\n1° Média ponderada: "+mediaPonderada+"\n2° Média ponderada: "+mediaPonderada2);
        scanner.close();
    }
}
