/*
name: TestGrades
date: 6/11/2020
author: Gareth Warren
*/

import javax.swing.JOptionPane;

public class TestGrades{
    public static void main(String args[]){
        //Get Numerical Test Scores
        int firstNumber = setGrade();
        int secondNumber = setGrade();
        int thirdNumber = setGrade();
        int fourthNumber = setGrade();
        int fifthNumber = setGrade();
                
        //Assign Letter Grades
        char firstGrade = determineGrade(firstNumber);
        char secondGrade = determineGrade(secondNumber);
        char thirdGrade = determineGrade(thirdNumber);
        char fourthGrade = determineGrade(fourthNumber);
        char fifthGrade = determineGrade(fifthNumber);
    
        //Get Average Score
        int average = calcAverage(firstNumber, secondNumber, thirdNumber, fourthNumber, fifthNumber);
        //Average Letter Grade
        char overallGrade = determineGrade(average);
    
        JOptionPane.showMessageDialog(null, "The first test score " + firstNumber + " gets a " + firstGrade + '\n' + 
                                        "The second test score " + secondNumber + " gets a " + secondGrade + '\n' +
                                        "The third test score " + thirdNumber + " gets a " + thirdGrade + '\n' +
                                        "The fourth test score " + fourthNumber + " gets a " + fourthGrade + '\n' + 
                                        "The fifth test score " + fifthNumber + " gets a " + fifthGrade + '\n' +
                                        "The average score for all tests is " + average + " with an overall grade of " + overallGrade);
        System.exit(0);
    }
    
    //Get Grade from User
    public static int setGrade(){
        String placeholder = "";
        int grade = -1;
        
        do{
            placeholder = JOptionPane.showInputDialog("Enter a number grade for this test");
            if(placeholder != "" && placeholder != null && placeholder.matches("^[0-9]*")){
                grade = Integer.parseInt(placeholder); 
            }   
        }while(grade <= 0 || grade >= 100);
        
        return grade;
    }
    
    //Calculate Average Grade
    public static int calcAverage(int first, int second, int third, int fourth, int fifth){
        int average = (first + second + third + fourth + fifth)/5;
        return average;
    }
    
    //Assign Letter Grade
    public static char determineGrade(int numberGrade){
        char letterGrade = 'n';
        
        if(numberGrade <= 100 && numberGrade >= 90){
            letterGrade = 'A';
        }
        else if(numberGrade <= 89 && numberGrade >= 80){
            letterGrade = 'B';
        }
        else if(numberGrade <= 79 && numberGrade >= 70){
            letterGrade = 'C';
        }
        else if(numberGrade <= 69 && numberGrade >= 60){
            letterGrade = 'D';
        }
        else if(numberGrade <= 59){
            letterGrade = 'F';
        }
        
        return letterGrade;
    }
}