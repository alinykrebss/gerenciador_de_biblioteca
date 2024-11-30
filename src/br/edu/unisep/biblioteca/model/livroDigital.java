package br.edu.unisep.biblioteca.model;

public class livroDigital extends livro {
    private String linkDownload;

    public livroDigital(String titulo, String autor, String genero, String isbn, int anoPublicacao, String editora, String linkDownload) {
        super(titulo, autor, genero, isbn, anoPublicacao, editora);
        this.linkDownload = linkDownload;
    }

    public livroDigital(String titulo, String autor, String genero, String isbn, int anoPublicacao, String editora) {
        super(titulo, autor, genero, isbn, anoPublicacao, editora);
    }

    public String toString() {
        return super.toString() + ", Tipo: Digital, Link: " + linkDownload;
    }
}
