
/**
 * name: Souper Bowl date: 4/12/2021 author: Gareth Warren
 * 
 * This program pulls data from Ticketcity using JSoup to create a list of teams
 * that won the Super Bowl
 */

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SouperBowl {

    /**
     * gatherData method uses the JSoup API to create an Array that holds the names of the
     * winning teams
     * 
     * @param teamArray
     * @return String[]
     */
    public static String[] gatherData(String[] teamArray) {
        Document document = null;
        int index = 0;
        Elements tableData;
        Element targetElement;
        String targetString = "";

        try {
            document = Jsoup.connect("https://blog.ticketcity.com/nfl/super-bowl/super-bowl-champions/").get();
        } catch (IOException exception) {
            System.out.println("Can't Connect to the Site. Exiting program");
            System.exit(0);
        }
        tableData = document.getElementsByTag("tr");

        for (Element div : tableData) {
            targetElement = div.child(2);
            targetString = targetElement.text();

            if (!targetString.equalsIgnoreCase("Champion") && !targetString.equalsIgnoreCase("TBD")) {
                teamArray[index] = targetString;
                index++;
            }
        }

        return teamArray;
    }

    /**
     * displayData displays a list of Super Bowl winners and the game they won
     * 
     * @param teamArray
     */
    public static void displayData(String[] teamArray) {
        System.out.println("Super Bowl Champions");

        for (int index = 0; index < teamArray.length; index++) {
            System.out.println("Game " + (index + 1) + " : " + teamArray[index]);
        }

        System.out.println();
    }

    /**
     * numberOfTimesTeamWon displays the number of times a team won. If the supplied
     * team has never won, it displays the fact they never won.
     * 
     * @param teamArray
     * @param teamName
     */
    public static void numberOfTimesTeamWon(String[] teamArray, String teamName) {
        int counter = 0;
        for (int index = 0; index < teamArray.length; index++) {
            if (teamArray[index].equalsIgnoreCase(teamName)) {
                counter += 1;
            }
        }
        if (counter == 0) {
            System.out.println("The " + teamName + " never won the Super Bowl.");
        } else {
            System.out.println("The " + teamName + " won the Super Bowl " + counter + " times!");
        }
    }

    /**
     * Main prompts the user for their favorite team and then asks if they wish to
     * see the full list of past winners
     * 
     * @param args
     */
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        String[] superBowlChampions = new String[55];
        String input = "";

        superBowlChampions = gatherData(superBowlChampions);

        System.out.println("Please enter your favorite team to see if they ever won the Super Bowl");
        input = keyboard.nextLine();

        numberOfTimesTeamWon(superBowlChampions, input);

        System.out.println("Do you want to see the list of past winners? Type Yes or No");
        input = keyboard.nextLine();

        if (input.equalsIgnoreCase("Yes")) {
            displayData(superBowlChampions);
        }

        keyboard.close();
        System.exit(0);
    }
}