package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SetorDePecasDAO {

    public void create(Setor_de_pecas setor) throws SQLException {
        // Verifica se o registro já existe
        if (exists(setor.getdiretor_Setor_pecas())) {
            System.out.println("Registro já existe na tabela Setor_de_peças.");
            return; // Ou pode lançar uma exceção, dependendo do seu caso
        }

        String sql = "INSERT INTO Setor_de_peças (Direto_Setor_peças, Peças_quantidade, Quanti_de_funcio) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, setor.getdiretor_Setor_pecas());
            stmt.setInt(2, setor.getPecasQuantidade());
            stmt.setInt(3, setor.getQuantiDeFuncio());
            stmt.executeUpdate();
        }
    }

    public Setor_de_pecas read(String diretoSetorPecas) throws SQLException {
        String sql = "SELECT * FROM Setor_de_peças WHERE Direto_Setor_peças = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, diretoSetorPecas);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Setor_de_pecas(
                        rs.getString("Direto_Setor_peças"),
                        rs.getInt("Peças_quantidade"),
                        rs.getInt("Quanti_de_funcio")
                );
            }
        }
        return null;
    }

    public void update(Setor_de_pecas setor) throws SQLException {
        String sql = "UPDATE Setor_de_peças SET Peças_quantidade = ?, Quanti_de_funcio = ? WHERE Direto_Setor_peças = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, setor.getPecasQuantidade());
            stmt.setInt(2, setor.getQuantiDeFuncio());
            stmt.setString(3, setor.getdiretor_Setor_pecas());
            stmt.executeUpdate();
        }
    }

    public void delete(String diretoSetorPecas) throws SQLException {
        String sql = "DELETE FROM Setor_de_peças WHERE Direto_Setor_peças = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, diretoSetorPecas);
            stmt.executeUpdate();
        }
    }

    public List<Setor_de_pecas> getAll() throws SQLException {
        List<Setor_de_pecas> setores = new ArrayList<>();
        String sql = "SELECT * FROM Setor_de_peças";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Setor_de_pecas setor = new Setor_de_pecas(
                        rs.getString("Direto_Setor_peças"),
                        rs.getInt("Peças_quantidade"),
                        rs.getInt("Quanti_de_funcio")
                );
                setores.add(setor);
            }
        }
        return setores;
    }

    // Método auxiliar para verificar se o registro já existe
    private boolean exists(String diretoSetorPecas) throws SQLException {
        Setor_de_pecas existingSetor = read(diretoSetorPecas);
        return existingSetor != null;
    }
}
