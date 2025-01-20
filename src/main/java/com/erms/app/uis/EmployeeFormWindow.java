package com.erms.app.uis;

import com.erms.app.entity.Employee;
import com.erms.app.service.EmployeeService;
import com.erms.app.service.EmployeeServiceTemplate;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class EmployeeFormWindow extends JFrame {
    private JTextField nameField, birthDateField;
    private JButton saveButton;
    private EmployeeServiceTemplate employeeServiceTemplate;
    private Employee employee;

    public EmployeeFormWindow(EmployeeServiceTemplate employeeServiceTemplate, Employee employee) {
        this.employeeServiceTemplate = employeeServiceTemplate;
        this.employee = employee;

        setTitle(employee == null ? "Ajouter Patient" : "Modifier Patient");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));

        nameField = new JTextField(employee != null ? employee.getFullName() : "");
        birthDateField = new JTextField(employee != null ? employee.getHireDate().toString() : "");
        saveButton = new JButton(employee == null ? "Ajouter" : "Modifier");

        add(new JLabel("Nom:"));
        add(nameField);
        add(new JLabel("Date de Naissance:"));
        add(birthDateField);
        add(saveButton);

       // saveButton.addActionListener(e -> savePatient());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

  /*  private void savePatient() {
        String name = nameField.getText();
        LocalDate birthDate = LocalDate.parse(birthDateField.getText());

        if (patient == null) {
            patient = new Patient();
        }
        patient.setName(name);
        patient.setBirthDate(birthDate);

        if (patient.getId() == null) {
            patientService.save(patient);
        } else {
            patientService.update(patient.getId(), patient);
        }
        dispose();
    }*/
}
