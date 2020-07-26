/* 
name: Magic Dates
date: 5/28/2020
author: Gareth Warren
check if
month multiply by day equals year
display to user if the day is magic or not
*/
import java.util.Scanner;

public class MagicDates{
    public static void main(String args[]){
        //initiate keyboard
        Scanner keyboard = new Scanner(System.in);
        //variables
        int month;
        int day;
        int year;
        
        String placeholder;//stand in value for parsing variables
        
     
        System.out.println("Please enter a month in numeric format");
        placeholder = keyboard.nextLine();
        month = Integer.parseInt(placeholder);
        
        System.out.println("Please enter a day in numeric format");
        placeholder = keyboard.nextLine();
        day = Integer.parseInt(placeholder);
        
        System.out.println("Please enter the last two digits of a year in numeric format");
        placeholder = keyboard.nextLine();
        year = Integer.parseInt(placeholder);
        
        if(day*month == year){
        System.out.println("This date is magic!");
        }else{
        System.out.println("This date is not magic.");
        }
    }
}