import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Homepage extends JFrame {
    private JLabel titleLabel;
    private JLabel userGreetingLabel;
    private JButton viewProfileButton;
    private JButton settingsButton;
    private JButton logoutButton;

    public Homepage() {
        initComponents();
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the form
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        titleLabel = new JLabel("Welcome to the Homepage", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        userGreetingLabel = new JLabel("Hello, User!", SwingConstants.CENTER);

        viewProfileButton = new JButton("View Profile");
        settingsButton = new JButton("Settings");
        logoutButton = new JButton("Logout");

        // Action listeners
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose(); // Close Homepage
                new LoginForm().setVisible(true); // Go back to LoginForm
            }
        });

        // Layout using GroupLayout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(titleLabel)
                .addComponent(userGreetingLabel)
                .addComponent(viewProfileButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addComponent(settingsButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(titleLabel)
                .addComponent(userGreetingLabel)
                .addComponent(viewProfileButton)
                .addComponent(settingsButton)
                .addComponent(logoutButton)
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Homepage().setVisible(true);
        });
    }
}
