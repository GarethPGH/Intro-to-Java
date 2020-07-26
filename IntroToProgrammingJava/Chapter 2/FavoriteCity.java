/*
name: FavoriteCity
date: 5/24/2020
author: Gareth Warren

Ask the user to enter the name of their favorite city
Store in string
Display: number of chars
Name UPPERCASE
Name lowercase
First char in cityname*/

import javax.swing.JOptionPane;

public class FavoriteCity{
    public static void main(String args[]){
        String cityName;
        cityName = JOptionPane.showInputDialog("Please enter the name of your favorite city:");
        //variables
        int nameLength = cityName.length();
        String nameUpperCase = cityName.toUpperCase();
        String nameLowerCase = cityName.toLowerCase();
        char firstLetter = cityName.charAt(0);
         
        System.out.println(nameLength);
        System.out.println(nameUpperCase);
        System.out.println(nameLowerCase);
        System.out.println(firstLetter);
        
        //Display to the user
        String nameLen = String.valueOf(nameLength);
        String fstLetter = String.valueOf(firstLetter);
        
        JOptionPane.showMessageDialog(null, nameLen + '\n' + nameUpperCase + '\n' + nameLowerCase + '\n' + fstLetter);
    }
}