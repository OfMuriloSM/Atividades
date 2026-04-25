package org.example.dao;

import org.example.model.Denuncia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DenunciaDAO {
    private Connection connection;

    public DenunciaDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void salvar(Denuncia denuncia) {
        String sql = "INSERT INTO denuncia (titulo, descricao, status) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, denuncia.getTitulo());
            stmt.setString(2, denuncia.getDescricao());
            stmt.setString(3, denuncia.getStatus());
            stmt.executeUpdate();
            System.out.println("Denúncia salva com sucesso no banco!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar denúncia: " + e.getMessage());
        }
    }

     public List<Denuncia> listarTodas() {
        List<Denuncia> listaDeDenuncias = new ArrayList<>();
        String sql = "SELECT * FROM denuncia";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Denuncia d = new Denuncia(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getString("status")
                );
                listaDeDenuncias.add(d);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar denúncias: " + e.getMessage());
        }
        return listaDeDenuncias;
    }
    public void atualizarStatus(int id, String novoStatus) {
        String sql = "UPDATE denuncia SET status = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, novoStatus);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Status atualizado para: " + novoStatus);
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar status: " + e.getMessage());
        }
    }
}