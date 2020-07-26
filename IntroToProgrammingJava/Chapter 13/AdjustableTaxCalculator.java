/*
name: AdjustableTaxCalculator
date: 7/21/2020
author: Gareth Warren 
*/

import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;

public class AdjustableTaxCalculator extends JFrame{
    private JTextField taxIncome;
    private JLabel moneyLabel;
    private JLabel taxLabel;
    private JLabel taxOwedLabel;
    private JTextField taxesDue;
    private JSlider taxPercentage;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private final int MAX_HEIGHT = 350;
    private final int MAX_WIDTH = 300;
    private double money;
    private double taxDue= 0.0;
    
   //Build Application
    public AdjustableTaxCalculator(){
        setTitle("Tax Calculator");
        setSize(MAX_WIDTH, MAX_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(6, 1);
        setLayout(layout);
        Container content = getContentPane();
        content.setBackground(Color.DARK_GRAY);
        content.setForeground(Color.LIGHT_GRAY);
        
        buildMoneyLabel();
        buildTextField();
        buildTaxLabel();
        buildSlider();
        buildTaxDueField();
        buildTaxOwedLabel();

        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        add(panel6);     

        pack();
        setVisible(true);  
    }
   //Build Methods
    private void buildMoneyLabel(){
        this.moneyLabel = new JLabel("Amount of Money to Tax");
        this.panel1 = new JPanel();
        panel1.setBackground(Color.DARK_GRAY);
        moneyLabel.setForeground(Color.LIGHT_GRAY);
        panel1.add(this.moneyLabel);
    }
    private void buildTextField(){
        this.taxIncome = new JTextField(10);
        this.panel2 = new JPanel();
        panel2.setBackground(Color.DARK_GRAY);
        panel2.add(this.taxIncome);
    }
    private void buildTaxLabel(){
        this.taxLabel = new JLabel("Tax Percentage");
        this.panel3 = new JPanel();
        panel3.setBackground(Color.DARK_GRAY);
        this.taxLabel.setForeground(Color.LIGHT_GRAY);
        panel3.add(this.taxLabel);
    }
    private void buildSlider(){
        this.taxPercentage = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        taxPercentage.setMajorTickSpacing(1);
        taxPercentage.setPaintLabels(true);
        this.taxPercentage.addChangeListener(new SliderListener());
        this.panel4 = new JPanel();
        panel4.setBackground(Color.DARK_GRAY);
        this.taxPercentage.setBackground(Color.DARK_GRAY);
        this.taxPercentage.setForeground(Color.LIGHT_GRAY);
        panel4.add(this.taxPercentage);
    }
    private void buildTaxOwedLabel(){
        this.taxOwedLabel = new JLabel("Tax Owed");
        this.panel5 = new JPanel();
        panel5.setBackground(Color.DARK_GRAY);
        taxOwedLabel.setForeground(Color.LIGHT_GRAY);
        panel5.add(this.taxOwedLabel);
    }
    private void buildTaxDueField(){        
        this.panel6 = new JPanel();
        this.taxesDue = new JTextField(18);
        taxesDue.setText("No Tax Due");
        taxesDue.setEditable(false);
        panel6.setBackground(Color.DARK_GRAY);
        panel6.add(this.taxesDue);
    }
   //Set Money, for SliderListener
    private void setMoney(){
        String input = this.taxIncome.getText();
        this.money = validateInput(input);
    }
   //Validate, for SliderListener
    private double validateInput(String input){
        double amountToTax = 0.0;        
        if(input.matches("[0-9]+[.]?[0-9]*")){
            amountToTax = Double.parseDouble(input);
        }else if(input == null || input == "" || !input.matches("[0-9]+[.]?[0-9]*")){
            JOptionPane.showMessageDialog(null, "That is not a valid number");
        }
        return amountToTax;
    }
   //SliderListener Class 
    private class SliderListener implements ChangeListener{
        public void stateChanged(ChangeEvent event){
            setMoney();
            double percent = (taxPercentage.getValue() * .01);
            changeLabel(percent);
        }
        
        private void changeLabel(double taxPercent){
            double taxesOwed = money * taxPercent;
            if(taxesOwed > 0){
               String tax = String.format("Taxes Owed:  $" + "%,.2f", taxesOwed);
               taxesDue.setText(tax);
            }
        }
    }
    
    public static void main(String args[]){
        new AdjustableTaxCalculator();
    }
}