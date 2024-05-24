package exercicios;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class IMC {
    public static void main(String[] args) {
        calculoIMC();
    }
    static void calculoIMC(){
        try{
        Scanner entrada = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Insira o seu peso atual:");
        double peso = entrada.nextDouble();
        System.out.println("Insira a sua altura atual:");
        double altura = entrada.nextDouble();
        double imc = peso / (Math.pow(altura, 2));
        if(imc<18.5){
            System.out.printf("Abaixo do peso, com o IMC de %.1f\n", imc);
        }
        else if(imc>=18.6 && imc<=24.9){
            System.out.printf("Peso ideal (parabéns), com o IMC de %.1f\n", imc);
        }
        else if(imc>=25.0 && imc<=29.9){
            System.out.printf("Levemente acima do peso, com o IMC de %.1f\n", imc);
        }
        else if(imc>=30.0 && imc<=34.9){
            System.out.printf("Obesidade grau I, com o IMC de %.1f\n", imc);
        }
        else if(imc>=35.0 && imc<=39.9){
            System.out.printf("Obesidade grau II(severa), com o IMC de %.1f\n", imc);
        }
        else{
            System.out.printf("Obesidade grau III(mórbiida), com o IMC de %.1f\n", imc);
        }
        entrada.close();}
        catch(InputMismatchException e){
            System.err.println("Insira apenas números com casas decimais, separados por (.)");
        }
    }
}
