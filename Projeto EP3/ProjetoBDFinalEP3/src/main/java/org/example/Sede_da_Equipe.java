package org.example;
public class Sede_da_Equipe {
    private String nomePresidente;
    private int quantidadeFunci;
    private String localizacao;
    private String setorDePecasDiretoSetorPecas;
    private String financasDiretorFinanceiro;
    private String setorDeMotoresDireitorDoSetorDeMotores;
    private String contrucaoDoCarroProjetista;
    private String materiasPrimasResponsavel;

    public Sede_da_Equipe(String nomePresidente, int quantidadeFunci, String localizacao, String setorDePecasDiretoSetorPecas, String financasDiretorFinanceiro, String setorDeMotoresDireitorDoSetorDeMotores, String contrucaoDoCarroProjetista, String materiasPrimasResponsavel) {
        this.nomePresidente = nomePresidente;
        this.quantidadeFunci = quantidadeFunci;
        this.localizacao = localizacao;
        this.setorDePecasDiretoSetorPecas = setorDePecasDiretoSetorPecas;
        this.financasDiretorFinanceiro = financasDiretorFinanceiro;
        this.setorDeMotoresDireitorDoSetorDeMotores = setorDeMotoresDireitorDoSetorDeMotores;
        this.contrucaoDoCarroProjetista = contrucaoDoCarroProjetista;
        this.materiasPrimasResponsavel = materiasPrimasResponsavel;
    }

    public String getNomePresidente() {
        return nomePresidente;
    }

    public void setNomePresidente(String nomePresidente) {
        this.nomePresidente = nomePresidente;
    }

    public int getQuantidadeFunci() {
        return quantidadeFunci;
    }

    public void setQuantidadeFunci(int quantidadeFunci) {
        this.quantidadeFunci = quantidadeFunci;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getSetorDePecasDiretoSetorPecas() {
        return setorDePecasDiretoSetorPecas;
    }

    public void setSetorDePecasDiretoSetorPecas(String setorDePecasDiretoSetorPecas) {
        this.setorDePecasDiretoSetorPecas = setorDePecasDiretoSetorPecas;
    }

    public String getFinancasDiretorFinanceiro() {
        return financasDiretorFinanceiro;
    }

    public void setFinancasDiretorFinanceiro(String financasDiretorFinanceiro) {
        this.financasDiretorFinanceiro = financasDiretorFinanceiro;
    }

    public String getSetorDeMotoresDireitorDoSetorDeMotores() {
        return setorDeMotoresDireitorDoSetorDeMotores;
    }

    public void setSetorDeMotoresDireitorDoSetorDeMotores(String setorDeMotoresDireitorDoSetorDeMotores) {
        this.setorDeMotoresDireitorDoSetorDeMotores = setorDeMotoresDireitorDoSetorDeMotores;
    }

    public String getContrucaoDoCarroProjetista() {
        return contrucaoDoCarroProjetista;
    }

    public void setContrucaoDoCarroProjetista(String contrucaoDoCarroProjetista) {
        this.contrucaoDoCarroProjetista = contrucaoDoCarroProjetista;
    }

    public String getMateriasPrimasResponsavel() {
        return materiasPrimasResponsavel;
    }

    public void setMateriasPrimasResponsavel(String materiasPrimasResponsavel) {
        this.materiasPrimasResponsavel = materiasPrimasResponsavel;
    }
}
