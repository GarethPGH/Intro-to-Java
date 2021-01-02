/**
name: Test
date: 12/7/2020
author: Gareth Warren

Test Class to demonstrate usage of PartTimeStudent and FullTimeStudent derived classes from base class Student
*/

public class Test{
    public static void main(String args[]){
        FullTimeStudent fulltime = new FullTimeStudent();
        fulltime.setResidentStatus("C");
        fulltime.setStudentName("Mary");
        fulltime.setStudentAddress("111 Street Street");
        fulltime.setState("Hawaii");
        fulltime.setZipCode("11111");
        fulltime.setEmail("Student@school.edu");
        fulltime.setCreditHours(20);
        double first = fulltime.calculateTuitionCost();
        double second = fulltime.calculateCapitalFee();
        double third = fulltime.calculateCollegeFee();
        double fourth = fulltime.calculateMalpracticeInsuranceFee();
        double fifth = fulltime.calculateAccidentInsuranceFee();
        double sixth = fulltime.calculateStudentServicesFee();
        double seventh = fulltime.calculateTotalCollegeFees();
        double eigth = fulltime.calculateTotalCollegeCost();
        fulltime.setStudentId();

        System.out.println("Name: " + fulltime.getStudentName()  + "\n" +
        "Address: " + fulltime.getStudentAddress()  + "\n" +
        "State: " + fulltime.getState()  + "\n" +
        "ZipCode: " + fulltime.getZipCode()  + "\n" +
        "Resident Status: " + fulltime.getResidentStatus()  + "\n" +
        "Email: " + fulltime.getEmail()  + "\n" +
        "Credit Hours: " + fulltime.getCreditHours()  + "\n" +
        "Tuition Cost: " + first + "\n" +
        "Capital Fee: " + second  + "\n" +
        "Malpractice Fee: " + fourth + "\n" +
        "College Fee: " + third  + "\n" +
        "Accident Insurance Fee: " + fifth + "\n" +
        "Student Service Fee: " + sixth  + "\n" + 
        "Total Coll Fee" + seventh + "\n" +
        "Total Coll Cost" + eigth + "\n"+
        "ID: " + fulltime.getStudentId());
         System.out.println();
   
        PartTimeStudent partime = new PartTimeStudent();
        partime.setResidentStatus("OS");
        partime.setStudentName("Jeff");
        partime.setStudentAddress("311 Road Road");
        partime.setState("Missouri");
        partime.setZipCode("11113");
        partime.setEmail("Student2@school.edu");
        partime.setCreditHours(17);
        first = partime.calculateTuitionCost();
        second = partime.calculateCapitalFee();
        third = partime.calculateCollegeFee();
        fourth = partime.calculateMalpracticeInsuranceFee();
        fifth = partime.calculateAccidentInsuranceFee();
        sixth = partime.calculateStudentServicesFee();
        seventh = partime.calculateTotalCollegeFees();
        eigth = partime.calculateTotalCollegeCost();
        partime.setStudentId();

        System.out.println("Name: " + partime.getStudentName()  + "\n" +
            "Address: " + partime.getStudentAddress()  + "\n" +
            "State: " + partime.getState()  + "\n" +
            "ZipCode: " + partime.getZipCode()  + "\n" +
            "Resident Status: " + partime.getResidentStatus()  + "\n" +
            "Email: " + partime.getEmail()  + "\n" +
            "Credit Hours: " + partime.getCreditHours() + "\n" +
            "Tuition Cost: " + first + "\n" +
            "Capital Fee: " + second  + "\n" +
            "Malpractice Fee: " + fourth + "\n" +
            "College Fee: " + third  + "\n" +
            "Accident Insurance Fee: " + fifth + "\n" +
            "Student Service Fee: " + sixth  + "\n" + 
            "Total Coll Fee" + seventh + "\n" +
            "Total Coll Cost" + eigth + "\n"+
            "ID: " + partime.getStudentId());
    }
}