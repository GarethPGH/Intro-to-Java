import javax.swing.JOptionPane;

public class Employee{
    private String employeeName;
    private String employeeNumber;
    private String hireDate;
    public final String[] months = {"January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
   
   //Constructor set to take user input upon instantiation
    public Employee(){
       this.setEmployeeName();
       employeeName = this.getEmployeeName();
       this.setEmployeeNumber();
       employeeNumber = this.getEmployeeNumber();
       this.setHireDate();
       hireDate = this.getHireDate();
    }
   //Accessors 
    public String getEmployeeName(){
        return employeeName;
    }
    public String getEmployeeNumber(){
        return employeeNumber;
    }
    public String getHireDate(){
        return hireDate;
    }
   //Mutators
    public void setEmployeeName(){
        String fName = this.setFirstName();
        String lName = this.setLastName();
        if(fName == null || fName.equals("")){
            this.employeeName = "Employee Name";
        }else if(lName == null || lName.equals("") && fName != null && !fName.equals("")){
            this.employeeName = fName;
        }else if(lName != null && !lName.equals("") && fName != null && !fName.equals("")){
            this.employeeName = fName + " " + lName;
        }
    }
    public void setEmployeeNumber(){
        char separator = 'c';
        String number = "";
        int len = 0;
        String check1 = "";
        String check2 = "";
        number = JOptionPane.showInputDialog("Enter Employee Number, in the format of XXX-L,/nwhere X is a digit 0-9, and L is a letter A-M");
        if(number == null || number.equals("")){
            number = "111-L";
        }
        len = number.length();
       //Check Length
        if(len == 5){
            check1 = number.substring(0,3);
            check2 = number.substring(4); 
            separator = number.charAt(3);
        }else if(len > 5 || len < 5){
            JOptionPane.showMessageDialog(null, "This is not a valid number");
            this.setEmployeeNumber();
        }       
       //Check Separator
        if(separator != '-'){
            JOptionPane.showMessageDialog(null, "This is not a valid number");
            this.setEmployeeNumber();
        }
       //Check Contents
        if(!check1.matches("[0-9]+")){
            JOptionPane.showMessageDialog(null, "This is not a valid number");
            this.setEmployeeNumber();
        }
        if(!check2.matches("[A-Ma-m]+")){
            JOptionPane.showMessageDialog(null, "This is not a valid number");
            this.setEmployeeNumber();
        }
        String empNumber = number.substring(0,4) + number.substring(4).toUpperCase();
        if(number == "111-L"){
            empNumber = "Employee Number";
        }
        this.employeeNumber = empNumber;
    }

    public void setHireDate(){
        String date = "";
        String month = "";
        String day = "";
        String year = "";
        
        JOptionPane.showMessageDialog(null, "Enter Employee Hire Date");
        month = this.setMonth();
        day = this.setDay(month);
        year = this.setYear();
        if(month.equals("month") || day.equals("day") || year.equals("year")){
            date = "Date Hired";
        }else{
            date = String.format(month + " " + day + ", " + year);
        }
        this.hireDate = date;
    }
    
   //Private Name Methods
    private String setFirstName(){
        String placeholder = "";
        String firstName = "";
        placeholder = JOptionPane.showInputDialog("Enter Employee First Name");
        if(placeholder == null || placeholder.equals("")){
            firstName = "";
        }else if(placeholder.matches("[A-Za-z]+")){
            firstName = placeholder.substring(0,1).toUpperCase() + placeholder.substring(1);
        }else{
            JOptionPane.showMessageDialog(null, "That is not a valid name");
            this.setFirstName();
        } 
        return firstName;
    }
    private String setLastName(){
        String placeholder = "";
        String lastName = "";
        placeholder = JOptionPane.showInputDialog("Enter Employee Last Name");
        if(placeholder == null || placeholder.equals("")){
            lastName = "";
        }else if(placeholder.matches("[A-Za-z]+")){
            lastName = placeholder.substring(0,1).toUpperCase() + placeholder.substring(1);
        }else{
            JOptionPane.showMessageDialog(null, "That is not a valid name");
            this.setLastName();
        }
        return lastName;
    }
   //Private Date Methods
     private String setMonth(){
        String placeholder = "";
        String month = "";
        int counter = 0;
        String capitalize = "";
        placeholder = JOptionPane.showInputDialog("Month Hired");
        if(placeholder == null || placeholder.equals("")){
            month = "month";
        }else{
            capitalize = placeholder.substring(0,1).toUpperCase() + placeholder.substring(1);
            for(int i = 0; i < months.length; i++){
               if(capitalize.equals(months[i])){
                   month = capitalize;
                   break;
               }else{
                   counter += 1;
               }
            }
            if(counter == 12){
                JOptionPane.showMessageDialog(null, "That is not a valid Month");
                this.setMonth();
            }
        }
        return month;
    }
    
    private String setDay(String month){
       //For simplicity, this does not account for Leap Year
        String placeholder = "";
        String day = "day";
        int compareMe = 0;
    
        placeholder = JOptionPane.showInputDialog("Date hired");
        if(placeholder == null || placeholder.equals("")){
             day = "";
        }else{
           //Check if valid input
            if(placeholder.matches("[0-9]+")){
                compareMe = Integer.parseInt(placeholder);
            }else{
                JOptionPane.showMessageDialog(null, "This is not a valid date");
                   this.setDay(month);
            }
           //Months with 31 days
            if(month.equals("January") || month.equals("March") ||month.equals("May") ||month.equals("July") ||month.equals("August") ||month.equals("October") || month.equals("December")){
                if(compareMe >= 1 && compareMe <=31){
                   day = placeholder;
                }else{
                   JOptionPane.showMessageDialog(null, "This is not a valid date");
                   this.setDay(month); 
                }
           //Months with 30 days 
            }else if(month.equals("April") || month.equals("June") ||month.equals("September") ||month.equals("November")){
                if(compareMe >= 1 && compareMe <= 30){
                   day = placeholder;
                }else{
                   JOptionPane.showMessageDialog(null, "This is not a valid date");
                   this.setDay(month); 
                }
           //Feburary     
            }else if(month.equals("Feburary")){
                if(compareMe >= 1 && compareMe <= 28){
                   day = placeholder;
                }else{
                   JOptionPane.showMessageDialog(null, "This is not a valid date");
                   this.setDay(month); 
                }
            }
        }
        return day;
    }
   
    private String setYear(){
        String placeholder = "";
        String year = "";
        int compareMe = 0;
        int len = 0;
        
        placeholder = JOptionPane.showInputDialog("Year Hired");
        if(placeholder == null || placeholder.equals("")){
            year = "year";
        }else{
            if(placeholder.matches("[0-9]+")){
                compareMe = Integer.parseInt(placeholder);
                len = placeholder.length();
            }else{
                JOptionPane.showMessageDialog(null, "This is not a valid year");
                this.setYear();
            }
           //Heavily assuming no human alive started working prior to 1940
           //Since using Date.now is beyond the scope, not future proofed past 2020
            if(len == 4 && compareMe >= 1940 && compareMe <= 2020){
                year = placeholder;
            }else if(len == 2){
                if(compareMe >= 40 && compareMe <= 99){
                    year = "19" + placeholder;
                }else if(compareMe >= 0 && compareMe <= 9){
                    year = "200" + placeholder;
                }else if(compareMe >= 10 && compareMe <= 20){
                    year = "20" + placeholder;
                }
            }else{
                JOptionPane.showMessageDialog(null, "This is not a valid year");
                this.setYear();
            }
        }
        return year;
    }
}