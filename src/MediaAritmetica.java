public class MediaAritmetica {
    public static void main(String[] args) {
        int numero1 = 8;
        int numero2 = 9;
        int numero3 = 7;
        double media1 = (numero1+numero2+numero3)/3;
        System.out.println("A primeira média é igual a: " + media1);
        int valor1 = 4;
        int valor2 = 5;
        int valor3 = 6;
        double media2 = (valor1+valor2+valor3)/3;
        System.out.println("A segunda média é igual a: " + media2);
        double resultado = media1+media2;
        System.out.println("A soma das médias é igual a: " + resultado);
        double mediaGeral = resultado/2;
        System.out.println("A média geral é igual a: " + mediaGeral);
        System.out.println();
    }
}
