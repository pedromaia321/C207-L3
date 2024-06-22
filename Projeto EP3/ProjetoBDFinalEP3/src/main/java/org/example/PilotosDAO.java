package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class PilotosDAO {

    public void create(Pilotos piloto) throws SQLException {
        String sql = "INSERT INTO Pilotos (nome, Idade, nível) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, piloto.getNome());
            stmt.setInt(2, piloto.getIdade());
            stmt.setInt(3, piloto.getNivel());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                piloto.setIdPilotos(generatedKeys.getInt(1));
            }
        }
    }


    public Pilotos read(int idPilotos) throws SQLException {
        String sql = "SELECT * FROM Pilotos WHERE idPilotos = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPilotos);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Pilotos(
                        rs.getInt("idPilotos"),
                        rs.getString("nome"),
                        rs.getInt("Idade"),
                        rs.getInt("nível")
                );
            }
        }
        return null;
    }

    public void update(Pilotos piloto) throws SQLException {
        String sql = "UPDATE Pilotos SET nome = ?, Idade = ?, nível = ? WHERE idPilotos = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, piloto.getNome());
            stmt.setInt(2, piloto.getIdade());
            stmt.setInt(3, piloto.getNivel());
            stmt.setInt(4, piloto.getIdPilotos());
            stmt.executeUpdate();
        }
    }

    public void delete(int idPilotos) throws SQLException {
        String sql = "DELETE FROM Pilotos WHERE idPilotos = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPilotos);
            stmt.executeUpdate();
        }
    }

    public List<Pilotos> getAll() throws SQLException {
        List<Pilotos> pilotos = new ArrayList<>();
        String sql = "SELECT * FROM Pilotos";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pilotos piloto = new Pilotos(
                        rs.getInt("idPilotos"),
                        rs.getString("nome"),
                        rs.getInt("Idade"),
                        rs.getInt("nível")
                );
                pilotos.add(piloto);
            }
        }
        return pilotos;
    }
}
