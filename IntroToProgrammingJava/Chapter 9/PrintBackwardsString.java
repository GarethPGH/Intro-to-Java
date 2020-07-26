/*
Name: PrintBackwardsString
Date: 7/8/2020
Author: Gareth Warren
*/
import javax.swing.JOptionPane;

public class PrintBackwardsString{
    public static void main(String args[]){
        String inputString = JOptionPane.showInputDialog("Enter anything you want to see reversed");
        String reversed = ReverseString.reverse(inputString);
        JOptionPane.showMessageDialog(null, inputString + " reversed is: " + reversed);
        System.exit(0);
    }
}
