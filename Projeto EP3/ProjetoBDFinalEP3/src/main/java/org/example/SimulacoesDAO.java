package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimulacoesDAO {

    public void create(Simulacoes simulacao) throws SQLException {
        String sql = "INSERT INTO Simulacoes (Direitor_das_simulaçoes, Piloto1, Piloto2, Pilotos_idPilotos) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, simulacao.getDireitorDasSimulacoes());
            stmt.setString(2, simulacao.getPiloto1());
            stmt.setString(3, simulacao.getPiloto2());
            stmt.setInt(4, simulacao.getPilotosIdPilotos());
            stmt.executeUpdate();
        }
    }

    public Simulacoes read(String direitorDasSimulacoes) throws SQLException {
        String sql = "SELECT * FROM Simulacoes WHERE Direitor_das_simulaçoes = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, direitorDasSimulacoes);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Simulacoes(
                        rs.getString("Direitor_das_simulaçoes"),
                        rs.getString("Piloto1"),
                        rs.getString("Piloto2"),
                        rs.getInt("Pilotos_idPilotos")
                );
            }
        }
        return null;
    }

    public void update(Simulacoes simulacao) throws SQLException {
        String sql = "UPDATE Simulacoes SET Piloto1 = ?, Piloto2 = ?, Pilotos_idPilotos = ? WHERE Direitor_das_simulaçoes = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, simulacao.getPiloto1());
            stmt.setString(2, simulacao.getPiloto2());
            stmt.setInt(3, simulacao.getPilotosIdPilotos());
            stmt.setString(4, simulacao.getDireitorDasSimulacoes());
            stmt.executeUpdate();
        }
    }

    public void delete(String direitorDasSimulacoes) throws SQLException {
        String sql = "DELETE FROM Simulacoes WHERE Direitor_das_simulaçoes = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, direitorDasSimulacoes);
            stmt.executeUpdate();
        }
    }

    public List<Simulacoes> getAll() throws SQLException {
        List<Simulacoes> simulacoes = new ArrayList<>();
        String sql = "SELECT * FROM Simulacoes";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Simulacoes simulacao = new Simulacoes(
                        rs.getString("Direitor_das_simulaçoes"),
                        rs.getString("Piloto1"),
                        rs.getString("Piloto2"),
                        rs.getInt("Pilotos_idPilotos")
                );
                simulacoes.add(simulacao);
            }
        }
        return simulacoes;
    }
}
