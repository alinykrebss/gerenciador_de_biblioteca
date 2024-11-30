package br.edu.unisep.biblioteca.model;

public class usuario {
    private String nome;

    public usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return "Usuário: " + nome;
    }
}
