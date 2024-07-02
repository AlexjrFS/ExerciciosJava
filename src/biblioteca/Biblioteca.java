package biblioteca;
import java.time.LocalDate;
import java.util.*;
public class Biblioteca {
    private static ArrayList<Livro> livros = new ArrayList<>();
    private static ArrayList<EmprestimoDev> empresdev = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    static boolean ativo = true;
    public static void main(String[] args){
        livros.add(new Livro("Dom Casmurro", "Machado de Assis", 1899, "9788582850350"));
        livros.add(new Livro("O Menino Marrom", "Ziraldo Alves Pinto", 1986, "9788506005194"));
        empresdev.add(new EmprestimoDev("Dom Casmurro", "9788582850350", "Luis", "luis@gmail.com", null, null, true, 0));
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
                    case 5:emprestimoDevolucao(scanner);break;
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
            System.out.println("Nenhum livro com ISBN " +  isbn + " cadastrado com esta ISBN!");
        }
    }
    /*private static void emprestimoDevolucao(Scanner scanner){
        System.out.println("Deseja registrar um espréstimo ou uma devolução?\n1. Empréstimo\n2. Devolução");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if(opcao == 1){
            System.out.println("Digite a IBNS do livro a ser emprestado:");
            String ibns = scanner.nextLine();
            Livro livroEmprestado = null;
            for(Livro livro : livros){
                if(livro.getIsbn().equals(ibns)){
                    livroEmprestado = livro;
                    break;
                }
            }
            if(livroEmprestado == null){
                System.out.println("Livro com IBNS " + ibns + " não foi encontrado");
                return;
            }
            System.out.println("Insira o nome da pessoa reswponsável pelo empréstimo:");
            String nomePessoaEmprestimo = scanner.nextLine();
            System.out.println("Insira o email da pessoa responsável pelo empréstimo:");
            String emailPessoaEmprestimo = scanner.nextLine();
            LocalDate dataEmprestimo = LocalDate.now();
            LocalDate dataDevolucao = dataEmprestimo.plusWeeks(2);
            String idEmprestimo = UUID.randomUUID().toString();
            EmprestimoDev novoEmprestimoDev = new EmprestimoDev(livroEmprestado.getTitulo(),livroEmprestado.getIsbn(), nomePessoaEmprestimo,emailPessoaEmprestimo, dataEmprestimo, dataDevolucao, ativo);
            empresdev.add(novoEmprestimoDev);
            System.out.println("Empréstimo registrado com sucesso!");
            System.out.println(novoEmprestimoDev);
        }
        else if(opcao == 2){
            System.out.println("Digite a ISBN do livro a ser devolvido:");
            String isbn = scanner.nextLine();
            for (EmprestimoDev emprestimo : empresdev) {
                if (emprestimo.getIBNSLivro().equals(isbn) && !emprestimo.getStatusEmprestimo()) {
                    emprestimo.setStatusEmprestimo(true);
                    emprestimo.setDataDevolucao(LocalDate.now());
                    System.out.println("Devolução registrada com sucesso!");
                    System.out.println(emprestimo);
                    return;
                }
            }
            System.out.println("Nenhum empréstimo ativo encontrado para o ISBN " + isbn + ".");
        }
        else{
            System.out.println("Insira uma das opções acima.");
        }
    }*/
    private static void emprestimoDevolucao(Scanner scanner) {
        System.out.println("Deseja registrar um empréstimo ou uma devolução?\n1. Empréstimo\n2. Devolução");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir o newline deixado por nextInt
    
        if (opcao == 1) {
            System.out.println("Digite a ISBN do livro a ser emprestado:");
            String isbn = scanner.nextLine().trim(); // Limpar espaços em branco extras
            Livro livroEmprestado = null;
    
            for (Livro livro : livros) {
                if (livro.getIsbn().equals(isbn)) {
                    livroEmprestado = livro;
                    break;
                }
            }
    
            if (livroEmprestado == null) {
                System.out.println("Livro com ISBN " + isbn + " não foi encontrado.");
                return;
            }
    
            System.out.println("Insira o nome da pessoa reswponsável pelo empréstimo:");
            String nomePessoaEmprestimo = scanner.nextLine();
            System.out.println("Insira o email da pessoa responsável pelo empréstimo:");
            String emailPessoaEmprestimo = scanner.nextLine();
            LocalDate dataEmprestimo = LocalDate.now();
            LocalDate dataDevolucao = dataEmprestimo.plusWeeks(2);
            String idEmprestimo = UUID.randomUUID().toString();
            EmprestimoDev novoEmprestimo = new EmprestimoDev(
                livroEmprestado.getTitulo(), livroEmprestado.getIsbn(), nomePessoaEmprestimo, emailPessoaEmprestimo, dataEmprestimo, dataDevolucao,true);
    
            empresdev.add(novoEmprestimo);
            System.out.println("Empréstimo registrado com sucesso!");
            System.out.println(novoEmprestimo);
    
        } else if (opcao == 2) {
            System.out.println("Digite a ISBN do livro a ser devolvido:");
            String isbn = scanner.nextLine();
            for (EmprestimoDev emprestimo : empresdev) {
                if (emprestimo.getIBNSLivro().equals(isbn) && !emprestimo.getStatusEmprestimo()) {
                    emprestimo.setStatusEmprestimo(true);
                    emprestimo.setDataDevolucao(LocalDate.now());
                    System.out.println("Devolução registrada com sucesso!");
                    System.out.println(emprestimo);
                    return;
                }
            }
            System.out.println("Nenhum empréstimo ativo encontrado para o ISBN " + isbn + ".");
        }
        else{
            System.out.println("Insira uma das opções acima.");
        }
       
    }
    
}
