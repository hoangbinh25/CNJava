package com.mycompany.b66b80;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.*;

public class b67 extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					b67 frame = new b67();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public b67() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setText("Name");
		txtName.setBounds(99, 11, 123, 31);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(99, 98, 123, 33);
		contentPane.add(btnNewButton);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spinner.setBounds(167, 59, 55, 23);
		contentPane.add(spinner);
		
		JLabel lblNewLabel = new JLabel("Age:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(99, 53, 58, 34);
		contentPane.add(lblNewLabel);
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:user.db");
			stmt = conn.createStatement();
			String createTableSQL = "CREATE TABLE IF NOT EXISTS Users (" +
				"ID INTERGER PRIMARY KEY INCREMENT, " +
				"Name TEXT, "+
				"Age INTERGER)";
			stmt.execute(createTableSQL);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}



















