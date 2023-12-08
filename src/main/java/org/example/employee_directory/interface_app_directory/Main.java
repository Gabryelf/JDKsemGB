package org.example.employee_directory.interface_app_directory;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        DirectoryApp directoryApp = new DirectoryApp();

        JFrame frame = new JFrame("Employee Directory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        JLabel idLabel = new JLabel("Employee ID:");
        JTextField idField = new JTextField(10);
        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneField = new JTextField(10);
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(10);
        JLabel experienceLabel = new JLabel("Experience:");
        JTextField experienceField = new JTextField(10);

        JButton addButton = new JButton("Add Employee");
        addButton.addActionListener(e -> {
            int employeeId = Integer.parseInt(idField.getText());
            String phoneNumber = phoneField.getText();
            String name = nameField.getText();
            int experience = Integer.parseInt(experienceField.getText());

            Employee employee = new Employee(employeeId, phoneNumber, name, experience);
            directoryApp.addEmployee(employee);
            JOptionPane.showMessageDialog(null, "Employee added successfully");
        });

        JButton searchButton = new JButton("Search Employee by ID");
        searchButton.addActionListener(e -> {
            int employeeId = Integer.parseInt(idField.getText());

            Employee employee = directoryApp.searchByEmployeeId(employeeId);
            if (employee != null) {
                JOptionPane.showMessageDialog(null, employee.getName() + " - " + employee.getPhoneNumber());
            } else {
                JOptionPane.showMessageDialog(null, "Employee not found");
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(experienceLabel);
        panel.add(experienceField);
        panel.add(addButton);
        panel.add(searchButton);

        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}

