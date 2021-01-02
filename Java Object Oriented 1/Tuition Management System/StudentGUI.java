/** 
name: StudentGUI
date: 12/7/2020
author: Gareth Warren

StudentGUI features a form to input student information
Validation checks prevent invalid data from being sent to OuputFrame, and the user is informed to re-enter data
Add Student adds a student to the ArrayList that is sent to OutputFrame
View Student List makes the OutputFrame visible, which contains a student list
Exit Program will end the program
 
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.lang.Exception;
import java.util.*;

public class StudentGUI extends JFrame{
    private final int MAX_HEIGHT = 600;
    private final int MAX_WIDTH = 800;
    //Student Info
    private JTextField txtName = new JTextField(20);
    private JTextField txtEmail = new JTextField(20);
    private JTextField txtAddress = new JTextField(20);
    private JTextField txtState = new JTextField(10);
    private JTextField txtZip = new JTextField(10);
    private JTextField txtResidency = new JTextField(10);
    private JTextField txtCredits = new JTextField(10);
    private JTextField txtStuID = new JTextField(10);

    OutputFrame output = new OutputFrame();
    
    GrayJOptionPane pane = new GrayJOptionPane();

    public StudentGUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create Master Panel
        JPanel masterPanel = new JPanel(new BorderLayout());
        masterPanel.setBackground(Color.DARK_GRAY);
        masterPanel.setSize(MAX_WIDTH, MAX_HEIGHT);
        Border margin = BorderFactory.createLineBorder(Color.DARK_GRAY,5);
        //build panels
        JPanel banner = buildBanner();
        JPanel name = buildPanel("Student Name:", txtName);
        JPanel address = buildPanel("Home Address:", txtAddress);
        JPanel state = buildPanel("Home State:", txtState);
        JPanel email = buildPanel("Email Address:", txtEmail);
        JPanel zipcode = buildPanel("Zip Code:", txtZip);
        JPanel credits = buildPanel("Registered Credit Hours:", txtCredits);
        JPanel residency = buildPanel("Residency Status:", txtResidency);
        JPanel textfields = new JPanel(new GridLayout(4,2));
        JPanel buttons = buildButtons();
    
        textfields.setBackground(Color.DARK_GRAY);
        textfields.add(name);
        textfields.add(email);
        textfields.add(address);
        textfields.add(residency);
        textfields.add(state);
        textfields.add(credits);
        textfields.add(zipcode);
        textfields.setBorder(margin);
        
        masterPanel.add(banner, BorderLayout.NORTH);
        masterPanel.add(textfields, BorderLayout.CENTER);
        masterPanel.add(buttons, BorderLayout.SOUTH);
        add(masterPanel);
        
        //Border
        Border line = BorderFactory.createLineBorder(Color.DARK_GRAY, 20);
        masterPanel.setBorder(line);
        
        //Visible true
        setVisible(true);
        setResizable(false);
        //pack
        pack();

    }
    private JPanel buildPanel(String title, JTextField txtField){
        JPanel panel = new JPanel(new GridLayout(1,2));
        JLabel label = new JLabel(title, SwingConstants.LEFT);
        Font font = new Font("Verdana", Font.PLAIN ,12);
        label.setFont(font);
        panel.setBackground(Color.DARK_GRAY);
        label.setForeground(Color.LIGHT_GRAY);
        
        panel.add(label);
        panel.add(txtField);
        
        Border line = BorderFactory.createMatteBorder(0,7,7,5, Color.DARK_GRAY);
        panel.setBorder(line);
        
        return panel;
    }
    private JPanel buildBanner(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
    
        JLabel label = new JLabel("Tuition Information System", SwingConstants.CENTER);
        Font font = new Font("Verdana", Font.BOLD, 22);
        label.setFont(font);
        label.setForeground(Color.MAGENTA);

        panel.add(label);

        return panel;
    }
    private JPanel buildButtons(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
         
        JButton addButton = new JButton("Add Student");
        JButton studentButton = new JButton("View Student List");
        JButton exitButton = new JButton("Exit Program");
        addButton.addActionListener(new StudentGUI.AddStudentListener());
        studentButton.addActionListener(new StudentGUI.SeeStudentsListener());
        exitButton.addActionListener(new StudentGUI.ExitListener());

        addButton.setBackground(Color.BLACK);
        studentButton.setBackground(Color.BLACK);
        exitButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.MAGENTA);
        studentButton.setForeground(Color.MAGENTA);
        exitButton.setForeground(Color.MAGENTA);

        panel.add(addButton);
        panel.add(studentButton);
        panel.add(exitButton);
        
        return panel;
    }
    private class AddStudentListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            //TextFields
            String strName = txtName.getText();
            String strEmail = txtEmail.getText();
            String strResident = txtResidency.getText();
            String strAdd = txtAddress.getText();
            String strState = txtState.getText();
            String strZip = txtZip.getText();
            String strCredits = txtCredits.getText();

            int credits = validateCreditHours(strCredits);
            int counter = 0;
            Student student;
            //Validate Credits create Type Student 
            if(credits > 0 && credits <= 11){
                student = new PartTimeStudent();
                counter +=1;
            }else if(credits > 11){
                student = new FullTimeStudent();
                counter +=1;
            }else{
                //if either of the two assignments fail, return to caller
                txtCredits.setText("Invalid");
                pane.showMessageDialog(null, "Credit Hours must be included to proceed. Re-enter and Try Again.");
                return;
            }
            student.setCreditHours(credits);
            //Validate Email
            if(validateEmail(strEmail)){
                student.setEmail(strEmail);
                counter +=1;
            }else{
                txtEmail.setText("Invalid");
            }
            //Validate Residency
             strResident = formatString(strResident);
            if(validateResidency(strResident)){
                student.setResidentStatus(strResident);
                counter +=1;
            }else{
                txtResidency.setText("Invalid");
            }
            //Validate Zip
            if(validateZip(strZip)){
                student.setZipCode(strZip);
                counter+=1;
            }else{
                txtZip.setText("Invalid");
            }
            //Validate State
            strState = formatString(strState);
            if(validateState(strState)){
                student.setState(strState);
                counter+=1;
            }else{
                txtState.setText("Invalid");
            }
            //Validate Name
            strName = formatString(strName);
            if(validateName(strName)){
                student.setStudentName(strName);
                counter+=1;
            }else{
                txtName.setText("Invalid");
            }
            //Validate Address
            strAdd = formatString(strAdd);
            if(validateAddress(strAdd)){
                student.setStudentAddress(strAdd);
                counter+=1;
            }else{
                txtAddress.setText("Invalid");
            }

            if(counter == 7){
                student.setStudentId();
                output.setData((Student)student);
            }else if (counter != 7){
                pane.showMessageDialog(null,"One, or more, Textfields are Invalid. Double check Student Information, Re-enter, and Try Again");
            }
        }
        private int validateCreditHours(String str){
            int credits = 0;
            str = str.trim();
            try {
                credits = Integer.parseInt(str);
            } catch (Exception e) {
                credits = -1;
            }
            return credits;
        }
        private boolean validateEmail(String str){
            boolean isValid = false;
            str = str.trim();
            String regex = "[A-Za-z0-9]*@{1}[A-Za-z0-9]*.{1}[a-z]{3}"; 
            if(str.matches(regex)){
                isValid = true;
            }
            return isValid;
        }
        private boolean validateResidency(String str){
            boolean isValid = false;
            str = str.toUpperCase();
            str = str.trim();
            if(str.equals("C") || str.equals("OC") || str.equals("OS")){
                isValid = true;
            }
            return isValid;
        }
        private boolean validateZip(String str){
            boolean isValid = false;
            str = str.trim();
            if(str.length() == 5 && str.matches("[0-9]{5}")|| str.length() == 9 && str.matches("[0-9]{9}") || str.matches("[0-9]{5}-{1}[0-9]{4}")){
                isValid = true;
            }
            return isValid;
        }
        private boolean validateState(String str){
            boolean isValid = false;
            
            //Comparison Array
            String[] states = {"Alabama", "AL","Alaska","AK","Arizona","AZ","Arkansas","AR","California","CA",
                   "Colorado","CO", "Connecticut","CT","Delaware","DE","Florida","FL","Georgia","GA","Hawaii","HI",
                   "Idaho","ID","Illinois","IL","Indiana","IN","Iowa","IA","Kansas","KS","Kentucky","KY","Louisiana","LA",
                   "Maine","ME","Maryland","MD","Massachusetts","MA","Michigan","MI","Minnesota","MN","Mississippi","MS",
                   "Missouri","MO","Montana","MT","Nebraska","NE","Nevada","NV","New Hampshire","NH","New Jersey","NJ",
                   "New Mexico","NM","New York","NY","North Carolina","NC","North Dakota","ND","Ohio","OH","Oklahoma","OK",
                   "Oregon","OR","Pennsylvania","PA","Rhode Island","RI","South Carolina","SC","South Dakota","SD","Tennessee","TN",
                   "Texas","TX","Utah","UT","Vermont","VT","Virginia","VA","Washington","WA","West Virginia","WV",
                   "Wisconsin","WI","Wyoming","WY"};

            for(String state: states){
                if(str.equals(state)){
                    isValid = true;
                    break;
                }
            }
            return isValid;
        }
         private boolean validateAddress(String str){
            boolean isValid = false;
            str = str.trim();
            if(str.length() > 0 && str.matches("[0-9A-Za-z\\s]*")){
                isValid = true;
            }
            return isValid;
        }
        private boolean validateName(String str){
            boolean isValid = false;
            str = str.trim();
            if(str.length() > 0 && str.matches("[A-Za-z]*[\\s'-]?[A-Za-z]*")){
                isValid = true;
            }
            return isValid;
        }
        private String formatString(String str){
            str = str.trim();
            int len = str.length();
            if(len == 1 || len == 2){
                str = str.toUpperCase();
            }else if(len > 2 && str.contains(" ")){
                String[] splitString = str.split(" ");
                str = "";
                for(String segment: splitString){
                    segment = segment.substring(0,1).toUpperCase() + segment.substring(1).toLowerCase();
                    str += segment + " ";
                }
                str = str.trim();
            }else if(len > 2){
                str = str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
            }else if(str == null){
                str = "";
            }
            return str;
        }
    }
    private class SeeStudentsListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            output.setLocation(400,40);
            output.setVisible(true);
        }
    }
    private class ExitListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            System.exit(0);
        }
    }
    public class GrayJOptionPane extends JOptionPane{
        public GrayJOptionPane(){
            UIManager.put("OptionPane.background", Color.DARK_GRAY);
            UIManager.put("OptionPane.messageForeground", Color.RED);
            UIManager.put("Panel.background", Color.DARK_GRAY);
        }
    }
    public static void main(String args[]){
        new StudentGUI();
    }
}