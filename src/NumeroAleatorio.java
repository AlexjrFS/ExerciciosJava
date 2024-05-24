 import java.util.Random;
public class NumeroAleatorio {
  public static void main(String[] args) {
    numeroGeradoInteiro();
  }
  static void numeroGeradoInteiro(){
    Random aleatorio = new Random();
    int valor = aleatorio.nextInt(1,1000);
    System.out.println("Número inteiro gerado entre 1 e 1000 é: " + valor);
  }
} 
