package com.erms.app.uis;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AuthApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Authentification");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Utilisateur:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 160, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Mot de passe:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 160, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Connexion");
        loginButton.setBounds(10, 80, 250, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                String token = authenticate(username, password);
                if(token==null) {
                JOptionPane.showMessageDialog(panel, "Token: " + token);
                }
                    //     SwingUtilities.invokeLater(() -> new MainWindow(Role.ADMIN).setVisible(true)); // ou Role.DOCTOR, Role.NURSE
                
            }
        });
    }

    private static String authenticate(String username, String password) {
        try {
            URL url = new URL("http://localhost:8085/api/auth/login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            String jsonInputString = "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";
        System.out.println(jsonInputString);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                    
                }
           //     System.out.println(response.toString());
                return response.toString();
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
