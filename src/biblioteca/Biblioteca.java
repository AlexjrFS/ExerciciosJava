package biblioteca;
import java.util.*;
public class Biblioteca {
    private static ArrayList<Livro> livros = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    static boolean ativo = true;
    public static void main(String[] args){
        livros.add(new Livro("Dom Casmurro", "Machado de Assis", 1899, "9788582850350"));
        livros.add(new Livro("O Menino Marrom", "Ziraldo Alves Pinto", 1986, "9788506005194"));
        try{
            while(ativo){
                System.out.println("--- Menu de Opções ---");
                System.out.println("1. Cadastrar um novo livro.");
                System.out.println("2. Remover um livro cadastrado.");
                System.out.println("3. Listar livros cadastrados.");
                System.out.println("4. Buscar por um livro cadastrado.");
                System.out.println("5. Registrar empréstimo/devolução.");
                System.out.println("6. Sair.");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:cadastroLivro(scanner);break;
                    case 2:removerLivro(scanner);break;
                    case 3:listarLivros();break;
                    case 4:buscarLivro(scanner);break;
                    case 5: // implementar a funcionalidade de empréstimo/devolução aquibreak;
                    case 6: ativo = false; System.out.println("Volte Sempre!");break;
                    default:System.out.println("Opção inválida.");break;
                }
            }
        } 
        catch(InputMismatchException e){
            System.out.println("Insira os dados de forma correta!");
        } 
        finally{
            scanner.close();
        }
    }
    private static void cadastroLivro(Scanner scanner){
    System.out.println("Insira o titulo do livro a ser cadastrado:");
    String titulo = scanner.nextLine();
    System.out.println("Insira o autor:");
    String autor = scanner.nextLine();
    System.out.println("Insira o ano de Publicação:");
    int anoPublicacao = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Insira a ISBN:");
    String isbn = scanner.nextLine();
    Livro novoLivro = new Livro(titulo, autor, anoPublicacao, isbn);
    livros.add(novoLivro);
    System.out.println("Livro '" + titulo + "' cadastrado com sucesso!");
    }    
    private static void removerLivro(Scanner scanner){
        System.out.println("Insira a ISBN do livro que deseja remover do sistema:");
        String isbn = scanner.nextLine();
        for(int i = 0; i < livros.size(); i++){
            Livro livro = livros.get(i);
            if(livro.getIsbn().equals(isbn)){
                livros.remove(i);
                System.out.println("Livro " + livro.getTitulo() + " deletado com sucesso!");
                return;
            }
        }
        System.out.println("Livro com ISBN " + isbn + " não encontrado.");
    }
    private static void listarLivros(){
        System.out.println("Livros cadastrados no sistema:");
        for(Livro livro : livros){
            livro.displayLivro();
        }
    }
    private static void buscarLivro(Scanner scanner){
        System.out.println("Insira a ISBN do livro:");
        String isbn = scanner.nextLine();
        boolean encontrado = false;
        for(Livro livro : livros){
            if(livro.getIsbn().equals(isbn)){
                System.out.println("Livro cadastrado no sistema:");
                livro.displayLivro();
                encontrado = true;
                break;
            }           
        }
        if(!encontrado){
            System.out.println("Livro com ISBN " +  isbn +" cadastrado com esta ISBN!");
        }
    }
    private static void emprestimoDevolucao(Scanner scanner){
        System.out.println("Deseja registrar um espréstimo ou uma devolução?\n1. Empréstimo\n 2. Devolução");
        int opcao = scanner.nextInt();
        if(opcao == 1){
            
        }
        else if(opcao == 2){

        }
    }
}
