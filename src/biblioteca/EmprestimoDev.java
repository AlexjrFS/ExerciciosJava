package biblioteca;

import java.time.LocalDate;

public class EmprestimoDev{
    private String tituloLivro;
    private String ibnsLivro;
    private String nomePessoaEmprestimo;
    private String emailPessoaEmprestimo;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean statusEmprestimo;
    private int idEmprestimo;
    public EmprestimoDev(String tituloLivro, String ibnsLivro, String nomePessoaEmprestimo,String emailPessoaEmprestimo, 
    LocalDate dataEmprestimo, LocalDate dataDevolucao, boolean statusEmprestimo, int idEmprestimo){
        this.tituloLivro = tituloLivro;
        this.ibnsLivro = ibnsLivro;
        this.nomePessoaEmprestimo = nomePessoaEmprestimo;
        this.emailPessoaEmprestimo = emailPessoaEmprestimo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.statusEmprestimo = false;
        this.idEmprestimo = idEmprestimo;
    }
    public EmprestimoDev(String titulo, String isbn, String nomePessoaEmprestimo2, String emailPessoaEmprestimo2,
            LocalDate dataEmprestimo2, LocalDate dataDevolucao2, boolean ativo) {
        //TODO Auto-generated constructor stub
    }
    public String getTituloLivro(){
        return tituloLivro;
    }
    public String getIBNSLivro(){
        return ibnsLivro;
    }
    public String getNomePessoaEmprestimo(){
        return nomePessoaEmprestimo;
    }
    public String getEmailPessoaEmprestimo(){
        return emailPessoaEmprestimo;
    }
    public LocalDate getDataEmprestimo(){
        return dataEmprestimo;
    }
    public LocalDate getDataDevolucao(){
        return dataDevolucao;
    }
    public boolean getStatusEmprestimo(){
        return statusEmprestimo;
    }
    public int getIdEmprestimo(){
        return idEmprestimo;
    }
    public void setTituloLivro(String tituloLivro){
        this.tituloLivro = tituloLivro;
    }
    public void setIbnsLivro(String ibnsLivro){
        this.ibnsLivro = ibnsLivro;
    }
    public void setNomePessoaEmprestimo(String nomePessoaEmprestimo){
        this.nomePessoaEmprestimo = nomePessoaEmprestimo;
    }
    public void setEmailPessoaEmprestimo(String emailPessoaEmprestimo){
        this.emailPessoaEmprestimo = emailPessoaEmprestimo;
    }
    public void setDataEmprestimo(LocalDate dataEmprestimo){
        this.dataEmprestimo = dataEmprestimo;
    }
    public void setDataDevolucao(LocalDate dataDevolucao){
        this.dataDevolucao = dataDevolucao;
    }
    public void setStatusEmprestimo(boolean statusEmprestimo){
        this.statusEmprestimo = statusEmprestimo;
    }
    public void setIdEmprestimo(int idEmprestimo){
        this.idEmprestimo = idEmprestimo++;
    }
    public void displayEmprestimo(){
        System.out.println("Id" + idEmprestimo + " | Status: " + statusEmprestimo + " | Livro: " + tituloLivro + " | IBNS: " + ibnsLivro + " | Nome do responsável: " + nomePessoaEmprestimo + " | Email: " + emailPessoaEmprestimo + " | Data Empréstimo: " + dataEmprestimo + " | Data Devolução: " + dataDevolucao );
    }
}
