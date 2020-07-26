import javax.swing.JOptionPane;

public class Phone{
   //Field
    private String phoneNumber;
   //Constructor 
    public Phone(){
        phoneNumber = "";
    }
   //Accessor 
    public String getPhoneNumber(){
        return phoneNumber;
    }
   //Mutator
    public void setPhoneNumber(){
        String input = "";
        boolean isNumber = false;
        boolean chkregex = false;
        boolean chkregex2 = false;
        boolean index3 = false;
        boolean index7 = false;
        
        while(!isNumber){
            input = JOptionPane.showInputDialog("Please enter a phone number, including area code in the format XXX-XXX-XXXX");
            
            chkregex = input.matches("[A-Za-z0-9-]+"); 
            chkregex2 = input.matches("[0-9-]+");
            index3 = input.indexOf('-') == 3;
            index7 = input.indexOf('-', 5) == 7;
                   
            if(chkregex || chkregex2){
                if(index3 && index7){
                    isNumber = true;
                 }
            }
        }
        input = input.toUpperCase();
        this.phoneNumber = input;
    }
    
    //Validation Methods
     public String phoneNumberValidation(String input){
         String results = "";
         boolean checkContents = false;
        //check length
         checkContents = this.verifyLength(input);
         
        //if previous check passes, check separators
         if(checkContents){
             checkContents = this.verifySeparators(input);
         }
         
        //if previous check passes, check content
         if(checkContents){
             checkContents = this.verifyContents(input);
         }
         
        //if final check passes
         if(checkContents){
             results = input;
         }else{
             JOptionPane.showMessageDialog(null, "This is not a valid Phone Number");
         }
         return results;
     }
    //Verify Length
     private boolean verifyLength(String input){
         final int length = 12;
         boolean isValid = false;
         int stringLen = input.length();
         if(stringLen == length){
             isValid = true;
         }
         return isValid;
     }
    //Verify Separators
     private boolean verifySeparators(String input){
         char firstSeparator = input.charAt(3);
         char secondSeparator = input.charAt(7);
         boolean isValid = false;
         
         if(firstSeparator == '-' && secondSeparator == '-'){
             isValid = true;
         }
         
         return isValid;
     }
    //Verify Contents of Number
     private boolean verifyContents(String input){
         boolean isValid = false;
         boolean condition = false;
         char[] checkContents = input.toCharArray();
         for(int i = 0; i <3; i++){
             condition = Character.isLetterOrDigit(checkContents[i]);
             if(!condition){
                 break;
             }
         }    
         if(condition){
             for(int i = 4; i < 7; i++){
                 condition = Character.isLetterOrDigit(checkContents[i]);
                 if(!condition){
                     break;
                 }
             } 
         } 
         if(condition){
             for(int i = 8; i < 12; i++){
                 condition = Character.isLetterOrDigit(checkContents[i]);
                 if(!condition){
                     break;
                 }
             } 
         }
         isValid = condition;
         return isValid;     
     }
    //Translation Method
     public String translateNumber(String input){
         int len = input.length();        
         char[] translated = new char[len];
         char c = '/';
      
         for(int i = 0; i < len; i++){
            c = input.charAt(i);
            if(c == 'A'|| c == 'B' || c == 'C'){
                translated[i] = '2';
            }
            else if(c == 'D'|| c == 'E' || c == 'F'){
                translated[i] = '3';
            }
            else if(c == 'G'|| c == 'H' || c == 'I'){
                translated[i] = '4';
            }
            else if(c == 'J'|| c == 'K' || c == 'L'){
                translated[i] = '5';
            }
            else if(c == 'M'|| c == 'N' || c == 'O'){
                translated[i] = '6';
            }
            else if(c == 'P'|| c == 'Q' || c == 'R' || c == 'S'){
                translated[i] = '7';
            }
            else if(c == 'T'|| c == 'U' || c == 'V'){
                translated[i] = '8';
            }
            else if(c == 'W'|| c == 'X' || c == 'Y' || c == 'Z'){
                translated[i] = '9';
            }else{
                translated[i] = input.charAt(i);
            }
         }
            String returnString = new String(translated);
            return returnString;
     }
     
}