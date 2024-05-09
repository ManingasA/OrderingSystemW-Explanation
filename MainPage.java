package orderingsystem;

//imports all the necessary class to use
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.text.SimpleDateFormat;

public class MainPage extends JFrame implements ActionListener, KeyListener, MouseListener{

    //the frame
        JFrame mainPage = new JFrame();
    //the three panels (colored in grey)
        JPanel register, table, receipt, computation, mainPanel;
    //texts in the topPanel
        JLabel productID, productName, quantity, price, subtotalprice;
    //TextFields in the topPanel
        JTextField prodIDField, prodNameField, qtyField, priceField, subtotalpriceField,
                totalTextField, payTextField, balanceTextField;
    //buttons
        JButton plusButton, minusButton, addButton, printBillButton;         
    //texts in the rightPanel    
        JLabel payLabel, totalLabel, balanceLabel;
    //table in the bottomPanel
        JTable bottomTable;
        Object[] column = {"Product ID", "Product Name", "Quantity", "Price", "SubTotal"};
        DefaultTableModel model = new DefaultTableModel();  
        JScrollPane scrollPane;    
    //texts in the receipts
        JLabel productReceipt, qTYReceipt, priceReceipt, subTotalReceipt,
                cashReceipt, changeReceipt, separator, thankYouMessage, date, time
                , separator2;
    //prints out the date and time
        Date currentDate = new Date();
    //formats the time
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
    //formats the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLLL dd, yyyy");
      
    //Buttons for PanelSwitching
        JButton mainButton, supplyButton, salesButton;   
    //Panels for Buttons for panelswitching
        JPanel buttonPanel;
    //icon
        JLabel image;
    //ScrollPane for Receipt
        JTextArea Receipt;
    //CardLayout
        CardLayout card = new CardLayout();
        JPanel cardPanel = new JPanel(card);
        SupplyCatalog supply;

