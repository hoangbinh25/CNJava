package com.mycompany.jFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class kiemtra {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Thông tin sinh viên");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        JLabel nameLabel = new JLabel("Họ và tên:");
        JTextField nameField = new JTextField();
        JLabel dobLabel = new JLabel("Ngày sinh (dd/MM/yyyy):");
        JTextField dobField = new JTextField();
        JLabel hometownLabel = new JLabel("Quê quán:");
        JTextField hometownField = new JTextField();
        
        

        JButton addButton = new JButton("Thêm");

        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(nameLabel); inputPanel.add(nameField);
        inputPanel.add(dobLabel); inputPanel.add(dobField);
        inputPanel.add(hometownLabel); inputPanel.add(hometownField);
        inputPanel.add(new JLabel()); inputPanel.add(addButton);

        String[] columnNames = {"Họ và tên", "Ngày sinh", "Quê quán"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

       
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String dob = dobField.getText().trim();
            String hometown = hometownField.getText().trim();

            if (name.isEmpty() || dob.isEmpty() || hometown.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Vui lòng nhập đầy đủ thông tin!");
            } else if (!isTextOnly(name)) {
                JOptionPane.showMessageDialog(frame, "Họ và tên chỉ được chứa ký tự chữ!");
            } else if (!isValidDate(dob)) {
                JOptionPane.showMessageDialog(frame, "Ngày sinh phải theo định dạng dd/MM/yyyy!");
            } else if (!isTextOnly(hometown)) {
                JOptionPane.showMessageDialog(frame, "Quê quán chỉ được chứa ký tự chữ!");
            } else {
                model.addRow(new Object[]{name, dob, hometown});
                nameField.setText("");
                dobField.setText("");
                hometownField.setText("");
            }
        });
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static boolean isTextOnly(String s) {
        return s.matches("[\\p{L} ]+"); 
    }
    
    public static boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
