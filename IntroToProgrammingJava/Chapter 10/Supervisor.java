/*
name: Supervisor
date: 7/15/2020
author: Gareth Warren
*/

import javax.swing.JOptionPane;

public class Supervisor{
    public static void main(String args[]){
        JOptionPane.showMessageDialog(null, "Enter Supervisor Information");
        ShiftSupervisor supervisor = new ShiftSupervisor();
        
        String shiftLead = String.format("Name: " + supervisor.getEmployeeName() + "\nDate Hired: " + supervisor.getHireDate() + "\nEmployeeNumber: " + supervisor.getEmployeeNumber() + "\nAnnual Salary: " + supervisor.getSalary() + "\nAnnual Production Bonus: " + supervisor.getBonus());
        JOptionPane.showMessageDialog(null, "Shift Supervisor Information\n" + shiftLead);
        
        System.exit(0);
    }
}