public class ParkedCar{
    private String make;
    private String model;
    private String color;
    private String licenseNumber;
    private int minutesParked;
    
   //Constructors 
    public ParkedCar(String carMake, String carModel, String carColor, String license, int minutes){
        this.make = carMake;
        this.model = carModel;
        this.color = carColor;
        this.licenseNumber = license;
        this.minutesParked = minutes;
    }
    
    public ParkedCar(ParkedCar object2){  
        this.make = object2.make;
        this.model = object2.model;
        this.color = object2.color;
        this.licenseNumber = object2.licenseNumber;
        this.minutesParked = object2.minutesParked;
    }
    
   //Accessors
    public String getMake(){
       return make;
    }
    public String getModel(){
       return model;
    }
    public String getColor(){
       return color;
    }
    public String getLicenseNumber(){
       return licenseNumber;
    }
    public int getMinutesParked(){
       return minutesParked;
    }
    
   //Mutators
    public void setMake(String carMake){
       make = carMake;
    }
    public void setModel(String carModel){
       model = carModel;
    }
    public void setColor(String carColor){
       color = carColor;
    }
    public void setLicenseNumber(String license){
       licenseNumber = license;
    }
    public void setMinutesParked(int minutes){
       minutesParked = minutes;
    }
}