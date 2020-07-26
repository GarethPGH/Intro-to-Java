/*
name: SumOfNumbers
date: 6/5/2020
author: Gareth Warren 
*/

import javax.swing.JOptionPane;

public class SumOfNumbers{

    public static void main(String args[]){
        //variables
        int number;
        int sum = 0;
        String placeholder;
        
        //Ask user for a number
        placeholder = JOptionPane.showInputDialog("Please enter a nonzero positive integer value");
        number = Integer.parseInt(placeholder);
        
        if(number > 0){
            for(int i = 1 ; i <= number; i++){
               sum += i;
               //Watch the loop process, not needed, but fun
               System.out.println(sum);
            }
        }
        
        //Show user the sum from their number
        JOptionPane.showMessageDialog(null, "The sum of the range of numbers from 1 to your number" + number + " is: " + sum);
        
        System.exit(0);
    }
}