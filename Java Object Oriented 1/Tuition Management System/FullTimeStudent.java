/**
name: FullTimeStudent 
date: 12/7/2020
author: Gareth Warren

Derived Class from Base Class Student
Contains overridden methods to assign values to fee fields inherited from base class
Blueprint intended for a student taking 12 or more credit hours
*/

public class FullTimeStudent extends Student{        
    //Constructor
    public FullTimeStudent(){
        super();
    }
    //Method Definitions
    @Override 
    public double calculateTuitionCost(){
       final double dblCTuition = 1650.0;
       final double dblOCTuition = 3300.0;
       final double dblOSTuition = 4950.0;
       
       String strStatus = this.getResidentStatus();
       double tuitionCost = 0.0;
       double dblExtraFee = 0.0;
       
       if(strStatus.equals("C")){
           tuitionCost = dblCTuition;
       }else if(strStatus.equals("OC")){
           tuitionCost = dblOCTuition;
       }else if(strStatus.equals("OS")){
           tuitionCost = dblOSTuition;
       }
       dblExtraFee = calculateExtraHoursFee();
       tuitionCost += dblExtraFee;
       return tuitionCost;
    }
    
    @Override 
    public double calculateCapitalFee(){
       final double dblCCapital = 0.0;
       final double dblOCCapital = 78.0;
       final double dblOSCapital = 85.0;
       
       String strStatus = this.getResidentStatus();
       double dblCapital = 0.0;
       
       if(strStatus.equals("C")){
           dblCapital = dblCCapital;
       }else if(strStatus.equals("OC")){
           dblCapital = dblOCCapital;
       }else if(strStatus.equals("OS")){
           dblCapital = dblOSCapital;
       }
       return dblCapital;
    }
    
    @Override 
    public double calculateCollegeFee(){
        final double dblCollegeFee = 72.0;
        double fee = dblCollegeFee;
        return fee;
    }
    
    @Override 
    public double calculateMalpracticeInsuranceFee(){
        final double dblMalpracticeFee = 7.70;
        double fee = dblMalpracticeFee;
        return fee;
    }
    
    @Override 
    public double calculateAccidentInsuranceFee(){
        final double dblAccidentFee = 5.40;
        double fee = dblAccidentFee;
        return fee;
    }
    
    @Override 
    public double calculateStudentServicesFee(){
        int intCredits = this.getCreditHours();
        final double dblFeePerCredit = 4.25;
        double fee = dblFeePerCredit * (double)intCredits;
        return fee;
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
    
    private double calculateExtraHoursFee(){
        final double dblExtraCreditCost = 110.0;
        int intCredits = this.getCreditHours();
        
        double dblExtraHoursFee;
        if(intCredits > 18){
            intCredits = intCredits - 18;
            dblExtraHoursFee = (double)intCredits * dblExtraCreditCost; 
        }else{
            dblExtraHoursFee = 0.0;
        }
        return dblExtraHoursFee;
    }
}