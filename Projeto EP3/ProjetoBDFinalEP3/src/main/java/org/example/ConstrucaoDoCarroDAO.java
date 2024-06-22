package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConstrucaoDoCarroDAO {

    public void create(Construcao_do_carro carro) throws SQLException {
        String sql = "INSERT INTO Construcao_do_carro (Projetista, Setor_de_peças_Direto_Setor_peças, Materias_primas_Responsavel, Setor_de_motores_Direitor_do_setor_de_motores) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, carro.getProjetista());
            stmt.setString(2, carro.getSetorDePecasDiretoSetorPecas());
            stmt.setString(3, carro.getMateriasPrimasResponsavel());
            stmt.setString(4, carro.getSetorDeMotoresDireitorDoSetorDeMotores());
            stmt.executeUpdate();
        }
    }

    public Construcao_do_carro read(String projetista) throws SQLException {
        String sql = "SELECT * FROM Construcao_do_carro WHERE Projetista = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, projetista);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Construcao_do_carro(
                        rs.getString("Projetista"),
                        rs.getString("Setor_de_peças_Direto_Setor_peças"),
                        rs.getString("Materias_primas_Responsavel"),
                        rs.getString("Setor_de_motores_Direitor_do_setor_de_motores")
                );
            }
        }
        return null;
    }

    public void update(Construcao_do_carro carro) throws SQLException {
        String sql = "UPDATE Construcao_do_carro SET Setor_de_peças_Direto_Setor_peças = ?, Materias_primas_Responsavel = ?, Setor_de_motores_Direitor_do_setor_de_motores = ? WHERE Projetista = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, carro.getSetorDePecasDiretoSetorPecas());
            stmt.setString(2, carro.getMateriasPrimasResponsavel());
            stmt.setString(3, carro.getSetorDeMotoresDireitorDoSetorDeMotores());
            stmt.setString(4, carro.getProjetista());
            stmt.executeUpdate();
        }
    }

    public void delete(String projetista) throws SQLException {
        String sql = "DELETE FROM Construcao_do_carro WHERE Projetista = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, projetista);
            stmt.executeUpdate();
        }
    }

    public List<Construcao_do_carro> getAll() throws SQLException {
        List<Construcao_do_carro> carros = new ArrayList<>();
        String sql = "SELECT * FROM Construcao_do_carro";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Construcao_do_carro carro = new Construcao_do_carro(
                        rs.getString("Projetista"),
                        rs.getString("Setor_de_peças_Direto_Setor_peças"),
                        rs.getString("Materias_primas_Responsavel"),
                        rs.getString("Setor_de_motores_Direitor_do_setor_de_motores")
                );
                carros.add(carro);
            }
        }
        return carros;
    }
}
