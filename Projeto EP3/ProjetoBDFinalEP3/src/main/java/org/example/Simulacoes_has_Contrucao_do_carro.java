package org.example;
public class Simulacoes_has_Contrucao_do_carro {
    private String simulacoesDireitorDasSimulacoes;
    private String contrucaoDoCarroProjetista;

    public Simulacoes_has_Contrucao_do_carro(String simulacoesDireitorDasSimulacoes, String contrucaoDoCarroProjetista) {
        this.simulacoesDireitorDasSimulacoes = simulacoesDireitorDasSimulacoes;
        this.contrucaoDoCarroProjetista = contrucaoDoCarroProjetista;
    }

    public String getSimulacoesDireitorDasSimulacoes() {
        return simulacoesDireitorDasSimulacoes;
    }

    public void setSimulacoesDireitorDasSimulacoes(String simulacoesDireitorDasSimulacoes) {
        this.simulacoesDireitorDasSimulacoes = simulacoesDireitorDasSimulacoes;
    }

    public String getContrucaoDoCarroProjetista() {
        return contrucaoDoCarroProjetista;
    }

    public void setContrucaoDoCarroProjetista(String contrucaoDoCarroProjetista) {
        this.contrucaoDoCarroProjetista = contrucaoDoCarroProjetista;
    }
}
