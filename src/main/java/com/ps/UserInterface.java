package com.ps;

import com.ps.signaturesandwiches.*;
import com.ps.structure.Sandwich;
import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;
import java.util.Scanner;

public class UserInterface {

    private static Scanner cmdscnr = new Scanner(System.in);
    private static Scanner inptscnr = new Scanner(System.in);

    public void mainMenu() {
        int choice;

        do {
            System.out.println("We're excited serve you today! What would you like to do?");
            System.out.println(" 1) Start a New Order");
            System.out.println(" 0) Exit\n");
            System.out.print("Please enter the number that corresponds to your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1:
                        orderMenu();
                        break;
                    case 0:
                        System.out.println("\nThanks for stopping by! We hope to see you again soon :)");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nOops! That's not a valid choice. Please enter 1 or 0.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please enter 1 or 0.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private void orderMenu() {
        int choice;

        do {
            System.out.println("\nTime to make it yours! - What's next for your order?");
            System.out.println(" 1) Add Sandwich - Customize your perfect bite!");
            System.out.println(" 2) Add Drink - Stay refreshed!");
            System.out.println(" 3) Add Chips - Crunchy goodness on the side!");
            System.out.println(" 4) Checkout - Let's finalize your order!");
            System.out.println(" 0) Cancel Order - Start from scratch!\n");
            System.out.print("Please enter the number that corresponds to your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1:
                        addSandwich();
                        break;
                    case 2:
                        //addDrink();
                        break;
                    case 3:
                        //addChips();
                        break;
                    case 4:
                        //checkoutOrder();
                        break;
                    case 0:
                        System.out.println("\nOrder canceled. Returning to Home Screen...\n");
                        return;
                    default:
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private void addSandwich() {
        int choice;

        do {
            System.out.println("\nLet's create your sandwich! What would you like to do?");
            System.out.println(" 1) Choose a Signature Sandwich and Customize!");
            System.out.println(" 2) Build Your Own Sandwich!\n");
            System.out.print("Please enter the number that corresponds to your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1:
                        displaySignatureSandwiches();
                        break;
                    case 2:
                        //buildYourOwnSandwich();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private void displaySignatureSandwiches() {
        int choice;

        do {
            System.out.println("\nHere are our delicious signature sandwiches:");

            Sandwich blt = new BLT(SandwichSize.MEDIUM, BreadType.WHITE, true);
            Sandwich phillyCheeseSteak = new PhillyCheeseSteak(SandwichSize.MEDIUM, BreadType.WHITE, true);
            Sandwich veggieDelight = new VeggieDelight(SandwichSize.MEDIUM, BreadType.WHEAT, false);
            Sandwich meatLovers = new MeatLovers(SandwichSize.MEDIUM, BreadType.WHITE, true);
            Sandwich italianSpecial = new ItalianSpecial(SandwichSize.MEDIUM, BreadType.WHITE, true);

            System.out.println(" 1) BLT - " + blt.getDescription());
            System.out.println(" 2) Philly Cheese Steak - " + phillyCheeseSteak.getDescription());
            System.out.println(" 3) Veggie Delight - " + veggieDelight.getDescription());
            System.out.println(" 4) Meat Lover's - " + meatLovers.getDescription());
            System.out.println(" 5) Italian Special - " + italianSpecial.getDescription() + "\n");
            System.out.print("Please select a sandwich to customize or enter 0 to go back: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1:
                        //customizeSignatureSandwich(blt);
                        break;
                    case 2:
                        //customizeSignatureSandwich(phillyCheeseSteak);
                        break;
                    case 3:
                        //customizeSignatureSandwich(veggieDelight);
                        break;
                    case 4:
                        //customizeSignatureSandwich(meatLovers);
                        break;
                    case 5:
                        //customizeSignatureSandwich(italianSpecial);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }
}