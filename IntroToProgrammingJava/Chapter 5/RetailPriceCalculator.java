/*
name: RetailPriceCalculator
date: 6/11/2020
author: Gareth Warren
*/

import javax.swing.JOptionPane;

public class RetailPriceCalculator{
    public static void main(String args[]){
        
        double wholesale = assignWholesale();
        double percentage = assignPercentage();
        
        double cost = calculateRetail(wholesale, percentage);
        
        String retail = String.format("%,.2f", cost);
    
        JOptionPane.showMessageDialog(null, "The Retail Cost of your item should be: $" + retail); 
        System.exit(0); 
    }
    
    //Calculate Retail Price of an Item
    public static double calculateRetail(double wholesaleCost, double markupPercent){
        double percent = (double)markupPercent * .01;
        double retailPrice =  wholesaleCost + (wholesaleCost * percent);
    
        return retailPrice;
    }
    //Ask user for wholesale cost
    public static double assignWholesale(){
        double wholesale = 0.0;
        boolean changeMe = true;
        String placeholder = "";
          
          while(changeMe){
            placeholder = JOptionPane.showInputDialog("Please enter the wholesale cost of the item");
            
            if(placeholder != null && placeholder != "" && placeholder.matches("^[0-9]*\\.?[0-9]*")){
                wholesale = Double.parseDouble(placeholder);
                changeMe = false;
            }
          }
        return wholesale;
    }
    //Ask user for percentage markup
    public static double assignPercentage(){
        double percentage = 0.0;
        boolean changeMe = true;
        String placeholder = "";
        
        while(changeMe){
            placeholder = JOptionPane.showInputDialog("Please enter the markup percentage of the item");
            
            if(placeholder != null && placeholder != "" && placeholder.matches("^[0-9]*\\.?[0-9]*")){
                percentage = Double.parseDouble(placeholder);
                changeMe = false;
            }
          }
        return percentage;
    }
    
}