import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.io.File;

/**
 * Name: CurlyBraceChecker Date: 4/26/2021 Author: Gareth Warren
 * 
 * This program utilizes a Stack to determine if the Curly Braces in a given
 * Java File are paired properly as a psuedo-syntax checker
 */

public class CurlyBraceChecker {
    /**
     * Name Field, holds the name of a given file so it is accessible by both
     * methods
     */
    String name;

    /**
     * getBraces method takes a String, that is the name of a text file It reads the
     * File, and returns a Char[] that contains a copy of every Open and Closed
     * Curly Brace, contained within.
     * 
     * @param fileName
     * @return Char[]
     */
    public char[] getBraces(String fileName) {
        name = fileName;
        Scanner reader;
        ArrayList<Character> braces = new ArrayList<>();
        String input;
        char[] inputArr;
        char[] returnArr = {};

        try {
            File file = new File(fileName);
            reader = new Scanner(file);

            while (reader.hasNext()) {
                input = reader.nextLine();
                inputArr = input.toCharArray();
                for (char character : inputArr) {
                    if (character == '{') {
                        braces.add('{');
                    } else if (character == '}') {
                        braces.add('}');
                    }
                }
            }

            returnArr = new char[braces.size()];
            for (int index = 0; index < returnArr.length; index++) {
                returnArr[index] = braces.get(index);
            }
            reader.close();

        } catch (Exception exception) {
            System.out.println("File not found. Exiting program.");
            System.exit(0);
        }
        return returnArr;
    }

    /**
     * countBraces method takes a Char[], and utilizes a Stack to count the number
     * of braces. It prints whether or not the Curly Braces are evenly matched (and
     * that the file would run), based upon pushing and popping values from the
     * Stack
     * 
     * @param arr
     */
    public void countBraces(char[] arr) {
        Stack<Character> stackChecker = new Stack<Character>();
        int openBraceCounter = 0;
        int closeBraceCounter = 0;
        int totalBraces = arr.length;

        // Count Number of Braces
        for (int index = 0; index < totalBraces; index++) {
            if (arr[index] == '{') {
                openBraceCounter++;
            }
        }
        closeBraceCounter = totalBraces - openBraceCounter;

        // There must be an Even number of Braces for the file to run
        if ((totalBraces % 2) != 0) {
            System.out.println(name + " contains a total of " + totalBraces + " Braces, with " + openBraceCounter
                    + " Open Braces and " + closeBraceCounter + " Close Braces."
                    + "\nBrace Count is Odd. This means the Braces are Uneven. The file will not run.");
            return;
        }
        // Use a Stack to determine whether or not the Braces are Balanced
        for (int index = 0; index < totalBraces; index++) {
            if (arr[index] == '{') {
                stackChecker.push(arr[index]);

            } else if (arr[index] == '}') {
                try {
                    stackChecker.pop();
                } catch (EmptyStackException exception) {
                    // Checks condition where brace pattern is similar to {}}
                    System.out.println(name + " contains a total of " + totalBraces + " Braces, with "
                            + openBraceCounter + " Open Braces and " + closeBraceCounter + " Close Braces."
                            + "The Braces are Uneven, and the file will not run, due to missing Open Brace(s)");
                    return;
                }
            }
        }
        // If Stack is Empty, it means the Braces are Even. If not, it means there is an
        // excess of Open Braces
        if (stackChecker.isEmpty()) {
            System.out.println(name + " contains a total of " + totalBraces + " Braces, with " + openBraceCounter
                    + " Open Braces, and Close Braces." + "\n The Braces are even and the file " + name + " will run.");
        } else {
            System.out.println(name + " contains a total of " + totalBraces + " Braces, with " + openBraceCounter
                    + " Open Braces and " + closeBraceCounter + " Close Braces."
                    + "\n The braces are not even, and the file will fail to run, due to excess, unpaired, Open Brace(s).");
        }
    }

    /**
     * Main Method Allows for a User to test multiple files, but will run the test
     * on Both SportsTeam1.java, and SportsTeam2.java prior to User Interaction.
     */
    public static void main(String args[]) {
        String fileName = "SportsTeam1.java";
        Boolean flag = true;
        Scanner keyboard = new Scanner(System.in);
        CurlyBraceChecker curlyBraces = new CurlyBraceChecker();

        System.out.println("Testing File Checker...");

        char[] braces = curlyBraces.getBraces(fileName);
        curlyBraces.countBraces(braces);

        fileName = "SportsTeam2.java";
        braces = curlyBraces.getBraces(fileName);
        curlyBraces.countBraces(braces);

        while (flag) {
            System.out.println("Do you wish to test another file? Type Yes or No");

            String placeholder = keyboard.nextLine();

            if (placeholder.toUpperCase().equals("YES")) {
                System.out.println(
                        "Enter the name, or fully qualified path, of another file, followed by the .java extension");
                fileName = keyboard.nextLine();
                braces = curlyBraces.getBraces(fileName);
                curlyBraces.countBraces(braces);
            } else {
                System.out.println("Have a Nice Day.");
                flag = false;
            }
        }
        keyboard.close();
    }

}