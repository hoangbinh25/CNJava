package com.mycompany.b51b65;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.JButton;

public class b51 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					b51 frame = new b51();
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
	public b51() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(5, 5, 274, 14);
		contentPane.add(progressBar);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(91, 30, 89, 23);
		contentPane.add(btnStart);
		
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
					@Override
					protected Void doInBackground() throws Exception {
						for (int i = 0; i <= 100; i++) {
							publish(i);
							Thread.sleep(100);
						}
						return null;
					}
					
					@Override
					protected void process(java.util.List<Integer> chunks) {
						for (int value : chunks) {
							progressBar.setValue(value);
						}
					}
				};
				worker.execute();
			}
		});
	}
}
