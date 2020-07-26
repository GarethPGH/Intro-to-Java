/*
name: MovieRevenue
date: 7/23/2020
author: Gareth Warren
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MovieRevenue extends JFrame{
  
 //GUI fields
 //Generic TextFields and Labels
   private JLabel label;
   private JTextField text;
 //Labels
   private JLabel priceLabel;
   private JLabel numberLabel;
   private JLabel grossLabel;
   private JLabel netLabel;
   private JLabel totalGrossLabel;
   private JLabel totalNetLabel;
 //Text Fields
   private JTextField priceAdultText = new JTextField(10);
   private JTextField priceChildText = new JTextField(10);
   private JTextField numberAdultText = new JTextField(10);
   private JTextField numberChildText = new JTextField(10);
   private JTextField grossAdultText = new JTextField(10);
   private JTextField grossChildText = new JTextField(10);
   private JTextField netAdultText = new JTextField(10);
   private JTextField netChildText = new JTextField(10);
   private JTextField totalGrossText;
   private JTextField totalNetText;
   
 //Build GUI
   public MovieRevenue(){
       setTitle("Theater Revenue");
       
       BorderLayout layout = new BorderLayout(10,10);
       setLayout(layout);
       
       JPanel userGrid = new JPanel();
       userGrid = buildUserGrid();
       
       JPanel revenueGrid = new JPanel();
       revenueGrid = buildRevenueGrid();
      
       JPanel revenueTotal = new JPanel();
       revenueTotal = buildTotalRevenue();
       
       JPanel button = new JPanel();
       JButton calcButton = new JButton("Calculate");
       calcButton.addActionListener(new ButtonListener());
       button = buildButtonPanel(calcButton);
       
       JPanel infoPanel = new JPanel();
       JLabel infoLabel= new JLabel("Fill in Information on Left, Click Button to Calculate Revenue");
       infoLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
       infoPanel.add(infoLabel);
      
       add(userGrid, layout.WEST);
       add(revenueGrid, layout.EAST);
       add(button, layout.CENTER);
       add(revenueTotal, layout.SOUTH);
       add(infoPanel, layout.NORTH);
       
       pack();
       
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
   }
 //Build Methods
 //Generic Child Labels
   private JPanel child(JTextField text){
       JPanel panel = new JPanel();
       label = new JLabel("Child:");
       panel.add(label);
       panel.add(text);
       return panel;
   }
    private JPanel childNoEdit(JTextField text){
       JPanel panel = new JPanel();
       label = new JLabel("Child:");
       text.setEditable(false);
       panel.add(label);
       panel.add(text);
       return panel;
   }
 //Generic Adult Labels
   private JPanel adult(JTextField text){
       JPanel panel = new JPanel();
       label = new JLabel("Adult:");
       panel.add(label);
       panel.add(text);
       return panel;
   }
   private JPanel adultNoEdit(JTextField text){
       JPanel panel = new JPanel();
       label = new JLabel("Adult:");
       text.setEditable(false);
       panel.add(label);
       panel.add(text);
       return panel;
   }
 //Button
   private JPanel buildButtonPanel(JButton aButton){
       GridLayout layout = new GridLayout(3, 1);
       JPanel empty = new JPanel();
       JPanel button = new JPanel(layout);
       JPanel buttonPanel = new JPanel();
       
       aButton.setPreferredSize(new Dimension(150, 40));
       
       buttonPanel.add(aButton);
       button.add(empty);
       button.add(buttonPanel);
       
       pack();
       return button;
   }
 //User Input Panel
   private JPanel buildUserGrid(){
       JPanel panel = new JPanel(new GridLayout(6,1));
       priceLabel = new JLabel("Price Per Ticket");
       numberLabel = new JLabel("Number of Tickets");
       Font bold = new Font("SansSerif", Font.BOLD, 14);
       priceLabel.setFont(bold);
       numberLabel.setFont(bold);
       
       JPanel priceChild = new JPanel();
       priceChild = this.child(this.priceChildText);
       JPanel numberChild = new JPanel();
       numberChild = this.child(this.numberChildText);
       JPanel priceAdult = new JPanel();
       priceAdult = this.adult(this.priceAdultText);
       JPanel numberAdult = new JPanel();
       numberAdult = this.adult(this.numberAdultText);
       
       panel.add(priceLabel);
       panel.add(priceChild);
       panel.add(priceAdult);
       panel.add(numberLabel);
       panel.add(numberChild);
       panel.add(numberAdult);
       
       return panel;
   }
 //Revenue Panel
   private JPanel buildRevenueGrid(){
       JPanel panel = new JPanel(new GridLayout(6,1));
       grossLabel = new JLabel("Gross Revenue");
       netLabel = new JLabel("Net Revenue");
       Font bold = new Font("SansSerif", Font.BOLD, 14);
       netLabel.setFont(bold);
       grossLabel.setFont(bold);
       
       JPanel grossChild = new JPanel();
       grossChild = this.childNoEdit(this.grossChildText);
       JPanel netChild = new JPanel();
       netChild = this.childNoEdit(this.netChildText);
       JPanel grossAdult = new JPanel();
       grossAdult = this.adultNoEdit(this.grossAdultText);
       JPanel netAdult = new JPanel();
       netAdult = this.adultNoEdit(this.netAdultText);
       
       panel.add(grossLabel);
       panel.add(grossChild);
       panel.add(grossAdult);
       panel.add(netLabel);
       panel.add(netChild);
       panel.add(netAdult);
       
       return panel;
   }
 //Total Revenue Panel
   private JPanel buildTotalRevenue(){
      JPanel panel = new JPanel();
      totalGrossLabel = new JLabel("Total Gross Revenue:");
      totalNetLabel = new JLabel("Total Net Revenue:");
      Font bold = new Font("SansSerif", Font.BOLD, 14);
      totalGrossLabel.setFont(bold);
      totalNetLabel.setFont(bold);
      totalGrossText = new JTextField(10);
      totalGrossText.setEditable(false);
      totalNetText = new JTextField(10);
      totalNetText.setEditable(false);
      
      panel.add(totalGrossLabel);
      panel.add(totalGrossText);
      panel.add(totalNetLabel);
      panel.add(totalNetText);
      
      return panel;
   }
  
 //Button Listener Class
   private class ButtonListener implements ActionListener{
       public void actionPerformed(ActionEvent event){    
           String text = "";
           String input = "";
           final double THEATER_REVENUE = 0.2;
         //Get Values 
           int numberChildren = 0;
           input = numberChildText.getText();
           numberChildren = validateNumber(input, numberChildText);
           
           int numberAdults = 0;
           input = numberAdultText.getText();
           numberAdults = validateNumber(input, numberAdultText);
           
           double priceAdults = 0.0;
           input = priceAdultText.getText();
           priceAdults = validatePrice(input, priceAdultText);
           
           double priceChildren = 0.0;
           input = priceChildText.getText();
           priceChildren = validatePrice(input, priceChildText);
         //Calculate Values
           double grossChildRevenue = setGrossRevenue(numberChildren, priceChildren);
           double grossAdultRevenue = setGrossRevenue(numberAdults, priceAdults);
           double netAdultRevenue = setNetRevenue(numberAdults, priceAdults, THEATER_REVENUE);
           double netChildRevenue = setNetRevenue(numberChildren, priceChildren, THEATER_REVENUE);
           double grossRevenue = totalRevenue(grossAdultRevenue, grossChildRevenue);
           double netRevenue = totalRevenue(netAdultRevenue, netChildRevenue);
       
           String grossC = String.format("$"+ "%,.2f", grossChildRevenue);
           String grossA = String.format("$"+ "%,.2f", grossAdultRevenue);
           String netC = String.format("$"+ "%,.2f", netChildRevenue);
           String netA = String.format("$"+ "%,.2f", netAdultRevenue);
           String gross = String.format("$"+ "%,.2f", grossRevenue);
           String net = String.format("$"+ "%,.2f", netRevenue);
           
           grossChildText.setText(grossC);
           grossAdultText.setText(grossA);
           netChildText.setText(netC);
           netAdultText.setText(netA);
           totalGrossText.setText(gross);
           totalNetText.setText(net);
       }   
     //Gross Revenue
       private double setGrossRevenue(int number, double price){     
           double revenue = 0.0;   
           revenue = (double)number * price;
           return revenue;
       } 
     //Net Revenue
       private double setNetRevenue(int number, double price, double fin){
           double revenue = 0.0;   
           revenue = ((double)number * price) * fin;
           return revenue; 
       }           
     //Total Revenue
       private double totalRevenue(double child, double adult){
           double revenue = child + adult;
           return revenue;
       } 
     //Input Validation  
       private double validatePrice(String input, JTextField field){
            double price = 0.0; 
                
            if(input.matches("[0-9]+[.]?[0-9]*")){
                price = Double.parseDouble(input);
            }else if(input == null || input == "" || !input.matches("[0-9]+[.]?[0-9]*")){
                field.setText("Not Valid"); 
            }
            return price;
        }
        private int validateNumber(String input, JTextField field){
            int number = 0; 
                
            if(input.matches("[0-9]+")){
                number = Integer.parseInt(input);
            }else if(input == null || input == "" || !input.matches("[0-9]+")){
                field.setText("Not Valid"); 
            }
            return number;
        }      
       
   }
   //Embedded Main
   public static void main(String args[]){
       new MovieRevenue();
   }
}