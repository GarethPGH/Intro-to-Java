/**
*Name: Convert Money
*Date: 9/27/2020
*Author: Gareth Warren
*
*This class contains a generic method convertMoney 
*to convert from USD to multiple currencies
*Or convert from multiple currencies to USD
*
*It contains a method to assign a conversionRate from the arrays 
*to pass to the convertMoney method along with the amount to convert 
*It also contains methods to assign Name and Currency symbols and return them
*/

class ConvertMoney{
   //Conversion Constants
    private static final String[] CURRENCY = {"Euros", "British Pounds", "Indian Rupees", "Australian Dollars", "Canadian Dollars", "Chinese Yuan Renminbi", "Mexican Pesos", "Emirati Dirham", "Japanese Yen"};
    private static final double[] CONVERT_FROM_US = {0.8814379875, 0.6465951610, 62.1675026086, 1.2809887428, 1.2577632453, 6.2514214914, 15.0798110010, 3.6729978913, 118.8900437410};
    private static final double[] CONVERT_TO_US = {1.1345097604, 1.5465627650,  0.0160855746, 0.7806469851, 0.7950621898,  0.1599636181, 0.0663138285, 0.2722571669, 0.0084111332};
    private static final String[] CURRENCY_SIGN = {"\u20AC", "\u00A3", "INR", "AU$", "CA$", "RMB", "\u20B1", "AED", "\u00A5"};
    
   //Assign Conversion Rate 
    public static double pickConversionRate(int index, String flag){
        double conversionRate = 0.0;
        if(flag == "to"){
            conversionRate = CONVERT_TO_US[index-1];
        }else if(flag == "from"){
            conversionRate = CONVERT_FROM_US[index-1];
        }
        return conversionRate;
    }
   //Assign Currency
    public static String pickCurrency(int index){
        String currency = CURRENCY[index-1];
        return currency;
    }
   //Assign CurrencySymbol
    public static String pickCurrencySymbol(int index){
        String currency = CURRENCY_SIGN[index-1];
        return currency;
    }
   //Conversion Method
    public static double convertMoney(double conversionRate, double money){
        money *= conversionRate;
        return money;
    }
}
    