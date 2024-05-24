package exercicios;
import java.util.ArrayList;
import java.util.Scanner;
class Tarefa{
    private String description;
    private boolean isCompleted;
    private int taskId;
    private static int nextId = 1; 
    public Tarefa(String description){
        this.description = description;
        this.isCompleted = false;
        this.taskId = nextId++;
    }
    public String getDescription(){
        return description;
    }
    public boolean isCompleted(){
        return isCompleted;
    }
    public int getTaskId(){
        return taskId;
    }    
    public void completeTask(){
        this.isCompleted = true;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void displayTask(){
        String status = isCompleted ? "Completa" : "Pendente";
        System.out.println("Código: " + taskId + " | Tarefa: " + description + " | Status: " + status);
    }
}
public class Tarefas{
    private static ArrayList<Tarefa> tasks = new ArrayList<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("\nMenu das tarefas:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Completar tarefa");
            System.out.println("3. Listar as tarefas");
            System.out.println("4. Atualizar tarefa");
            System.out.println("5. Sair");
            System.out.print("Selecione uma das opções do sistema: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:addTask(scanner);break;
                case 2:completeTask(scanner);break;
                case 3:listTasks();break;
                case 4:updateTask(scanner);break;
                case 5:System.out.println("Saindo do sistema, até mais!");break;
                default:System.out.println("Opção inválida!");
            }
        } while(choice != 5);
        scanner.close();
    }
    private static void addTask(Scanner scanner){
        System.out.print("Envie a descrição desta tarefa: ");
        String description = scanner.nextLine();
        Tarefa newTask = new Tarefa(description);
        tasks.add(newTask);
        System.out.println("Tarefa de código " + newTask.getTaskId() + " adicionada com sucesso!");
    }
    private static void completeTask(Scanner scanner){
        System.out.print("Envie o código da tarefa a completar: ");
        int taskId = scanner.nextInt();
        scanner.nextLine();
        for(Tarefa task : tasks) {
            if(task.getTaskId() == taskId) {
                task.completeTask();
                System.out.println("Tarefa marcada como completada!");
                return;
            }
        }
        System.out.println("Tarefa não encontrada.");
    }
    private static void updateTask(Scanner scanner) {
        System.out.print("Envie o código da tarefa a atualizar: ");
        int taskId = scanner.nextInt();
        scanner.nextLine();
        for (Tarefa task : tasks) {
            if (task.getTaskId() == taskId) {
                System.out.print("Envie a nova descrição da tarefa: ");
                String newDescription = scanner.nextLine();
                task.setDescription(newDescription);
                System.out.println("Tarefa atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Tarefa não encontrada.");
    }
    private static void listTasks(){
        if(tasks.isEmpty()){
            System.out.println("Não há tarefas na lista.");
        } 
        else{
            for(Tarefa task : tasks){
                task.displayTask();
            }
        }
    }
}
