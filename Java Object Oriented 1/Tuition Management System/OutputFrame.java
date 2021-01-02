/**
name: OutputFrame
date: 12/7/2020
author: Gareth Warren

GUI Class to output information using Student, FulltimeStudent, and PartTimeStudent classes
Features a Splitpane JList which displays the names of students. 
Selecting a name displays individual information about the student, 
including personal information from the StudentGUI class textfields, 
student Id, and what fees they are assigned 
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.SwingConstants;
import javax.swing.event.*;
import java.lang.Exception;
import java.util.*;
import java.text.DecimalFormat;

public class OutputFrame extends JFrame{
    private ArrayList<Student> StudentsList = new ArrayList<Student>();
    private ArrayList<double[]> StudentFeeList = new ArrayList<double[]>();

    private final int MAX_HEIGHT = 800;
    private final int MAX_WIDTH = 600;
    //List Model Needed to Add Students to List
    private DefaultListModel listModel = new DefaultListModel();
       
    private JLabel nameLabel = new JLabel("",  SwingConstants.CENTER);
    private JLabel idLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel stateLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel addressLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel residentLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel zipLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel creditsLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel emailLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel tuitionLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel collfeeLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel capfeeLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel malpracLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel accidentLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel stuservLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel totalfeeLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel totalcostLabel = new JLabel("", SwingConstants.CENTER);
    private JLabel[] labels = {nameLabel, idLabel, stateLabel, addressLabel, residentLabel, zipLabel, creditsLabel, emailLabel,
                    tuitionLabel, collfeeLabel, capfeeLabel, malpracLabel, accidentLabel, stuservLabel, totalcostLabel, totalfeeLabel};

    public JList<Student> listStudent = new JList<Student>(listModel);

    public OutputFrame(){
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(MAX_WIDTH, MAX_HEIGHT);
        JPanel masterPanel = new JPanel(new BorderLayout());
        masterPanel.setBackground(Color.DARK_GRAY);
        JSplitPane list = buildList();
        JPanel banner = buildBanner();
        Font font = new Font("Verdana", Font.PLAIN, 12);
        for (JLabel label : labels){
            label.setBackground(Color.DARK_GRAY);
            label.setForeground(Color.LIGHT_GRAY);
            label.setFont(font);
        }
        
        masterPanel.add(banner, BorderLayout.NORTH);
        masterPanel.add(list, BorderLayout.CENTER);
        Border line = BorderFactory.createLineBorder(Color.DARK_GRAY, 20);
        masterPanel.setBorder(line);
        add(masterPanel);

        listStudent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listStudent.addListSelectionListener(new listListener());
        listStudent.setFixedCellWidth(200);
        listStudent.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Student) {
                    ((JLabel) renderer).setText(((Student) value).getStudentName());
                }
                return renderer;
            }
        });
        //Visible 
        setVisible(false);
        setResizable(false);
    } 
    public void setData(Student student){
        StudentsList.add(student);
        
        listModel.addElement(student);
    }
    private JSplitPane buildList(){
        listStudent.setVisibleRowCount(50);
        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(200);
        splitPane.resetToPreferredSizes();
        splitPane.setLeftComponent(new JScrollPane(listStudent));
        
        JPanel panel = new JPanel(new GridLayout(16,1));
        panel.setBackground(Color.DARK_GRAY);
    
        panel.add(nameLabel);
        panel.add(idLabel);
        panel.add(emailLabel);
        panel.add(addressLabel);
        panel.add(stateLabel);
        panel.add(zipLabel);
        panel.add(creditsLabel);
        panel.add(residentLabel);
        panel.add(tuitionLabel);
        panel.add(collfeeLabel);
        panel.add(capfeeLabel);
        panel.add(malpracLabel);
        panel.add(accidentLabel);
        panel.add(stuservLabel);
        panel.add(totalfeeLabel);
        panel.add(totalcostLabel);

        splitPane.setRightComponent(panel);
        
        JPanel labelPanel = new JPanel();
        labelPanel.setBackground(Color.DARK_GRAY);
        return splitPane;
    }
    private JPanel buildBanner(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
    
        JLabel label = new JLabel("List of Students", SwingConstants.CENTER);
        Font font = new Font("Verdana", Font.BOLD, 22);
        label.setFont(font);
        label.setForeground(Color.MAGENTA);

        panel.add(label);

        return panel;
    }

    private void setInfo(Student student){
        int credits = student.getCreditHours();
        String decStr = "";
        double fee = 0.0;
        DecimalFormat df = new DecimalFormat("0.00");
        nameLabel.setText("Name: " + student.getStudentName());
        idLabel.setText("Student Id: " + student.getStudentId());
        addressLabel.setText("Address: " + student.getStudentAddress());
        stateLabel.setText("State: " + student.getState());
        zipLabel.setText("Zip Code: " + student.getZipCode());
        emailLabel.setText("Email: " + student.getEmail());
        creditsLabel.setText("Registered Credit Hours: " + credits);
        residentLabel.setText("Residency Status: " + student.getResidentStatus());
        fee = student.calculateTuitionCost();
        decStr = df.format(fee);
        tuitionLabel.setText(String.format("Tuition Cost: $" + decStr));
        fee = student.calculateCollegeFee();
        decStr = df.format(fee);
        collfeeLabel.setText(String.format("College Fee: $" + decStr));
        fee = student.calculateCapitalFee();
        decStr = df.format(fee);
        capfeeLabel.setText(String.format("Capital Fee: $" + decStr));
        fee = student.calculateMalpracticeInsuranceFee();
        decStr = df.format(fee);
        malpracLabel.setText(String.format("Malpractice Insurance Fee: $" + decStr));
        fee = student.calculateAccidentInsuranceFee();
        decStr = df.format(fee);
        accidentLabel.setText(String.format("Accident Insurance Fee: $" + decStr));
        fee = student.calculateStudentServicesFee();
        decStr = df.format(fee);
        stuservLabel.setText(String.format("Student Services Fee: $" + decStr));
        fee = student.calculateTotalCollegeFees();
        decStr = df.format(fee);
        totalfeeLabel.setText(String.format("Total Fees: $" + decStr));
        fee = student.calculateTotalCollegeCost();
        decStr = df.format(fee);
        totalcostLabel.setText(String.format("Total College Cost: $" + decStr));
    }

    private class listListener implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent event){
            Student student = listStudent.getSelectedValue();
            setInfo(student);
        }
    };
}