package br.edu.unisep.biblioteca.model;

public abstract class livro {
    private String titulo;
    private String autor;
    private String genero;
    private String isbn;
    private int anoPublicacao;
    private String editora;

    public livro(String titulo, String autor, String genero, String isbn, int anoPublicacao, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String toString() {
        return String.format("Título: %s, Autor: %s, Gênero: %s, ISBN: %s, Ano: %d, Editora: %s",
                titulo, autor, genero, isbn, anoPublicacao, editora);
    }
}
