
/*
 name: SortSearchAssign
 date: 4/6/2021
 author: Gareth Warren 
 Wrote main, and getArray
 Altered createFile to return a File object
 Comments about my findings at end of file
*/

import java.io.*;
import java.util.*;

public class SortSearchAssign_ {
    // Method which generates text file containing 1 million random numbers
    public static File createFile() {
        // File to be created in default directory
        File file = new File("somanynumbers.txt");
        Random rng = new Random();
        int r;

        try {
            // Create the file
            PrintWriter output = new PrintWriter(file);

            // Write random numbers into a file
            for (int i = 0; i < 1000000; i++) {
                // Genereates a random number in range of (0 - 100)
                r = rng.nextInt(101);
                output.write(r + ", ");
            }
            System.out.println("File created.");
            // Close file
            output.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Cannot do that.");
        }

        return file;
    }

    // STUDENT TO DO
    public static int[] getArray(File file) {
        int[] intArray;
        ArrayList<String> unformattedFileContents = new ArrayList<String>();
        String[] stringArray;
        String fileContents;

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                unformattedFileContents.add(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File not found. Exiting program");
            System.exit(0);
        }

        fileContents = unformattedFileContents.toString();
        fileContents = fileContents.substring(1, fileContents.length() - 1);
        stringArray = fileContents.split(", ");
        intArray = new int[stringArray.length];

        try {
            for (int index = 0; index < intArray.length; index++) {
                intArray[index] = Integer.parseInt(stringArray[index]);
            }
        } catch (NumberFormatException exception) {
            System.out.println("Does not contain Integers. Exiting program");
            System.exit(0);
        }

        return intArray;
    }

    public static void main(String[] args) {

        // Retrieve intArray of Million ints
        File intFile = createFile();
        int[] sortedArray = getArray(intFile);
        int[] copiedArray = sortedArray.clone();
        AllSearch SearchMethod = new AllSearch();
        AllSorts SortMethod = new AllSorts();
        long startTime = 0L;
        long endTime = 0L;
        int searchIndex = 0;

        // Compare search and sort algorithms
        // Sort Methods

        // Takes too long: Bubble Sort
        // startTime = System.currentTimeMillis();
        // sortedArray = SortMethod.bubbleSort(arrayToSortnSearch);
        // endTime = System.currentTimeMillis();
        // System.out.println("Bubble Sort took " + (endTime - startTime) + "
        // milliseconds");

        // Takes too long: Selection Sort
        // startTime = System.currentTimeMillis();
        // sortedArray = SortMethod.selectionSort(arrayToSortnSearch);
        // endTime = System.currentTimeMillis();
        // System.out.println("Selection Sort took " + (endTime - startTime) + "
        // milliseconds");

        // Takes too long: Insertion Sort
        // startTime = System.currentTimeMillis();
        // sortedArray = SortMethod.insertionSort(arrayToSortnSearch);
        // endTime = System.currentTimeMillis();
        // System.out.println("Insertion Sort took " + (endTime - startTime) +
        // "milliseconds");

        // Quickest: Merge Sort
        startTime = System.currentTimeMillis();
        sortedArray = SortMethod.mergeSort(sortedArray);
        endTime = System.currentTimeMillis();
        System.out.println("Merge Sort took " + (endTime - startTime) + " milliseconds");

        // Fairly Quick: QuickSort
        startTime = System.currentTimeMillis();
        sortedArray = SortMethod.quickSort(sortedArray, sortedArray.length / 4, sortedArray.length - 4);
        endTime = System.currentTimeMillis();
        System.out.println("Quick Sort took " + (endTime - startTime) + " milliseconds");

        System.out.println();

        // Search Methods
        // Passing Original Array to Linear Search
        System.out.println("Unsorted Linear Search");
        startTime = System.currentTimeMillis();
        searchIndex = SearchMethod.linearSearch(copiedArray, 93);
        System.out.println("Number Found at: " + searchIndex + " index");
        endTime = System.currentTimeMillis();
        System.out.println("Unsorted Linear Search took " + (endTime - startTime) + " milliseconds");

        System.out.println();

        // Passing Sorted Array to Linear Search
        System.out.println("Sorted Linear Search");
        startTime = System.currentTimeMillis();
        searchIndex = SearchMethod.linearSearch(sortedArray, 93);
        System.out.println("Number Found at: " + searchIndex + " index");
        endTime = System.currentTimeMillis();
        System.out.println("Sorted Linear Search took " + (endTime - startTime) + " milliseconds");

        System.out.println();

        // Passing Sorted Array to Jump Search
        System.out.println("Sorted Jump Search");
        startTime = System.currentTimeMillis();
        searchIndex = SearchMethod.jumpSearch(sortedArray, 93);
        System.out.println("Number Found at: " + searchIndex + " index");
        endTime = System.currentTimeMillis();
        System.out.println("Sorted Jump Search took " + (endTime - startTime) + " milliseconds");

        System.out.println();

        // Passing Sorted Array to Binary Search
        System.out.println("Binary Search");
        startTime = System.currentTimeMillis();
        searchIndex = SearchMethod.binSearch(sortedArray, 93);
        System.out.println("Number Found at: " + searchIndex + " index");
        endTime = System.currentTimeMillis();
        System.out.println("Binary Search took " + (endTime - startTime) + " milliseconds");

        /*
         * Sorts take a long time compared to Searches. So, in most cases, Linear Search
         * would be a better alternative unless there is a way to ensure that data is
         * always entered or used in sorted order. Linear Search seems to take 2-7ms.
         * 
         * In the case of needing to perform a sort and use a search method, Merge Sort
         * followed by Binary Search will likely be the best option. Binary Search runs
         * 0-1ms in each pass through. Jump Search seems to take a bit longer.
         * 
         * Merge Sort takes around 200-400 ms. Quick Sort takes a bit longer than Merge
         * Sort, but it is still fairly quick, taking between 2,000-6,000ms
         * 
         * In no cases are Insertion Sort, Selection Sort, or Bubble Sort appropriate
         * for an array of this size. Insertion Sort took somewhere around 43,000ms. I
         * didn't even let the other two finish, because they were taking too long. All
         * three are commented out to prevent them from running.
         * 
         * Worst case would likely be to perform a Bubble Sort followed by a Linear
         * Search, especially if the element is at the end of the sorted array.
         */
    }

}
