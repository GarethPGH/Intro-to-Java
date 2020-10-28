/*
name: InventoryTestClass
date: 10/27/2020
author: Gareth Warren

Small test class to verify results using Inventory Class
*/

public class InventoryTestClass {
   public static void main(String[] args){
      
      Inventory inventory = new Inventory(1,"something",1f,1,1,1);

      int current = inventory.calculateCurrentProductQuantity(); //Should be 1
      float currentValue = inventory.calculateCurrentProductValue();//Should be 1
      int counter = inventory.calculateDifferentInventoryProducts(); //Should be 1
      int accumItems = inventory.calculateTotalInventoryItems(); //Should be 1
      float accumValue = inventory.calculateTotalInventoryValue(); //Should be 1
      int accumSold = inventory.calculateTotalInventoryItemsSold(); //Should be 1
      boolean isLessThan50 = inventory.checkProductLevel(); //Should be true
      
      System.out.println("Current: " + current + " Current Value: " + currentValue + " Counter: " + counter + 
      " Total Items: " + accumItems + " Total Value: "  + accumValue + " Total Sold: " + accumSold + " Is less than 50: " + isLessThan50);

      inventory.setProductNumber(2);
      inventory.setProductDesc("blah");
      inventory.setQuantOnHand(100);
      inventory.setQuantOnOrder(100);
      inventory.setProductPrice(2f);
      inventory.setQuantSold(0);
      
      current = inventory.calculateCurrentProductQuantity(); //Should be 200
      currentValue = inventory.calculateCurrentProductValue();//Should be 400
      counter = inventory.calculateDifferentInventoryProducts(); //Should be 2
      accumItems = inventory.calculateTotalInventoryItems(); //Should be 201
      accumValue = inventory.calculateTotalInventoryValue(); //Should be 401
      accumSold = inventory.calculateTotalInventoryItemsSold(); //Should be 1
      isLessThan50 = inventory.checkProductLevel(); //Should be false
      
      System.out.println("Current: " + current + " Current Value: " + currentValue + " Counter: " + counter + 
      " Total Items: " + accumItems + " Total Value: "  + accumValue + " Total Sold: " + accumSold+ " Is less than 50: " + isLessThan50);
   }
}
