/**
 * Validation Methods Class, written on 1/16/2020, by Gareth Warren
 * 
 * 
 * Contains methods for use with the StudentGUI class Extracted into utility
 * class for code reuse as Java practice
 * 
 * There are probably better validation methods, or libraries out there in
 * production land
 */

public class ValidationMethods {
    /**
     * Validates that credit hours can be parsed For use with the Student GUI
     * program May be removed from class for more generic use cases
     * 
     * @param str
     * @return
     */
    public static int validateCreditHours(String str) {
        int credits = 0;
        str = str.trim();
        try {
            credits = Integer.parseInt(str);
        } catch (Exception e) {
            credits = -1;
        }
        return credits;
    }

    /**
     * Validates an email field any combination of letters and numbers with an @
     * sign, followed by any combination of letters or numbers, followed by a
     * period, followed by a 3 digit suffix to represent any top level domain
     * 
     * @param str
     * @return
     */
    public static boolean validateEmail(String str) {
        boolean isValid = false;
        str = str.trim();
        String regex = "[A-Za-z0-9]*@{1}[A-Za-z0-9]*.{1}[a-z]{3}";
        if (str.matches(regex)) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * Validates whether Residency is C, OC, or OS For use with the StudentGUI
     * program May be removed from class for more generic use cases
     * 
     * @param str
     * @return
     */
    public static boolean validateResidency(String str) {
        boolean isValid = false;
        str = str.toUpperCase();
        str = str.trim();
        if (str.equals("C") || str.equals("OC") || str.equals("OS")) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * Validates a 5 digit, or 9 digit ZipCode, with or without a hyphen
     * 
     * @param str
     * @return
     */
    public static boolean validateZip(String str) {
        boolean isValid = false;
        str = str.trim();
        if (str.length() == 5 && str.matches("[0-9]{5}") || str.length() == 9 && str.matches("[0-9]{9}")
                || str.matches("[0-9]{5}-{1}[0-9]{4}")) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * Validates a State field. Checks to see if string is in the array of accepted
     * US states and abbreviations
     * 
     * @param str
     * @return
     */
    public static boolean validateState(String str) {
        boolean isValid = false;

        // Comparison Array
        String[] states = { "Alabama", "AL", "Alaska", "AK", "Arizona", "AZ", "Arkansas", "AR", "California", "CA",
                "Colorado", "CO", "Connecticut", "CT", "Delaware", "DE", "Florida", "FL", "Georgia", "GA", "Hawaii",
                "HI", "Idaho", "ID", "Illinois", "IL", "Indiana", "IN", "Iowa", "IA", "Kansas", "KS", "Kentucky", "KY",
                "Louisiana", "LA", "Maine", "ME", "Maryland", "MD", "Massachusetts", "MA", "Michigan", "MI",
                "Minnesota", "MN", "Mississippi", "MS", "Missouri", "MO", "Montana", "MT", "Nebraska", "NE", "Nevada",
                "NV", "New Hampshire", "NH", "New Jersey", "NJ", "New Mexico", "NM", "New York", "NY", "North Carolina",
                "NC", "North Dakota", "ND", "Ohio", "OH", "Oklahoma", "OK", "Oregon", "OR", "Pennsylvania", "PA",
                "Rhode Island", "RI", "South Carolina", "SC", "South Dakota", "SD", "Tennessee", "TN", "Texas", "TX",
                "Utah", "UT", "Vermont", "VT", "Virginia", "VA", "Washington", "WA", "West Virginia", "WV", "Wisconsin",
                "WI", "Wyoming", "WY" };

        for (String state : states) {
            if (str.equals(state)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    /**
     * Validates an address field Basically can accept a string with any combination
     * of random letters and numbers
     * 
     * @param str
     * @return
     */
    public static boolean validateAddress(String str) {
        boolean isValid = false;
        str = str.trim();
        if (str.length() > 0 && str.matches("[0-9A-Za-z\\s]*")) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * Validates a name field Includes hyphenated names, or single quotes such as in
     * O'Neill
     * 
     * @param str
     * @return
     */
    public static boolean validateName(String str) {
        boolean isValid = false;
        str = str.trim();
        if (str.length() > 0 && str.matches("[A-Za-z]*[\\s'-]?[A-Za-z]*")) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * Formats Strings and Returns them capitalized. Use cases: Names, and 1, or 2
     * digit abbreviations This should work for any string separated by spaces, of
     * any length
     * 
     * @param str
     * @return
     */
    public static String formatString(String str) {
        // Check null and reassign if null
        if (str != null) {
            str = str.trim();
        } else {
            str = "";
        }

        int len = str.length();

        if (len == 1 || len == 2) {
            str = str.toUpperCase();
        } else if (len > 2 && str.contains(" ")) {
            String[] splitString = str.split(" ");
            str = "";
            for (String segment : splitString) {
                segment = segment.substring(0, 1).toUpperCase() + segment.substring(1).toLowerCase();
                str += segment + " ";
            }
            str = str.trim();
        } else if (len > 2) {
            str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }
        return str;
    }

}