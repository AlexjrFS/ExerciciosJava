package biblioteca;
class Livro{
private String titulo;
private String autor;
private int anoPublicacao;
private String isbn;

public Livro(String titulo, String autor, int anoPublicacao, String isbn){
    this.titulo = titulo;
    this.autor = autor;
    this.anoPublicacao = anoPublicacao;
    this.isbn = isbn;
}
public String getTitulo(){
    return titulo;
}
public String getAutor(){
    return autor;
}
public int getAnoPublicacao(){
    return anoPublicacao;
}
public String getIsbn(){
    return isbn;
}
public void setTitulo(String titulo){
    this.titulo = titulo;
}
public void setAutor(String autor){
    this.autor = autor;
}
public void setAnoPublicacao(int anoPublicacao){
    this.anoPublicacao = anoPublicacao;
}
public void setIsbn(String isbn){
    this.isbn = isbn;
}
public void displayLivro(){
    System.out.println("Livro: " + titulo + " | Autor: " + autor + " | Publicado no ano de: " + anoPublicacao + " | ISBN: " + isbn);
}
public Livro get(String isbn2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get'");
}
public void remove(String isbn2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'remove'");
}
}
