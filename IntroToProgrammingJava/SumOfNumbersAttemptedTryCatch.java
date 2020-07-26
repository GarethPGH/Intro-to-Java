/*
name: SumOfNumbers
date: 6/5/2020
author: Gareth Warren 
*/

import javax.swing.JOptionPane;
import java.lang.NumberFormatException;


public class SumOfNumbersAttemptedTryCatch{

    public static void main(String args[]){
        //variables
        int number;
        int sum = 0;
        String placeholder;
        
        //Ask user for a number
        placeholder = JOptionPane.showInputDialog("Please enter a nonzero positive integer value");
        
        //Likely a syntax error, but I find it odd that program execution skips the step above asking for a value for placeholder
        try{
            number = Integer.parseInt(placeholder);
        }catch(Exception NumberFormatException){
            placeholder = JOptionPane.showInputDialog("Please enter a valid number");
        }
        
        if(number > 0){
            for(int i = 1 ; i <= number; i++){
               sum += i;
               //Watch the loop process, not needed, but fun
               System.out.println(sum);
            }
        }
        
        //Show user the sum from their number
        JOptionPane.showMessageDialog(null, "The sum of the range of numbers from 1 to " + number + " is: " + sum);
        
        System.exit(0);
    }
}