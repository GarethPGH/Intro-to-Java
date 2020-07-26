import javax.swing.JOptionPane;

public class PhoneWithInputValidation{
   //Field
    private String phoneNumber;
   
   //Constructor
    public Phone(){
        phoneNumber = "";
    }
    
   //Mutator
    public void setPhoneNumber(){
        String placeholder = "";
        placeholder = JOptionPane.showInputDialog("Please enter a US phone number, including area code");
        this.formatPhoneNumber(placeholder);
    }
    
   //Accessor
    public String getPhoneNumber(){
        return phoneNumber;
    }  
    
   //Methods 
    public String translateNumber(){
    
    }
    
    public boolean checkDigits(char[] checkNumbers){
       boolean check = false;

       for(char C : checkNumbers){
          check = Character.isLetterOrDigit(C);
          if(check == false){
              return false;
          }
       }
       return true;
    }
    
    public boolean validatePhoneNumberLength(String input){
        input = input.trim();
        boolean checkA = false;
        boolean checkB = false;
        int length = input.length();
        char[] checkNumbers = input.toCharArray();
        
        //Phone Numbers as XXXXXXXXXX
        if(length == 10){
            checkB = this.checkDigits(checkNumbers);
            if(checkB == true){
                checkA = true;
            }
            for(char c: input){
                if(c.matches(regex)){
                    checkA = false;
                }
            }
            
        //Phone Numbers as XXX-XXX-XXXX
        }else if(length == 12){
            char thirdIndex = input.charAt(3);
            char seventhIndex = input.charAt(7);
            if(thirdIndex == '-' && seventhIndex == '-'){
                for(int i = 0; i<3; i++){
                    checkA = false;
                    checkB = this.checkDigits(checkNumbers[i]);
                    if(checkB == true){
                        checkA = true;
                    }
                }for(int i = 4; i < 7; i++){
                    checkA = false;
                    checkB = this.checkDigits(checkNumbers[i]);
                    if(checkB == true){
                        checkA = true;
                    }
                }for(int i = 8; i < 12; i++){
                    checkA = false;
                    checkB = this.checkDigits(checkNumbers[i]);
                    if(checkB == true){
                        checkA = true;
                    }
                }
            }
            
        //Phone Numbers as (XXX)XXX-XXXX
        }else if(length == 13){
            char firstIndex = input.charAt(0);
            char fourthIndex = input.charAt(4);
            char eigthIndex = input.charAt(8);
            if(firstIndex == '(' && fourthIndex == ')' && eigthIndex == '-'){
               for(int i = 1; i < 4; i++){
                   checkA = false;
                   checkB = this.checkDigits(checkNumbers[i]);
                   if(checkB == true){
                       checkA = true;
                   }
               }
               for(int i = 5; i < 8; i++){
                   checkA = false;
                   checkB = this.checkDigits(checkNumbers[i]);
                   if(checkB == true){
                       checkA = true;
                   }
               }
               for(int i = 9; i < 13; i++){
                   checkA = false;
                   checkB = this.checkDigits(checkNumbers[i]);
                   if(checkB == true){
                       checkA = true;
                   }
               }
            }        
        }
        return checkA;         
    }
    
   //Reject and Replace Invalid phone numbers
    public String validatePhoneNumber(String number){
        String returnString = "";
        boolean isValid = false;
        final String regex = "*[,^.+&*%$#@!~`?':;,<>/|\\[\\]=_{}]";
        for(char c: number){
            if(c.matches(regex)){
                break;
            }else{
                isValid = true;
            }
        }
        if(isValid){
            returnString = number;
        }else{
            returnString = JOptionPane.showInputDialog("That is not a valid phone number. Please enter a valid phone number");
            this.formatPhoneNumber(returnString);
        }
        return returnString;
    }
   
}