package sistemaagendamento1.newpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaLogin extends JFrame {

    public TelaLogin() {
        setTitle("Login - Amaral Barbearia");
        setSize(900, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JPanel painel = new JPanel();
        painel.setBackground(Color.BLACK);
        painel.setBounds(0, 0, 900, 350);
        painel.setLayout(null);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setBounds(50, 50, 100, 25);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(50, 75, 200, 30);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setForeground(Color.WHITE);
        lblSenha.setBounds(50, 120, 100, 25);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(50, 145, 200, 30);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(50, 190, 100, 30);
        btnEntrar.setBackground(new Color(0, 200, 255));

        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autenticarUsuario(txtUsuario.getText(), new String(txtSenha.getPassword()));
            }
        });

        painel.add(lblUsuario);
        painel.add(txtUsuario);
        painel.add(lblSenha);
        painel.add(txtSenha);
        painel.add(btnEntrar);
        add(painel);
    }

    private void autenticarUsuario(String usuario, String senha) {
        try (Connection conexao = Conexao.conectar()) {
            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
                new TelaAgendamento().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro no login: " + e.getMessage());
        }
    }
}
