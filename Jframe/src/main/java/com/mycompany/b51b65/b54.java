package com.mycompany.b51b65;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class b54 extends JFrame {

    private JPanel contentPane;
    private JProgressBar progressBar;
    private JLabel statusLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    b54 frame = new b54();
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
    public b54() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 200); 
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        
        progressBar = new JProgressBar();
        progressBar.setBounds(50, 50, 300, 30);
        progressBar.setMaximum(100);
        contentPane.add(progressBar);
        
        JButton loadButton = new JButton("Load");
        loadButton.setBounds(150, 100, 100, 30);
        contentPane.add(loadButton);
        
        statusLabel = new JLabel("");
        statusLabel.setBounds(150, 140, 100, 30);
        contentPane.add(statusLabel);
        
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DataLoader().execute();
            }
        });
    }
    
    private class DataLoader extends SwingWorker<Void, Integer> {
        @Override
        protected Void doInBackground() throws Exception {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(100); 
                publish(i);
            }
            return null;
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            progressBar.setValue(chunks.get(chunks.size() - 1));
        }

        @Override
        protected void done() {
            statusLabel.setText("Done");
        }
    }
}
