package Homework3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MilestoneCalculator extends JFrame {
    private JLabel lblStudentName, lblStudentNo, lblMilestone1, lblMilestone2, lblTerminalAssessment;
    private JTextField txtStudentName, txtStudentNo, txtMilestone1, txtMilestone2, txtTerminalAssessment;
    private JButton calculateButton, clearButton, exitButton;

    public MilestoneCalculator() {
        super("Milestone Calculator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        // Create components
        lblStudentName = new JLabel("Student Name:");
        txtStudentName = new JTextField(30);
        lblStudentNo = new JLabel("Student No:");
        txtStudentNo = new JTextField(30);
        lblMilestone1 = new JLabel("Milestone 1 (Max 25):");
        txtMilestone1 = new JTextField(10);
        lblMilestone2 = new JLabel("Milestone 2 (Max 40):");
        txtMilestone2 = new JTextField(10);
        lblTerminalAssessment = new JLabel("Terminal Assessment (Max 35):");
        txtTerminalAssessment = new JTextField(10);

        calculateButton = new JButton("Calculate");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        // Define panel and layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Add components to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblStudentName, gbc);
        gbc.gridx = 1;
        panel.add(txtStudentName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblStudentNo, gbc);
        gbc.gridx = 1;
        panel.add(txtStudentNo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblMilestone1, gbc);
        gbc.gridx = 1;
        panel.add(txtMilestone1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblMilestone2, gbc);
        gbc.gridx = 1;
        panel.add(txtMilestone2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(lblTerminalAssessment, gbc);
        gbc.gridx = 1;
        panel.add(txtTerminalAssessment, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(calculateButton, gbc);

        gbc.gridy = 6;
        panel.add(clearButton, gbc);

        gbc.gridy = 7;
        panel.add(exitButton, gbc);

        // Add panel to frame
        add(panel);

        // Add ActionListener to buttons
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void calculateGrade() {
        try {
            String studentName = txtStudentName.getText();
            if (studentName.matches(".*\\d.*")) {
                throw new IllegalArgumentException("Student Name should not contain numbers.");
            }

            String studentNo = txtStudentNo.getText();
            float milestone1 = Float.parseFloat(txtMilestone1.getText());
            float milestone2 = Float.parseFloat(txtMilestone2.getText());
            float terminalAssessment = Float.parseFloat(txtTerminalAssessment.getText());

            if (milestone1 < 0 || milestone1 > 25 || milestone2 < 0 || milestone2 > 40 || terminalAssessment < 0 || terminalAssessment > 35) {
                throw new IllegalArgumentException("Milestones and Terminal Assessment must be within their respective ranges.");
            }

            Student student = new Student();
            student.setStudentName(studentName);
            student.setStudentNumber(studentNo);
            student.setMilestone1(milestone1);
            student.setMilestone2(milestone2);
            student.setTerminalAssessment(terminalAssessment);

            GradeOutput output = new GradeOutput(student);
            output.setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for Milestones and Terminal Assessment.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtStudentName.setText("");
        txtStudentNo.setText("");
        txtMilestone1.setText("");
        txtMilestone2.setText("");
        txtTerminalAssessment.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MilestoneCalculator().setVisible(true);
            }
        });
    }
}
