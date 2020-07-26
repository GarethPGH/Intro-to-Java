/*
name: AverageMonthlyRainfall
date: 6/25/2020
author: Gareth Warren
*/

import javax.swing.JOptionPane;


public class AverageMonthlyRainfall{
    public static void main(String[] args){
       //Object Declaration
        Rainfall monthlyRain = new Rainfall();
        
       //Variables
        String month = "";
        double rainfall = 0.0;
        int length = monthlyRain.getMonthlyRainfallLength();
        String placeholder = "";
        double standin = 0.0;
        
       //Assign Rain Values
        for(int i = 0; i < length; i++){
            month = monthlyRain.getMonth(i);
            while(!placeholder.matches("^[0-9]*\\.?[0-9]*") || placeholder == null || placeholder == ""){
                placeholder = JOptionPane.showInputDialog("Please enter the average rain for " + month);
            }
            rainfall = Double.parseDouble(placeholder);
            placeholder = "";
            
            monthlyRain.setMonthlyRainfall(rainfall, i);
            standin = monthlyRain.getMonthlyRainfall(i);
            System.out.println(month + " rainfall: " + standin);
        }
        
       //Find Average and Total Rain
        String averageRain = monthlyRain.averageRain();
        String totalRain = monthlyRain.totalRain();
       
       //Find month with Most and Least Rain 
        String maxRain = monthlyRain.monthMaxRain(); 
        String minRain = monthlyRain.monthMinRain();
        
        System.out.println(maxRain);
        System.out.println(minRain);
        
        JOptionPane.showMessageDialog(null, averageRain + '\n' + totalRain + '\n' + maxRain + '\n' + minRain);
        
        System.exit(0);
    }
}
