public class PoliceOfficer{
    private String officerName;
    private int badgeNumber;
    private boolean giveTicket;
    private ParkedCar car;
    private ParkingMeter meter;
    
   //Constructors
    public PoliceOfficer(String name, int badge, boolean bool, ParkedCar parkedCar, ParkingMeter parkingMeter){
        this.officerName = name;
        this.badgeNumber = badge;
        this.giveTicket = bool;
        this.car = new ParkedCar(parkedCar);
        this.meter = new ParkingMeter(parkingMeter);
    }
    
    public PoliceOfficer(PoliceOfficer object2){
        this.officerName = object2.officerName;
        this.badgeNumber = object2.badgeNumber;
        this.giveTicket = object2.giveTicket;
        this.car = new ParkedCar(object2.car);
        this.meter = new ParkingMeter(object2.meter);
    }
   //Accessors
    public String getOfficerName(){
        return officerName;
    }
    
    public int getBadgeNumber(){
        return badgeNumber;
    }
    
    public boolean getTicket(){
       giveTicket = this.makeTicket(this.car, this.meter);
       return giveTicket;
    }
   //Mutators
    public void setParkedCar(ParkedCar aParkedCar){
        this.car = aParkedCar;
    }
    
    public void setParkingMeter(ParkingMeter aParkingMeter){
        this.meter = aParkingMeter;
    }
    public void setOfficerName(String name){
        officerName = name;
    }
    
    public void setBadgeNumber(int number){
        badgeNumber = number;
    }
   //Methods
    public boolean makeTicket(ParkedCar carParked, ParkingMeter theMeter){
        boolean ticket = false;
        int minutesParked = carParked.getMinutesParked();
        int minutesPaid = theMeter.getMinutesPaid();
        if(minutesParked > minutesPaid){
            ticket = true;
        }
        return ticket;
    }
  
}