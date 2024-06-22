package org.example;

public class Pilotos {
    private int idPilotos;
    private String nome;
    private int idade;
    private int nivel;

    // Construtor com ID
    public Pilotos(int idPilotos, String nome, int idade, int nivel) {
        this.idPilotos = idPilotos;
        this.nome = nome;
        this.idade = idade;
        this.nivel = nivel;
    }

    // Getters e setters
    public int getIdPilotos() {
        return idPilotos;
    }

    public void setIdPilotos(int idPilotos) {
        this.idPilotos = idPilotos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
