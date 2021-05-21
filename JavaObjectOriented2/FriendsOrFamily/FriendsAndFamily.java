/**
 * name: FriendsAndFamily
 * date: 2/19/2021
 * author: Gareth Warren
 * 
 * Console Application Main Class allows for a user to enter information about the people they know.
 * It creates objects and from the Friend and Family classes using the information provided and displays their toString output.
 */
package CIT244_LabAssignments.Wk2;

import java.util.Scanner;
import CIT244_LabAssignments.Wk2.Friend;
import CIT244_LabAssignments.Wk2.Family;

public class FriendsAndFamily {

    /**
     * Creates an Object Array with size provided by the user
     * 
     * @param keyboard
     * @return Object[] returnObject
     */
    public Object[] getSize(Scanner keyboard) {
        String placeholder;
        Object[] returnObject;
        int size = 0;
        boolean isValid = false;

        while (isValid != true) {
            System.out.println("How many people do you want to enter?");
            placeholder = keyboard.nextLine();
            if (placeholder.matches("[0-9]+")) {
                size = Integer.parseInt(placeholder);
            }
            if (size > 0) {
                isValid = true;
            } else if (size <= 0) {
                System.out.println("Size must be a positive whole number");
            }
        }

        returnObject = new Object[size];
        return returnObject;
    }

    /**
     * Allows user to decide whether person is friend or family member Return value
     * is used to trigger appropriate program execution
     * 
     * @param keyboard
     * @return int status
     */
    public int friendOrFamily(Scanner keyboard) {
        int status = 2;
        String relationship;

        System.out.println("Is this person a friend or family member? Type Friend or Family");
        System.out.println("If you type anything else, the program will exit");

        relationship = keyboard.nextLine();
        relationship = relationship.trim().toLowerCase();

        if (relationship.equals("family")) {
            status = 1;
        } else if (relationship.equals("friend")) {
            status = 0;
        }

        return status;
    }

    /**
     * Allows user to type in the name of a person
     * 
     * @param keyboard
     * @param status
     * @return String name
     */
    public String getName(Scanner keyboard, int status) {
        String name = "";
        String[] splitString;
        boolean isValid = false;

        if (status == 0) {
            System.out.println("What is your friend's name?");
        } else if (status == 1) {
            System.out.println("What is your family member's name?");
        } else if (status == 2) {
            System.out.println("Program exiting");
            System.exit(0);
        }
        while (isValid == false) {
            name = keyboard.nextLine();
            if (name.matches("[A-Za-z '-]+")) {
                isValid = true;
            } else {
                System.out.println("Name must not contain any numbers. Please re-enter the person's name");
            }
        }

        if (name.length() > 2 && name.contains(" ")) {
            splitString = name.split(" ");
            name = "";
            for (String segment : splitString) {
                segment = segment.substring(0, 1).toUpperCase() + segment.substring(1).toLowerCase();
                name += segment + " ";
            }
            name = name.trim();
        } else if (name.length() > 2) {
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }

        return name;
    }

    /**
     * Allows user to type in their relationship to a person
     * 
     * @param keyboard
     * @param memberName
     * @return String relationship
     */
    public String getRelation(Scanner keyboard, String memberName) {
        String relationship = "";
        boolean isValid = false;

        /*
         * Since the vast array of human relationships is rather large. I am foregoing a
         * proper check right now. String must not contain any numbers
         */

        while (isValid == false) {
            System.out.println("How are you related to " + memberName + "?");
            relationship = keyboard.nextLine();
            if (relationship.matches("[A-Za-z '-]+")) {
                isValid = true;
            } else {
                System.out.println("Relationship must not contain any numbers");
            }
        }

        return relationship;
    }

    /**
     * Allows user to determine how long they have known a person
     *
     * @param keyboard
     * @param memberName
     * @return int time
     */
    public int getTimeKnown(Scanner keyboard, String memberName) {
        int time = 0;
        String placeholder;
        boolean isValid = false;

        while (isValid == false) {
            System.out.println("How long have you known " + memberName + "?");
            placeholder = keyboard.nextLine();

            if (placeholder.matches("[0-9]+")) {
                time = Integer.parseInt(placeholder);
                isValid = true;
            } else {
                System.out.println("Time must be a positive whole number");
            }
        }

        return time;
    }

    /**
     * Displays the toString method from all of the objects in the supplied array
     */
    public void display(Object[] friendOrFamily) {
        for (Object member : friendOrFamily) {
            System.out.print(member.toString());
            System.out.println();
        }
    }

    /** Main Method of class */
    public static void main(String args[]) {
        FriendsAndFamily group = new FriendsAndFamily();
        Scanner keyboard = new Scanner(System.in);
        Object[] peopleArray;
        int index = 0;
        String intro;
        Friend friendMember;
        Family familyMember;
        int timeKnown;
        String relation;

        System.out.println(
                "Do you wish to enter information about the people you known? Anything other than Yes will terminate the program.");

        intro = keyboard.nextLine();
        intro = intro.trim().toLowerCase();

        if (intro.equals("yes")) {
            peopleArray = group.getSize(keyboard);

            while (index < peopleArray.length) {

                int type = group.friendOrFamily(keyboard);
                String name = group.getName(keyboard, type);
                if (type == 0) {
                    timeKnown = group.getTimeKnown(keyboard, name);
                    friendMember = new Friend(name, timeKnown);
                    peopleArray[index] = friendMember;
                } else if (type == 1) {
                    relation = group.getRelation(keyboard, name);
                    familyMember = new Family(name, relation);
                    peopleArray[index] = familyMember;
                }
                if (index != peopleArray.length - 1) {
                    System.out.println("Please enter information about the next person");
                }
                index++;
            }
            group.display(peopleArray);
        } else {
            System.out.println("Program Exiting");
        }

        System.exit(0);
    }
}
