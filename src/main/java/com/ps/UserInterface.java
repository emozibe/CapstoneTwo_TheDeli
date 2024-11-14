package com.ps;

import com.ps.structure.*;
import com.ps.enums.*;
import com.ps.signaturesandwiches.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static final Scanner cmdscnr = new Scanner(System.in);
    private static final Scanner inptscnr = new Scanner(System.in);
    private Order order;

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
                    case 1 -> startNewOrder();
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

    private void startNewOrder() {
        System.out.print("\nPlease enter your name: ");
        String customerName = inptscnr.nextLine();

        order = new Order(customerName);
        System.out.println("\nWelcome, " + customerName + "! Your order ID is: " + order.getOrderID());
        orderMenu();
    }

    private void orderMenu() {
        int choice;

        do {
            System.out.println("\n--- Order Menu ---");
            System.out.println("Time to make it yours! What would you like to add?");
            System.out.println(" 1) Add Sandwich - Customize your perfect bite!");
            System.out.println(" 2) Add Drink - Stay refreshed!");
            System.out.println(" 3) Add Chips - Crunchy goodness on the side!");
            System.out.println(" 4) View and Remove Items in Order");
            System.out.println(" 5) Checkout - Let's finalize your order!");
            System.out.println(" 0) Cancel Order - Start from scratch!");
            System.out.print("\nPlease enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1 -> addSandwich();
                    case 2 -> addDrink();
                    case 3 -> addChips();
                    case 4 -> viewAndRemoveItem();
                    case 5 -> checkoutOrder();
                    case 0 -> {
                        System.out.println("\nOrder canceled. Returning to Home Screen...");
                        order.clearOrder();
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
        System.out.println("\n--- Checkout ---");
        System.out.println("Order Summary for " + order.getCustomerName() + ":");
        order.printOrderSummary();
        System.out.println("\nThank you for your order!");
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
                        return;
                    }
                    default -> System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }

                System.out.print("\nWould you like to add another sandwich? (1 for Yes, 2 for No): ");
                int another = cmdscnr.nextInt();
                cmdscnr.nextLine();
                if (another != 1) break;

            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private void addDrink() {
        int choice;

        do {
            System.out.println("\n--- Drink Selection ---");
            System.out.println("Choose a drink to stay refreshed!");
            System.out.println(" 1) Coke");
            System.out.println(" 2) Sprite");
            System.out.println(" 3) Fanta");
            System.out.println(" 4) Dr. Pepper");
            System.out.println(" 5) Lemonade");
            System.out.println(" 6) Sweet Tea");
            System.out.println(" 7) Unsweet Tea");
            System.out.println(" 8) Water - Free");
            System.out.print("\nPlease enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                if (choice < 1 || choice > 8) {
                    System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                    continue;
                }

                DrinkType selectedType = switch (choice) {
                    case 1 -> DrinkType.COKE;
                    case 2 -> DrinkType.SPRITE;
                    case 3 -> DrinkType.FANTA;
                    case 4 -> DrinkType.DR_PEPPER;
                    case 5 -> DrinkType.LEMONADE;
                    case 6 -> DrinkType.SWEET_TEA;
                    case 7 -> DrinkType.UNSWEET_TEA;
                    case 8 -> DrinkType.WATER;
                    default -> null;
                };

                DrinkSize size = DrinkSize.SMALL;
                if (selectedType != DrinkType.WATER) {
                    do {
                        System.out.println("\nSelect drink size:");
                        System.out.println(" 1) Small - $2.00");
                        System.out.println(" 2) Medium - $2.50");
                        System.out.println(" 3) Large - $3.00");
                        System.out.print("\nPlease enter your choice: ");

                        int sizeChoice = cmdscnr.nextInt();
                        cmdscnr.nextLine();

                        switch (sizeChoice) {
                            case 1 -> size = DrinkSize.SMALL;
                            case 2 -> size = DrinkSize.MEDIUM;
                            case 3 -> size = DrinkSize.LARGE;
                            default -> {
                                System.out.println("\nOops! That's not a valid size choice. Please try again.\n");
                                continue;
                            }
                        }
                        break;
                    } while (true);
                } else {
                    System.out.println("\nSelected water - no charge.");
                }

                Drink drink = new Drink(size, selectedType);
                order.addItem(drink);
                System.out.println(drink + " added to your order.");

                System.out.print("\nWould you like to add another drink? (1 for Yes, 2 for No): ");
                int another = cmdscnr.nextInt();
                cmdscnr.nextLine();
                if (another != 1) break;

            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private void addChips() {
        int choice;

        do {
            System.out.println("\n--- Chips Selection ---");
            System.out.println("Choose a flavor to add a crunchy side!");
            System.out.println(" 1) Original");
            System.out.println(" 2) BBQ");
            System.out.println(" 3) Sour Cream");
            System.out.println(" 4) Cheese");
            System.out.println(" 5) Salt and Vinegar");
            System.out.print("\nPlease enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                if (choice < 1 || choice > 5) {
                    System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                    continue;
                }

                ChipFlavor selectedFlavor = switch (choice) {
                    case 1 -> ChipFlavor.ORIGINAL;
                    case 2 -> ChipFlavor.BBQ;
                    case 3 -> ChipFlavor.SOUR_CREAM;
                    case 4 -> ChipFlavor.CHEESE;
                    case 5 -> ChipFlavor.SALT_AND_VINEGAR;
                    default -> null;
                };

                Chips chips = new Chips(selectedFlavor);
                order.addItem(chips);
                System.out.println(chips + " added to your order.");

                System.out.print("\nWould you like to add another bag of chips? (1 for Yes, 2 for No): ");
                int another = cmdscnr.nextInt();
                cmdscnr.nextLine();
                if (another != 1) break;

            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private void viewAndRemoveItem() {
        if (order.getItems().isEmpty()) {
            System.out.println("\nYour order is currently empty.");
            return;
        }

        System.out.println("\n--- Current Order Items ---");
        List<Product> items = order.getItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.println(" " + (i + 1) + ") " + items.get(i));
        }
        System.out.print("\nEnter the item number to remove, or 0 to go back: ");

        try {
            int choice = cmdscnr.nextInt();
            cmdscnr.nextLine();

            if (choice > 0 && choice <= items.size()) {
                Product removedItem = items.get(choice - 1);
                order.removeItem(removedItem);
                System.out.println(removedItem + " has been removed from your order.");
            } else if (choice != 0) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
            }
        } catch (Exception e) {
            System.out.println("\nOops! That's not a valid choice. Please try again.\n");
            cmdscnr.next();
        }
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
                    Sandwich selectedSandwich = sandwiches[choice - 1].clone();

                    SandwichSize selectedSize = selectSandwichSize();
                    BreadType selectedBread = selectBreadType();

                    selectedSandwich.setSandwichSize(selectedSize);
                    selectedSandwich.setBreadType(selectedBread);

                    for (Topping topping : selectedSandwich.getCurrentToppings()) {
                        topping.setSize(selectedSize);
                    }

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

        SandwichSize sandwichSize = selectSandwichSize();

        BreadType breadType = selectBreadType();

        boolean toasted = askIfToasted();

        Sandwich customSandwich = new CustomSandwich(sandwichSize, breadType, toasted);

        System.out.println("\nNow, let's add your toppings!");

        selectToppings(customSandwich);

        System.out.println("\nYour custom sandwich has been added to your order!");
        return customSandwich;
    }

    private List<Topping> selectToppings(Sandwich sandwich) {
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

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1 -> {
                        selectMeat(sandwich.getSandwichSize(), sandwich);
                        viewCurrentToppings(sandwich, false);
                    }
                    case 2 -> {
                        selectCheese(sandwich.getSandwichSize(), sandwich);
                        viewCurrentToppings(sandwich, false);
                    }
                    case 3 -> {
                        selectVeggies(sandwich.getSandwichSize(), sandwich);
                        viewCurrentToppings(sandwich, false);
                    }
                    case 4 -> {
                        selectCondiments(sandwich.getSandwichSize(), sandwich);
                        viewCurrentToppings(sandwich, false);
                    }
                    case 5 -> viewCurrentToppings(sandwich, true);
                    case 0 -> {
                        System.out.println("\nAll toppings selected. Moving to the next step!\n");
                        return sandwich.getCurrentToppings();
                    }
                    default -> System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private void selectMeat(SandwichSize size, Sandwich sandwich) {
        List<Topping> selectedMeats = new ArrayList<>();
        MeatType[] meats = MeatType.values();

        MeatType meatType;
        while ((meatType = getEnumChoice(meats, "Meat")) != null) {
            final String meatName = meatType.toString();

            boolean alreadyAdded = sandwich.getCurrentToppings().stream()
                    .anyMatch(t -> t.getName().equalsIgnoreCase(meatName)) ||
                    selectedMeats.stream()
                            .anyMatch(t -> t.getName().equalsIgnoreCase(meatName));

            if (alreadyAdded) {
                System.out.println("The topping " + meatName + " is already on your sandwich!");
            } else {
                System.out.print("Would you like extra meat? (1 for Yes, 2 for No): ");
                boolean extraMeat = cmdscnr.nextInt() == 1;
                cmdscnr.nextLine();

                Meat meatTopping = new Meat(meatType, size, extraMeat);
                selectedMeats.add(meatTopping);
                System.out.println(meatName + " added to your sandwich.");
            }
        }

        addUniqueToppings(sandwich.getCurrentToppings(), selectedMeats);
    }

    private void selectCheese(SandwichSize size, Sandwich sandwich) {
        List<Topping> selectedCheeses = new ArrayList<>();
        CheeseType[] cheeses = CheeseType.values();

        CheeseType cheeseType;
        while ((cheeseType = getEnumChoice(cheeses, "Cheese")) != null) {
            final String cheeseName = cheeseType.toString();

            boolean alreadyAdded = sandwich.getCurrentToppings().stream()
                    .anyMatch(t -> t.getName().equalsIgnoreCase(cheeseName)) ||
                    selectedCheeses.stream()
                            .anyMatch(t -> t.getName().equalsIgnoreCase(cheeseName));

            if (alreadyAdded) {
                System.out.println("The topping " + cheeseName + " is already on your sandwich!");
            } else {
                System.out.print("Would you like extra cheese? (1 for Yes, 2 for No): ");
                boolean extraCheese = cmdscnr.nextInt() == 1;
                cmdscnr.nextLine();

                Cheese cheeseTopping = new Cheese(cheeseType, size, extraCheese);
                selectedCheeses.add(cheeseTopping);
                System.out.println(cheeseName + " added to your sandwich.");
            }
        }

        addUniqueToppings(sandwich.getCurrentToppings(), selectedCheeses);
    }

    private void selectVeggies(SandwichSize size, Sandwich sandwich) {
        List<Topping> selectedVeggies = new ArrayList<>();
        VeggieType[] veggies = VeggieType.values();

        VeggieType veggieType;
        while ((veggieType = getEnumChoice(veggies, "Veggies")) != null) {
            final String veggieName = veggieType.toString();

            boolean alreadyAdded = sandwich.getCurrentToppings().stream()
                    .anyMatch(t -> t.getName().equalsIgnoreCase(veggieName)) ||
                    selectedVeggies.stream()
                            .anyMatch(t -> t.getName().equalsIgnoreCase(veggieName));

            if (alreadyAdded) {
                System.out.println("The topping " + veggieName + " is already on your sandwich!");
            } else {
                Veggies veggieTopping = new Veggies(veggieType, size);
                selectedVeggies.add(veggieTopping);
                System.out.println(veggieName + " added to your sandwich.");
            }
        }

        addUniqueToppings(sandwich.getCurrentToppings(), selectedVeggies);
    }

    private void selectCondiments(SandwichSize size, Sandwich sandwich) {
        List<Topping> selectedCondiments = new ArrayList<>();
        CondimentType[] condiments = CondimentType.values();

        CondimentType condimentType;
        while ((condimentType = getEnumChoice(condiments, "Condiments")) != null) {
            final String condimentName = condimentType.toString();

            boolean alreadyAdded = sandwich.getCurrentToppings().stream()
                    .anyMatch(t -> t.getName().equalsIgnoreCase(condimentName)) ||
                    selectedCondiments.stream()
                            .anyMatch(t -> t.getName().equalsIgnoreCase(condimentName));

            if (alreadyAdded) {
                System.out.println("The topping " + condimentName + " is already on your sandwich!");
            } else {
                Condiments condimentTopping = new Condiments(condimentType, size, false);
                selectedCondiments.add(condimentTopping);
                System.out.println(condimentName + " added to the sandwich.");

                addSideCondimentOption();
            }
        }

        addUniqueToppings(sandwich.getCurrentToppings(), selectedCondiments);
    }

    private SandwichSize selectSandwichSize() {
        int choice;

        SandwichSize[] sizes = SandwichSize.values();
        do {
            System.out.println("\n--- Select Sandwich Size ---");
            for (int i = 0; i < sizes.length; i++) {
                System.out.printf(" %d) %s (%.1f\") - $%.2f\n", i + 1, sizes[i], (i == 0 ? 4.0 : i == 1 ? 8.0 : 12.0), sizes[i].getPrice());
            }
            System.out.print("\nPlease enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                if (choice > 0 && choice <= sizes.length) {
                    return sizes[choice - 1];
                } else {
                    System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private BreadType selectBreadType() {
        int choice;

        BreadType[] breadTypes = BreadType.values();
        do {
            System.out.println("\n--- Select Bread Type ---");
            for (int i = 0; i < breadTypes.length; i++) {
                System.out.println(" " + (i + 1) + ") " + breadTypes[i]);
            }
            System.out.print("\nPlease enter your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                if (choice > 0 && choice <= breadTypes.length) {
                    return breadTypes[choice - 1];
                } else {
                    System.out.println("\nOops! That's not a valid choice. Please try again.\n");
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

    private void addUniqueToppings(List<Topping> currentToppings, List<Topping> newToppings) {
        for (Topping newTopping : newToppings) {
            boolean alreadyAdded = currentToppings.stream()
                    .anyMatch(t -> t.getName().equalsIgnoreCase(newTopping.getName())
                            && t.isExtra() == newTopping.isExtra()
                            && t.getClass().equals(newTopping.getClass()));

            if (alreadyAdded) {
                System.out.println("The topping " + newTopping + " is already on your sandwich!");
            } else {
                currentToppings.add(newTopping);
                System.out.println(newTopping + " added to your sandwich!");
            }
        }
    }

    private void addSideCondimentOption() {
        List<String> sideSauces = new ArrayList<>();
        SideCondimentType[] condiments = SideCondimentType.values();
        int choice;

        System.out.println("\nWould you like any extra condiment on the side? (1 for Yes, 2 for No): ");
        int extraChoice = cmdscnr.nextInt();
        cmdscnr.nextLine();
        if (extraChoice != 1) return;

        System.out.println("\n--- Side Condiments ---");
        System.out.println("Select a side condiment:");
        for (int i = 0; i < condiments.length; i++) {
            System.out.println(" " + (i + 1) + ") " + condiments[i].toString());
        }
        System.out.println(" 0) No more side sauces");

        do {
            System.out.print("\nPlease enter your choice: ");
            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                if (choice == 0) {
                    if (!sideSauces.isEmpty()) {
                        System.out.println("Side condiments added: " + String.join(", ", sideSauces));
                    }
                    break;
                }

                if (choice > 0 && choice <= condiments.length) {
                    SideCondimentType selectedCondiment = condiments[choice - 1];
                    sideSauces.add(selectedCondiment.toString());
                    System.out.println(selectedCondiment + " added as a side sauce.");
                } else {
                    System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private <T extends Enum<T>> T getEnumChoice(T[] options, String toppingType) {
        int choice;
        do {
            System.out.println("\n--- Select " + toppingType + " ---");
            for (int i = 0; i < options.length; i++) {
                System.out.println(" " + (i + 1) + ") " + options[i].toString());
            }
            System.out.println(" 0) Done with " + toppingType.toLowerCase() + "!");

            System.out.print("\nPlease enter your choice: ");
            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                if (choice == 0) return null;
                if (choice > 0 && choice <= options.length) {
                    return options[choice - 1];
                } else {
                    System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private void modifyToppings(Sandwich sandwich) {
        int choice;

        System.out.println("\n--- Modify Toppings ---");
        System.out.println("Let's customize the toppings on your " + sandwich.getName() + "!\n");

        do {
            System.out.println("Current toppings on your sandwich:");
            viewCurrentToppings(sandwich, false);

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
                        System.out.println();
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
            double toppingPrice = topping.getPrice();
            totalPrice += toppingPrice;
            System.out.printf(" - %s: $%.2f\n", topping, toppingPrice);
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