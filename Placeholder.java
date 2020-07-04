/*
name: Placeholder for Algorithms Workbench
author: Gareth Warren

*/
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Placeholder{
    public static void main(String args[]){
       Circle circ = new Circle(3);
       Circle otherCirc = new Circle(5);
       
       String circString = circ.toString();
       boolean isequal = otherCirc.equals(circ);
       boolean areabool = circ.greaterThan(otherCirc);
       
       System.out.println(circString + " is equal " + isequal + " greater " + areabool);
       
              
    }
}
