/*
name: EmployeeInformation
date: 6/18/2020
author: Gareth Warren
*/
import javax.swing.JOptionPane;

public class EmployeeInformation{
    public static void main(String args[]){
       //Employee Objects
        Employee Susan = new Employee("Susan Meyers", 47899, "Accounting", "Vice President");
        Employee Mark = new Employee("Mark Jones", 39119, "IT", "Programmer");
        Employee Joy = new Employee("Joy Rogers", 81774, "Manufacturing", "Engineer");
        
       //Display Employees
        String Employees = String.format("Name: " + Susan.getEmployeeName() + "   ID: " + Susan.getEmployeeId() + "   Department: " + Susan.getEmployeeDepartment() + "   Position: " + Susan.getEmployeePosition() + '\n' 
                                          + "Name: " + Mark.getEmployeeName() + "   ID: " + Mark.getEmployeeId() + "   Department: " + Mark.getEmployeeDepartment() + "   Position: " + Mark.getEmployeePosition() + '\n'
                                          + "Name: "+ Joy.getEmployeeName() + "   ID: " + Joy.getEmployeeId() + "   Department: " + Joy.getEmployeeDepartment() + "   Position: " + Joy.getEmployeePosition());
                                          
        JOptionPane.showMessageDialog(null, Employees);
        
        System.exit(0);     
    }
}