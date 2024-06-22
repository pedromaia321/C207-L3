package org.example;

public class Setor_de_motores {
    private String direitor_do_setor_de_motores;
    private int quanti_de_funci;
    private int quanti_para_pesquisa;

    public Setor_de_motores(String direitor_do_setor_de_motores, int quanti_de_funci, int quanti_para_pesquisa) {
        this.direitor_do_setor_de_motores = direitor_do_setor_de_motores;
        this.quanti_de_funci = quanti_de_funci;
        this.quanti_para_pesquisa = quanti_para_pesquisa;
    }

    public String getDireitor_do_setor_de_motores() {
        return direitor_do_setor_de_motores;
    }

    public void setDireitor_do_setor_de_motores(String direitor_do_setor_de_motores) {
        this.direitor_do_setor_de_motores = direitor_do_setor_de_motores;
    }

    public int getQuanti_de_funci() {
        return quanti_de_funci;
    }

    public void setQuanti_de_funci(int quanti_de_funci) {
        this.quanti_de_funci = quanti_de_funci;
    }

    public int getQuanti_para_pesquisa() {
        return quanti_para_pesquisa;
    }

    public void setQuanti_para_pesquisa(int quanti_para_pesquisa) {
        this.quanti_para_pesquisa = quanti_para_pesquisa;
    }
}
