package com.mycompany.jFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class b49 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					b49 frame = new b49();
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
	public b49() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sample");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(114, 95, 144, 36);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Red");
		rdbtnNewRadioButton.setBounds(32, 37, 60, 42);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Blue");
		rdbtnNewRadioButton_1.setBounds(180, 37, 55, 42);
		contentPane.add(rdbtnNewRadioButton_1);		
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Green");		
		rdbtnNewRadioButton_2.setBounds(301, 31, 69, 54);
		contentPane.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getSource() == rdbtnNewRadioButton && rdbtnNewRadioButton.isSelected()) {
					lblNewLabel.setForeground(Color.RED);
				}
				
			}
		});
		

		rdbtnNewRadioButton_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getSource() == rdbtnNewRadioButton_1 && rdbtnNewRadioButton_1.isSelected()) {
					lblNewLabel.setForeground(Color.BLUE);
				}
			}
		});
		
		rdbtnNewRadioButton_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getSource() == rdbtnNewRadioButton_2 && rdbtnNewRadioButton_2.isSelected()) {
					lblNewLabel.setForeground(Color.GREEN);
				}
			}
		});
	}

}
