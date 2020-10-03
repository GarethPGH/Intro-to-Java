/**
Name: Convert Multiple Currencies Standalone
Date: 9/27/2020
Author: Gareth Warren

This program allows the user to convert an amount of money from US Dollars to one of nine different currencies
Or an amount of money in one of nine different currencies to US Dollars
The user may also switch menus with Option 10
Program execution continues until the user decides to quit by choosing Option 11, uses the Cancel, or X buttons 

This version does not require an additional class
*/

import javax.swing.JOptionPane;

public class ConvertMultipleCurrenciesStandalone{
   //Conversion Rates for Euros, British Pounds, Indian Rupee, Australian Dollar, Canadian Dollar, Chinese Yuan Renminbi, Mexican Pesos, Emrati Dirham and Japanese Yen
        public static final double[] CONVERT_FROM_US = {0.8814379875, 0.6465951610, 62.1675026086, 1.2809887428, 1.2577632453, 6.2514214914, 15.0798110010, 3.6729978913, 118.8900437410};
        public static final double[] CONVERT_TO_US = {1.1345097604, 1.5465627650,  0.0160855746, 0.7806469851, 0.7950621898,  0.1599636181, 0.0663138285, 0.2722571669, 0.0084111332};
  
       //Currency Signs: Country code used when Unicode not found
        public static final String[] CURRENCY_SIGN = {"\u20AC", "\u00A3", "INR", "AU$", "CA$", "RMB", "\u20B1", "AED", "\u00A5"};
       //Currency Names
        public static final String[] CURRENCY = {"Euros", "British Pounds", "Indian Rupees", "Australian Dollars", "Canadian Dollars", "Chinese Yuan Renminbi", "Mexican Pesos", "Emirati Dirham", "Japanese Yen"};
       
       //Conversion Methods
        public static double convertToEuros(double money){
            money *= CONVERT_FROM_US[0];
            return money;
        }
        public static double convertToBritishPounds(double money){
            money *= CONVERT_FROM_US[1];
            return money;
        }
        public static double convertToIndianRupees(double money){
            money *= CONVERT_FROM_US[2];
            return money;
        }
        public static double convertToAustralianDollars(double money){
            money *= CONVERT_FROM_US[3];
            return money;
        }
        public static double convertToCanadianDollars(double money){
            money *= CONVERT_FROM_US[4];
            return money;
        }
        public static double convertToChineseYuanRenminbi(double money){
            money *= CONVERT_FROM_US[5];
            return money;
        }
        public static double convertToMexicanPesos(double money){
            money *= CONVERT_FROM_US[6];
            return money;
        }
        public static double convertToEmiratiDirham(double money){
            money *= CONVERT_FROM_US[7];
            return money;
        }
        public static double convertToJapaneseYen(double money){
            money *= CONVERT_FROM_US[8];
            return money;
        }
    
      //Convert into US Currency
        public static double convertFromEuros(double money){
            money *= CONVERT_TO_US[0];
            return money;
        }
        public static double convertFromBritishPounds(double money){
            money *= CONVERT_TO_US[1];
            return money;
        }
        public static double convertFromIndianRupees(double money){
            money *= CONVERT_TO_US[2];
            return money;
        }
        public static double convertFromAustralianDollars(double money){
            money *= CONVERT_TO_US[3];
            return money;
        }
        public static double convertFromCanadianDollars(double money){
            money *= CONVERT_TO_US[4];
            return money;
        }
        public static double convertFromChineseYuanRenminbi(double money){
            money *= CONVERT_TO_US[5];
            return money;
        }
        public static double convertFromMexicanPesos(double money){
            money *= CONVERT_TO_US[6];
            return money;
        }
        public static double convertFromEmiratiDirham(double money){
            money *= CONVERT_TO_US[7];
            return money;
        }
        public static double convertFromJapaneseYen(double money){
            money *= CONVERT_TO_US[8];
            return money;
        }
     
       //Assign Currency
        public static String getCurrencyName(int index){
            String currency = CURRENCY[index-1];
            return currency;
        }
       //Assign CurrencySymbol
        public static String getCurrencySign(int index){
            String currency = CURRENCY_SIGN[index-1];
            return currency;
        }
       //Method creates String and displays it to the User
        public static void displayOutput(double money, double moneyConverted, String currency, String currencySign, String flag){
             String formattedOutput = "";
          
             if(flag == "from"){
                 formattedOutput = String.format("Amount Converted from US Dollars " + ":\n $ " + "%,.10f" + "\nto " + currency + " is:\n " + currencySign + " " + "%,.10f", money, moneyConverted); 
             }else if(flag == "to"){
                 formattedOutput = String.format("Amount Converted from " + currency + ":\n " + currencySign + " " + "%,.10f" + "\nto US Dollars is:\n $ " + "%,.10f", money, moneyConverted); 
             }
             JOptionPane.showMessageDialog(null, formattedOutput);
        }
    
