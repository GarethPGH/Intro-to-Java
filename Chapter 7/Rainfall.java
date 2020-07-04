public class Rainfall{

   //Average rainfall array
   private double[] monthlyRainfall = new double[12];
   
   //Months are a constant
   private final String[] theMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
   
   public Rainfall(){
       for(double rainfall : monthlyRainfall){
           rainfall = 0.0;
       }
   }
   
   //Set Rainfall 
   public void setMonthlyRainfall(double measuredRainfall, int month){
       monthlyRainfall[month] = measuredRainfall;
   }
   
   //Acessors
   public double getMonthlyRainfall(int month){
       return monthlyRainfall[month];
   }
   
   public String getMonth(int month){
       return theMonths[month];
   }
   
   public int getMonthlyRainfallLength(){
       return monthlyRainfall.length;
   }
   
   //Methods
   //Find the month with the maximum rainfall
   public String monthMaxRain(){
      
       int month = 0;
       double maxRain = monthlyRainfall[0];
       
       for(int index = 1; index < monthlyRainfall.length; index++){
           if(monthlyRainfall[index] > maxRain){
               maxRain = monthlyRainfall[index];
               month = index;
           }
       }
       String monthMaxRain = String.format(theMonths[month] + " had the most amount of rain, with %.2f inches of rain.", monthlyRainfall[month]);
       
       return monthMaxRain;
   }
   
   //Find the month with the minimum rainfall
   public String monthMinRain(){
       int month = 0;
       double minRain = monthlyRainfall[0];
       
       for(int index = 1; index < monthlyRainfall.length; index++){
           if(monthlyRainfall[index] < minRain){
               minRain = monthlyRainfall[index];
               month = index;
           }
       }
       String monthMinRain = String.format(theMonths[month] + " had the least amount of rain, with %.2f inches of rain." , monthlyRainfall[month]);
       
       return monthMinRain;
   }
   
   //Average Rainfall
   public String averageRain(){
       double sum = 0.0;
       for(double value : monthlyRainfall){
           sum += value;
       }
       sum = sum/12;
       
       String average = String.format("The average rainfall for the year is %.2f", sum);
       
       return average;
   }
   
   //Total Rainfall
   public String totalRain(){
       double sum = 0.0;
       for(double value : monthlyRainfall){
           sum += value;
       }
       String total = String.format("The total rainfall amount for the year is %.2f", sum);
       
       return total;
   }
}