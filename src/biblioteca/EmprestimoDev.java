package biblioteca;

public class EmprestimoDev{
    private String tituloLivro;
    private String ibnsLivro;
    private String nomePessoaEmprestimo;
    private String emailPessoaEmprestimo;
    private String dataEmprestimo;
    private String dataDevolucao;
    private boolean statusEmprestimo;
    private int idEmprestimo;

    public EmprestimoDev(String tituloLivro, String ibnsLivro, String nomePessoaEmprestimo,String emailPessoaEmprestimo, 
    String dataEmprestimo, String dataDevolucao, boolean statusEmprestimo, int idEmprestimo){
        this.tituloLivro = tituloLivro;
        this.ibnsLivro = ibnsLivro;
        this.nomePessoaEmprestimo = nomePessoaEmprestimo;
        this.emailPessoaEmprestimo = emailPessoaEmprestimo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.statusEmprestimo = false;
        this.idEmprestimo = idEmprestimo;
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
    public String getDataEmprestimo(){
        return dataEmprestimo;
    }
    public String getDataDevolucao(){
        return dataDevolucao;
    }
    public boolean getStatusEmprestimo(){
        return statusEmprestimo;
    }
    public int getIdEmprestimo(){
        return idEmprestimo;
    }
}
