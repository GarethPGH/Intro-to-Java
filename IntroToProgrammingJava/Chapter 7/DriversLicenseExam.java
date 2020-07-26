/*
name: DriversLicenseExam
date: 6/27/2020
author: Gareth Warren
*/
import javax.swing.JOptionPane;

public class DriversLicenseExam{
    public static void main(String args[]){
       //Initialized and set Student Answers
        DriverExam examAttempt = new DriverExam();
        examAttempt.setStudentAnswers();
        String[] exam = examAttempt.getStudentAnswers();
       
       //View Student Answers and Answer Key
        System.out.println("Student Answers:");
        for(String value : exam){
            System.out.print(value + ", ");
        }
        System.out.println();  
        
        String[] answers = examAttempt.getAnswerKey();
        System.out.println("Answer Key:");
        for(String value : answers){
            System.out.print(value + ", ");
        }
        System.out.println();    
           
       //Extract Exam Stats
        String[] graded = examAttempt.checkStudentAnswers(exam);
        int correct = examAttempt.totalCorrect(graded);
        int incorrect = examAttempt.totalIncorrect(graded);
        boolean pass = examAttempt.passed(correct);
        String missed = examAttempt.questionsMissed(graded);

       //Determine if Student Passes 
        String grade = "";
        if(pass){
            grade = "Passed";
        }else if(!pass){
            grade = "Failed";
        }
        
       //Display stats 
        String gradedExam = String.format("The student got " + correct + " questions correct\n" + "The student got " + incorrect + " questions incorrect\n"
                                    + "The student missed the following questions: " + missed + '\n' + "The student " + grade + " the exam."); 
        
        JOptionPane.showMessageDialog(null, gradedExam);
        System.exit(0);
    }
}
  