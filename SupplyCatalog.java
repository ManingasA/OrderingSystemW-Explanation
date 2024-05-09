package orderingsystem;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class SupplyCatalog extends JFrame implements ActionListener, MouseListener{
  
    //SQL
    String url = "jdbc:mysql://localhost:3306/products";
    String user = "root";
    String pass = "PassWord";
    String instruction = "SELECT IDproduct, ProductName, Price, Stocks FROM prddatabase";
    
    //Table
    JTable supplyTable;
    Object [] columns = {"Product ID", "Product Name", "Price", "Stock"};
    DefaultTableModel model = new DefaultTableModel(columns, 0);
    
    //JFrame supplyFrame = new JFrame();
    JScrollPane scroll;
    JButton aButton/*, MButton, SButton, PButton*/;
    JPanel tablePanel, addingPanel, supplyPanel/*, buttonPanel2*/;
    JLabel id, name, prc, stk;
    JLabel image;
    JTextField ID, Name, Prc, Stk;
    
    //CardLayout
    //CardLayout cLay = new CardLayout();
   
    @SuppressWarnings("LeakingThisInConstructor")
    public SupplyCatalog() {
        
        supplyPanel = new JPanel();
        supplyPanel.setBounds(0, 0, 1365, 720);
        supplyPanel.setLayout(null);
        
        ImageIcon icon = new ImageIcon("Logo.png");
        image = new JLabel(icon);
        image.setBounds(140, 10, 100, 70);
       
      /*supplyFrame.setSize(1365, 720);
        supplyFrame.setResizable(false);
        supplyFrame.setLocationRelativeTo(null);
        supplyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        supplyFrame.setLayout(null);*/
       
        //SQL database to Table
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement pst = conn.prepareStatement(instruction)) {
                
                ResultSet rst = pst.executeQuery();
                
                while(rst.next()) {
                    
                    String prodID = rst.getString("IDproduct");
                    String prodName = rst.getString("ProductName");
                    String pri = rst.getString("Price");
                    String stk = rst.getString("Stocks");
                    Object[]rows = {prodID, prodName, pri, stk};
                    
                    model.addRow(rows);
                }
        }
        catch(SQLException sql) {
            sql.printStackTrace();
        }
        //Table Panel
        tablePanel = new JPanel();
        tablePanel.setBounds(300, 10, 1040, 625);
        tablePanel.setBackground(Color.GRAY);
        tablePanel.setLayout(null);
        
        //Table
        supplyTable = new JTable();
        supplyTable.setRowHeight(20);
        supplyTable.setModel(model);
        supplyTable.setBackground(Color.white);
        supplyTable.setForeground(Color.black);
        supplyTable.setAutoCreateRowSorter(false);
        
        //adds table to a scrollpane
        scroll = new JScrollPane(supplyTable);
        scroll.setBounds(0, 0, 1040, 625);
        //adds scrollpane to the panel
        tablePanel.add(scroll);
        
        //adding panel
        addingPanel = new JPanel();
        addingPanel.setBounds(10, 10, 280, 625);
        addingPanel.setBackground(new Color(213, 213, 213));
        addingPanel.setLayout(null);
        
        //Button
        aButton = new JButton("Add");
        aButton.setForeground(Color.white);
        aButton.setBackground(new Color (1, 113, 187));
        aButton.addActionListener(this);
        aButton.setFocusable(false);
        aButton.setFont(new Font("Arial", Font.PLAIN, 20));
        aButton.setBounds(90, 500, 110, 40);
        
        //TextFields and JLabel
        id = new JLabel("Product ID");
        id.setBounds(30, 60, 150, 30);
        id.setFont(new Font("Arial", Font.PLAIN, 20));
        
        ID = new JTextField();
        ID.setFont(new Font ("Arial", Font.PLAIN, 15));
        ID.setBounds(30, 100, 220, 30);
        
        name = new JLabel("Product Name");
        name.setBounds(30, 160, 150, 30);
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        
        Name = new JTextField();
        Name.setFont(new Font ("Arial", Font.PLAIN, 15));
        Name.setBounds(30, 200, 220, 30);
        
        prc = new JLabel("Price");
        prc.setBounds(30, 260, 150, 30);
        prc.setFont(new Font("Arial", Font.PLAIN, 20));
        
        Prc = new JTextField();
        Prc.setFont(new Font ("Arial", Font.PLAIN, 15));
        Prc.setBounds(30, 300, 220, 30);
        
        stk = new JLabel("Stock");
        stk.setBounds(30, 360, 150, 30);
        stk.setFont(new Font("Arial", Font.PLAIN, 20));
        
        Stk = new JTextField();
        Stk.setFont(new Font ("Arial", Font.PLAIN, 15));
        Stk.setBounds(30, 400, 220, 30);
  
        addingPanel.add(ID);
        addingPanel.add(id);
        addingPanel.add(Name);
        addingPanel.add(name);
        addingPanel.add(Prc);
        addingPanel.add(prc);
        addingPanel.add(Stk);
        addingPanel.add(stk);
        addingPanel.add(aButton);
        
        supplyPanel.add(addingPanel);
        supplyPanel.add(tablePanel);
        
        /*
        //panel for buttons in supplyclass
        buttonPanel2 = new JPanel(new FlowLayout());
        buttonPanel2.setBounds(15, 640, 250, 35);
        //buttonPanel.setBackground(new Color(210, 213, 218));  

        MButton = new JButton("Main");
        MButton.setBackground(Color.GREEN);
        MButton.setForeground(Color.BLACK);
        MButton.addMouseListener(this);
        MButton.setFocusable(false);
        MButton.setFont(new Font("Arial", Font.PLAIN, 15));
        MButton.setSize(100, 30);
        
        PButton = new JButton("Products");
        PButton.setBackground(Color.YELLOW);
        PButton.setForeground(Color.BLACK);
        PButton.setFocusable(false);
        PButton.setFont(new Font("Arial", Font.PLAIN, 15));
        PButton.setSize(100, 30);
        
        SButton = new JButton("Sales");
        SButton.setBackground(Color.RED);
        SButton.setForeground(Color.BLACK);
        SButton.setFocusable(false);
        SButton.addMouseListener(this);
        SButton.setFont(new Font("Arial", Font.PLAIN, 15));
        SButton.setSize(100, 30);
        
    //panel for the switching buttons
        buttonPanel2.add(MButton);
        buttonPanel2.add(PButton);
        buttonPanel2.add(SButton);*/
        
        /*supplyFrame.add(buttonPanel2);
        supplyFrame.add(supplyPanel);
        supplyFrame.setIconImage(icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        supplyFrame.setVisible(true);*/
        //supplyFrame.setLayout(null);
    
    }

    @Override
    //this actionPerformed method is responsible for registring new products
    //updating the database, and automatically updating the table in the frame
    
    public void actionPerformed(ActionEvent e) {
        //SQL Syntax for inputing a product into database 
       String insert = "INSERT INTO prddatabase (IDproduct, ProductName, Price, Stocks) VALUES (?, ?, ?, ?)";
       //and checking each rows to look for a match
       String check = "SELECT COUNT(*) AS count FROM prddatabase WHERE IDproduct = ?;";
       
       //Connects 
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root", "PassWord");
              PreparedStatement pstinsert = conn.prepareStatement(insert);
              PreparedStatement pstcheck = conn.prepareStatement(check)) {
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery("SELECT * FROM prddatabase;");
            
               String i = ID.getText(); 
               String n = Name.getText();
               String p = Prc.getText();
               String s = Stk.getText();
               
               pstcheck.setString(1, i);
               ResultSet rsCheck = pstcheck.executeQuery();
               rsCheck.next();
               int count = rsCheck.getInt("count");
               
         
               if (i.isEmpty() || n.isEmpty() || p.isEmpty() || s.isEmpty()) {
                   JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
               }
               else if (count > 0) {
                   JOptionPane.showMessageDialog(this, "Product ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
               }
               
               else {
                   pstinsert.setString(1, i);
                   pstinsert.setString(2, n);
                   pstinsert.setString(3, p);
                   pstinsert.setString(4, s);
                   
                   int registered = pstinsert.executeUpdate();
                   if(registered > 0) {
                       JOptionPane.showMessageDialog(this, "Added Succesfully!", "", JOptionPane.INFORMATION_MESSAGE);
                       ID.setText("");
                       Name.setText("");
                       Prc.setText("");
                       Stk.setText("");
                       
                       //calls the supplyTable
                       DefaultTableModel model = (DefaultTableModel) supplyTable.getModel();
                       //adds data from textfields into a row
                       Object [] rowData = {i, n, p, s};
                       model.addRow(rowData);
                       
                       this.dispose();    
                   }
                   
               }pstinsert.close();
               conn.close();
               
        } 
        
       catch(SQLException sqle) {
           sqle.printStackTrace();
       }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == supplyTable) {
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
      
    }
  
}
