package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FinancasDAO {

    public void create(Financas financas) throws SQLException {
        String sql = "INSERT INTO Finanças (Diretor_financeiro, Contador, Salarios, Valor_investido_no_carro) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, financas.getDiretorFinanceiro());
            stmt.setString(2, financas.getContador());
            stmt.setInt(3, financas.getSalarios());
            stmt.setInt(4, financas.getValorInvestidoNoCarro());
            stmt.executeUpdate();
        }
    }

    public Financas read(String diretorFinanceiro) throws SQLException {
        String sql = "SELECT * FROM Finanças WHERE Diretor_financeiro = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, diretorFinanceiro);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Financas(
                        rs.getString("Diretor_financeiro"),
                        rs.getString("Contador"),
                        rs.getInt("Salarios"),
                        rs.getInt("Valor_investido_no_carro")
                );
            }
        }
        return null;
    }

    public void update(Financas financas) throws SQLException {
        String sql = "UPDATE Finanças SET Contador = ?, Salarios = ?, Valor_investido_no_carro = ? WHERE Diretor_financeiro = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, financas.getContador());
            stmt.setInt(2, financas.getSalarios());
            stmt.setInt(3, financas.getValorInvestidoNoCarro());
            stmt.setString(4, financas.getDiretorFinanceiro());
            stmt.executeUpdate();
        }
    }

    public void delete(String diretorFinanceiro) throws SQLException {
        String sql = "DELETE FROM Finanças WHERE Diretor_financeiro = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, diretorFinanceiro);
            stmt.executeUpdate();
        }
    }

    public List<Financas> getAll() throws SQLException {
        List<Financas> financasList = new ArrayList<>();
        String sql = "SELECT * FROM Finanças";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Financas financas = new Financas(
                        rs.getString("Diretor_financeiro"),
                        rs.getString("Contador"),
                        rs.getInt("Salarios"),
                        rs.getInt("Valor_investido_no_carro")
                );
                financasList.add(financas);
            }
        }
        return financasList;
    }
}