    MainPage(SupplyCatalog supplycatalog){
        
        this.supply = supplycatalog;
        
        cardPanel.setBounds(0, 0, 1335, 635);
        
        //icon
        ImageIcon icon = new ImageIcon("C:\\Users\\arnel\\OneDrive\\Desktop\\Coding\\OrderingSystem\\src\\orderingsystem\\Logo.png");
        image = new JLabel(icon);
        image.setBounds(140, 10, 100, 70);
        
       
        //mainPanel settings
        mainPanel = new JPanel();
        mainPanel.setSize(1335, 635);
        mainPanel.setLayout(null);

        //top panel
        register = new JPanel();
        register.setBackground(new Color(200, 203, 218));       
        register.setBounds(15, 15, 935, 170);
        register.setLayout(null);     
        
        productID = new JLabel("Product ID");
        productID.setBounds(50, 35, 150, 30);
        productID.setFont(new Font("Arial", Font.PLAIN, 20));
        
        prodIDField = new JTextField();
        //added the listener here so that when the user pressed "enter key"
        //the code will not perform something else that uses the same key
        prodIDField.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent enew) {
        if (enew.getKeyCode() == KeyEvent.VK_ENTER) {
            productDatabase func = new productDatabase(MainPage.this);   
        }
    }
});
        prodIDField.setFont(new Font ("Arial", Font.PLAIN, 15));
        prodIDField.setBounds(45, 75, 100, 30);
        
        productName = new JLabel("Product Name");
        productName.setBounds(220, 35, 150, 30);
        productName.setFont(new Font("Arial", Font.PLAIN, 20));
        
        //added the listener here so that when the user pressed "enter key"
        //the code will not perform something else that uses the same key
        prodNameField = new JTextField();
        prodNameField.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent enew) {
        if (enew.getKeyCode() == KeyEvent.VK_ENTER) {
            productDatabase func = new productDatabase(MainPage.this);   
        }
    }
});
        prodNameField.setFont(new Font ("Arial", Font.PLAIN, 15));
        prodNameField.setBounds(170, 75, 220, 30);
        
        quantity = new JLabel("Quantity");
        quantity.setBounds(430, 35, 150, 30);
        quantity.setFont(new Font("Arial", Font.PLAIN, 20));
        
        //added the listener here so that when the user pressed "enter key"
        //the code will not perform something else that uses the same key
        qtyField = new JTextField();
        qtyField.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent calc) {
        if (calc.getKeyCode() == KeyEvent.VK_ENTER) {
           Integer qt = Integer.valueOf(qtyField.getText());
           Double price = Double.valueOf(priceField.getText());
           String subtotal = String.valueOf(qt * price);
           subtotalpriceField.setText(subtotal);          
        }
    }
});
        qtyField.setFont(new Font ("Arial", Font.PLAIN, 15));
        qtyField.setBounds(420, 75, 100, 30);
        
        plusButton = new JButton();
        plusButton.setBounds(530, 65, 30, 20);
        plusButton.setBackground(Color.green);
        plusButton.addActionListener(this);
        plusButton.setFocusable(false);
        
        minusButton = new JButton();
        minusButton.setBounds(530, 95, 30, 20);
        minusButton.setBackground(Color.red);
        minusButton.addActionListener(this);
        minusButton.setFocusable(false);
               
        price = new JLabel("Price");
        price.setBounds(600, 35, 150, 30);
        price.setFont(new Font("Arial", Font.PLAIN, 20));
        
        priceField = new JTextField();
        priceField.setFont(new Font ("Arial", Font.PLAIN, 15));
        priceField.setBounds(590, 75, 100, 30);
        
        subtotalprice = new JLabel("Subtotal");
        subtotalprice.setBounds(750, 35, 150, 30);
        subtotalprice.setFont(new Font("Arial", Font.PLAIN, 20));
        
        subtotalpriceField = new JTextField("0.0");
        subtotalpriceField.setFont(new Font ("Arial", Font.PLAIN, 15));
        //tPriceField.setEnabled(false);
        subtotalpriceField.setBounds(745, 75, 100, 30);
        
        addButton = new JButton("Add");
        addButton.setForeground(Color.white);
        addButton.setBackground(new Color (1, 113, 187));
        addButton.addActionListener(this);
        addButton.setFocusable(false);
        addButton.setFont(new Font("Arial", Font.PLAIN, 20));
        addButton.setBounds(745, 120, 100, 40);
        
        register.add(productID);
        register.add(prodIDField);
        register.add(productName);
        register.add(prodNameField);
        register.add(quantity);
        register.add(qtyField);
        register.add(plusButton);
        register.add(minusButton);
        register.add(price);
        register.add(priceField);
        register.add(subtotalprice);
        register.add(subtotalpriceField);
        register.add(addButton); 
        
    //bottomPanel
        table = new JPanel();
        table.setBackground(new Color(200, 203, 218));
        table.setBounds(15, 200, 935, 435);
        table.setLayout(null);
   
        bottomTable = new JTable();
        model.setColumnIdentifiers(column);
        bottomTable.setModel(model);
        bottomTable.setBackground(Color.white);
        bottomTable.setForeground(Color.black);
        bottomTable.setSelectionBackground(new Color (226, 89, 103));
        bottomTable.setSelectionForeground(Color.white);
        bottomTable.setFont(new Font("Arial", Font.PLAIN, 13));
        bottomTable.setRowHeight(22);
        bottomTable.addMouseListener((MouseListener) this);
        bottomTable.setAutoCreateRowSorter(false);
        
        JTableHeader header = bottomTable.getTableHeader();
        header.setBorder(null);
        bottomTable.setShowGrid(false);
    
        scrollPane = new JScrollPane(bottomTable);
        scrollPane.setForeground(Color.red);
        scrollPane.setBackground(Color.white);
        scrollPane.setBounds(0, 0, 935, 435);
       
        table.add(scrollPane);
      
    //Texts that will appear in the receipt panel
    //Receipt panel    
        receipt = new JPanel();
        receipt.setBackground(new Color(210, 213, 218));
        receipt.setBounds(960, 320, 375, 315);
        receipt.setLayout(null);
        
        date = new JLabel();  
        time = new JLabel();
        separator = new JLabel();
        productReceipt = new JLabel();  
        qTYReceipt = new JLabel();
        priceReceipt = new JLabel();
        subTotalReceipt = new JLabel();
        cashReceipt = new JLabel();
        changeReceipt = new JLabel();
        separator2 = new JLabel();
        thankYouMessage = new JLabel();
        
        receipt.add(date);
        receipt.add(time);
        receipt.add(separator);
        receipt.add(separator2);
        receipt.add(productReceipt);
        receipt.add(qTYReceipt);
        receipt.add(priceReceipt);
        receipt.add(thankYouMessage);
        receipt.add(subTotalReceipt);
        receipt.add(cashReceipt);
        receipt.add(changeReceipt);
        
    //buttons
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBounds(15, 640, 250, 35);
        //buttonPanel.setBackground(new Color(210, 213, 218));  

        mainButton = new JButton("Main");
        mainButton.setBackground(Color.GREEN);
        mainButton.setForeground(Color.BLACK);
        mainButton.setFocusable(false);
        mainButton.addMouseListener(this);
        mainButton.setFont(new Font("Arial", Font.PLAIN, 15));
        mainButton.setSize(100, 30);
        
        supplyButton = new JButton("Products");
        supplyButton.setBackground(Color.YELLOW);
        supplyButton.setForeground(Color.BLACK);
        supplyButton.addMouseListener(this);
        supplyButton.setFocusable(false);
        supplyButton.setFont(new Font("Arial", Font.PLAIN, 15));
        supplyButton.setSize(100, 30);
        
        salesButton = new JButton("Sales");
        salesButton.setBackground(Color.RED);
        salesButton.setForeground(Color.BLACK);
        salesButton.setFocusable(false);
        salesButton.addMouseListener(this);
        salesButton.setFont(new Font("Arial", Font.PLAIN, 15));
        salesButton.setSize(100, 30);
        
    //panel for the switching buttons
        buttonPanel.add(mainButton);
        buttonPanel.add(supplyButton);
        buttonPanel.add(salesButton);
        
    //Panel for Total, Pay, Balance 
        computation = new JPanel();
        computation.setBackground(new Color(210, 213, 218));
        computation.setBounds(960, 15, 375, 300);
        computation.setLayout(null);
        
    //Total, Pay, Balance
        totalLabel = new JLabel("Total");
        totalLabel.setBounds(165, 10, 150, 30);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        totalTextField = new JTextField();
        totalTextField.setBounds(120, 40, 150, 30);
        totalTextField.setFont(new Font("Arial", Font.BOLD, 25));
       //totalTextField.setEditable(false);
        
        payLabel = new JLabel("Pay");
        payLabel.setBounds(170, 80, 150, 30);
        payLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        payTextField = new JTextField();
        payTextField.setBounds(120, 110, 150, 30);
        payTextField.setFont(new Font("Arial", Font.BOLD, 25));
        payTextField.addKeyListener(this);
     
        balanceLabel = new JLabel("Balance");
        balanceLabel.setBounds(160, 150, 150, 30);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        balanceTextField = new JTextField();
        balanceTextField.setBounds(120, 180, 150, 30);
        balanceTextField.setFont(new Font("Arial", Font.BOLD, 25));
        
        printBillButton = new JButton("Print Bill");
        printBillButton.setBounds(135, 245, 120, 40);
        printBillButton.addActionListener(this);
        printBillButton.setFont(new Font("Arial", Font.BOLD, 15));
        printBillButton.setFocusable(false);
        printBillButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    //adds all the elements for the Total, Pay, Balance section   
        computation.add(printBillButton);
        computation.add(balanceTextField);
        computation.add(balanceLabel);
        computation.add(payTextField);
        computation.add(payLabel);
        computation.add(totalTextField);
        computation.add(totalLabel); 
   
    ///adds 4 panels onto the CardLayout panel
        
        mainPanel.add(computation);
        mainPanel.add(receipt);
        mainPanel.add(register);  
        mainPanel.add(table); 
   
        cardPanel.add(mainPanel, "Main");
        cardPanel.add(supply.supplyPanel, "Supply");
        
        
    //adds button panel to the frame
        mainPage.add(cardPanel);
        mainPage.add(buttonPanel);
        
    //settings of our frame  
        mainPage.setSize(1365, 720);
        mainPage.setLayout(null);
        mainPage.setResizable(false);
        mainPage.setIconImage(icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        mainPage.setTitle("Ordering System");
        mainPage.setIconImage(icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        mainPage.setLocationRelativeTo(null);     
        mainPage.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        mainPage.setVisible(true);
     
        
     //ignore the comment below this text
     //frame.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        
    }
       
        
    //the codes from here down to the bottom is what makes the buttons, textfields, etc, interactive
    @Override
    public void actionPerformed(ActionEvent e) {

            if (e.getSource () == addButton) {
               if (prodIDField.getText().equals("") || prodNameField.getText().equals("") ||
                    qtyField.getText().equals("") || priceField.getText().equals("")){ 
                    JOptionPane.showMessageDialog(this, "Please Enter All Data");
               }
               else {
                Object[]rows = {prodIDField.getText(), prodNameField.getText(), qtyField.getText(), priceField.getText(), subtotalpriceField.getText()}; 
                model.addRow(rows);
                JOptionPane.showMessageDialog(this, "Data Added Successfully!");
                
        //this code will erase all the text in the textfield above whenever the addbutton is pressed
                prodIDField.setText("");
                prodNameField.setText("");
                qtyField.setText("");
                priceField.setText("");
                //totalTextField.setText(subtotalpriceField.getText());
                
                //checks if the textfields are empty, if they are then 0.0 is set to sTF and tTF
                //if the textfields aren't empty, it will convert the text into Double and put it inside sTF and tTF
                double sTF = subtotalpriceField.getText().isEmpty() ? 0.0 : Double.parseDouble(subtotalpriceField.getText());
                double tTF = totalTextField.getText().isEmpty() ? 0.0 : Double.parseDouble(totalTextField.getText());
                
                //adds the two values
                Double result = sTF + tTF;
                
                //turns the value onto a text and display it inside the textfield
                totalTextField.setText(String.valueOf(result));
                subtotalpriceField.setText("");
               }
               
            }
            //if the button is pressed, it will add one
            if(e.getSource() == plusButton) {
                Integer quantityTable = Integer.valueOf(qtyField.getText());
                quantityTable++;
                qtyField.setText(quantityTable.toString());
                
                Double price = Double.parseDouble(priceField.getText());
                String subtotal = String.valueOf(quantityTable * price);
                subtotalpriceField.setText(subtotal);    
            }
            //if the button is pressed, it will decrease one
            if(e.getSource() == minusButton) {
                Integer quantityTable = Integer.valueOf(qtyField.getText());
                quantityTable--;
                qtyField.setText(quantityTable.toString());
                
                Double price = Double.valueOf(priceField.getText());
                String subtotal = String.valueOf(quantityTable * price);
                subtotalpriceField.setText(subtotal);
            }
            //this code will print out the receipt once the printBill button is pressed
            if(e.getSource() == printBillButton) {
                
                date.setText("Date: " + dateFormat.format(currentDate));
                date.setBounds(20, 10, 150, 100);
                
                time.setText("Time: " + timeFormat.format(currentDate));
                time.setBounds(20, 25, 100, 100);
                
                separator.setText("==============================================");
                separator.setBounds(20, 45, 350, 100);
                
                productReceipt.setText("Product");
                productReceipt.setBounds(20, 65, 100, 100);
                
                qTYReceipt.setText("Quantity");
                qTYReceipt.setBounds(100, 65, 100, 100);
                
                priceReceipt.setText("Price");
                priceReceipt.setBounds(180, 65, 100, 100);             
                
                subTotalReceipt.setText("Total: " + "₱" + totalTextField.getText());
                subTotalReceipt.setBounds(240, 155, 100, 100);
                
                cashReceipt.setText("Cash: " + "₱" + payTextField.getText());
                cashReceipt.setBounds(239, 175, 100, 100);
                
                changeReceipt.setText("Change: " + "₱" + balanceTextField.getText());
                changeReceipt.setBounds(225, 195, 100, 100);
            
                separator2.setText("==============================================");
                separator2.setBounds(20, 215, 350, 100);
                
                thankYouMessage.setText("Thank you for your purchase!");
                thankYouMessage.setBounds(120, 235, 180, 100);               
                
                //String name = payTextField.getText();
                //name.setBounds();
            } 
        }
    
//the code below will make it so that when the user typed a key, it will respond
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
//the code below will make it so that when the user pressed a key, it will respond
//the code below will get the text in the total, pay, and balance field and turn them into integers
//and calculate them
    
    @Override
    public void keyPressed(KeyEvent e) {
       
        try {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            double num1 = Double.parseDouble(totalTextField.getText());   
            double num2 = Double.parseDouble(payTextField.getText());
            String result = String.valueOf(num2 - num1);
            
            if (num2 < num1) {
                JOptionPane.showMessageDialog(null, "Insufficient Payment");
                balanceTextField.setText("");
            }
            else {
            balanceTextField.setText(result); 
            
            subTotalReceipt.setText("Subtotal: " + " ₱" + totalTextField.getText());
            cashReceipt.setText("      Cash: " + " ₱" + payTextField.getText());
            changeReceipt.setText(" Change: " + " ₱" + result);            
            }
        }
        }
        catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Only enter numbers");
        }

        
       /*try {
       if (e.getKeyCode() == KeyEvent.VK_ENTER) {
           productDatabase data = new productDatabase();
           
           String enteredId = prodIDField.getText();
           String productName = data.getProductName();
           String productPrice = data.getPrice();
           
           
       }
       }
       catch (NumberFormatException nme) {
           nme.printStackTrace();
       }*/
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {   
        
        if (e.getSource() == supplyButton) {
            card.show(cardPanel, "Supply");
        }
        
        if(e.getSource() == mainButton) {
            card.show(cardPanel, "Main");
        }
        
        if (e.getSource() == salesButton) {
                mainPage.dispose();
        }
        
        if (e.getSource() == bottomTable) {
               int SelectedRowIndex = bottomTable.getSelectedRow();
               if(SelectedRowIndex != -1) {
               int option = JOptionPane.showConfirmDialog
               (null, "Do you want to delete the selected row?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
               if(option == JOptionPane.YES_OPTION) {
                   model.removeRow(SelectedRowIndex);
               }
              
            }
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

