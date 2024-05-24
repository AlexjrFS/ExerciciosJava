package exercicios;

import java.util.Random;

public class GerarNumeroEVerificar {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        int valor = aleatorio.nextInt(100); 
        
        if (valor % 2 == 0) {
            if (valor >= 50) {
                System.out.println("O valor é par e é maior ou igual a 50. Este valor é: " + valor);
            } else {
                System.out.println("O valor é par e é menor do que 50. Este valor é: " + valor);
            }
        } else {
            if (valor >= 50) {
                System.out.println("O valor é ímpar e é maior ou igual a 50. Este valor é: " + valor);
            } else {
                System.out.println("O valor é ímpar e é menor do que 50. Este valor é: " + valor);
            }
        }
    }
}
