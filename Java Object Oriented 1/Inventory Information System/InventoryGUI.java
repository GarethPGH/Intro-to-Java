/**
name: InventoryGUI
date: 10/27/2020
author: Gareth Warren

Inventory Layout Class 

1: Title Banner
2: User Input Text Fields for each Inventory Object
3: Update Inventory, Clear Input, Clear Everything Buttons
4: Product Listing, 
5: TextFields for Individual Product and Inventory Accumulator Information. 
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.lang.Exception;

public class InventoryGUI extends JFrame{
   //User Input Fields
    private JTextField txtProdNumber = new JTextField(6);
    private JTextField txtProdDesc = new JTextField(6);
    private JTextField txtQuantOnHand = new JTextField(6);
    private JTextField txtQuantOnOrder = new JTextField(6);
    private JTextField txtQuantSold = new JTextField(6);
    private JTextField txtProdPrice = new JTextField(6);
   
    //Inventory Fields
    private JTextField txtTotalProduct = new JTextField(6);
    private JTextField txtTotalValueProduct = new JTextField(6);
    private JTextField txtTotalIndividualProducts = new JTextField(6);
    private JTextField txtTotalInventory = new JTextField(6);
    private JTextField txtTotalInventorySold = new JTextField(6);
    private JTextField txtTotalInventoryValue = new JTextField(6);

   //Size Constants
    private final int MAX_HEIGHT = 800;
    private final int MAX_WIDTH = 600;
    //Constructor

    //List Model Needed to Add Products to List
    private DefaultListModel listModel = new DefaultListModel();
    
    //GrayJOptionPane for Warning Messages
    private GrayJOptionPane pane = new GrayJOptionPane();
   
    public InventoryGUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create Master Panel
        JPanel masterPanel = new JPanel(new BorderLayout());
        masterPanel.setBackground(Color.DARK_GRAY);
        masterPanel.setSize(MAX_WIDTH, MAX_HEIGHT);

        //build panels
        JPanel banner = buildBanner();
        JPanel input = buildInputPanel();
        JPanel buttons = buildButtons();
        JPanel output = buildOutputPanel();
        JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(Color.DARK_GRAY);
        JPanel topHalf = new JPanel(new BorderLayout());
        JPanel bottomHalf = new JPanel(new BorderLayout());
        //add panels
        topHalf.add(banner, BorderLayout.NORTH);
        topHalf.add(input, BorderLayout.CENTER);
        topHalf.add(emptyPanel, BorderLayout.SOUTH);
        bottomHalf.add(buttons, BorderLayout.NORTH);
        bottomHalf.add(output,BorderLayout.CENTER);
        
        masterPanel.add(topHalf, BorderLayout.NORTH);
        masterPanel.add(bottomHalf, BorderLayout.SOUTH);
        
        add(masterPanel);
        
        //Border
        Border line = BorderFactory.createLineBorder(Color.DARK_GRAY, 15);
        masterPanel.setBorder(line);
        
        //Visible true
        setVisible(true);
        setResizable(false);
        //pack
        pack();
    }
    //Build Methods
    private JPanel buildBanner(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
    
        JLabel label = new JLabel("Inventory Information System", SwingConstants.CENTER);
        Font font = new Font("Verdana", Font.BOLD, 22);
        label.setFont(font);
        label.setForeground(Color.LIGHT_GRAY);

        panel.add(label);

        return panel;
    }
    private JPanel buildInputPanel(){
        JPanel panel = new JPanel(new GridLayout(1,3));
        JPanel panel1 = new JPanel(new GridLayout(2,1));
        JPanel panel2 = new JPanel(new GridLayout(2,1));
        JPanel panel3 = new JPanel(new GridLayout(2,1));
        
        panel.setBackground(Color.DARK_GRAY);
        panel1.setBackground(Color.DARK_GRAY);
        panel2.setBackground(Color.DARK_GRAY);
        panel3.setBackground(Color.DARK_GRAY);
        
        JPanel numPanel = buildPanel("Product Number", txtProdNumber);
        JPanel namePanel = buildPanel("Product Name", txtProdDesc);
        JPanel pricePanel = buildPanel("Product Price", txtProdPrice);
        JPanel onHandPanel = buildPanel("Quantity on Hand", txtQuantOnHand);
        JPanel onOrderPanel = buildPanel("Quantity on Order", txtQuantOnOrder);
        JPanel soldPanel = buildPanel("Quantity Sold", txtQuantSold);
   
        panel1.add(numPanel);
        panel1.add(onHandPanel);
      
        panel2.add(namePanel);
        panel2.add(onOrderPanel);
          
        panel3.add(pricePanel);
        panel3.add(soldPanel);
                
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        
        return panel;
    }
    private JPanel buildButtons(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
         
        JButton updateButton = new JButton("Update Inventory");
        JButton clearButton = new JButton("Clear Input");
        JButton clearEverythingButton = new JButton("Clear Everything");
        updateButton.addActionListener(new InventoryGUI.UpdateListener());
        clearButton.addActionListener(new InventoryGUI.ClearListener());
        clearEverythingButton.addActionListener(new InventoryGUI.ClearEverythingListener());

        panel.add(updateButton);
        panel.add(clearButton);
        panel.add(clearEverythingButton);
        
        return panel;
    }
    private JPanel buildOutputPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        //Create List
        JPanel scrollPanel = new JPanel(new BorderLayout());
        JPanel listPanel = new JPanel();
        listPanel.setBackground(Color.DARK_GRAY);
        JLabel listLabel = new JLabel("Product List");
        listLabel.setForeground(Color.LIGHT_GRAY);
        listPanel.add(listLabel);
        JList productList = new JList(listModel);
        productList.setVisibleRowCount(5);
        JScrollPane scrollpane = new JScrollPane(productList);
        scrollPanel.add(listPanel, BorderLayout.NORTH);
        scrollPanel.add(scrollpane, BorderLayout.CENTER);
        scrollPanel.setBackground(Color.DARK_GRAY);

        //Create Labels
        JLabel prodLabel = new JLabel("Current Product");
        JPanel prodPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(Color.DARK_GRAY);
        prodPanel.add(prodLabel);
        prodPanel.setBackground(Color.DARK_GRAY);
        prodLabel.setForeground(Color.LIGHT_GRAY);

        JLabel invLabel = new JLabel("Total Inventory");
        JPanel invPanel = new JPanel(new GridLayout(5, 1, 2, 2));
        invPanel.add(invLabel);
        invPanel.setBackground(Color.DARK_GRAY);
        invLabel.setForeground(Color.LIGHT_GRAY);
        
        //Set TextFields to Uneditable
        txtTotalIndividualProducts.setEditable(false);
        txtTotalInventory.setEditable(false);
        txtTotalInventorySold.setEditable(false);
        txtTotalInventoryValue.setEditable(false);
        txtTotalProduct.setEditable(false);
        txtTotalValueProduct.setEditable(false);
        
        //Build Individual Text Fields
        JPanel totProdPanel = buildPanel("Total Items", txtTotalProduct);
        JPanel totProdValuePanel = buildPanel("Total Value", txtTotalValueProduct);
        JPanel totDiffProdPanel = buildPanel("Different Products", txtTotalIndividualProducts);
        JPanel totInventoryPanel = buildPanel("Total Items", txtTotalInventory);
        JPanel totInventorySoldPanel = buildPanel("Items Sold", txtTotalInventorySold);
        JPanel totValuePanel = buildPanel("Total Value", txtTotalInventoryValue);
        
        //Add to Panels
        prodPanel.add(emptyPanel);
        prodPanel.add(totProdPanel);
        prodPanel.add(emptyPanel);
        prodPanel.add(totProdValuePanel);
        
        invPanel.add(totDiffProdPanel);
        invPanel.add(totInventoryPanel);
        invPanel.add(totInventorySoldPanel);
        invPanel.add(totValuePanel);

        JPanel staticPanel = new JPanel(new GridLayout(1,3));
        
        //add to main Panel
        staticPanel.add(prodPanel);
        staticPanel.add(emptyPanel);
        staticPanel.add(invPanel);
        staticPanel.setBackground(Color.DARK_GRAY);
        
        panel.add(scrollPanel, BorderLayout.NORTH);
        panel.add(staticPanel, BorderLayout.SOUTH);
        return panel;
    }
    //Individual Product
    //Generic Method for building panels
    private JPanel buildPanel(String title, JTextField txtField){
        GridLayout layout = new GridLayout(2,1);
        
        JPanel panel = new JPanel(layout);
        JLabel label = new JLabel(title);
        Font font = new Font("Verdana", Font.PLAIN ,12);
        label.setFont(font);
        panel.setBackground(Color.DARK_GRAY);
        label.setForeground(Color.LIGHT_GRAY);
        
        panel.add(label);
        panel.add(txtField);
        
        Border line = BorderFactory.createMatteBorder(5,1,1,5, Color.DARK_GRAY);
        panel.setBorder(line);
        
        return panel;
    }

    //ActionListeners for Buttons
    private class UpdateListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Inventory useInventory = new Inventory();
            String warning = "";
            String strProdNum = txtProdNumber.getText();
            String strQuantOnHand = txtQuantOnHand.getText();
            String strQuantOnOrder = txtQuantOnOrder.getText();
            String strQuantSold = txtQuantSold.getText();
            String strProdPrice = txtProdPrice.getText(); 
            String strProdName = txtProdDesc.getText();
            String strProductInfo = "";
                        
            //Validate Numerical Text Fields
            boolean checkProdNum;
            boolean checkQuantOnHand;
            boolean checkQuantOnOrder;
            boolean checkQuantSold;
            boolean checkProdPrice;

            checkQuantOnHand = validateInt(strQuantOnHand);
            checkQuantOnOrder = validateInt(strQuantOnOrder);
            checkQuantSold = validateInt(strQuantSold);
            checkProdNum = validateInt(strProdNum);
            checkProdPrice = validateFloat(strProdPrice);
            
            if(checkQuantOnHand && checkQuantOnOrder && checkQuantSold && checkProdNum && checkProdPrice){
                useInventory.setProductNumber(strProdNum);
                useInventory.setQuantOnHand(strQuantOnHand);
                useInventory.setQuantOnOrder(strQuantOnOrder);
                useInventory.setQuantSold(strQuantSold);
                useInventory.setProductPrice(strProdPrice);
                
                strProdPrice = String.format(strProdPrice, "%,.2f");
                strQuantOnHand = String.format(strQuantOnHand, "%,d");
                strQuantOnOrder =  String.format(strQuantOnOrder, "%,d");
                strQuantSold =  String.format(strQuantSold, "%,d");
                strProductInfo = "Number:  " + strProdNum + "   Name:  " + strProdName + "   On Hand:  " + strQuantOnHand + "   On Order:  " + strQuantOnOrder + "   Price:  " + strProdPrice + "   Quantity Sold:  " + strQuantSold;  
                listModel.addElement(strProductInfo);


                int intCurrentTotalProd = useInventory.calculateCurrentProductQuantity();
                float fCurrentValue = useInventory.calculateCurrentProductValue();
                int intTotalDiffProds = useInventory.calculateDifferentInventoryProducts();
                int intTotalInvItems = useInventory.calculateTotalInventoryItems();
                float fTotalInvValue = useInventory.calculateTotalInventoryValue();
                int intTotalItemsSold = useInventory.calculateTotalInventoryItemsSold();
                
                //Check Product level
                if(useInventory.checkProductLevel()){
                    pane.showMessageDialog(null, "Product Level is Less than 50 Items. Order More Product!");
                }
                //Convert ints to String
                String strDiffProds = useInventory.intToString(intTotalDiffProds);
                String strCurrentTotalProd = useInventory.intToString(intCurrentTotalProd);
                String strTotalInvItems = useInventory.intToString(intTotalInvItems);
                String strTotalItemsSold = useInventory.intToString(intTotalItemsSold);
                //format Float Values
                String strTotalInvValue = String.format("%,.2f", fTotalInvValue);
                String strCurrentValue = String.format("%,.2f", fCurrentValue);

                txtTotalIndividualProducts.setText(strDiffProds);
                txtTotalInventory.setText(strTotalInvItems);
                txtTotalInventorySold.setText(strTotalItemsSold);
                txtTotalInventoryValue.setText(strTotalInvValue);
                txtTotalProduct.setText(strCurrentTotalProd);
                txtTotalValueProduct.setText(strCurrentValue);
            }else{
                pane.showMessageDialog(null, "Re-enter Product Information and Try Again");
            }
        }
        private boolean validateFloat(String text){
            boolean isValid = false;
            float number;
            try{
                number = Float.parseFloat(text);
            }catch(NumberFormatException exception){
                number = -1f;
            }
            if (number >= 0.0f){
                isValid = true;
            }
            return isValid;
        }
        private boolean validateInt(String text){
            boolean isValid = false;
            int number;
            try{
                number = Integer.parseInt(text);
            }catch(NumberFormatException exception){
                number = -1;
            }
            if (number >= 0){
                isValid = true;
            }
            return isValid;
        }
    }
    private class ClearListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            //Clear all the input fields
            txtProdDesc.setText("");
            txtProdNumber.setText("");
            txtProdPrice.setText("");
            txtQuantOnHand.setText("");
            txtQuantOnOrder.setText("");
            txtQuantSold.setText("");
        }
    }
    private class ClearEverythingListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            //Clear Everything
            String sure = "";
      
            sure = pane.showInputDialog("This will erase all data entered into form. Type Yes or Y to proceed.");
            if(sure ==  null){
                sure = "";
            }
            sure = sure.toUpperCase();
            if(sure.equals("YES") || sure.equals("Y")){
                txtProdDesc.setText("");
                txtProdNumber.setText("");
                txtProdPrice.setText("");
                txtQuantOnHand.setText("");
                txtQuantOnOrder.setText("");
                txtQuantSold.setText("");
                txtTotalIndividualProducts.setText("");
                txtTotalInventory.setText("");
                txtTotalInventorySold.setText("");
                txtTotalInventoryValue.setText("");
                txtTotalProduct.setText(""); 
                txtTotalValueProduct.setText("");
                listModel.removeAllElements();
                //Resets Static Data Fields
                Inventory.clearInventoryData();
            }
        }
    }
    //Changing JOptionPane Color for Exception
    public class GrayJOptionPane extends JOptionPane{
        public GrayJOptionPane(){
            UIManager.put("OptionPane.background", Color.DARK_GRAY);
            UIManager.put("OptionPane.messageForeground", Color.RED);
            UIManager.put("Panel.background", Color.DARK_GRAY);
        }
    }
    
    //Main
    public static void main(String args[]){
        new InventoryGUI();
    }
}