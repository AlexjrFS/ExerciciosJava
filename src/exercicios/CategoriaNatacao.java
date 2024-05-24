package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class CategoriaNatacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Digite sua idade e verifique em qual categoria você está na natação:");
        int idade = scanner.nextInt();
        if(idade>=5 && idade<=7)
        System.out.println("Infantil A");
        else if(idade>=8 && idade<=10)
        System.out.println("Infantil B");
        else if(idade>=11 && idade<=13)
        System.out.println("Juvenil A");
        else if(idade>=14 && idade<=17)
        System.out.println("Juvenil B");
        else if(idade>=18 && idade<=40)
        System.out.println("Adulto");
        else if(idade>=41)
        System.out.println("Master");
        else
        System.out.println("Idade inválida, mínimo 5 anos");
        scanner.close();
    }
}
