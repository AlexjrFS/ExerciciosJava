package exercicios;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class CalculoInss {
    public static void main(String[] args) {
        try{
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Insira o valor do salário:");
        double salario = scanner.nextDouble();
        if(salario<=1751.81){
            double desconto = salario*0.08;
            System.out.println("Desconto do INSS: R$ "+desconto);
        }
        else if(salario>1751.81 && salario<=2919.72){
            double desconto = salario*0.09;
            System.out.println("Desconto do INSS: R$ "+desconto);
        }
        else if(salario>2919.72 ){
            double desconto = salario*0.11;
            System.out.println("Desconto do INSS: R$ "+desconto);
        }
        else{
            System.out.println(salario);
        }
        scanner.close();    
    }
    catch(InputMismatchException e){
        System.err.println("Insira apenas números.\nSepare os decimais com (.).");
    }
    }
}
