import javax.swing.JOptionPane;

public class ShiftSupervisor extends Employee{
   
    private String salary;
    private String bonus;
    
    public ShiftSupervisor(){
        super();
   
        this.setSalary();
        salary = this.getSalary();
        this.setBonus();
        bonus = this.getBonus();
    }
   //Accessors
    public String getSalary(){
        return salary;
    }
    
    public String getBonus(){
        return bonus;
    }
   //Mutators
    public void setSalary(){
        String placeholder = "";
        int pay = 0;
        String supervisorSalary = "";
        placeholder = JOptionPane.showInputDialog("Enter Shift Supervisor Salary");
        if(placeholder == null || placeholder.equals("")){
            supervisorSalary = "Salary";
        }else if(placeholder.matches("[0-9]+")){
            pay = Integer.parseInt(placeholder);
            supervisorSalary = String.format("$" + "%,d", pay);
        }else{
            JOptionPane.showMessageDialog(null, "That is not a valid salary");
            this.setSalary();
        }
      
        this.salary = supervisorSalary;
    }
    
    public void setBonus(){
        String placeholder = "";
        String prodBonus = "";
        int pay = 0;
        placeholder = JOptionPane.showInputDialog("Enter Production Bonus");
        if(placeholder == null || placeholder.equals("")){
            prodBonus = "Bonus";
        }else if(placeholder.matches("[0-9]+")){
            pay = Integer.parseInt(placeholder);
            prodBonus = String.format("$" + "%,d", pay);
        }else{
            JOptionPane.showMessageDialog(null, "That is not a valid salary");
            this.setBonus();
        }
      
        this.bonus = prodBonus;
    }
}