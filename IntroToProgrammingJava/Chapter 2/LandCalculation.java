/*
name: Land Calculation
date: 5/24/2020
author: Gareth Warren

Calculate the number of acres in 389,767 square feet
1 acre is 43,560 square feet*/

public class LandCalculation{
    
    public static void main(String args[]){
         int acre = 43560;
         int land = 389767;
         
         double numOfAcres = (double)land/acre;
         System.out.print(numOfAcres);
    }
}