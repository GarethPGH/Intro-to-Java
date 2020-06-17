/*
name: Information
date: 5/24/2020
author: Gareth Warren

Display each on a separate line, using only 1 println:
Name
Address, with City, State, Zip
Tele Number
College Major*/

public class Information{
    public static void main(String args[]){
       //Variables
       String name = "Gareth";
       String address = "100 Cherrywood St. Pittsburgh Pa, 15212";
       String phoneNumber = "545-657-7259";
       String collegeMajor = "Software Development";
       
       System.out.println(name + '\n' + address + '\n' + phoneNumber + '\n' + collegeMajor);
    }
}