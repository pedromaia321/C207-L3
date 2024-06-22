package org.example;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Criando objetos para inserir no banco de dados
        Setor_de_pecas setorDePecas = new Setor_de_pecas("Direto_Setor_peças", 100, 50);
        Pilotos piloto1 = new Pilotos(1, "Piloto 1", 30, 7);
        Pilotos piloto2 = new Pilotos(2, "Piloto 2", 28, 6);

        // Criando objetos DAO
        SetorDePecasDAO setorDePecasDAO = new SetorDePecasDAO();
        PilotosDAO pilotosDAO = new PilotosDAO();

        try {
            // Criando registros no banco de dados para Setor_de_peças
            setorDePecasDAO.create(setorDePecas);
            System.out.println("Setor de peças criado:");
            printSetorInfo(setorDePecas);

            // Atualizando um registro em Setor_de_peças
            setorDePecas.setPecasQuantidade(120);
            setorDePecas.setQuantiDeFuncio(60);
            setorDePecasDAO.update(setorDePecas);
            System.out.println("Setor de peças atualizado:");
            printSetorInfo(setorDePecas);

            // Buscando registros em Setor_de_peças
            Setor_de_pecas setorBuscado = setorDePecasDAO.read("Direto_Setor_peças");
            if (setorBuscado != null) {
                System.out.println("Setor de peças encontrado:");
                printSetorInfo(setorBuscado);
            }

            // Deletando um registro em Setor_de_peças
            setorDePecasDAO.delete("Direto_Setor_peças");
            System.out.println("Setor de peças deletado:");

            // Listando todos os registros de Setor_de_peças
            List<Setor_de_pecas> setores = setorDePecasDAO.getAll();
            System.out.println("Lista de setores:");
            for (Setor_de_pecas s : setores) {
                printSetorInfo(s);
            }

            // Criando registros no banco de dados para Pilotos
            pilotosDAO.create(piloto1);
            pilotosDAO.create(piloto2);
            System.out.println("Pilotos criados:");
            printPilotoInfo(piloto1);
            printPilotoInfo(piloto2);

            // Atualizando um registro em Pilotos
            piloto1.setNome("Novo Piloto 1");
            pilotosDAO.update(piloto1);
            System.out.println("Piloto atualizado:");
            printPilotoInfo(piloto1);

            // Buscando registros em Pilotos
            Pilotos pilotoBuscado = pilotosDAO.read(2); // Buscando pelo ID 2
            if (pilotoBuscado != null) {
                System.out.println("Piloto encontrado:");
                printPilotoInfo(pilotoBuscado);
            }

            // Deletando um registro em Pilotos
            pilotosDAO.delete(1); // Deletando pelo ID 1
            System.out.println("Piloto deletado:");

            // Listando todos os registros de Pilotos
            List<Pilotos> pilotos = pilotosDAO.getAll();
            System.out.println("Lista de pilotos:");
            for (Pilotos p : pilotos) {
                printPilotoInfo(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printSetorInfo(Setor_de_pecas setor) {
        System.out.println("Nome do diretor: " + setor.getdiretor_Setor_pecas());
        System.out.println("Quantidade de peças: " + setor.getPecasQuantidade());
        System.out.println("Quantidade de funcionários: " + setor.getQuantiDeFuncio());
        System.out.println();
    }

    private static void printPilotoInfo(Pilotos piloto) {
        System.out.println("ID do piloto: " + piloto.getIdPilotos());
        System.out.println("Nome do piloto: " + piloto.getNome());
        System.out.println("Idade do piloto: " + piloto.getIdade());
        System.out.println("Nível do piloto: " + piloto.getNivel());
        System.out.println();
    }
}