    public static void main(String args[]){
       //Menu Constants
        final String CHOICES = "Convert US Dollar Amount to Desired Currency (Type 1), or Convert A Currency Amount to US Dollar (Type 2)?";

        final String CONVERT_FROM = "Convert US Dollars to desired Currency\n"+
            "    1:) Euro\n    2:) British Pound\n    3:) Indian Rupee\n    4:) Australian Dollar\n    5:) Canadian Dollar\n" +
            "    6:) Chinese Yuan Renminbi\n    7:) Mexican Peso\n    8:) Emirati Dirham\n    9:) Japanese Yen\n    10:) Convert to US Dollars\n    11:) Quit";

        final String CONVERT_TO = "Convert The following Currencies to US Dollars\n"+
            "    1:) Euro\n    2:) British Pound\n    3:) Indian Rupee\n    4:) Australian Dollar\n    5:) Canadian Dollar\n" +
            "    6:) Chinese Yuan Renminbi\n    7:) Mexican Peso\n    8:) Emirati Dirham\n    9:) Japanese Yen\n    10:) Convert from US Dollars\n    11:) Quit";
             
       //Initial User Input
        String option = "";
       //Menu Option
        String menuOption = "";
        String flag = "";
        int switchValue = 0;
       //Control Flag
        boolean goAgain = true;
       //Input
        double amountToConvert = 0.0;
       //Outputs
        double amountConverted = 0.0; 
        String currencySign = "";
        String currency = "";
       //For Parsing to amountToConvert 
        String moneyPlaceholder= "";     
       
       //Display Initial Menu
        option = JOptionPane.showInputDialog(CHOICES);
        
        do{
            if(option == null || option.isEmpty()){
               //This should exit program
                menuOption = "11";
                flag = "to";
                option = "2"; 
            }else if(!option.equals("1") && !option.equals("2")){  
                option = JOptionPane.showInputDialog("You must type a 1 or a 2");
            }
        }while(!option.equals("1") && !option.equals("2"));
        
       //Set flag for Switch Option 10 and displayOutput method
        if(option.equals("1")){
            flag = "from";
        }else if(option.equals("2")){
            flag = "to";
        }
        
        while(goAgain){ 
           //Get Menu Option User Input
            if(option.equals("1") && !menuOption.equals("11")){
                menuOption = JOptionPane.showInputDialog(CONVERT_FROM);
                
                while(!menuOption.matches("1[0-1]|[1-9]")){
                    if(menuOption == null || menuOption.isEmpty()){
                        menuOption = "11";
                    }else{
                        menuOption = JOptionPane.showInputDialog("Please enter a number between 1 and 11 to use menu");
                    }
                }
            }else if(option.equals("2") && !menuOption.equals("11")){
                menuOption = JOptionPane.showInputDialog(CONVERT_TO);
                
                while(!menuOption.matches("1[0-1]|[1-9]")){
                    if(menuOption == null || menuOption.isEmpty()){
                        menuOption = "11";
                    }else{
                        menuOption = JOptionPane.showInputDialog("Please enter a number between 1 and 11 to use menu");
                    }
                }
            }
          //Parse the Switch Option  
           switchValue = Integer.parseInt(menuOption); 
                        
           if(menuOption.matches("[1-9]") && menuOption.length() == 1){
               //Get Amount of Money to convert
                String regex = "[0-9]*[.]?[0-9]+";
             
                if(flag.equals("from")){
                    moneyPlaceholder = JOptionPane.showInputDialog("How much US currency do you want to convert?");
                    do{
                       //This check lets the user use buttons to end program
                        if(moneyPlaceholder == null){
                            System.exit(0);
                        }else if(!moneyPlaceholder.matches(regex)){
                            moneyPlaceholder = JOptionPane.showInputDialog("Enter a valid numerical value");
                        }
                    }while(!moneyPlaceholder.matches(regex));
                }else if(flag.equals("to")){
                    moneyPlaceholder = JOptionPane.showInputDialog("How much foreign currency do you want to convert?");
                    do{
                       //This check lets the user use buttons to end program
                        if(moneyPlaceholder == null){
                            System.exit(0);
                        }else if(!moneyPlaceholder.matches(regex)){
                            moneyPlaceholder = JOptionPane.showInputDialog("Enter a valid numerical value");
                        }
                    }while(!moneyPlaceholder.matches(regex));             
                }
                amountToConvert = Double.parseDouble(moneyPlaceholder);
            }  
            switch(switchValue){
               case 1:
                   if(flag == "from"){
                       amountConverted = convertToEuros(amountToConvert);
                   }else if(flag == "to"){
                       amountConverted = convertToEuros(amountToConvert);
                   }
                   currencySign = getCurrencySign(1);
                   currency = getCurrencyName(1);
                   displayOutput(amountToConvert, amountConverted, currency, currencySign, flag);
                   break;
               case 2:
                   if(flag == "from"){
                       amountConverted = convertToBritishPounds(amountToConvert);
                   }else if(flag == "to"){
                       amountConverted = convertFromBritishPounds(amountToConvert);
                   }
                   currencySign = getCurrencySign(2);
                   currency = getCurrencyName(2);
                   displayOutput(amountToConvert, amountConverted, currency, currencySign, flag);
                   break;
               case 3:
                   if(flag == "from"){
                       amountConverted = convertToIndianRupees(amountToConvert);
                   }else if(flag == "to"){
                       amountConverted = convertFromIndianRupees(amountToConvert);
                   }
                   currencySign = getCurrencySign(3);
                   currency = getCurrencyName(3);
                   displayOutput(amountToConvert, amountConverted, currency, currencySign, flag);
                   break;
               case 4:
                   if(flag == "from"){
                       amountConverted = convertToAustralianDollars(amountToConvert);
                   }else if(flag == "to"){
                       amountConverted = convertFromAustralianDollars(amountToConvert);
                   }
                   currencySign = getCurrencySign(4);
                   currency = getCurrencyName(4);
                   displayOutput(amountToConvert, amountConverted, currency, currencySign, flag);
                   break;
               case 5:
                   if(flag == "from"){
                       amountConverted = convertToCanadianDollars(amountToConvert);
                   }else if(flag == "to"){
                       amountConverted = convertFromCanadianDollars(amountToConvert);
                   }
                   currencySign = getCurrencySign(5);
                   currency = getCurrencyName(5);
                   displayOutput(amountToConvert, amountConverted, currency, currencySign, flag);
                   break;
               case 6:
                   if(flag == "from"){
                       amountConverted = convertToChineseYuanRenminbi(amountToConvert);
                   }else if(flag == "to"){
                       amountConverted = convertFromChineseYuanRenminbi(amountToConvert);
                   }
                   currencySign = getCurrencySign(6);
                   currency = getCurrencyName(6);
                   displayOutput(amountToConvert, amountConverted, currency, currencySign, flag);
                   break;
               case 7:
                   if(flag == "from"){
                       amountConverted = convertToMexicanPesos(amountToConvert);
                   }else if(flag == "to"){
                       amountConverted = convertFromMexicanPesos(amountToConvert);
                   }
                   currencySign = getCurrencySign(7);
                   currency = getCurrencyName(7);
                   displayOutput(amountToConvert, amountConverted, currency, currencySign, flag);
                   break;
               case 8:
                   if(flag == "from"){
                       amountConverted = convertToEmiratiDirham(amountToConvert);
                   }else if(flag == "to"){
                       amountConverted = convertFromEmiratiDirham(amountToConvert);
                   }
                   currencySign = getCurrencySign(8);
                   currency = getCurrencyName(8);
                   displayOutput(amountToConvert, amountConverted, currency, currencySign, flag);
                   break;
               case 9:
                   if(flag == "from"){
                       amountConverted = convertToJapaneseYen(amountToConvert);
                   }else if(flag == "to"){
                       amountConverted = convertFromJapaneseYen(amountToConvert);
                   }
                   currencySign = getCurrencySign(9);
                   currency = getCurrencyName(9);
                   displayOutput(amountToConvert, amountConverted, currency, currencySign, flag);
                   break;
               case 10:
                  //if from, pick convertTo
                   if(flag.equals("from")){
                       option = "2";
                       flag = "to";
                   }else if(flag.equals("to")){
                  //if to, pick convertFrom
                       option = "1";
                       flag = "from";
                   }
                   break;
               case 11:
                   goAgain = false;
                   break;
               default: 
                   if(menuOption == null){
                       menuOption = "11";
                       goAgain = false;
                   }else{
                       menuOption = JOptionPane.showInputDialog("Please enter a number between 1 and 11 to use menu");
                   }
                   break;
            }menuOption = "";
     }
     System.exit(0);
     }
     
     
   

}