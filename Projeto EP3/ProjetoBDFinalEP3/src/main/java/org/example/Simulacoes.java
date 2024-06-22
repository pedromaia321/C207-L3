package org.example;
public class Simulacoes {
    private String direitorDasSimulacoes;
    private String piloto1;
    private String piloto2;
    private int pilotosIdPilotos;

    public Simulacoes(String direitorDasSimulacoes, String piloto1, String piloto2, int pilotosIdPilotos) {
        this.direitorDasSimulacoes = direitorDasSimulacoes;
        this.piloto1 = piloto1;
        this.piloto2 = piloto2;
        this.pilotosIdPilotos = pilotosIdPilotos;
    }

    public String getDireitorDasSimulacoes() {
        return direitorDasSimulacoes;
    }

    public void setDireitorDasSimulacoes(String direitorDasSimulacoes) {
        this.direitorDasSimulacoes = direitorDasSimulacoes;
    }

    public String getPiloto1() {
        return piloto1;
    }

    public void setPiloto1(String piloto1) {
        this.piloto1 = piloto1;
    }

    public String getPiloto2() {
        return piloto2;
    }

    public void setPiloto2(String piloto2) {
        this.piloto2 = piloto2;
    }

    public int getPilotosIdPilotos() {
        return pilotosIdPilotos;
    }

    public void setPilotosIdPilotos(int pilotosIdPilotos) {
        this.pilotosIdPilotos = pilotosIdPilotos;
    }
}
