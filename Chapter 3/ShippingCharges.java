/*
name: ShippingCharges
date: 5/30/2020
author: Gareth Warren

Display shipping charges based on milage and pounds. 
First 500 mi are not prorated
*/
import javax.swing.JOptionPane;

public class ShippingCharges{
    public static void main(String args[]){
    
        //variables
        int miles;
        float weight;
        float rate = 0.0f;
        
        //placeholder for conversions
        String placeholder;
        
        placeholder = JOptionPane.showInputDialog("Destination in whole miles: ");
        miles = Integer.parseInt(placeholder);
        
        placeholder = JOptionPane.showInputDialog("Weight of package: ");
        weight = Float.parseFloat(placeholder);
        
        if(weight <= 2){
            rate = 1.10f;
        }
        else if(weight > 2 && weight <= 6){
            rate = 2.20f;
        }
        else if(weight > 6 && weight <=10){
            rate = 3.70f;
        }
        else if(weight > 10){
            rate = 3.80f;
        }
        
        //Note shipping will not incur additional charges until milage >= 1000 in 500 mile increments
        int multiplier = miles/500;
        
        if(multiplier >= 2){
            rate = rate * multiplier; 
        }
        
        //Display to the user
        String rateFormatted = String.format("$%,.2f",rate); 
        
        JOptionPane.showMessageDialog(null, "Shipping Charge: " + rateFormatted);
        
        System.exit(0);
    }
}