package com.erms.app.uis;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

import com.erms.app.config.AppConfigRestTemplate;
import com.erms.app.entity.Employee;
//import com.erms.app.entity.Role;
import com.erms.app.service.EmployeeService;
import com.erms.app.service.EmployeeServiceTemplate;

/*
import com.votreprojet.config.AppConfig;
import com.votreprojet.models.Patient;
import com.votreprojet.models.Role;
import com.votreprojet.services.PatientService;
import com.votreprojet.services.PatientService2;
import com.votreprojet.services.PatientServiceTemplate;
*/
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {
    private JTable patientTable;
    private JButton addButton, updateButton, deleteButton;
  //  private EmployeeServiceTemplate employeeService;
    private EmployeeService employeeService;
    public MainWindow(Role role) {
        // Créez un contexte Spring uniquement pour obtenir les employee
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigRestTemplate.class);
        RestTemplate restTemplate = context.getBean(RestTemplate.class);
      //  employeeService = new EmployeeService(restTemplate); // Passez le restTemplate au service

        setTitle("Gestion des EMPLOYEE");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        patientTable = new JTable();
        add(new JScrollPane(patientTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        if (role == Role.ADMIN) {
            addButton = new JButton("Ajouter");
            updateButton = new JButton("Modifier");
            deleteButton = new JButton("Supprimer");

            buttonPanel.add(addButton);
            buttonPanel.add(updateButton);
            buttonPanel.add(deleteButton);

            /*        addButton.addActionListener(e -> addPatient());
           updateButton.addActionListener(e -> updatePatient());
            deleteButton.addActionListener(e -> deletePatient());*/
        } else if (role == Role.NURSE) {
            updateButton = new JButton("Modifier");

            buttonPanel.add(updateButton);
     //       updateButton.addActionListener(e -> updatePatient());
        }

        add(buttonPanel, BorderLayout.SOUTH);
        loadPatients();
    }

    private void loadPatients() {
        List<Employee> patients = employeeService.getAllEmployee();
        DefaultTableModel model = new DefaultTableModel(new Object[]{"getJobTitle", "getFullName", "getHireDate"}, 0);
        for (Employee patient : patients) {
            model.addRow(new Object[]{patient.getJobTitle(), patient.getFullName(), patient.getHireDate()});
        }
        patientTable.setModel(model);
    }

   /* private void addPatient() {
        EmployeeFormWindow formWindow = new EmployeeFormWindow(employeeService, null);
        formWindow.setVisible(true);
        formWindow.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                loadPatients();
            }
        });
    }*/

  /*
    private void updatePatient() {
        int selectedRow = patientTable.getSelectedRow();
        if (selectedRow >= 0) {
            Long id = (Long) patientTable.getValueAt(selectedRow, 0);
            Patient patient = patientService.findById(id).orElse(null);
            if (patient != null) {
                PatientFormWindow formWindow = new PatientFormWindow(patientService, patient);
                formWindow.setVisible(true);
                formWindow.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        loadPatients();
                    }
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un patient à modifier.");
        }
    }*/

 /*   private void deletePatient() {
        int selectedRow = patientTable.getSelectedRow();
        if (selectedRow >= 0) {
            Long id = (Long) patientTable.getValueAt(selectedRow, 0);
            patientService.delete(id);
            loadPatients();
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un patient à supprimer.");
        }
    }*/

    
    
/*    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        SwingUtilities.invokeLater(() -> new MainWindow(Role.ADMIN).setVisible(true)); // ou Role.DOCTOR, Role.NURSE
    }*/
}
