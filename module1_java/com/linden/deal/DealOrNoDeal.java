package com.linden.deal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealOrNoDeal {
    // Get a List of possible case values from .01 to 1,000,000
    static List<Double> caseValues = GameSetup.getValues();

    public static void main(String[] args) {
        System.out.println("Welcome to Deal or No Deal!!");

        // Create empty List of BriefCase objects that will be populated
        List<BriefCase> caseList = new ArrayList<>();

        // This for loop creates 26 cases - with random values for every case
        for (int x = 0; x < 26; x++) {
            int listNum = RandomGenerator.getRandomNumberBetween(0, caseValues.size() );
            BriefCase newBriefCase = new BriefCase(x + 1, caseValues.get(listNum));
            caseList.add(newBriefCase);
            caseValues.remove(listNum);
        }

        // Show the new 26 BriefCases
        printCases(caseList);

        // Create a Scanner which will take user input
        Scanner scanner = new Scanner(System.in);

        int myCaseNumber = -1;
        // Loop until user has entered a valid case No. for their case
        while (myCaseNumber < 0) {
            System.out.println("\nPlease Choose your Case ");
            String caseNumber = scanner.nextLine();
            if (isCaseNumber(caseNumber)) {
                myCaseNumber = Integer.parseInt(caseNumber) - 1;
                BriefCase bc = caseList.get(myCaseNumber);
                bc.setMyCase(true);
            } else {
                System.out.println("\nPlease Enter a number between 1 and 26. ");
            }
        }

        // Show all cases with the user's chosen case
        printCases(caseList);

        int round = 0;
        boolean gameOver = false;

        // A Loop for each Round of the Game - currently only one
        // This can be expanded to handle multiple rounds
        while (!gameOver) {
            round++;

            // Setup empty List of cases numbers to Open
            List<Integer> casesToOpenList = new ArrayList<>();

            // Setup number of cases to open this round
            int casesToOpen = 7 - round;
            if (casesToOpen < 2) casesToOpen = 2;

            System.out.println("Round " + round);
            System.out.println("You now need to select " + casesToOpen + " cases to Open");

            // Loop until the casesToOpenList size matches the number of cases to open this round
            while (casesToOpenList.size() < casesToOpen) {
                System.out.println("\nPlease Enter an unopened Case Number ");
                String caseNumber = scanner.nextLine();
                if (isCaseNumber(caseNumber)) {
                    int n = Integer.parseInt(caseNumber) - 1;
                    casesToOpenList.add(n);

                    // Get BriefCase and set as opened
                    BriefCase bc = caseList.get(n);
                    bc.setOpened(true);
                } else {
                    System.out.println("\nPlease Enter a number between 1 and 26. ");
                }

            }

            // Print the list of All Cases showing the new opened case values
            printCases(caseList);

            // Get banker's offer and print it
            System.out.println("The Banker has an offer for you!");
            System.out.println("The offer is $" + String.format("%1$,.2f", bankerOffer(caseList)));

            // Ask for Deal or No Deal and get answer
            System.out.println("\nDeal or No Deal? ");
            String answer = scanner.nextLine();

            // End game for this first version of program
            gameOver = true;

            // Show your case value
            BriefCase myCase = caseList.get(myCaseNumber);
            System.out.println("Your case had $" + String.format("%1$,.2f", myCase.getCaseValue()));

        }
    }

    /**
     * Create an Offer amount based on total value of unopened cases divided by number of unopened cases.
     *
     * @param caseList  List of BriefCase Objects
     * @return          Double offer value
     */
    private static Double bankerOffer(List<BriefCase> caseList) {
        Double total = 0D;
        Double cases = 0D;
       // Loop through all BriefCases
        for (BriefCase bc : caseList) {

           // If the case has not be opened
            if (!bc.isOpened()) {
                total += bc.getCaseValue();
                cases++;
            }
        }
        return total / cases;
    }

    /**
     * Checks the caseNumber String and returns true if a number between 1 & 26.
     *
     * @param caseNumber    String case number value
     * @return              True if number between 1 & 26
     */
    private static boolean isCaseNumber(String caseNumber) {
        if (caseNumber == null || caseNumber.isEmpty()) return false;
        if (!caseNumber.chars().allMatch( Character::isDigit )) return false;
        int num = Integer.parseInt(caseNumber);
        if (num < 1 || num > 26) return false;
        return true;

    }

    /**
     * Prints out the 26 BriefCases, each case's number and value if opened.
     *
     * @param caseList  List of BriefCase Objects
     */
    private static void printCases(List<BriefCase> caseList){
        int lineOnesPrinted = 0;
        String lineTwo = "";

        // Loop through all cases
        for (int x = 0; x < caseList.size(); x++) {

            BriefCase bc = caseList.get(x);
            System.out.print(bc.getLineOne());
            lineOnesPrinted++;
            lineTwo += bc.getLineTwo();

            // After every 5 first lines printed (or the last case)
            // End the First line, print the second line, and add a blank line
            // Then reset the variables
            if (lineOnesPrinted == 5 || x == 25) {
                System.out.println();
                System.out.println(lineTwo);
                System.out.println();
                lineOnesPrinted = 0;
                lineTwo = "";
            }

        }
    }

}
