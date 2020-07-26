/*
name: Pizza Cost Application
date: 5/24/2020
author: Gareth Warren 

The cost of making a pizza at a local shop is as follows:

    Labor cost is $0.75 per pizza, regardless of size.
    Rent cost is $1.00 per pizza, regardless of size.
    Materials is $0.05 * diameter * diameter, where diameter is measured in inches.

You will store the labor, rent as constants.
You will prompt the user for the size of the pizza.

Formulas:

materials = .05 * diameter * diameter
pizzaCost = labor + rent + materials 

Create a PizzaCost application that displays the cost of making the pizza*/


import javax.swing.JOptionPane;

public class PizzaCost{
    public static void main(String args[]){
        //Const variables
        final float labor = 0.75f;
        final float rent = 1.00f;
       
        //Get diameter of ordered pizza       
        String input = JOptionPane.showInputDialog("What is the diameter of the ordered pizza?");
        int diameter = Integer.parseInt(input);
    
        //calculate cost of Materials and Pizza
        float materials = .05f * diameter * diameter; //Implicit type coercion should be allowed here, from int to float
        float pizzaCost = labor + rent + materials;
        
        System.out.println("The diameter of the pizza in inches is: " + diameter);
        System.out.println("The cost of making the pizza is: $" + pizzaCost);
        
        //Display to user cost of making Pizza
        //format to money using String.format method
        String cost = String.format("$%,.2f", pizzaCost);
        
        JOptionPane.showMessageDialog(null, "The diameter of the pizza is: " + diameter + " inches" + '\n' + "The cost of making the pizza is: " + cost);
        
        System.exit(0);
    }
}
