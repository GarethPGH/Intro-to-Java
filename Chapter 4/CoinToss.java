/*
name: CoinToss
date: 6/6/2020
author: Gareth Warren

For 8 coin tosses, h for heads, t for tails,
sum number of heads and number of tails, and calculate their percentages. 
Display in a formatted table pattern
*/
import java.util.Random;

public class CoinToss{
    public static void main(String args[]){
        //Set up random numbers for coin toss
        Random randomNumbers = new Random();
        
        //Variables
        int randomNumber = 0;
        int numberOfHeads = 0;
        int numberOfTails = 0;
        char face = 'h';
        
        //Perform Coin Toss, Assign face, Count number of Heads and Tails
        for(int i = 1; i <= 8; i++){
             randomNumber = randomNumbers.nextInt(100);
             //System.out.println(randomNumber);
             
             if(randomNumber > 50){
                 face = 'h';
                 numberOfHeads++;
             }else if(randomNumber <= 50){
                 face = 't';
                 numberOfTails++;
             }
             System.out.println("Toss " + i + ": " + face);
        }
        
        //Calculate percentage of Heads and Tails
        double numberOfTosses = 8.0;
        double percentageOfHeads = (double)numberOfHeads/numberOfTosses * 100; 
        double percentageOfTails = (double)numberOfTails/numberOfTosses * 100;
        
        System.out.println("Number of Heads: " + numberOfHeads + " Percentage of Heads: " + percentageOfHeads + "%");
        System.out.println("Number of Tails: " + numberOfTails + " Percentage of Tails: " + percentageOfTails + "%");
   }
}