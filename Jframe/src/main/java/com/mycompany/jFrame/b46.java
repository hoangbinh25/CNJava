package com.mycompany.jFrame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class b46 extends JFrame {

    private JPanel contentPane;
    private JList<String> list;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    b46 frame = new b46();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public b46() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
                          "Item 6", "Item 7", "Item 8", "Item 9", "Item 10"};
        list = new JList<>(items);
        
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(30, 30, 220, 300);
        contentPane.add(scrollPane);

        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        String selectedItem = list.getModel().getElementAt(index);
                        JOptionPane.showMessageDialog(contentPane, "Bạn chọn: " + selectedItem);
                    }
                }
            }
        });
    }
}
