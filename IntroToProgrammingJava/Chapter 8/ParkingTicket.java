public class ParkingTicket{
    private ParkedCar car;
    private PoliceOfficer officer;
    private ParkingMeter meter;
   //Constructors 
    public ParkingTicket(PoliceOfficer anOfficer, ParkedCar aCar, ParkingMeter aMeter){
        this.car = new ParkedCar(aCar);
        this.officer = new PoliceOfficer(anOfficer);
        this.meter = new ParkingMeter(aMeter);
    }
    
   //Methods
    public int setFine(ParkingMeter parkingMeter, ParkedCar parkedCar){
        int minutesOver = parkedCar.getMinutesParked() - parkingMeter.getMinutesPaid();
        
        int multiplier = parkedCar.getMinutesParked()/60;
        int fine = 0;
        final int basicFine = 25;
        int additionalFine = (multiplier * 10) - 10;
        
        if(minutesOver < 60){
            fine = basicFine;
        }else{
            fine = basicFine + additionalFine;
        }
        
        return fine;
    }
    
    public String toString(){
        int fineAmount = this.setFine(this.meter, this.car);
        String policeOfficer = String.format("Officer Name: " +'\"'+ officer.getOfficerName() +'\"'+ " Badge Number: " +'\"'+ officer.getBadgeNumber() +'\"');
        String parkedCar = String.format("Car Make: " + '\"' + car.getMake() +'\"'+ " Model: " +'\"' + car.getModel() +'\"'+ " Color: " +'\"'+ car.getColor() +'\"' + " License Plate Number: " +'\"'+ car.getLicenseNumber() +'\"');
        String fine = String.format("Fine Amount: $%,d", fineAmount);
        
        String report = String.format(policeOfficer + '\n' + parkedCar + '\n' + fine);
        return report;
    }
}