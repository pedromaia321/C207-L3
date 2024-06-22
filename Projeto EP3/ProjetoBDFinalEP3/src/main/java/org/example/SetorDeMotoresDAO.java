package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SetorDeMotoresDAO {

    public void create(Setor_de_motores setor) throws SQLException {
        String sql = "INSERT INTO Setor_de_motores (Direitor_do_setor_de_motores, Quanti_de_funci, Quanti_para_pesquisa) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, setor.getDireitor_do_setor_de_motores());
            stmt.setInt(2, setor.getQuanti_de_funci());
            stmt.setInt(3, setor.getQuanti_para_pesquisa());
            stmt.executeUpdate();
        }
    }

    public Setor_de_motores read(String direitorSetorMotores) throws SQLException {
        String sql = "SELECT * FROM Setor_de_motores WHERE Direitor_do_setor_de_motores = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, direitorSetorMotores);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Setor_de_motores(
                        rs.getString("Direitor_do_setor_de_motores"),
                        rs.getInt("Quanti_de_funci"),
                        rs.getInt("Quanti_para_pesquisa")
                );
            }
        }
        return null;
    }

    public void update(Setor_de_motores setor) throws SQLException {
        String sql = "UPDATE Setor_de_motores SET Quanti_de_funci = ?, Quanti_para_pesquisa = ? WHERE Direitor_do_setor_de_motores = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, setor.getQuanti_de_funci());
            stmt.setInt(2, setor.getQuanti_para_pesquisa());
            stmt.setString(3, setor.getDireitor_do_setor_de_motores());
            stmt.executeUpdate();
        }
    }

    public void delete(String direitorSetorMotores) throws SQLException {
        String sql = "DELETE FROM Setor_de_motores WHERE Direitor_do_setor_de_motores = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, direitorSetorMotores);
            stmt.executeUpdate();
        }
    }

    public List<Setor_de_motores> getAll() throws SQLException {
        List<Setor_de_motores> setores = new ArrayList<>();
        String sql = "SELECT * FROM Setor_de_motores";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Setor_de_motores setor = new Setor_de_motores(
                        rs.getString("Direitor_do_setor_de_motores"),
                        rs.getInt("Quanti_de_funci"),
                        rs.getInt("Quanti_para_pesquisa")
                );
                setores.add(setor);
            }
        }
        return setores;
    }
}
