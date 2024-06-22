package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SedeDaEquipeDAO {

    public void create(Sede_da_Equipe equipe) throws SQLException {
        String sql = "INSERT INTO Sede_da_Equipe (Nome_presidente, Quantidade_funci, Localização, Setor_de_peças_Direto_Setor_peças, Finanças_Diretor_financeiro, Setor_de_motores_Direitor_do_setor_de_motores, Contrucao_do_carro_Projetista, Materias_primas_Responsavel) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, equipe.getNomePresidente());
            stmt.setInt(2, equipe.getQuantidadeFunci());
            stmt.setString(3, equipe.getLocalizacao());
            stmt.setString(4, equipe.getSetorDePecasDiretoSetorPecas());
            stmt.setString(5, equipe.getFinancasDiretorFinanceiro());
            stmt.setString(6, equipe.getSetorDeMotoresDireitorDoSetorDeMotores());
            stmt.setString(7, equipe.getContrucaoDoCarroProjetista());
            stmt.setString(8, equipe.getMateriasPrimasResponsavel());
            stmt.executeUpdate();
        }
    }

    public Sede_da_Equipe read(String nomePresidente) throws SQLException {
        String sql = "SELECT * FROM Sede_da_Equipe WHERE Nome_presidente = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomePresidente);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Sede_da_Equipe(
                        rs.getString("Nome_presidente"),
                        rs.getInt("Quantidade_funci"),
                        rs.getString("Localização"),
                        rs.getString("Setor_de_peças_Direto_Setor_peças"),
                        rs.getString("Finanças_Diretor_financeiro"),
                        rs.getString("Setor_de_motores_Direitor_do_setor_de_motores"),
                        rs.getString("Contrucao_do_carro_Projetista"),
                        rs.getString("Materias_primas_Responsavel")
                );
            }
        }
        return null;
    }

    public void update(Sede_da_Equipe equipe) throws SQLException {
        String sql = "UPDATE Sede_da_Equipe SET Quantidade_funci = ?, Localização = ?, Setor_de_peças_Direto_Setor_peças = ?, Finanças_Diretor_financeiro = ?, Setor_de_motores_Direitor_do_setor_de_motores = ?, Contrucao_do_carro_Projetista = ?, Materias_primas_Responsavel = ? WHERE Nome_presidente = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, equipe.getQuantidadeFunci());
            stmt.setString(2, equipe.getLocalizacao());
            stmt.setString(3, equipe.getSetorDePecasDiretoSetorPecas());
            stmt.setString(4, equipe.getFinancasDiretorFinanceiro());
            stmt.setString(5, equipe.getSetorDeMotoresDireitorDoSetorDeMotores());
            stmt.setString(6, equipe.getContrucaoDoCarroProjetista());
            stmt.setString(7, equipe.getMateriasPrimasResponsavel());
            stmt.setString(8, equipe.getNomePresidente());
            stmt.executeUpdate();
        }
    }

    public void delete(String nomePresidente) throws SQLException {
        String sql = "DELETE FROM Sede_da_Equipe WHERE Nome_presidente = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomePresidente);
            stmt.executeUpdate();
        }
    }

    public List<Sede_da_Equipe> getAll() throws SQLException {
        List<Sede_da_Equipe> equipes = new ArrayList<>();
        String sql = "SELECT * FROM Sede_da_Equipe";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Sede_da_Equipe equipe = new Sede_da_Equipe(
                        rs.getString("Nome_presidente"),
                        rs.getInt("Quantidade_funci"),
                        rs.getString("Localização"),
                        rs.getString("Setor_de_peças_Direto_Setor_peças"),
                        rs.getString("Finanças_Diretor_financeiro"),
                        rs.getString("Setor_de_motores_Direitor_do_setor_de_motores"),
                        rs.getString("Contrucao_do_carro_Projetista"),
                        rs.getString("Materias_primas_Responsavel")
                );
                equipes.add(equipe);
            }
        }
        return equipes;
    }
}
