package com.mycompany.jFrame;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class b50 extends JFrame {

    private JPanel contentPane;
    private JLabel lblClickCount;
    private JLabel lblMousePosition;
    private int clickCount = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    b50 frame = new b50();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public b50() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnMultiEvent = new JButton("Multi-Event");
        btnMultiEvent.setBounds(130, 50, 150, 40);
        contentPane.add(btnMultiEvent);

        lblClickCount = new JLabel("Click Count: 0");
        lblClickCount.setBounds(30, 120, 150, 30);
        contentPane.add(lblClickCount);

        lblMousePosition = new JLabel("Mouse Position: (0, 0)");
        lblMousePosition.setBounds(30, 160, 200, 30);
        contentPane.add(lblMousePosition);

        btnMultiEvent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickCount++;
                lblClickCount.setText("Click Count: " + clickCount);  
            }
        });

        contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();
                lblMousePosition.setText("Mouse Position: (" + mouseX + ", " + mouseY + ")");
            }
        });
    }
}
