public class ParkingMeter{
    private int minutesPaid;
   
   //Constructors
    public ParkingMeter(int minutes){
        this.minutesPaid = minutes;
    }
    
    public ParkingMeter(ParkingMeter object2){
        this.minutesPaid = object2.minutesPaid;
    }
   //Accessor
    public int getMinutesPaid(){
        return minutesPaid;
    }
   //Mutator
    public void setMinutesPaid(int minutes){
        minutesPaid = minutes;
    }
}