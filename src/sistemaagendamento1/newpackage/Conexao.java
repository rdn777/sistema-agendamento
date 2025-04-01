package sistemaagendamento1.newpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/barbearia_db";
    private static final String USUARIO = "rd";  // Alterar se necessário
    private static final String SENHA = "120624rn";  // Coloque a senha correta do MySQL

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.err.println("❌ Erro na conexão com o banco de dados: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
