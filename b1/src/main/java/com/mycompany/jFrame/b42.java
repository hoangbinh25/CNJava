package com.mycompany.jFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class b42 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					b42 frame = new b42();
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
	public b42() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selector = (String) comboBox.getSelectedItem();
				 Color color = switch (selector) {
	                case "Red" -> Color.RED;
	                case "Blue" -> Color.BLUE;
	                case "Green" -> Color.GREEN;
	                case "Yellow" -> Color.YELLOW;
	                case "Orange" -> Color.ORANGE;
	                default -> Color.WHITE;
	            };
				JOptionPane.showMessageDialog(comboBox, "You selected: " + color);
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Red", "Blue", "Green", "Yellow", "Black"}));
		contentPane.add(comboBox, BorderLayout.NORTH);
	}

}
