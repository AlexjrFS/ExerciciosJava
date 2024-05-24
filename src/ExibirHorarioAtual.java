import java.time.LocalTime;

public class ExibirHorarioAtual {
    public static void main(String[] args) {
        LocalTime hora = LocalTime.now();
        System.out.println("Que horas são?");
        System.out.println("Agora são " + hora);
    }
}
