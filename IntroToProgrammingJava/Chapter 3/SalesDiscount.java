/*
name: SalesDiscount
date: 5/29/2020
author: Gareth Warren

a program that offers a discount based on number of package sales
diplay amount of discount, if applicable and cost of total sale
*/

import javax.swing.JOptionPane;

public class SalesDiscount{
    public static void main(String args[]){
        //constant
        final int price = 99;
        
        //variables
        float discount = 0.0f;
        float total;
        int numPackages;
        
        String placeholder = JOptionPane.showInputDialog("Enter the number of software packages being purchased.");
        numPackages = Integer.parseInt(placeholder);
        
         //Calculate Total and Discount
        if(numPackages >= 10 && numPackages <= 19){
            discount = .2f;//20%
        }else if(numPackages >= 20 && numPackages <= 49){
            discount = .3f;//30%
        }else if(numPackages >= 50 && numPackages <= 99){
            discount = .4f;//40%
        }else if(numPackages >= 100){
            discount = .5f;//50%
        }
       
        total = ((float)price - ((float)price * discount)) * (float)numPackages;
        discount = discount * 100;
        
        //Show to User
        String message = String.format("Your discount is %.0f %%, and your total price is $%,.2f", discount, total);
        JOptionPane.showMessageDialog(null, message);
        
        System.exit(0);
    }
}