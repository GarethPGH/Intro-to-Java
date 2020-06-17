/*
name: PaintJobEstimator
date: 6/11/2020
author: Gareth Warren
*/

import javax.swing.JOptionPane;
import java.util.regex.*;

public class PaintJobEstimator{
    public static void main(String args[]) throws java.lang.NullPointerException{
    
    //User variables
        int rooms = 0;
        int squareFeet = 0;
        double pricePerGallon = 0.0;
    
    //loop variables
        String placeholder = "";
        boolean changeMe = true;
    
    //User input
        while(changeMe){ 
            placeholder = JOptionPane.showInputDialog("Enter the number of rooms you need painted");
            if(placeholder.matches("^[0-9]*")){
                rooms = Integer.parseInt(placeholder);
                changeMe = false;
            }  
        }
        //reset changeMe    
        changeMe = true;
        int totalSquareFeet = 0;
     
        for(int i = 0; i < rooms; i++){
            while(changeMe){
                placeholder = JOptionPane.showInputDialog("Enter the number of square feet in this room");
                if(placeholder.matches("^[0-9]*")){
                    squareFeet = Integer.parseInt(placeholder);                 
                    changeMe = false;
                } 
                totalSquareFeet += squareFeet;      
            }
            //reset changeMe
            changeMe = true;  
        }
      
        while(changeMe){ 
            placeholder = JOptionPane.showInputDialog("Enter the price per gallon of paint");
             
            if(placeholder.matches("^[0-9]*.[0-9]*")){
                pricePerGallon = Double.parseDouble(placeholder);
                changeMe = false;
            }
               
        }
    //Method variables
        int numberOfGallons = gallonsOfPaint(totalSquareFeet);
        int totalHours = hoursOfLabor(numberOfGallons);
        double paintCost = costOfPaint(numberOfGallons, pricePerGallon);
        double laborCost = costOfLabor(totalHours);
        double total = totalCost(paintCost, laborCost);
    
    //Display Job Order
        String displayString = String.format("Paint Needed:  %,d gallons\nTotal Work Hours:  %,d \nPaint Cost:  $%,.2f \nLabor Cost:  $%,.2f \nTotal Job Cost:  $%,.2f\n", numberOfGallons, totalHours, paintCost, laborCost, total);
        System.out.println(displayString);
        
        JOptionPane.showMessageDialog(null, displayString);
        
        System.exit(0);
    }
    
    //Given Square footage needed painted, find number of gallons of paint needed for the job
    public static int gallonsOfPaint(int squareFeet){
        final int squareFeetPerGallon = 115;
        int modulo = squareFeet % squareFeetPerGallon; 
        int gallons;
        
        //No such thing as a partial gallon
        if(modulo == 0){
            gallons = squareFeet / squareFeetPerGallon;
        }else{
            gallons = (squareFeet / squareFeetPerGallon) + 1;
        }
    
        return gallons;
    }
    
    //Given number of gallons of paint, find total hours needed to complete job
    public static int hoursOfLabor(int gallonsOfPaint){
        final int hoursPerGallon = 8;
        int hours = hoursPerGallon * gallonsOfPaint;
        return hours;
    }
    
    //Given number of gallons and cost per gallon, find total cost for needed paint
    public static double costOfPaint(int gallonsOfPaint, double costPerGallon){
        double costOfPaint = (double)gallonsOfPaint * costPerGallon;
        return costOfPaint;
    }
    
    //Given total hours from hoursOfLabor, find Cost of labor
    public static double costOfLabor(int hours){
        final double hourlyRate = 18.00;
        double costOfLabor = (double)hours * hourlyRate;
    
        return costOfLabor;
    }
    
    //Given cost of paint, and cost of labor, find total cost of job
    public static double totalCost(double costOfLabor, double costOfPaint){
        double total = costOfLabor +  costOfPaint;
        return total;
    }
          
}