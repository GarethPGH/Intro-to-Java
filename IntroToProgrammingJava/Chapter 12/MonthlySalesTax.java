/*
name: MonthlySalesTax
date: 7/20/2020
author: Gareth Warren
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MonthlySalesTax extends JFrame{
   //GUI Fields 
    private JPanel panel;
    private JLabel messageLabel;
    private JTextField monthlySales;
    private JRadioButton countyTax;
    private JRadioButton stateTax;
    private JRadioButton totalTax;
    private ButtonGroup taxButtons;
    private final int MAX_HEIGHT = 130;
    private final int MAX_WIDTH = 800;
   
   //Constructor             
    public MonthlySalesTax(){
        setTitle("Monthly Sales Tax");
        setSize(MAX_WIDTH, MAX_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        buildPanel();
        add(panel);
        panel.setBackground(Color.DARK_GRAY);
        getContentPane().setBackground(Color.DARK_GRAY);
        setVisible(true);
    }
    
   //Create Label, Text Field and Buttons
    private void buildPanel(){
        this.messageLabel = new JLabel("Enter Total Monthly Sales");
        this.monthlySales = new JTextField(10);
        this.countyTax = new JRadioButton("Show County Tax Due");
        this.stateTax = new JRadioButton("Show State Tax Due");
        this.totalTax = new JRadioButton("Show Total Tax Due");
        
        messageLabel.setForeground(Color.PINK);
        
        countyTax.setBackground(Color.DARK_GRAY);
        countyTax.setForeground(Color.LIGHT_GRAY);
        stateTax.setBackground(Color.DARK_GRAY);
        stateTax.setForeground(Color.LIGHT_GRAY);
        totalTax.setBackground(Color.DARK_GRAY);
        totalTax.setForeground(Color.LIGHT_GRAY);
 
        taxButtons = new ButtonGroup();
        taxButtons.add(countyTax);
        taxButtons.add(stateTax);
        taxButtons.add(totalTax);
        
        countyTax.addActionListener(new RadioButtonListener());
        stateTax.addActionListener(new RadioButtonListener());
        totalTax.addActionListener(new RadioButtonListener());
        
        panel = new JPanel();
        panel.add(messageLabel);
        panel.add(monthlySales);
        panel.add(countyTax);
        panel.add(stateTax);
        panel.add(totalTax);
    }
   //Extended JOptionPane Class to Change Colors
    private class GrayJOptionPane extends JOptionPane{
        public GrayJOptionPane(){
            UIManager.put("OptionPane.background", Color.DARK_GRAY);
            UIManager.put("OptionPane.messageForeground", Color.LIGHT_GRAY);
            UIManager.put("Panel.background", Color.DARK_GRAY);
        }
    }
   //Internal RadioButtonListener Class
    private class RadioButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String input = "";
            String totalSales = "";
            double tax = 0.0;
            String showTax = "";
            input = monthlySales.getText();
            double sales = this.validateInput(input);
            totalSales = String.format("$" + "%,.2f", sales);
            GrayJOptionPane pane = new GrayJOptionPane();
                
            if(event.getSource() == countyTax){
                if(sales == 0.0){
                    return;
                }else{
                    tax = sales * .02;
                    showTax = String.format("$" + "%,.2f", tax);
                    pane.showMessageDialog(null, "The County Monthly Tax due for the amount " + totalSales + " is " + showTax);
                }
            }else if(event.getSource() == stateTax){
                if(sales == 0.0){
                    return;
                }else{
                    tax = sales * .04;
                    showTax = String.format("$" + "%,.2f", tax);
                    pane.showMessageDialog(null, "The State Monthly Tax due for the amount " + totalSales + " is " + showTax);
                }
            }else if(event.getSource() == totalTax){
                if(sales == 0.0){
                    return;
                }else{
                    tax = (sales * .02) + (sales * .04);
                    showTax = String.format("$" + "%,.2f", tax);
                    pane.showMessageDialog(null, "The Total Monthly Tax due for the amount " + totalSales + " is " + showTax);
                }
            }
        }
       //Input Validation     
        private double validateInput(String input){
            double sales = 0.0; 
                
            if(input.matches("[0-9]+[.]?[0-9]*")){
                sales = Double.parseDouble(input);
            }else if(input == null || input == "" || !input.matches("[0-9]+[.]?[0-9]*")){
                JOptionPane.showMessageDialog(null, "That is not a valid number");
            }
            return sales;
         }
    }
   //Main     
    public static void main(String args[]){
        new MonthlySalesTax();
    }
}