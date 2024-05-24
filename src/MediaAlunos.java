import java.util.Locale;
import java.util.Scanner;

public class MediaAlunos {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira a primeira nota: ");
        double nota1 = scanner.nextDouble();
        System.out.println("Insira a segunda nota:");
        double nota2 = scanner.nextDouble();
        System.out.println("Insira a terceira nota:");
        double nota3 = scanner.nextDouble();
        double media = (nota1+nota2+nota3)/3;

        if(media>=7.0)
        System.out.println("O aluno foi aprovado com a média "+media);
        
        else if(media>=5.0 && media<7.0)
        System.out.println("O aluno ficou em exame por finalizar com a média "+media);
        
        else
        System.out.println("O aluno foi reprovado pois não alcançou a meta ficando com a média "+media);
        
        scanner.close();
    }
}
