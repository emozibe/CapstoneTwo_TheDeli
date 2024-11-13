package com.ps;

import com.ps.structure.*;
import com.ps.signaturesandwiches.*;
import com.ps.enums.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static final Scanner cmdscnr = new Scanner(System.in);
    private static final Scanner inptscnr = new Scanner(System.in);
    private Order order = new Order();
    private final List<Sandwich> sandwich = new ArrayList<>();
    //private List<Drink> drink = new ArrayList<>();
    //private List<Chips> chip = new ArrayList<>();

    public void mainMenu() {
        int choice;

        do {
            System.out.println("\n\uD83E\uDD6A --- Welcome to DELI-cious! --- \uD83E\uDD6A\n");
            System.out.println("We're excited to serve you today! What would you like to do?");
            System.out.println(" 1) Start a New Order");
            System.out.println(" 0) Exit");
            System.out.print("\nPlease enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1 -> orderMenu();
                    case 0 -> {
                        System.out.println("\nThanks for stopping by! We hope to see you again soon :)");
                        System.exit(0);
                    }
                    default -> System.out.println("\nOops! That's not a valid choice. Please enter 1 or 0.\n");
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
            System.out.println("\n--- Order Menu ---");
            System.out.println("Time to make it yours! What would you like to add?");
            System.out.println(" 1) Add Sandwich - Customize your perfect bite!");
            System.out.println(" 2) Add Drink - Stay refreshed!");
            System.out.println(" 3) Add Chips - Crunchy goodness on the side!");
            System.out.println(" 4) Checkout - Let's finalize your order!");
            System.out.println(" 0) Cancel Order - Start from scratch!");
            System.out.print("\nPlease enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1 -> addSandwich();
                    case 2 -> addDrink();
                    case 3 -> addChips();
                    case 4 -> checkoutOrder();
                    case 0 -> {
                        System.out.println("\nOrder canceled. Returning to Home Screen...");
                        sandwich.clear();
                        return;
                    }
                    default -> System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private void checkoutOrder() {
        System.out.println("Order summary and receipt creation.");
    }

    private void addSandwich() {
        int choice;

        do {
            System.out.println("\n--- Sandwich Creation ---");
            System.out.println("Let's create your sandwich! What would you like to do?");
            System.out.println(" 1) Choose a Signature Sandwich and Customize!");
            System.out.println(" 2) Build Your Own Sandwich!");
            System.out.println(" 0) Go Back to Order Menu");
            System.out.print("\nPlease enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1 -> displaySignatureSandwiches();
                    case 2 -> {
                        Sandwich customSandwich = buildYourOwnSandwich();
                        order.addItem(customSandwich);
                    }
                    case 0 -> {
                        System.out.println("\nReturning to Order Menu...\n");
                        return;  // Exit the loop and return to orderMenu
                    }
                    default -> System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private void addDrink() {
        System.out.println("Drink added to your order!");
    }

    private void addChips() {
        System.out.println("Chips added to your order!");
    }

    private void displaySignatureSandwiches() {
        int choice;
        Sandwich[] sandwiches = {
                new BLT(SandwichSize.MEDIUM, BreadType.WHITE, true),
                new PhillyCheeseSteak(SandwichSize.MEDIUM, BreadType.WHITE, true),
                new VeggieDelight(SandwichSize.MEDIUM, BreadType.WHEAT, false),
                new MeatLovers(SandwichSize.MEDIUM, BreadType.WHITE, true),
                new ItalianSpecial(SandwichSize.MEDIUM, BreadType.WHITE, true)
        };

        do {
            System.out.println("\n--- Signature Sandwiches ---");
            for (int i = 0; i < sandwiches.length; i++) {
                System.out.println(" " + (i + 1) + ") " + sandwiches[i].getName() + " - " + sandwiches[i].getDescription());
            }
            System.out.print("\nSelect a sandwich to customize, or enter 0 to go back: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                if (choice == 0) return;
                if (choice >= 1 && choice <= sandwiches.length) {
                    Sandwich selectedSandwich = sandwiches[choice - 1];
                    customizeSignatureSandwich(selectedSandwich);
                } else {
                    System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private void customizeSignatureSandwich(Sandwich selectedSandwich) {
        BreadType breadType = selectBreadType();
        SandwichSize sandwichSize = selectSandwichSize();
        selectedSandwich.setBreadType(breadType);
        selectedSandwich.setSandwichSize(sandwichSize);

        System.out.println("\nHere are the default toppings for your " + selectedSandwich.getName() + ":");
        viewCurrentToppings(selectedSandwich, false);
        System.out.print("Would you like to customize the toppings? (1 for Yes, 2 for No): ");

        int customizeChoice = cmdscnr.nextInt();
        cmdscnr.nextLine();
        if (customizeChoice == 1) {
            modifyToppings(selectedSandwich);
        }
        order.addItem(selectedSandwich);
        System.out.println("\nYour customized " + selectedSandwich.getName() + " has been added to your order!\n");
    }

    private Sandwich buildYourOwnSandwich() {
        System.out.println("\n--- Build Your Own Sandwich ---");
        System.out.println("Let's start with the basics!");

        // Select Bread Type
        BreadType breadType = selectBreadType();

        // Select Sandwich Size
        SandwichSize sandwichSize = selectSandwichSize();

        // Toasted Option
        boolean toasted = askIfToasted();

        // Create custom sandwich with selected options
        Sandwich customSandwich = new CustomSandwich(sandwichSize, breadType, toasted);

        System.out.println("\nNow, let's add your toppings!");

        // Add Toppings
        selectToppings(customSandwich);

        System.out.println("\nYour custom sandwich has been added to your order!");
        return customSandwich;
    }

    private BreadType selectBreadType() {
        int choice;

        do {
            System.out.println("\n--- Select Bread Type ---");
            System.out.println(" 1) White");
            System.out.println(" 2) Wheat");
            System.out.println(" 3) Rye");
            System.out.println(" 4) Wrap");
            System.out.print("\nPlease enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1 -> {
                        return BreadType.WHITE;
                    }
                    case 2 -> {
                        return BreadType.WHEAT;
                    }
                    case 3 -> {
                        return BreadType.RYE;
                    }
                    case 4 -> {
                        return BreadType.WRAP;
                    }
                    default -> System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private SandwichSize selectSandwichSize() {
        int choice;

        do {
            System.out.println("\n--- Select Sandwich Size ---");
            System.out.println(" 1) Small (4\") - $5.50");
            System.out.println(" 2) Medium (8\") - $7.00");
            System.out.println(" 3) Large (12\") - $8.50");
            System.out.print("\nPlease enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1 -> {
                        return SandwichSize.SMALL;
                    }
                    case 2 -> {
                        return SandwichSize.MEDIUM;
                    }
                    case 3 -> {
                        return SandwichSize.LARGE;
                    }
                    default -> System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private boolean askIfToasted() {
        int choice;

        do {
            System.out.println("\n--- Toasted Option ---");
            System.out.println("Would you like your sandwich toasted?");
            System.out.println(" 1) Yes");
            System.out.println(" 2) No");
            System.out.print("\nPlease enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.println("\nGot it! Toasting your sandwich.");
                        return true;
                    }
                    case 2 -> {
                        System.out.println("\nLeaving your sandwich untoasted.");
                        return false;
                    }
                    default -> System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private List<Topping> selectToppings(Sandwich sandwich) {
        List<Topping> toppings = sandwich.getCurrentToppings();
        int choice;

        do {
            System.out.println("\n--- Topping Selection ---");
            System.out.println("Select a topping category:");
            System.out.println(" 1) Meat");
            System.out.println(" 2) Cheese");
            System.out.println(" 3) Veggies");
            System.out.println(" 4) Condiments");
            System.out.println(" 5) View/remove current toppings");
            System.out.println(" 0) Done with toppings");
            System.out.print("\nPlease enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1 -> {
                        addUniqueToppings(toppings, selectMeat(sandwich.getSandwichSize()));
                        viewCurrentToppings(sandwich, false);
                    }
                    case 2 -> {
                        addUniqueToppings(toppings, selectCheese(sandwich.getSandwichSize()));
                        viewCurrentToppings(sandwich, false);
                    }
                    case 3 -> {
                        addUniqueToppings(toppings, selectVeggies(sandwich.getSandwichSize()));
                        viewCurrentToppings(sandwich, false);
                    }
                    case 4 -> {
                        addUniqueToppings(toppings, selectCondiments(sandwich.getSandwichSize()));
                        viewCurrentToppings(sandwich, false);
                    }
                    case 5 -> viewCurrentToppings(sandwich, true);
                    case 0 -> {
                        System.out.println("\nAll toppings selected. Moving to the next step!\n");
                        return toppings;
                    }
                    default -> System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private void addUniqueToppings(List<Topping> currentToppings, List<Topping> newToppings) {
        for (Topping topping : newToppings) {
            if (currentToppings.contains(topping)) {
                System.out.println("The topping " + topping.getName() + " is already on your sandwich!");
            } else {
                currentToppings.add(topping);
                System.out.println(topping.getName() + " added to your sandwich!");
            }
        }
    }

    private void modifyToppings(Sandwich sandwich) {
        int choice;

        System.out.println("\n--- Modify Toppings ---");
        System.out.println("Let's customize the toppings on your " + sandwich.getName() + "!\n");

        do {
            // Display current toppings for review
            System.out.println("Current toppings on your sandwich:");
            viewCurrentToppings(sandwich, false);

            // Display modification options
            System.out.println("\nWhat would you like to do?");
            System.out.println(" 1) Add Toppings");
            System.out.println(" 2) Remove Toppings");
            System.out.println(" 0) Done with customization");
            System.out.print("\nEnter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.println("\n--- Add Toppings ---");
                        List<Topping> newToppings = selectToppings(sandwich);
                        for (Topping topping : newToppings) {
                            sandwich.addTopping(topping);
                            System.out.println(topping.getName() + " added!");
                        }
                    }
                    case 2 -> {
                        System.out.println("\n--- Remove Toppings ---");
                        removeToppings(sandwich);
                    }
                    case 0 -> {
                        System.out.println("\nAll set! Finished customizing your toppings.");
                        return;
                    }
                    default -> System.out.println("\nOops! That's not a valid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.");
                cmdscnr.next();
            }
        } while (true);
    }

    private void removeToppings(Sandwich sandwich) {
        int choice;

        do {
            List<Topping> currentToppings = sandwich.getCurrentToppings();
            if (currentToppings.isEmpty()) {
                System.out.println("\nYour sandwich currently has no toppings to remove.");
                return;
            }

            System.out.println("\n--- Current Toppings ---");
            System.out.println("Size: " + sandwich.getSandwichSize() + ", Bread Type: " + sandwich.getBreadType() +
                    ", Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));

            double totalPrice = sandwich.getBasePrice();
            for (int i = 0; i < currentToppings.size(); i++) {
                Topping topping = currentToppings.get(i);
                double price = topping.getPrice();
                totalPrice += price;
                System.out.printf(" %d) %s%s: $%.2f\n", i + 1, topping.getName(), (topping.isExtra() ? " (Extra)" : ""), price);
            }

            System.out.printf("\nTotal Sandwich Price: $%.2f\n\n", totalPrice);
            System.out.print("Enter the number of the topping to remove or 0 to finish: ");
            choice = cmdscnr.nextInt();
            cmdscnr.nextLine();

            if (choice == 0) {
                System.out.println("\nFinished removing toppings.\n");
                return;
            } else if (choice > 0 && choice <= currentToppings.size()) {
                Topping toppingToRemove = currentToppings.get(choice - 1);
                sandwich.removeTopping(toppingToRemove);
                System.out.println(toppingToRemove.getName() + " removed from your sandwich!");
            } else {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
            }
        } while (true);
    }

    private List<Topping> selectMeat(SandwichSize size) {
        List<Topping> meats = new ArrayList<>();
        int choice;
        boolean extraMeat;

        do {
            System.out.println("\n--- Select Meat ---");
            System.out.println(" 1) Bacon");
            System.out.println(" 2) Ham");
            System.out.println(" 3) Chicken");
            System.out.println(" 4) Steak");
            System.out.println(" 5) Roast Beef");
            System.out.println(" 6) Salami");
            System.out.println(" 0) Done with meat!\n");
            System.out.print("Please enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                if (choice == 0) return meats;

                String meatName;
                switch (choice) {
                    case 1 -> meatName = "Bacon";
                    case 2 -> meatName = "Ham";
                    case 3 -> meatName = "Chicken";
                    case 4 -> meatName = "Steak";
                    case 5 -> meatName = "Roast Beef";
                    case 6 -> meatName = "Salami";
                    default -> {
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                        continue;
                    }
                }

                // Calculate extra meat cost based on size
                double extraCost = switch (size) {
                    case SMALL -> 0.50;
                    case MEDIUM -> 1.00;
                    case LARGE -> 1.50;
                };

                System.out.printf("\nWould you like extra %s for an additional $%.2f? (1 for Yes, 2 for No): ", meatName, extraCost);
                int extraChoice = cmdscnr.nextInt();
                cmdscnr.nextLine();
                extraMeat = (extraChoice == 1);

                // Create Meat topping with the selected options
                Meat meatTopping = new Meat(meatName, size, extraMeat);
                meats.add(meatTopping);
                System.out.println(meatName + (extraMeat ? " with extra meat" : "") + " added to your sandwich!");

            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private List<Topping> selectCheese(SandwichSize size) {
        List<Topping> cheeses = new ArrayList<>();
        int choice;
        boolean extraCheese;

        do {
            System.out.println("\n--- Select Cheese ---");
            System.out.println(" 1) American");
            System.out.println(" 2) Provolone");
            System.out.println(" 3) Cheddar");
            System.out.println(" 4) Swiss");
            System.out.println(" 0) Done with cheese!\n");
            System.out.print("Please enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                if (choice == 0) return cheeses;

                String cheeseName;
                switch (choice) {
                    case 1 -> cheeseName = "American";
                    case 2 -> cheeseName = "Provolone";
                    case 3 -> cheeseName = "Cheddar";
                    case 4 -> cheeseName = "Swiss";
                    default -> {
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                        continue;
                    }
                }

                // Calculate extra cheese cost based on size
                double extraCost = switch (size) {
                    case SMALL -> 0.30;
                    case MEDIUM -> 0.60;
                    case LARGE -> 0.90;
                };

                System.out.printf("\nWould you like extra %s for an additional $%.2f? (1 for Yes, 2 for No): ", cheeseName, extraCost);
                int extraChoice = cmdscnr.nextInt();
                cmdscnr.nextLine();
                extraCheese = (extraChoice == 1);

                // Create Cheese topping with the selected options
                Cheese cheeseTopping = new Cheese(cheeseName, size, extraCheese);
                cheeses.add(cheeseTopping);
                System.out.println(cheeseName + (extraCheese ? " with extra cheese" : "") + " added to your sandwich!");

            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private List<Topping> selectVeggies(SandwichSize size) {
        List<Topping> veggies = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Select Veggies ---");
            System.out.println(" 1) Lettuce");
            System.out.println(" 2) Peppers");
            System.out.println(" 3) Onions");
            System.out.println(" 4) Tomatoes");
            System.out.println(" 5) Jalapeños");
            System.out.println(" 6) Cucumbers");
            System.out.println(" 7) Pickles");
            System.out.println(" 8) Guacamole");
            System.out.println(" 9) Mushrooms");
            System.out.println(" 0) Done with veggies!\n");
            System.out.print("Please enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                if (choice == 0) return veggies;

                String veggieName;
                switch (choice) {
                    case 1 -> veggieName = "Lettuce";
                    case 2 -> veggieName = "Peppers";
                    case 3 -> veggieName = "Onions";
                    case 4 -> veggieName = "Tomatoes";
                    case 5 -> veggieName = "Jalapeños";
                    case 6 -> veggieName = "Cucumbers";
                    case 7 -> veggieName = "Pickles";
                    case 8 -> veggieName = "Guacamole";
                    case 9 -> veggieName = "Mushrooms";
                    default -> {
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                        continue;
                    }
                }

                Veggies veggieTopping = new Veggies(veggieName, size);
                veggies.add(veggieTopping);
                System.out.println(veggieName + " added.");

            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private List<Topping> selectCondiments(SandwichSize size) {
        List<Topping> condiments = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Select Condiments ---");
            System.out.println(" 1) Mayo");
            System.out.println(" 2) Mustard");
            System.out.println(" 3) Ketchup");
            System.out.println(" 4) Ranch");
            System.out.println(" 5) Thousand Island");
            System.out.println(" 6) Vinaigrette");
            System.out.println(" 0) Done with condiments\n");
            System.out.print("Please enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                if (choice == 0) return condiments;

                String condimentName;
                switch (choice) {
                    case 1 -> condimentName = "Mayo";
                    case 2 -> condimentName = "Mustard";
                    case 3 -> condimentName = "Ketchup";
                    case 4 -> condimentName = "Ranch";
                    case 5 -> condimentName = "Thousand Island";
                    case 6 -> condimentName = "Vinaigrette";
                    default -> {
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                        continue;
                    }
                }

                Condiments condimentTopping = new Condiments(condimentName, size, false);
                condiments.add(condimentTopping);
                System.out.println(condimentName + " added to the sandwich.");

                System.out.print("\nWould you like an extra condiment on the side? (1 for Yes, 2 for No): ");
                int extraChoice = cmdscnr.nextInt();
                cmdscnr.nextLine();
                if (extraChoice == 1) {
                    List<String> sideSauces = addSideCondimentOption();
                    if (!sideSauces.isEmpty()) {
                        System.out.println("Side condiments added: " + String.join(", ", sideSauces));
                    }
                }

            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private List<String> addSideCondimentOption() {
        List<String> sideSauces = new ArrayList<>();
        int choice;

        System.out.println("\n--- Side Condiments ---");
        System.out.println("Select a side condiment:");
        System.out.println(" 1) Mayo");
        System.out.println(" 2) Mustard");
        System.out.println(" 3) Ketchup");
        System.out.println(" 4) Ranch");
        System.out.println(" 5) Thousand Island");
        System.out.println(" 6) Vinaigrette");
        System.out.println(" 7) Au Jus");
        System.out.println(" 0) No side sauce");
        System.out.print("\nPlease enter your choice: ");

        do {
            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                if (choice == 0) {
                    System.out.println("\nNo side sauce added.\n");
                    return sideSauces;
                }

                String sideSauceName = switch (choice) {
                    case 1 -> "Mayo";
                    case 2 -> "Mustard";
                    case 3 -> "Ketchup";
                    case 4 -> "Ranch";
                    case 5 -> "Thousand Island";
                    case 6 -> "Vinaigrette";
                    case 7 -> "Au Jus";
                    default -> null;
                };

                if (sideSauceName != null) {
                    sideSauces.add(sideSauceName);
                    System.out.println(sideSauceName + " added as a side sauce.");
                } else {
                    System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private void viewCurrentToppings(Sandwich sandwich, boolean allowRemoval) {
        List<Topping> toppings = sandwich.getCurrentToppings();

        if (toppings.isEmpty()) {
            System.out.println("\nYour sandwich currently has no toppings.\n");
            return;
        }

        System.out.println("\n--- Current Toppings ---");
        System.out.println("Size: " + sandwich.getSandwichSize() + ", Bread Type: " + sandwich.getBreadType() +
                ", Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));

        double totalPrice = sandwich.getBasePrice();

        for (Topping topping : toppings) {
            double price = topping.getPrice();
            totalPrice += price;
            System.out.printf(" - %s%s: $%.2f\n", topping.getName(), (topping.isExtra() ? " (Extra)" : ""), price);
        }

        System.out.printf("\nTotal Sandwich Price: $%.2f\n", totalPrice);

        if (allowRemoval) {
            System.out.print("\nWould you like to remove a topping? (1 for Yes, 2 for No): ");
            int choice = cmdscnr.nextInt();
            cmdscnr.nextLine();

            if (choice == 1) {
                removeToppings(sandwich);
            } else {
                System.out.println("No toppings were removed.");
            }
        }
    }
}