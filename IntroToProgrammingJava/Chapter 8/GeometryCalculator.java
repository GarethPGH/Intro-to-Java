/*
name: GeometryCalculator
date: 7/2/2020
author: Gareth Warren
*/
import javax.swing.JOptionPane;

public class GeometryCalculator{
    public static void main(String args[]){
        String placeholder = "";
        String switchPlaceholder = "";
        String match = "-?[0-9]";//Allowing Negative Values, since problem requires Geometry Class to display an Error for Negatives
       
       //Menu
        while(!placeholder.matches("[1-4]")){
            placeholder = JOptionPane.showInputDialog("Geometry Calculator\n1: Calculate the Area of a Circle\n2: Calculate the Area of a Rectangle\n3: Calculate the Area of a Triangle\n4: Quit\nEnter Choice (1-4)");
        }
       //Options
        switch(placeholder){
           //Select Area of Circle
            case "1":{
                int rad = 0; 
                while(!switchPlaceholder.matches(match)){
                    switchPlaceholder = JOptionPane.showInputDialog("Enter a number to represent the Radius of a Circle");
                }
                rad = Integer.parseInt(switchPlaceholder);
                double areaCircle = Geometry.areaOfCircle(rad);
                if(areaCircle != 0){
                    JOptionPane.showMessageDialog(null, "The area of the Circle is " + areaCircle);
                }
                switchPlaceholder = "";
                break;
            }
           //Select Area of Rectangle
            case "2":{
                int len = 0; int wid = 0;
                while(!switchPlaceholder.matches(match)){
                    switchPlaceholder = JOptionPane.showInputDialog("Enter a number to represent the Length of a Rectangle");
                }
                len = Integer.parseInt(switchPlaceholder);
                switchPlaceholder = "";
                while(!switchPlaceholder.matches(match)){
                    switchPlaceholder = JOptionPane.showInputDialog("Enter a number to represent the Width of a Rectangle");
                }
                wid = Integer.parseInt(switchPlaceholder);
                switchPlaceholder = "";
                int areaRectangle = Geometry.areaOfRectangle(len, wid);
                if(areaRectangle != 0){
                    JOptionPane.showMessageDialog(null, "The area of the Rectangle is " + areaRectangle);
                }
                break;
            }
           //Select Area of Triangle
            case "3":{
                int ht = 0; int bas = 0;
                while(!switchPlaceholder.matches(match)){
                    switchPlaceholder = JOptionPane.showInputDialog("Enter a number to represent the Height of a Triangle");
                }
                ht = Integer.parseInt(switchPlaceholder);
                switchPlaceholder = "";
                while(!switchPlaceholder.matches(match)){
                    switchPlaceholder = JOptionPane.showInputDialog("Enter a number to represent the Base of a Triangle");
                }
                bas = Integer.parseInt(switchPlaceholder);
                switchPlaceholder = "";
                double areaTriangle = Geometry.areaOfTriangle(ht, bas);
                if(areaTriangle != 0){
                    JOptionPane.showMessageDialog(null, "The area of the Triangle is " + areaTriangle);
                }
                break;
            }
           //Select Quit
            case "4":{
                JOptionPane.showMessageDialog(null, "Goodbye");
                break;
            }
        } 
    }
}