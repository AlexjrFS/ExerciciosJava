import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class DiasDeVida {
    public static void main(String[] args) {
        try{
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Insira sua idade atual:");
        int idade = scanner.nextInt();
        int dias = idade * 365;
        System.out.println(nome.toUpperCase() + ", VOCÊ JÁ VIVEU " + dias + " DIAS");
        scanner.close();
        }
        catch(InputMismatchException e){
            System.err.println("No campo idade insira apenas número.");
        }
    }
}
