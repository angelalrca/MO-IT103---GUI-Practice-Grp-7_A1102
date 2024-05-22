package Homework3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeOutput extends JFrame {
    private JLabel lblStudentName, lblStudentNo, lblMilestone1, lblMilestone2, lblTerminalAssessment, lblAveGrade;
    private JTextField txtStudentName, txtStudentNo, txtMilestone1, txtMilestone2, txtTerminalAssessment, txtAveGrade;
    private JButton closeButton;

    public GradeOutput(Student student) {
        super("Grade Output");
        setSize(600, 400); // Increased window width to accommodate larger text fields
        setLocationRelativeTo(null); // Center the window

        student.computeAverage();

        lblStudentName = new JLabel("Student Name:");
        lblStudentNo = new JLabel("Student No:");
        lblMilestone1 = new JLabel("Milestone 1:");
        lblMilestone2 = new JLabel("Milestone 2:");
        lblTerminalAssessment = new JLabel("Terminal Assessment:");
        lblAveGrade = new JLabel("Average Grade:");

        txtStudentName = new JTextField(30);
        txtStudentName.setEnabled(true); // Enable for input
        txtStudentName.setText(student.getStudentName());

        txtStudentNo = new JTextField(30);
        txtStudentNo.setEnabled(true); // Enable for input
        txtStudentNo.setText(student.getStudentNumber());

        txtMilestone1 = new JTextField(10);
        txtMilestone1.setEnabled(true); // Enable for input
        txtMilestone1.setText(student.getMilestone1());

        txtMilestone2 = new JTextField(10);
        txtMilestone2.setEnabled(true); // Enable for input
        txtMilestone2.setText(student.getMilestone2());

        txtTerminalAssessment = new JTextField(10);
        txtTerminalAssessment.setEnabled(true); // Enable for input
        txtTerminalAssessment.setText(student.getTerminalAssessment());

        txtAveGrade = new JTextField(10);
        txtAveGrade.setEnabled(false);
        txtAveGrade.setText(student.getAverageGrade());

        closeButton = new JButton("Close");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

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
        panel.add(lblAveGrade, gbc);
        gbc.gridx = 1;
        panel.add(txtAveGrade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(closeButton, gbc);

        add(panel);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
