package com.mycompany.b66b80;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class b66 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("User List");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);

            JTable table = new JTable();
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);

            Connection conn = null;
            Statement stmt = null;
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:users.db");

                stmt = conn.createStatement();
                String dropTableSQL = "DROP TABLE IF EXISTS Users";
                stmt.execute(dropTableSQL);
                
                stmt = conn.createStatement();
                String createTableSQL = "CREATE TABLE IF NOT EXISTS Users (" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Name TEXT, " +
                        "Age INTEGER)";
                stmt.execute(createTableSQL);

                String insertDataSQL = "INSERT INTO Users (Name, Age) VALUES " +
                        "('Hoang Binh', 20), " +
                        "('Hoang Phu', 22)";
                stmt.execute(insertDataSQL);

                String selectSQL = "SELECT * FROM Users";
                ResultSet rs = stmt.executeQuery(selectSQL);

                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                DefaultTableModel model = new DefaultTableModel();
                for (int i = 1; i <= columnCount; i++) {
                    model.addColumn(metaData.getColumnName(i));
                }

                while (rs.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        row[i - 1] = rs.getObject(i);
                    }
                    model.addRow(row);
                }

                table.setModel(model);

                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            frame.setVisible(true);
        });
    }
}
