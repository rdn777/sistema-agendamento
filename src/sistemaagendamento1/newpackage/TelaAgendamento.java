package sistemaagendamento1.newpackage;

import javax.swing.*;
import java.awt.*;

public class TelaAgendamento extends JFrame {
    public TelaAgendamento() {
        setTitle("Agendamento");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Background Image
        JLabel background = new JLabel(new ImageIcon("barbershop.png"));
        background.setBounds(0, 0, 800, 400);

        // Input field
        JTextField dataField = new JTextField("Selecione a data");
        dataField.setBounds(20, 50, 200, 30);
        dataField.setBackground(Color.LIGHT_GRAY);

        // Agendar button
        JButton agendarButton = new JButton("Agendar");
        agendarButton.setBounds(20, 100, 100, 30);
        agendarButton.setBackground(new Color(0, 200, 255));

        // Layered Pane to add components over the image
        JLayeredPane layeredPane = getLayeredPane();
        layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(dataField, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(agendarButton, JLayeredPane.PALETTE_LAYER);

        setVisible(true); // Garante que a tela seja exibida
    }
}
