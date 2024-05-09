/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orderingsystem;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class SalesCatalog {
    
    String url = "jdbc:mysql://localhost:3306/products";
    String uName = "root";
    String pass = "PassWord";
    /*
    try (Connection conn = DriverManager.getConnection(url, uName, pass)) {
    
}
    catch (SQLException sqle) {
    
}*/
    JFrame frame = new JFrame();
    JPanel salesPanel;
    
    JTable salesTable;
    Object []column = {"Product ID", "Product Name", "Quantity", "Price", "Amount"};
    DefaultTableModel model = new DefaultTableModel();   
    JScrollPane saleScroll;
    
    public SalesCatalog() {
        
        salesPanel = new JPanel();
        salesPanel.setBounds(50, 50, 600, 600);
        salesPanel.setBackground(Color.GRAY);
        salesPanel.setLayout(null);
        
        salesTable = new JTable();
        model.setColumnIdentifiers(column);
        salesTable.setBounds(30, 80, 100, 100);
        salesTable.setModel(model);
        salesTable.setRowHeight(20);
        
        saleScroll = new JScrollPane(salesTable);
        saleScroll.setBounds(0, 0, 600, 600);
        
        salesPanel.add(saleScroll);
      
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales", "root", "PassWord");
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM sales.storesales")) {
                
        }
        catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        frame.add(salesPanel);
                
        frame.setSize(1365, 720);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
    
    public static void main (String []args) {
        new SalesCatalog();
    }
}
