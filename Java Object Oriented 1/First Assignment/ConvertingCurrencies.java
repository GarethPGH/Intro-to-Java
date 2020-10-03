/**
*Name: ConvertingCurrencies
*Date: 9/27/2020
*Author: Gareth Warren
*
*This rewrite of ConvertMoney class uses individual methods 
*to convert from USD to multiple currencies
*Or convert from multiple currencies to USD
*
*It also contains methods to assign Name and Currency symbols and return them
*/

public class ConvertingCurrencies{
   //Conversion Rates for Euros, British Pounds, Indian Rupee, Australian Dollar, Canadian Dollar, Chinese Yuan Renminbi, Mexican Pesos, Emrati Dirham and Japanese Yen
    private static final double[] CONVERT_FROM_US = {0.8814379875, 0.6465951610, 62.1675026086, 1.2809887428, 1.2577632453, 6.2514214914, 15.0798110010, 3.6729978913, 118.8900437410};
    private static final double[] CONVERT_TO_US = {1.1345097604, 1.5465627650,  0.0160855746, 0.7806469851, 0.7950621898,  0.1599636181, 0.0663138285, 0.2722571669, 0.0084111332};
  
   //Currency Signs: Country code used when Unicode not found
    private static final String[] CURRENCY_SIGN = {"\u20AC", "\u00A3", "INR", "AU$", "CA$", "RMB", "\u20B1", "AED", "\u00A5"};
   //Currency Names
    private static final String[] CURRENCY = {"Euros", "British Pounds", "Indian Rupees", "Australian Dollars", "Canadian Dollars", "Chinese Yuan Renminbi", "Mexican Pesos", "Emirati Dirham", "Japanese Yen"};

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
}