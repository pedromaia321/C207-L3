package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimulacoesHasContrucaoDoCarroDAO {

    public void create(Simulacoes_has_Contrucao_do_carro simulacaoCarro) throws SQLException {
        String sql = "INSERT INTO Simulacoes_has_Contrucao_do_carro (Simulacoes_Direitor_das_simulaçoes, Contrucao_do_carro_Projetista) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, simulacaoCarro.getSimulacoesDireitorDasSimulacoes());
            stmt.setString(2, simulacaoCarro.getContrucaoDoCarroProjetista());
            stmt.executeUpdate();
        }
    }

    public Simulacoes_has_Contrucao_do_carro read(String simulacoesDireitorDasSimulacoes, String contrucaoDoCarroProjetista) throws SQLException {
        String sql = "SELECT * FROM Simulacoes_has_Contrucao_do_carro WHERE Simulacoes_Direitor_das_simulaçoes = ? AND Contrucao_do_carro_Projetista = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, simulacoesDireitorDasSimulacoes);
            stmt.setString(2, contrucaoDoCarroProjetista);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Simulacoes_has_Contrucao_do_carro(
                        rs.getString("Simulacoes_Direitor_das_simulaçoes"),
                        rs.getString("Contrucao_do_carro_Projetista")
                );
            }
        }
        return null;
    }

    public void update(Simulacoes_has_Contrucao_do_carro simulacaoCarro) throws SQLException {
        String sql = "UPDATE Simulacoes_has_Contrucao_do_carro SET Contrucao_do_carro_Projetista = ? WHERE Simulacoes_Direitor_das_simulaçoes = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, simulacaoCarro.getContrucaoDoCarroProjetista());
            stmt.setString(2, simulacaoCarro.getSimulacoesDireitorDasSimulacoes());
            stmt.executeUpdate();
        }
    }

    public void delete(String simulacoesDireitorDasSimulacoes, String contrucaoDoCarroProjetista) throws SQLException {
        String sql = "DELETE FROM Simulacoes_has_Contrucao_do_carro WHERE Simulacoes_Direitor_das_simulaçoes = ? AND Contrucao_do_carro_Projetista = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, simulacoesDireitorDasSimulacoes);
            stmt.setString(2, contrucaoDoCarroProjetista);
            stmt.executeUpdate();
        }
    }

    public List<Simulacoes_has_Contrucao_do_carro> getAll() throws SQLException {
        List<Simulacoes_has_Contrucao_do_carro> simulacoesCarro = new ArrayList<>();
        String sql = "SELECT * FROM Simulacoes_has_Contrucao_do_carro";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Simulacoes_has_Contrucao_do_carro simulacaoCarro = new Simulacoes_has_Contrucao_do_carro(
                        rs.getString("Simulacoes_Direitor_das_simulaçoes"),
                        rs.getString("Contrucao_do_carro_Projetista")
                );
                simulacoesCarro.add(simulacaoCarro);
            }
        }
        return simulacoesCarro;


    }
}