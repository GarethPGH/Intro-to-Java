import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;

/**
 * Name: Caesar Cipher Date: 3/10/2021 Author: Gareth Warren
 * 
 * Program allows the user to open a file, and decrypt the contents using the
 * decrypt method if it is a text file. The user must know the specific amount
 * of places to shift the string contents to display the file's decrypted text.
 * Text files must be saved in the project folder to be opened, unless supplied
 * with a fully qualified path name or a FileNotFound exception will occur.
 * 
 * For the purposes of testing, supply password.txt, and 5 in response to the
 * user prompts.
 */

public class CaesarCipher_Warren {

    /**
     * Decrypt method takes a string and an integer that serve to shift the contents
     * of a decrypted string. The index is then adjusted based on whether or not it
     * falls within the acceptable range of the indicies of the English alphabet
     * array [0-25]. It then returns the decrypted string
     * 
     * @param str
     * @param shift
     * @return
     */
    public static String decrypt(String str, int shift) {
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] encryptedStr = str.toCharArray();
        char[] decryptedStr = new char[str.length()];
        int shiftedIndex = 0;
        String decryptedString = "";

        for (int index = 0; index < str.length(); index++) {
            for (int index2 = 0; index2 < letters.length; index2++) {

                if (encryptedStr[index] == letters[index2]) {
                    // If shift is negative, make positive
                    if (shift < 0) {
                        shift = shift * -1;
                    }

                    shiftedIndex = index2 - shift;

                    // Readjust shiftedIndex
                    if (shiftedIndex > 25) {
                        shiftedIndex = 26 - (shiftedIndex % 26);
                    } else if (shiftedIndex < -25) {
                        shiftedIndex = (26 - ((shiftedIndex * -1) % 26));
                    } else if (shiftedIndex < 0 && shiftedIndex >= -25) {
                        shiftedIndex = 26 - (shiftedIndex * -1);
                    }

                    if (shiftedIndex == 26) {
                        shiftedIndex = 0;
                    }
                }

                decryptedStr[index] = letters[shiftedIndex];
            }
        }

        for (int index = 0; index < decryptedStr.length; index++) {
            decryptedString += String.valueOf(decryptedStr[index]);
        }

        return decryptedString;
    }

    /**
     * Main Method. Prompts for a name of a file, and an integer to pass to the
     * decrypt method. Program closes if File is not found Program will continue to
     * prompt for a valid integer value
     * 
     * @param args
     */
    public static void main(String args[]) {
        String decryptedString = "";
        String fileString = "";
        int shift = -1;
        boolean isValid = false;
        String filename;
        File file;
        Scanner scanFile;
        Scanner scanInput = new Scanner(System.in);
        StringBuilder listOfFileContents = new StringBuilder();

        System.out.println("Enter the name of a file to decrypt");
        filename = scanInput.next();
        // Remove newline in the buffer
        System.out.println(scanInput.nextLine());

        try {
            file = new File(filename);
            scanFile = new Scanner(file);

            while (isValid == false) {
                System.out.println("Enter a value between 0 and 25 to change the text in the file");
                try {
                    shift = Integer.parseInt(scanInput.nextLine());
                    isValid = true;
                } catch (NumberFormatException exception) {
                    System.out.println("Please re-enter your value.");
                }
            }
            scanInput.close();

            while (scanFile.hasNext()) {
                fileString = scanFile.nextLine();
                decryptedString = decrypt(fileString, shift);
                listOfFileContents.append(decryptedString + '\n');
            }
            scanFile.close();

            listOfFileContents.trimToSize();
            System.out.println(listOfFileContents);

        } catch (FileNotFoundException exception) {
            System.out.println("File not Found. Exiting Program");
            System.exit(0);
        }
    }
}