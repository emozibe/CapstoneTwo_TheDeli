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
    private List<Sandwich> sandwich = new ArrayList<>();
    //private List<Drink> drinks = new ArrayList<>();
    //private List<Chips> chips = new ArrayList<>();

    public static void main(String[] args) {
        new UserInterface().mainMenu();
    }

    public void mainMenu() {
        int choice;

        do {
            System.out.println("We're excited to serve you today! What would you like to do?");
            System.out.println(" 1) Start a New Order");
            System.out.println(" 0) Exit\n");
            System.out.print("Please enter the number that corresponds to your choice: ");

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
                    case 1 -> addSandwich();
                    case 2 -> addDrink();
                    case 3 -> addChips();
                    case 4 -> checkoutOrder();
                    case 0 -> {
                        System.out.println("\nOrder canceled. Returning to Home Screen...\n");
                        sandwich.clear();
                        //drinks.clear();
                        //chips.clear();
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
                    case 1 -> displaySignatureSandwiches();
                    case 2 -> buildYourOwnSandwich();
                    case 0 -> {
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
            System.out.println("\nHere are our Deli-cious signature sandwiches:");
            for (int i = 0; i < sandwiches.length; i++) {
                System.out.println(" " + (i + 1) + ") " + sandwiches[i].getName() + " - " + sandwiches[i].getDescription());
            }
            System.out.println(" 0) Go Back\n");
            System.out.print("Please select a sandwich to customize or enter 0 to go back: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                if (choice == 0) return;
                if (choice >= 1 && choice <= sandwiches.length) {
                    Sandwich selectedSandwich = sandwiches[choice - 1];
                    customizeSignatureSandwich(selectedSandwich);
                    sandwich.add(selectedSandwich);
                    System.out.println("\nYour customized " + selectedSandwich.getName() + " has been added to your order!\n");
                } else {
                    System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private Sandwich buildYourOwnSandwich() {
        BreadType breadType = selectBreadType();
        SandwichSize sandwichSize = selectSandwichSize();
        List<Topping> toppings = selectToppings(sandwichSize);
        boolean isToasted = askIfToasted();

        CustomSandwich customSandwich = new CustomSandwich(sandwichSize, breadType, isToasted);

        for (Topping topping : toppings) {
            customSandwich.addTopping(topping);
        }

        System.out.println("\nYour custom sandwich has been added to your order!\n");
        return customSandwich;
    }

    private void customizeSignatureSandwich(Sandwich sandwich) {
        BreadType breadType = selectBreadType();
        SandwichSize sandwichSize = selectSandwichSize();
        sandwich.setBreadType(breadType);
        sandwich.setSandwichSize(sandwichSize);

        System.out.println("\nHere are the default toppings for your " + sandwich.getName() + ":");
        viewCurrentToppings(sandwich.getCurrentToppings());

        System.out.println("Would you like to customize the toppings? (1 for Yes, 2 for No): ");
        int customizeChoice = cmdscnr.nextInt();
        cmdscnr.nextLine();

        if (customizeChoice == 1) {
            List<Topping> modifiedToppings = selectToppings(sandwichSize);
            sandwich.setCurrentToppings(modifiedToppings);
        }
    }



    private BreadType selectBreadType() {
        int choice;

        do {
            System.out.println("\nSelect a type of bread:");
            System.out.println(" 1) White");
            System.out.println(" 2) Wheat");
            System.out.println(" 3) Rye");
            System.out.println(" 4) Wrap\n");
            System.out.print("Please enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1:
                        return BreadType.WHITE;
                    case 2:
                        return BreadType.WHEAT;
                    case 3:
                        return BreadType.RYE;
                    case 4:
                        return BreadType.WRAP;
                    default:
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
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
            System.out.println("\nSelect the sandwich size:");
            System.out.println(" 1) Small (4\")");
            System.out.println(" 2) Medium (8\")");
            System.out.println(" 3) Large (12\")\n");
            System.out.print("Please enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1:
                        return SandwichSize.SMALL;
                    case 2:
                        return SandwichSize.MEDIUM;
                    case 3:
                        return SandwichSize.LARGE;
                    default:
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private List<Topping> selectToppings(SandwichSize size) {
        List<Topping> toppings = new ArrayList<>();
        int choice;

        do {
            System.out.println("\nSelect a topping category:");
            System.out.println(" 1) Meat");
            System.out.println(" 2) Cheese");
            System.out.println(" 3) Veggies");
            System.out.println(" 4) Condiments");
            System.out.println(" 5) View current sandwich toppings");
            System.out.println(" 0) Done with toppings\n");
            System.out.print("Please enter the number that corresponds to your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1 -> addUniqueToppings(toppings, selectMeat(size));
                    case 2 -> addUniqueToppings(toppings, selectCheese(size));
                    case 3 -> addUniqueToppings(toppings, selectVeggies(size));
                    case 4 -> addUniqueToppings(toppings, selectCondiments(size));
                    case 5 -> viewCurrentToppings(toppings);
                    case 0 -> {
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

    private List<Topping> selectMeat(SandwichSize size) {
        List<Topping> meats = new ArrayList<>();
        int choice;
        boolean extraMeat;

        do {
            System.out.println("\nSelect a meat:");
            System.out.println(" 1) Bacon");
            System.out.println(" 2) Ham");
            System.out.println(" 3) Chicken");
            System.out.println(" 4) Steak");
            System.out.println(" 5) Roast Beef");
            System.out.println(" 6) Salami");
            System.out.println(" 0) Done with meat!\n");
            System.out.print("Please enter the number that corresponds to your choice: ");

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
                // fix with price
                System.out.print("\nWould you like extra meat for " + meatName + "? (1 for Yes, 2 for No): ");
                int extraChoice = cmdscnr.nextInt();
                cmdscnr.nextLine();
                extraMeat = (extraChoice == 1);

                Meat meatTopping = new Meat(meatName, size, extraMeat);
                meats.add(meatTopping);
                System.out.println("\n" + meatName + (extraMeat ? " with extra meat" : "") + " added.");

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
            System.out.println("\nSelect a cheese:");
            System.out.println(" 1) American");
            System.out.println(" 2) Provolone");
            System.out.println(" 3) Cheddar");
            System.out.println(" 4) Swiss");
            System.out.println(" 0) Done with cheese!\n");
            System.out.print("Please enter the number that corresponds to your choice: ");

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
                // fix with price
                System.out.print("\nWould you like extra cheese for " + cheeseName + "? (1 for Yes, 2 for No): ");
                int extraChoice = cmdscnr.nextInt();
                cmdscnr.nextLine();
                extraCheese = (extraChoice == 1);

                Cheese cheeseTopping = new Cheese(cheeseName, size, extraCheese);
                cheeses.add(cheeseTopping);
                System.out.println(cheeseName + (extraCheese ? " with extra cheese" : "") + " added.");

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
            System.out.println("\nSelect a veggie:");
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
            System.out.print("Please enter the number that corresponds to your choice: ");

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
            System.out.println("\nSelect a condiment:");
            System.out.println(" 1) Mayo");
            System.out.println(" 2) Mustard");
            System.out.println(" 3) Ketchup");
            System.out.println(" 4) Ranch");
            System.out.println(" 5) Thousand Island");
            System.out.println(" 6) Vinaigrette");
            System.out.println(" 0) Done with condiments\n");
            System.out.print("Please enter the number that corresponds to your choice: ");

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

                System.out.println("Would you like to add an extra condiment on the side? (1 for Yes, 2 for No): ");
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

        System.out.println("\nSelect an extra condiment from the following options:");
        System.out.println(" 1) Mayo");
        System.out.println(" 2) Mustard");
        System.out.println(" 3) Ketchup");
        System.out.println(" 4) Ranch");
        System.out.println(" 5) Thousand Island");
        System.out.println(" 6) Vinaigrette");
        System.out.println(" 7) Au Jus");
        System.out.println(" 0) No side sauce!\n");
        System.out.print("Please enter the number that corresponds to your choice: ");

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

    private void viewCurrentToppings(List<Topping> toppings) {
        if (toppings.isEmpty()) {
            System.out.println("\nYour sandwich currently has no toppings.\n");
        } else {
            System.out.println("\nCurrent toppings on your sandwich:");
            for (Topping topping : toppings) {
                String extra = "";
                double price = topping.getPrice();
                if (topping instanceof Meat meatTopping && meatTopping.isExtraMeat()) {
                    extra = " (Extra)";
                } else if (topping instanceof Cheese cheeseTopping && cheeseTopping.isExtraCheese()) {
                    extra = " (Extra)";
                }
                System.out.printf(" - %s%s: $%.2f\n", topping.getName(), extra, price);
            }
            System.out.println();
        }
    }

    private boolean askIfToasted() {
        int choice;

        do {
            System.out.println("\nWould you like the sandwich toasted?");
            System.out.println(" 1) Yes");
            System.out.println(" 2) No");
            System.out.print("Please enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1:
                        return true;
                    case 2:
                        return false;
                    default:
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
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

    private void checkoutOrder() {
        System.out.println("Order summary and receipt creation.");
    }
}