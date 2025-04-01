package sistemaagendamento1.newpackage;

import java.sql.*;

public class UsuarioDAO {
    public boolean cadastrarUsuario(String nome, String email, String senha) {
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
            return false;
        }
    }

    public boolean validarLogin(String email, String senha) {
        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Erro ao validar login: " + e.getMessage());
            return false;
        }
    }
}
