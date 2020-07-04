/*
name: RetailCatalog
date: 6/19/2020
author: Gareth Warren
*/
import javax.swing.JOptionPane;

public class RetailCatalog{
    public static void main(String args[]){
       //Items
        RetailItem Item1 = new RetailItem("Jacket", 12, 59.95);
        RetailItem Item2 = new RetailItem("Designer Jeans", 40, 34.95);
        RetailItem Item3 = new RetailItem("Shirt", 20, 24.95);
        
       //Display Catalog
        String catalog = String.format("Item: " + Item1.getDescription() + "   Number of Units: " + Item1.getNumberOfUnits() + "   Price per unit: $" + Item1.getPrice() + '\n' + 
                                   "Item: " + Item2.getDescription() + "   Number of Units: " + Item2.getNumberOfUnits() + "   Price per unit: $" + Item2.getPrice() + '\n' +  
                                   "Item: " + Item3.getDescription() + "   Number of Units: " + Item3.getNumberOfUnits() + "   Price per unit: $" + Item3.getPrice());
        
        JOptionPane.showMessageDialog(null, catalog);
        
        System.exit(0); 
    }
}