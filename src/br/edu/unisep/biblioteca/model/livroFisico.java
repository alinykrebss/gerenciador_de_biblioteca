package br.edu.unisep.biblioteca.model;

public class livroFisico extends livro {
    private String codigoLocalizacao;

    public livroFisico(String titulo, String autor, String genero, String isbn, int anoPublicacao, String editora, String codigoLocalizacao) {
        super(titulo, autor, genero, isbn, anoPublicacao, editora);
        this.codigoLocalizacao = codigoLocalizacao;
    }

    public String toString() {
        return super.toString() + ", Tipo: Físico, Localização: " + codigoLocalizacao;
    }
}
