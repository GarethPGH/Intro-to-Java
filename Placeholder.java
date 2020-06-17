/*
name: Placeholder for Algorithms Workbench
author: Gareth Warren

*/
//import java.util.Scanner;
//import javax.swing.JOptionPane;

public class Placeholder{
public static void main(String args[]){
    System.out.println(quartersToDollars(4));
    System.out.println(quartersToDollars(7));
}
public static double quartersToDollars(int numberofQuarters){
   double dollars = ((double)numberofQuarters * 25)*.01;
   return dollars;
}

}
