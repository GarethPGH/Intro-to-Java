/*
name: NewHire
date: 7/14/2020
author: Gareth Warren
*/

import javax.swing.JOptionPane;

public class NewHire{
    public static void main(String args[]){
        JOptionPane.showMessageDialog(null, "Enter New Hire Information");
        ProductionWorker newHire = new ProductionWorker();
        
        String hire = String.format("Name: " + newHire.getEmployeeName() + "\nDate Hired: " + newHire.getHireDate() + "\nEmployeeNumber: " + newHire.getEmployeeNumber() + "\nAssigned Shift: " + newHire.getShift() + "\nHourly Pay: " + newHire.getHourlyPay());
        JOptionPane.showMessageDialog(null, "Employee Information\n" + hire);
        
        System.exit(0);
    }
}