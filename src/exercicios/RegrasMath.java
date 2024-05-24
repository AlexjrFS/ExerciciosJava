package exercicios;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class RegrasMath {
    public static void main(String[] args) {
        try{
    Locale.setDefault(Locale.US);
    Scanner scanner = new Scanner(System.in);
    System.out.println("Insira o primeiro valor:");
    double valor1 = scanner.nextDouble();
    System.out.println("Insira o segundo valor:");
    double valor2 = scanner.nextDouble();
    System.out.println("A soma dos valores é = " + (valor1+valor2));
    System.out.println("A subtração dos valores é = " + (valor1-valor2));
    System.out.println("A multiplicação dos valores é = " + (valor1*valor2));
    System.out.println("A divisão entre os valores é = " + (valor1/valor2));
    scanner.close();
        }
        catch(InputMismatchException e){
            System.out.println("Insira apenas números, e coloque (.) ao invés de (,)");
        }

    }
}
