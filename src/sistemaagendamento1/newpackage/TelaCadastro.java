package sistemaagendamento1.newpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TelaCadastro extends JFrame {

    public TelaCadastro() {
        setTitle("Cadastro - Amaral Barbearia");
        setSize(900, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JPanel painel = new JPanel();
        painel.setBackground(Color.BLACK);
        painel.setBounds(0, 0, 900, 350);
        painel.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setForeground(Color.WHITE);
        lblNome.setBounds(50, 50, 100, 25);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(50, 75, 200, 30);

        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setBounds(50, 120, 100, 25);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(50, 145, 200, 30);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setBounds(300, 50, 100, 25);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(300, 75, 200, 30);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setForeground(Color.WHITE);
        lblSenha.setBounds(300, 120, 100, 25);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(300, 145, 200, 30);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(50, 190, 120, 30);
        btnCadastrar.setBackground(new Color(0, 200, 255));

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario(txtNome.getText(), txtEmail.getText(), txtUsuario.getText(), new String(txtSenha.getPassword()));
            }
        });

        painel.add(lblNome);
        painel.add(txtNome);
        painel.add(lblEmail);
        painel.add(txtEmail);
        painel.add(lblUsuario);
        painel.add(txtUsuario);
        painel.add(lblSenha);
        painel.add(txtSenha);
        painel.add(btnCadastrar);
        add(painel);
    }

    private void cadastrarUsuario(String nome, String email, String usuario, String senha) {
        try (Connection conexao = Conexao.conectar()) {
            String sql = "INSERT INTO usuarios (nome, email, usuario, senha) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, usuario);
            stmt.setString(4, senha);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
            new TelaLogin().setVisible(true);
            dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + e.getMessage());
        }
    }
}
