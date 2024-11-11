package com.ps;

import java.util.Scanner;

public class UserInterface {

    private static Scanner cmdscnr = new Scanner(System.in);
    private static Scanner inptscnr = new Scanner(System.in);

    public void displayMainMenu() {
        int choice;

        do {
            System.out.println("Please select one of the following options -");
            System.out.println(" 1) Add a deposit");
            System.out.println(" 2) Add a payment");
            System.out.println(" 3) View your ledger");
            System.out.println(" 4) Exit ledger\n");
            System.out.print("Please enter the number that corresponds to your selection: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1:
                        //depositMenu();
                        break;
                    case 2:
                        //paymentMenu();
                        break;
                    case 3:
                        //ledgerMenu();
                        break;
                    case 4:
                        System.out.println("\nExiting...\nSee you soon :)");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nInvalid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }
}