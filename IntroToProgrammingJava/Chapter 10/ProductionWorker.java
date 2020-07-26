import javax.swing.JOptionPane;

public class ProductionWorker extends Employee{
    private int shift;
    private String hourlyPay;
    
    public ProductionWorker(){
        super();//Call Base Constructor
   
        this.setShift();
        shift = this.getShift();
        this.setHourlyPay();
        hourlyPay = this.getHourlyPay();
    }
    
   //Accessors
    public int getShift(){
        return shift;
    }
    
    public String getHourlyPay(){
        return hourlyPay;
    }
    
   //Mutators
    public void setShift(){
        shift = 0;
        String workShift = "";
        workShift = JOptionPane.showInputDialog("Enter Employee Shift: Day or Night");
     
        if(workShift == null || workShift.equals("")){
            this.shift = 0;
        }else if(workShift.equals("Day") || workShift.equals("day")){
            this.shift = 1;
        }else if(workShift.equals("Night") || workShift.equals("night")){
            this.shift = 2;
        }else if(workShift != "Night" && workShift != "night" && workShift != "day" && workShift != "Day"){
            JOptionPane.showMessageDialog(null, "That is not a valid shift for this position");
            this.setShift();
        }
    }
    
    public void setHourlyPay(){
        hourlyPay = "";
        String placeholder = "";
        double pay = 0.0;
        placeholder = JOptionPane.showInputDialog("Enter Employee Hourly Pay");
        if(placeholder == null || placeholder.equals("")){
            this.hourlyPay = "Hourly Payrate";
        }else if(placeholder.matches("[0-9]+[.]?[0-9]*")){
            pay = Double.parseDouble(placeholder);
            String payrate = String.format("$" + "%,.2f", pay);
            this.hourlyPay = payrate;
        }else{
            JOptionPane.showMessageDialog(null, "That is not a valid pay rate");
            this.setHourlyPay();
        }
    }
}