package exercicios;

import java.util.Locale;
import java.util.Scanner;

public class MesDoAno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Digite o mês do ano na forma numérica:");
        int numeroAno = scanner.nextInt();
        switch(numeroAno){
            case 1:System.out.println("Janeiro\n");break;
            case 2:System.out.println("Fevereiro\n");break;
            case 3:System.out.println("Março\n");
            case 4:System.out.println("Abril\n");break;
            case 5:System.out.println("Maio\n");break;
            case 6:System.out.println("Junho\n");
            case 7:System.out.println("Julho\n");break;
            case 8:System.out.println("Agosto\n");break;
            case 9:System.out.println("Setembro\n");
            case 10:System.out.println("Outubro\n");break;
            case 11:System.out.println("Novembro\n");break;
            case 12:System.out.println("Dezembro\n");break;
            default: System.out.println("Insira um valor válido.\n");
        }
        scanner.close();
    }
}
