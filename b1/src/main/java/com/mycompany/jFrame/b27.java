package com.mycompany.jFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class b27 extends JFrame {
    private JProgressBar progressBar;
    private JButton startButton;

    public b27() {
        setTitle("Progress Bar Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        progressBar = new JProgressBar(0, 100);
        progressBar.setPreferredSize(new Dimension(250, 30));
        progressBar.setStringPainted(true);

        startButton = new JButton("Start");

        add(progressBar);
        add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startProgress();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startProgress() {
        Timer timer = new Timer(50, null);
        timer.addActionListener(new ActionListener() {
            int value = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                value++;
                progressBar.setValue(value);
                if (value >= 100) {
                    timer.stop();
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new b27());
        
    }
}
