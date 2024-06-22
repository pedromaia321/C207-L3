package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriasPrimasDAO {

    public void create(Materias_primas materia) throws SQLException {
        String sql = "INSERT INTO Materias_primas (Responsavel, Materias_primas_adquiridas, Quantidade) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, materia.getResponsavel());
            stmt.setString(2, materia.getMateriasPrimasAdquiridas());
            stmt.setInt(3, materia.getQuantidade());
            stmt.executeUpdate();
        }
    }

    public Materias_primas read(String responsavel) throws SQLException {
        String sql = "SELECT * FROM Materias_primas WHERE Responsavel = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, responsavel);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Materias_primas(
                        rs.getString("Responsavel"),
                        rs.getString("Materias_primas_adquiridas"),
                        rs.getInt("Quantidade")
                );
            }
        }
        return null;
    }

    public void update(Materias_primas materia) throws SQLException {
        String sql = "UPDATE Materias_primas SET Materias_primas_adquiridas = ?, Quantidade = ? WHERE Responsavel = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, materia.getMateriasPrimasAdquiridas());
            stmt.setInt(2, materia.getQuantidade());
            stmt.setString(3, materia.getResponsavel());
            stmt.executeUpdate();
        }
    }

    public void delete(String responsavel) throws SQLException {
        String sql = "DELETE FROM Materias_primas WHERE Responsavel = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, responsavel);
            stmt.executeUpdate();
        }
    }

    public List<Materias_primas> getAll() throws SQLException {
        List<Materias_primas> materiasList = new ArrayList<>();
        String sql = "SELECT * FROM Materias_primas";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Materias_primas materia = new Materias_primas(
                        rs.getString("Responsavel"),
                        rs.getString("Materias_primas_adquiridas"),
                        rs.getInt("Quantidade")
                );
                materiasList.add(materia);
            }
        }
        return materiasList;
    }
}
