/**
name: PartTimeStudent 
date: 12/7/2020
author: Gareth Warren

Derived Class from Base Class Student
Contains overridden methods to assign values to fee fields inherited from base class
Blueprint intended for a student taking less than 12 credit hours
*/

public class PartTimeStudent extends Student{
    //Constructor
    public PartTimeStudent(){
        super();
    }
    //Method Definitions
    @Override 
    public double calculateTuitionCost(){
        final double dblCTuition = 110.0;
        final double dblOCTuition = 220.0;
        final double dblOSTuition = 330.0;
        
        String strResident = this.getResidentStatus();
        int intCredits = this.getCreditHours();
        double dblTuition = 0.0;
        
        if(strResident.equals("C")){
            dblTuition = dblCTuition * intCredits;
        }else if(strResident.equals("OC")){
            dblTuition = dblOCTuition * intCredits;
        }else if(strResident.equals("OS")){
            dblTuition = dblOSTuition * intCredits;
        }
         return dblTuition;
    }
    
    @Override 
    public double calculateCapitalFee(){
        final double dblCCapital = 0.0;
        final double dblOCCapital = 6.5;
        final double dblOSCapital = 7.50;
        
        String strResident = this.getResidentStatus();
        int intCredits = this.getCreditHours();
        double dblCapital = 0.0;
       
       if(strResident.equals("C")){
           dblCapital = dblCCapital;
       }else if(strResident.equals("OC")){
           dblCapital = dblOCCapital * intCredits;
       }else if(strResident.equals("OS")){
           dblCapital = dblOSCapital * intCredits;
       }
       return dblCapital;
    }
    
    @Override 
    public double calculateCollegeFee(){
        final double dblCollFee = 6.0;
        int intCredits = this.getCreditHours();
        
        double dblCollege = dblCollFee * intCredits;
        if(dblCollege > 72.0){
            dblCollege = 72.0;
        }
        return dblCollege;
    }
    
    @Override 
    public double calculateMalpracticeInsuranceFee(){
        final double dblMalpracticeFee = 7.0;
        double fee = dblMalpracticeFee;
        return fee;
    }
    
    @Override 
    public double calculateAccidentInsuranceFee(){
        final double dblAccidentFee = 0.0;
        double fee = dblAccidentFee;
        return fee;
    }
    
    @Override 
    public double calculateStudentServicesFee(){
        final double dblFeePerCredit = 4.0;
        int intCredits = this.getCreditHours();
        double dblStudentServicesFee = dblFeePerCredit * intCredits;
        return dblStudentServicesFee;
    }
    
    @Override 
      public double calculateTotalCollegeFees(){
        double capitalFee = calculateCapitalFee();
        double collegeFee = calculateCollegeFee();
        double malpracticeFee = calculateMalpracticeInsuranceFee(); 
        double accidentFee = calculateAccidentInsuranceFee();
        double studentFee = calculateStudentServicesFee();
        
        double totalCollegeFees = capitalFee + collegeFee + malpracticeFee + accidentFee + studentFee;
        return totalCollegeFees;
    }
    @Override 
    public double calculateTotalCollegeCost(){
        double tuition = calculateTuitionCost();
        double capitalFee = calculateCapitalFee();
        double collegeFee = calculateCollegeFee();
        double malpracticeFee = calculateMalpracticeInsuranceFee(); 
        double accidentFee = calculateAccidentInsuranceFee();
        double studentFee = calculateStudentServicesFee();
        
        double totalCollegeCost = capitalFee + collegeFee + malpracticeFee + accidentFee + studentFee + tuition;
        return totalCollegeCost;
    }
}