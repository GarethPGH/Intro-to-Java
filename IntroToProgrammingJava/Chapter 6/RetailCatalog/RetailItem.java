public class RetailItem{
   //Fields
    private String description;
    private int unitsOnHand;
    private double price;
   //Constructors
    public RetailItem(){
        description = "";
        unitsOnHand = 0;
        price = 0.0;
    }
    public RetailItem(String itemDescription, int numberOfUnits, double costOfItem){
        description = itemDescription;
        unitsOnHand = numberOfUnits;
        price = costOfItem;    
    }
   //Mutators
    public void setDescription(String desc){
        description = desc;
    }
    
    public void setNumberOfUnits(int units){
        unitsOnHand = units;
    }
    
    public void setPrice(double cost){
        price = cost;
    }
   //Accessors 
    public String getDescription(){
        return description;
    }
    
    public int getNumberOfUnits(){
        return unitsOnHand;
    }
    
    public double getPrice(){
        return price;
    }
}