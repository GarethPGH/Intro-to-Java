/**
name: Inventory
date: 10/27/2020
author: Gareth Warren

This class contains the fields and methods necessary to track individual products. 
It contains a method to warn if product levels are less than 50.
It also keeps a running tally of how many different products are in the inventory. 
It accumulates how many items have been sold, the total amount of items (minus sold), and how much the remaining items are worth.
It includes a static method to reset the accumulated values.
*/
import javax.swing.JOptionPane;

public class Inventory{
   //Instance Fields for individual product information
    private int intProductNumber;
    private String strProductDesc;
    private float fProductPrice;
    private int intQuantOnHand;
    private int intQuantOnOrder;
    private int intQuantSold;
    
   //Static Fields for Total Inventory
    private static int intDifferentProducts = 0; //Counter Variable
    private static int intTotalItems = 0; //Accumulator Value
    private static float fTotalValue = 0.0f; //Accumulator Value
    private static int intTotalItemsSold = 0; //Accumulator Value
    
   //No-Arg Constructor 
    public Inventory(){
        intProductNumber = 0;
        strProductDesc = "ProductName";
        fProductPrice = 0.0f;
        intQuantOnHand = 0;
        intQuantSold = 0;
    }
   //Constructor
    public Inventory(int intProductNumber, String strProductDesc, float fProductPrice, int intQuantOnHand, int intQuantOnOrder, int intQuantSold){
        this.intProductNumber = intProductNumber;
        this.strProductDesc = strProductDesc;
        this.fProductPrice = fProductPrice;
        this.intQuantOnHand = intQuantOnHand;
        this.intQuantOnOrder = intQuantOnOrder;
        this.intQuantSold = intQuantSold;
    }
    //Accessor Methods
    public int getProductNumber(){
        return intProductNumber;
    }
    public String getProductDesc(){
        return strProductDesc;
    }
    public float getProductPrice(){
        return fProductPrice;
    }
    public int getQuantOnHand(){
        return intQuantOnHand;
    }
    public int getQuantOnOrder(){
        return intQuantOnOrder;
    }
    public int getQuantSold(){
        return intQuantSold;
    }
    //Mutator Methods
    public void setProductNumber(int intProductNumber){
        this.intProductNumber = intProductNumber;
    }
    public void setProductNumber(String strProductNumber){
        this.intProductNumber = Integer.parseInt(strProductNumber);
    }
    public void setProductDesc(String strProductDesc){
        this.strProductDesc = strProductDesc;
    }
    public void setProductPrice(float fProductPrice){
        this.fProductPrice = fProductPrice;
    }
    public void setProductPrice(String strProductPrice){
        this.fProductPrice = Float.parseFloat(strProductPrice);
    }
    public void setQuantOnHand(int intQuantOnHand){
        this.intQuantOnHand = intQuantOnHand;
    }
    public void setQuantOnHand(String strQuantOnHand){
        this.intQuantOnHand = Integer.parseInt(strQuantOnHand);
    }
 
    public void setQuantOnOrder(int intQuantOnOrder){
        this.intQuantOnOrder = intQuantOnOrder;
    }
    public void setQuantOnOrder(String strQuantOnOrder){
        this.intQuantOnOrder = Integer.parseInt(strQuantOnOrder);
    }
    public void setQuantSold(int intQuantSold){
        this.intQuantSold = intQuantSold;
    }
    public void setQuantSold(String strQuantSold){
        this.intQuantSold = Integer.parseInt(strQuantSold);
    }

    //Instance Methods for Individual Product Inventory
    public int calculateCurrentProductQuantity(){
        int intQuantity;
        intQuantity = (intQuantOnHand + intQuantOnOrder) - intQuantSold;
        return intQuantity;
    }
    
    public float calculateCurrentProductValue(){
        float fProductValue;
        fProductValue = ((intQuantOnHand + intQuantOnOrder) - intQuantSold) * fProductPrice;
        return fProductValue;
    }
    
    public boolean checkProductLevel(){
        boolean warning = false;
        int quantity = (intQuantOnHand + intQuantOnOrder) - intQuantSold;
        if(quantity < 50){
            warning = true;
        }
        return warning;
    }

    //Static Methods for Total Product Inventory
    //Counter for Total Product Objects 
    public int calculateDifferentInventoryProducts(){
        intDifferentProducts += 1;
        return intDifferentProducts;
    }
    //Every Item in Inventory
    public int calculateTotalInventoryItems(){
        intTotalItems += ((intQuantOnHand + intQuantOnOrder) - intQuantSold);
        return intTotalItems;
    }
    //Every Item Sold from Inventory
    public int calculateTotalInventoryItemsSold(){
        intTotalItemsSold += intQuantSold;
        return intTotalItemsSold;
    }
    //Total Value of all Items in Inventory
    public float calculateTotalInventoryValue(){
        fTotalValue += ((intQuantOnHand + intQuantOnOrder) - intQuantSold) * fProductPrice;
        return fTotalValue;
    }

    //Reset Static Data Fields
    public static void clearInventoryData(){
        intDifferentProducts = 0;
        intTotalItems = 0;
        intTotalItemsSold = 0;
        fTotalValue = 0.0f;
    }

    //toString Methods
    public String intToString(int value){
        String str = Integer.toString(value);
        return str;
    }
    public String floatToString(float value){
        String str = Float.toString(value);
        return str;
    }
    
    //Inventory 
    public String InventoryToString(){
        int intCountProductObjects = calculateDifferentInventoryProducts();
        int intTotalItems = calculateTotalInventoryItems();
        float fInventoryValue = calculateTotalInventoryValue();
        
        String strInventory = "Total Inventory Products: " + intCountProductObjects + "\nTotal Items in Inventory: " + intTotalItems +
        "\nTotal Inventory Value: " + fInventoryValue;
        return strInventory;
    }  
}