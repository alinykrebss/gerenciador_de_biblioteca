package br.edu.unisep.biblioteca.model;

import java.time.LocalDate;

public class emprestimo {
    private livro livro;
    private usuario usuario;
    private String status;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public emprestimo(livro livro, usuario usuario, String status) {
        this.livro = livro;
        this.usuario = usuario;
        this.status = status;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public livro getLivro() {
        return livro;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
