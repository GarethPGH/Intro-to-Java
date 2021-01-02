/**
name: Student
date: 12/7/2020
author: Gareth Warren

Abstract Base Class for the demonstration/ usage of inheritance
Generic Student blueprint contains Information fields,
Fields for the assignment of fees
Accessors for all fieldswe, and Mutators for Information Fields
Abstract methods for the assignment of fees to be overridden by derived classes.
public toString method
*/

public abstract class Student{
   //Student Fields
    private int intStudentId = 0;
    private String strStudentName;
    private String strAddress;
    private String strState;
    private String strZipCode;
    private String strResidentStatus;
    private String strEmail;
    private int intCreditHours;

   //Static Accumultor Value to give Unique Ids.
    private static int intStudentNumber = 0;

   //Constructor
    public Student(){
        this.strStudentName = "";
        this.strAddress = "";
        this.strState = "";
        this.strZipCode = "";
        this.strResidentStatus = "";
        this.strEmail = "";
        this.intStudentId = 0;
        this.intCreditHours = 0;
    }
    
   //Accessors
    public String getStudentName(){
        return this.strStudentName;
    }
    public int getStudentId(){
        return this.intStudentId;
    }
    public String getStudentAddress(){
        return this.strAddress;
    }
    public String getState(){
        return this.strState;
    }
    public String getZipCode(){
        return this.strZipCode;
    }
    public String getResidentStatus(){
        return this.strResidentStatus;
    }
    public String getEmail(){
        return this.strEmail;
    }
    public int getCreditHours(){ 
        return this.intCreditHours;
    }
    
   //Mutators
    public void setStudentName(String strName){
        this.strStudentName = strName;
    }
    public void setStudentAddress(String strAddress){
        this.strAddress = strAddress;
    }
    public void setState(String strState){
        this.strState = strState;
    }
    public void setZipCode(String strZip){
        this.strZipCode = strZip;
    }
    public void setResidentStatus(String strResident){
        this.strResidentStatus = strResident;
    }
    public void setEmail(String strAdd){
        this.strEmail = strAdd;
    }
    public void setCreditHours(String strCredits){ 
        this.intCreditHours = Integer.parseInt(strCredits);
    }
    public void setCreditHours(int intCredits){ 
        this.intCreditHours = intCredits;
    }
    public void setStudentId(){
        this.intStudentNumber += 1;
        int counter = this.intStudentNumber;
        this.intStudentId += counter;
    }
  
  //Tuition Methods 
    public abstract double calculateTuitionCost();
    public abstract double calculateCapitalFee();
    public abstract double calculateCollegeFee();
    public abstract double calculateMalpracticeInsuranceFee();
    public abstract double calculateAccidentInsuranceFee();
    public abstract double calculateStudentServicesFee();
    public abstract double calculateTotalCollegeFees();
    public abstract double calculateTotalCollegeCost();
   
   //ToString Method
    public String toString(){
        String str = String.format("Student Name: " + this.strStudentName + " Email: "  + this.strEmail + "Student Id: " + Student.intStudentNumber +
            "\nAddress: " + this.strAddress + " State: " + this.strState + " Zip Code: " + this.strZipCode + 
            "\nResidency Status: " + this.strResidentStatus + " Credit Hours: " + this.intCreditHours);
        return str;
    }
}