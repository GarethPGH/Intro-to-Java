/*
name: ParkingEnforcement
date: 7/2/2020
author: Gareth Warren
*/
import javax.swing.JOptionPane;

public class ParkingEnforcement{
    public static void main(String args[]){
        ParkedCar thisCar = new ParkedCar("Toyota", "Prius", "Neon Green", "XVD546", 23250);
        ParkingMeter thisMeter = new ParkingMeter(128);
        PoliceOfficer officerBob = new PoliceOfficer("Bob", 1337, false, thisCar, thisMeter);
        boolean isTrue = officerBob.makeTicket(thisCar, thisMeter);
      
        String parkingTicket = "No ticket";
        if(isTrue == true){
            System.out.println(thisCar.getMake() +" " + thisCar.getModel() + " " + thisCar.getColor() + " " + thisCar.getLicenseNumber() + " " + thisCar.getMinutesParked());
            ParkingTicket ticket = new ParkingTicket(officerBob, thisCar, thisMeter);
            parkingTicket = ticket.toString();
        }
        
        System.out.print(parkingTicket);
        JOptionPane.showMessageDialog(null, parkingTicket);
        System.exit(0);
    }
}