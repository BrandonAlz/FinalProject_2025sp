import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SScreen extends JFrame {
    CardLayout card;
    JPanel main;

    public SScreen() {
        setTitle("Final Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        card = new CardLayout();
        main = new JPanel(card);

        main.add(createTitleScreen(), "Title");
        main.add(createCharacterCreationScreen(), "CharacterCreation");

        add(main);
        card.show(main, "Title");
        setVisible(true);
    }

    private JPanel createTitleScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Final Quest", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(e -> card.show(main, "CharacterCreation"));
        panel.add(startButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createCharacterCreationScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setFont(new Font("Arial", Font.PLAIN, 36));
        JTextField named = new JTextField(); 
        
        panel.setFont(new Font("Arial", Font.PLAIN, 36));
        String[] classes = {"Knight", "Mage", "Archer"};
        JComboBox<String> classBox = new JComboBox<>(classes);
        
        
        panel.add(new JLabel("Character Name:"));
        panel.setFont(new Font("Arial", Font.PLAIN, 36));
        panel.add(named);
        named.setFont(new Font("Arial", Font.PLAIN, 36));
        panel.add(new JLabel("Class:"));
        panel.add(classBox);
        classBox.setFont(new Font("Arial", Font.PLAIN, 36));
       
       
        panel.add(new JLabel()); // empty placeholder
        JButton createButton = new JButton("Create Character");

        createButton.addActionListener(e -> {
            String name = named.getText();
            String chosenClass = (String) classBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, "Character Created!\nname: " + name + "\nClass: " + chosenClass);
        });

        panel.add(createButton);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SScreen::new);
    }
}