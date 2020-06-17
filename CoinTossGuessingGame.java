/*
name: CoinTossGuessingGame
date: 6/6/2020
author: Gareth Warren

For 8 coin tosses, h for heads, t for tails,
sum number of heads and number of tails, and calculate their percentages. 
Display in a formatted table pattern
*/
import java.util.Random;
import javax.swing.JOptionPane;
import java.io.*;

public class CoinTossGuessingGame{
    public static void main(String args[]){
        //Set up random numbers for coin toss
        Random randomNumbers = new Random();
        
        //Variables
        int randomNumber = 0;
        int numberOfHeads = 0;
        int numberOfTails = 0;
        char face = 'h';
        char guess = 'u';
        String placeholder = "";
        
        //Perform Coin Toss, Assign face, Count number of Heads and Tails
        for(int i = 1; i <= 8; i++){
             randomNumber = randomNumbers.nextInt(100);
             //System.out.println(randomNumber);
             
             //This is causing StringIndexOutOfBoundException
             //I want the user to guess for each coin flip, and verify input
             while(guess != 'h' || guess != 't'){
                 placeholder = JOptionPane.showInputDialog("Guess the coin flip.\nPlease type \"h\" for heads or \"t\" for tails");
                 guess = placeholder.charAt(0);
                 System.out.print(guess);
             }
             
             if(randomNumber > 50){
                 face = 'h';
                 numberOfHeads++;
             }else if(randomNumber <= 50){
                 face = 't';
                 numberOfTails++;
             }
             
             if(guess == face){
                 JOptionPane.showMessageDialog(null, "You guessed correctly!");
             }else{
                 JOptionPane.showMessageDialog(null, "Wrong guess");
             }
             
             System.out.println("Toss " + i + ": " + face);
        }
        
        //Calculate percentage of Heads and Tails
        double numberOfTosses = 8.0;
        double percentageOfHeads = (double)numberOfHeads/numberOfTosses * 100; 
        double percentageOfTails = (double)numberOfTails/numberOfTosses * 100;
        
        System.out.println("Number of Heads: " + numberOfHeads + " Percentage of Heads: " + percentageOfHeads + "%");
        System.out.println("Number of Tails: " + numberOfTails + " Percentage of Tails: " + percentageOfTails + "%");
        
        System.exit(0);
   }
}