package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static Connection connection = null;

    private DatabaseConnection() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:sqlite:denuncias.db";
                connection = DriverManager.getConnection(url);
                criarTabela();
                System.out.println("Conexão com SQLite estabelecida!");
            } catch (SQLException e) {
                System.out.println("Erro ao conectar no banco: " + e.getMessage());
            }
        }
        return connection;
    }

    private static void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS denuncia (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo TEXT NOT NULL," +
                "descricao TEXT NOT NULL," +
                "status TEXT NOT NULL" +
                ");";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}