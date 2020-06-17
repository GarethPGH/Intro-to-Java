/*
name: PopulationTracker
date: 6/5/2020
author: Gareth Warren
*/

import javax.swing.JOptionPane;


public class PopulationTracker{
    public static void main(String args[]){
        //Variables initialized to comply with loop specifications
        int startingPopulation = 0;
        double increase = -1.1;
        int days = 0;
        int totalPopulation = 0;
        String placeholder = "";
    
        //Assign Values with Input Verification
        do{
            placeholder = JOptionPane.showInputDialog("How many individuals are in the starting population?"+'\n'+"Please make sure to enter a number that is greater than or equal to 2");
            
            if(placeholder != null && placeholder != "" && placeholder.matches("\\d+")){
                startingPopulation = Integer.parseInt(placeholder);
            }
        }while(startingPopulation < 2);
    
        do{
           placeholder = JOptionPane.showInputDialog("What is the rate of population increase?" +'\n'+"Please enter a positive percentage");
           
           if(placeholder != null && placeholder != "" && placeholder.matches("\\d+")){
               increase = Double.parseDouble(placeholder) * .01;
           }
        }while(increase < 0.0);
    
        do{
            placeholder = JOptionPane.showInputDialog("How many days do you want to track population increase?");
            
            if(placeholder != null && placeholder != "" && placeholder.matches("\\d+")){
                days = Integer.parseInt(placeholder);
            }
        }while(days < 1);
    
        //track population increase for the number of days at the rate of increase using the starting population
        //Variables for loop 
        double convertMe = 0.0; 
        String displayStartingPop; 
        displayStartingPop = String.format("%,d", startingPopulation);
        double percentage = increase * 100.0;
        String population = "";
        String currentPopulation;
    
        for(int currentDay = 1; currentDay <= days; currentDay++){
            if(currentDay > 1){
                startingPopulation = totalPopulation;
            }
        //No such thing as a partial individual
            convertMe = (double)startingPopulation + (double)startingPopulation * increase;
            totalPopulation = (int)convertMe;
        //Display current result to user
            population = String.format("%,d", totalPopulation);
            currentPopulation = String.format("%,d", startingPopulation);
        //I would display this as a message dialog, but clicking through multiple screens is annoying
            System.out.println("After " + currentDay + " days your expected population is " + population + " individuals; using the current number of " + currentPopulation + " individuals with a " + (int)percentage + "% rate of population increase");
        }
        
        //Display end results to user
        JOptionPane.showMessageDialog(null, "After " + days + " days your expected total population is " + population + " individuals; using a seed number of " + displayStartingPop + " individuals with a " + (int)percentage + "% rate of population increase"); 
    
        System.exit(0);
    }
}