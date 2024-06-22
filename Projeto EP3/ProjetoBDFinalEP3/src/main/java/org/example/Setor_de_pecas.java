package org.example;
public class Setor_de_pecas {
    private String diretor_Setor_pecas;
    private int pecasQuantidade;
    private int quantiDeFuncio;

    public Setor_de_pecas(String diretor_Setor_pecas, int pecasQuantidade, int quantiDeFuncio) {
        this.diretor_Setor_pecas = diretor_Setor_pecas;
        this.pecasQuantidade = pecasQuantidade;
        this.quantiDeFuncio = quantiDeFuncio;
    }

    public String getdiretor_Setor_pecas() {
        return diretor_Setor_pecas;
    }

    public void setdiretor_Setor_pecas(String diretor_Setor_pecas) {
        this.diretor_Setor_pecas = diretor_Setor_pecas;
    }

    public int getPecasQuantidade() {
        return pecasQuantidade;
    }

    public void setPecasQuantidade(int pecasQuantidade) {
        this.pecasQuantidade = pecasQuantidade;
    }

    public int getQuantiDeFuncio() {
        return quantiDeFuncio;
    }

    public void setQuantiDeFuncio(int quantiDeFuncio) {
        this.quantiDeFuncio = quantiDeFuncio;
    }
}
