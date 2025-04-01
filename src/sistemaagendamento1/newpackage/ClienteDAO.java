package sistemaagendamento1.newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    public void cadastrarCliente(String nome, String telefone, String email) {
        String sql = "INSERT INTO clientes (nome, telefone, email) VALUES (?, ?, ?)";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, telefone);
            stmt.setString(3, email);
            stmt.executeUpdate();
            System.out.println("✅ Cliente cadastrado com sucesso!");

        } catch (SQLException e) {
            System.err.println("❌ Erro ao cadastrar cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listarClientes() {
        String sql = "SELECT * FROM clientes";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("📋 Lista de Clientes:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   " | Nome: " + rs.getString("nome") +
                                   " | Telefone: " + rs.getString("telefone") +
                                   " | Email: " + rs.getString("email"));
            }

        } catch (SQLException e) {
            System.err.println("❌ Erro ao listar clientes: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
