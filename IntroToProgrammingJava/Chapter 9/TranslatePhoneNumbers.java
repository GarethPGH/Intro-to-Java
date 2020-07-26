/*
Name: TranslatePhoneNumbers
Date: 7/8/2020
Author: Gareth Warren
*/

import javax.swing.JOptionPane;

public class TranslatePhoneNumbers{
    public static void main(String args[]){
       Phone number = new Phone();
       number.setPhoneNumber();
       String phoneNumber = number.getPhoneNumber();
       number.phoneNumberValidation(phoneNumber);
       String translatedNumber = number.translateNumber(phoneNumber);
       
       JOptionPane.showMessageDialog(null, "This phone number: " + phoneNumber + " translates to: " + translatedNumber);
       
       System.exit(0); 
    }        
}