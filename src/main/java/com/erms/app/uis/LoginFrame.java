package com.erms.app.uis;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.io.IOException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class LoginFrame extends JFrame {
	 private JTextField usernameField;
	    private JPasswordField passwordField;
	    
	    
	    public LoginFrame() {
	        setTitle("Login");
	        setSize(300, 150);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        JPanel panel = new JPanel();
	        add(panel);
	        placeComponents(panel);

	        setVisible(true);
	    }
	    
	    private void placeComponents(JPanel panel) {
	        panel.setLayout(null);

	        JLabel usernameLabel = new JLabel("Username:");
	        usernameLabel.setBounds(10, 20, 80, 25);
	        panel.add(usernameLabel);

	        usernameField = new JTextField(20);
	        usernameField.setBounds(100, 20, 165, 25);
	        panel.add(usernameField);

	        JLabel passwordLabel = new JLabel("Password:");
	        passwordLabel.setBounds(10, 50, 80, 25);
	        panel.add(passwordLabel);

	        passwordField = new JPasswordField(20);
	        passwordField.setBounds(100, 50, 165, 25);
	        panel.add(passwordField);

	        JButton loginButton = new JButton("Login");
	        loginButton.setBounds(10, 80, 80, 25);
	        panel.add(loginButton);

	        loginButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String username = usernameField.getText();
	                String password = new String(passwordField.getPassword());
	                authenticate(username, password);
	            }
	        });
	    }
	    

/*	    private void authenticate(String username, String password) {
	        try (CloseableHttpClient httpClient = HttpClients.custom()
	                .setDefaultRequestConfig(RequestConfig.custom()
	                    .setCircularRedirectsAllowed(true)
	                    .build())
	                .build()) {
	            HttpPost request = new HttpPost("http://localhost:8085/api/auth/login");
	            request.setHeader("Content-Type", "application/json");

	            String jsonInputString = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", username, password);
	            StringEntity entity = new StringEntity(jsonInputString);
	            request.setEntity(entity);

	            try (CloseableHttpResponse response = httpClient.execute(request)) {
	                int code = response.getStatusLine().getStatusCode();
	                
	                System.out.println("Response code: " + code);

	                if (code == 200) {
	                    System.out.println("Authentication successful");
	                } else {
	                    String responseBody = EntityUtils.toString(response.getEntity());
	                    System.out.println("Authentication failed: " + responseBody);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }*/
	    
	    private void authenticate(String username, String password) {
	        try (CloseableHttpClient httpClient = HttpClients.custom()
	                .setDefaultRequestConfig(RequestConfig.custom()
	                    .setCircularRedirectsAllowed(true)
	                    .build())
	                .build()) {
	            HttpPost request = new HttpPost("http://localhost:8085/api/auth");
	            request.setHeader("Content-Type", "application/json");

	            String jsonInputString = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", username, password);
	            StringEntity entity = new StringEntity(jsonInputString);
	            request.setEntity(entity);

	            try (CloseableHttpResponse response = httpClient.execute(request)) {
	                int code = response.getStatusLine().getStatusCode();
	                System.out.println("Response code: " + code);

	                // Afficher les en-têtes de réponse
	                for (Header header : response.getAllHeaders()) {
	                    System.out.println(header.getName() + ": " + header.getValue());
	                }

	                if (code == 200) {
	                    System.out.println("Authentication successful");
	                } else if (code == 302) {
	                    String location = response.getFirstHeader("Location").getValue();
	                    System.out.println("Redirection to: " + location);
	                    // Vous pouvez maintenant gérer la redirection ici
	                } else {
	                    String responseBody = EntityUtils.toString(response.getEntity());
	                    System.out.println("Authentication failed: " + responseBody);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new LoginFrame());
	    }
}
