/*
name: Test Scores
date: 5/28/2020
author: Gareth Warren

holds 3 test scores, ask user to enter them, display average and letter grade
*/

import javax.swing.JOptionPane;

public class TestScores{
   public static void main(String args[]){
       //test score variables
       int score1;
       int score2;
       int score3;
       
       String placeholder; //placeholder to parseInt from
       
       placeholder = JOptionPane.showInputDialog("Enter the first test score");
       score1 = Integer.parseInt(placeholder);
       
       placeholder = JOptionPane.showInputDialog("Enter the second test score");
       score2 = Integer.parseInt(placeholder);
       
       placeholder = JOptionPane.showInputDialog("Enter the third test score");
       score3 = Integer.parseInt(placeholder);
       
       //Calculate average and grade
       int average = (score1 + score2 + score3)/3;
       String grade = "";
       
       if( average >= 90 && average <= 100 ){
               grade = "A";
           }
       else if( average >= 80 && average <= 89 ){
               grade = "B";
           }
       else if( average >= 70 && average <= 79 ){
               grade = "C";
           }
       else if( average >= 60 && average <= 69 ){
               grade = "D";
           }
       else if( average < 60 ){
               grade = "F";
           }
           
       //Display to the user
       String av = String.valueOf(average);
       
       JOptionPane.showMessageDialog(null, "Your average is: " + av + '\n' + "Your grade is: " + grade); 
       
       System.exit(0);
       }
}