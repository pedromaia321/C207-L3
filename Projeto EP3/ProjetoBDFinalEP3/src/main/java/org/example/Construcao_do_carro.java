package org.example;

public class Construcao_do_carro {
    private String projetista;
    private String setorDePecasDiretoSetorPecas;
    private String materiasPrimasResponsavel;
    private String setorDeMotoresDireitorDoSetorDeMotores;

    public Construcao_do_carro(String projetista, String setorDePecasDiretoSetorPecas, String materiasPrimasResponsavel, String setorDeMotoresDireitorDoSetorDeMotores) {
        this.projetista = projetista;
        this.setorDePecasDiretoSetorPecas = setorDePecasDiretoSetorPecas;
        this.materiasPrimasResponsavel = materiasPrimasResponsavel;
        this.setorDeMotoresDireitorDoSetorDeMotores = setorDeMotoresDireitorDoSetorDeMotores;
    }

    // getters e setters
    public String getProjetista() {
        return projetista;
    }

    public void setProjetista(String projetista) {
        this.projetista = projetista;
    }

    public String getSetorDePecasDiretoSetorPecas() {
        return setorDePecasDiretoSetorPecas;
    }

    public void setSetorDePecasDiretoSetorPecas(String setorDePecasDiretoSetorPecas) {
        this.setorDePecasDiretoSetorPecas = setorDePecasDiretoSetorPecas;
    }

    public String getMateriasPrimasResponsavel() {
        return materiasPrimasResponsavel;
    }

    public void setMateriasPrimasResponsavel(String materiasPrimasResponsavel) {
        this.materiasPrimasResponsavel = materiasPrimasResponsavel;
    }

    public String getSetorDeMotoresDireitorDoSetorDeMotores() {
        return setorDeMotoresDireitorDoSetorDeMotores;
    }

    public void setSetorDeMotoresDireitorDoSetorDeMotores(String setorDeMotoresDireitorDoSetorDeMotores) {
        this.setorDeMotoresDireitorDoSetorDeMotores = setorDeMotoresDireitorDoSetorDeMotores;
    }
}
