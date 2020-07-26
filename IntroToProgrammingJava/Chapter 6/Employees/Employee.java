public class Employee{
    //Fields
    private String name;
    private int idNumber;
    private String department;
    private String position;
    
    //Constructors
    public Employee(){
        name = "";
        idNumber = 0;
        department = "";
        position = "";
    }
    public Employee(String employeeName, int employeeId){
        name = employeeName;
        idNumber = employeeId;
        department = "";
        position = "";
    }
    public Employee(String employeeName, int employeeId, String assignedDepartment, String jobTitle){
        name = employeeName;
        idNumber = employeeId;
        department = assignedDepartment;
        position = jobTitle;
    }
    
    //Mutator Methods
    public void setEmployeeName(String employeeName){
        name = employeeName;
    }
    public void setEmployeeId(int employeeId){
        idNumber = employeeId;
    }
    public void setEmployeeDepartment(String assignedDepartment){
        department = assignedDepartment;
    }
    public void setEmployeePosition(String jobTitle){
        position = jobTitle;
    }
    
    //Accessor Methods
    public String getEmployeeName(){
        return name;
    }
    public int getEmployeeId(){
        return idNumber;
    }
    public String getEmployeeDepartment(){
        return department;
    }
    public String getEmployeePosition(){
        return position;
    }
}