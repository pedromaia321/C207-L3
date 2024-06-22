package org.example;
public class Materias_primas {
    private String responsavel;
    private String materiasPrimasAdquiridas;
    private int quantidade;

    public Materias_primas(String responsavel, String materiasPrimasAdquiridas, int quantidade) {
        this.responsavel = responsavel;
        this.materiasPrimasAdquiridas = materiasPrimasAdquiridas;
        this.quantidade = quantidade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getMateriasPrimasAdquiridas() {
        return materiasPrimasAdquiridas;
    }

    public void setMateriasPrimasAdquiridas(String materiasPrimasAdquiridas) {
        this.materiasPrimasAdquiridas = materiasPrimasAdquiridas;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
