package org.example;
public class Financas {
    private String diretorFinanceiro;
    private String contador;
    private int salarios;
    private int valorInvestidoNoCarro;

    public Financas(String diretorFinanceiro, String contador, int salarios, int valorInvestidoNoCarro) {
        this.diretorFinanceiro = diretorFinanceiro;
        this.contador = contador;
        this.salarios = salarios;
        this.valorInvestidoNoCarro = valorInvestidoNoCarro;
    }

    public String getDiretorFinanceiro() {
        return diretorFinanceiro;
    }

    public void setDiretorFinanceiro(String diretorFinanceiro) {
        this.diretorFinanceiro = diretorFinanceiro;
    }

    public String getContador() {
        return contador;
    }

    public void setContador(String contador) {
        this.contador = contador;
    }

    public int getSalarios() {
        return salarios;
    }

    public void setSalarios(int salarios) {
        this.salarios = salarios;
    }

    public int getValorInvestidoNoCarro() {
        return valorInvestidoNoCarro;
    }

    public void setValorInvestidoNoCarro(int valorInvestidoNoCarro) {
        this.valorInvestidoNoCarro = valorInvestidoNoCarro;
    }
}
