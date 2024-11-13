package com.ps;

import com.ps.structure.*;
import com.ps.signaturesandwiches.*;
import com.ps.enums.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static Scanner cmdscnr = new Scanner(System.in);
    private static Scanner inptscnr = new Scanner(System.in);
    private List<Sandwich> currentOrder = new ArrayList<>();

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
                        currentOrder.clear();
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
                        buildYourOwnSandwich();
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
                        customizeSignatureSandwich(blt);
                        break;
                    case 2:
                        customizeSignatureSandwich(phillyCheeseSteak);
                        break;
                    case 3:
                        customizeSignatureSandwich(veggieDelight);
                        break;
                    case 4:
                        customizeSignatureSandwich(meatLovers);
                        break;
                    case 5:
                        customizeSignatureSandwich(italianSpecial);
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

    private void buildYourOwnSandwich() {
        BreadType breadType = selectBreadType();
        SandwichSize sandwichSize = selectSandwichSize();
        List<Topping> toppings = selectToppings(sandwichSize);
        boolean isToasted = askIfToasted();

        Sandwich customSandwich = new CustomSandwich(sandwichSize, breadType, isToasted);
        for (Topping topping : toppings) {
            customSandwich.addTopping(topping);
        }
        currentOrder.add(customSandwich);

        System.out.println("\nYour sandwich has been added to your order!\n");
    }

    private void customizeSignatureSandwich(Sandwich sandwich) {
        BreadType breadType = selectBreadType();
        SandwichSize sandwichSize = selectSandwichSize();
        sandwich.setBreadType(breadType);
        sandwich.setSandwichSize(sandwichSize);

        System.out.println("\nCustomizing your " + sandwich.getName() + ":");
        List<Topping> additionalToppings = selectToppings(sandwichSize);
        for (Topping topping : additionalToppings) {
            sandwich.addTopping(topping);
        }
        currentOrder.add(sandwich);
        System.out.println("\nYour customized " + sandwich.getName() + " has been added to your order!\n");
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
            System.out.println(" 3) Large (12\")");
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
            System.out.println(" 0) Done with toppings\n");
            System.out.print("Please enter the number that corresponds to your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1:
                        toppings.addAll(selectMeat(size));
                        break;
                    case 2:
                        toppings.addAll(selectCheese(size));
                        break;
                    case 3:
                        toppings.addAll(selectVeggies(size));
                        break;
                    case 4:
                        toppings.addAll(selectCondiments(size));
                        break;
                    case 0:
                        return toppings;
                    default:
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private List<Topping> selectMeat(SandwichSize size) {

        List<Topping> meats = new ArrayList<>();
        int choice, extraChoice;

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

                if (choice == 0) {
                    return meats;
                }

                String meatName = "";

                switch (choice) {
                    case 1: meatName = "Bacon"; break;
                    case 2: meatName = "Ham"; break;
                    case 3: meatName = "Chicken"; break;
                    case 4: meatName = "Steak"; break;
                    case 5: meatName = "Roast Beef"; break;
                    case 6: meatName = "Salami"; break;
                    default:
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                        continue;
                }

                while (true) {
                    System.out.println("Would you like extra meat? 1) Yes  2) No  3) Choose a different meat");
                    extraChoice = cmdscnr.nextInt();
                    cmdscnr.nextLine();

                    if (extraChoice == 3) {
                        break;
                    } else if (extraChoice == 1 || extraChoice == 2) {
                        boolean extra = (extraChoice == 1);
                        meats.add(new Meat(meatName, size, extra));
                        break;
                    } else {
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                    }
                }

            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private List<Topping> selectCheese(SandwichSize size) {

        List<Topping> cheeses = new ArrayList<>();
        int choice, extraChoice;

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

                if (choice == 0) {
                    return cheeses;
                }

                String cheeseName = "";

                switch (choice) {
                    case 1: cheeseName = "American"; break;
                    case 2: cheeseName = "Provolone"; break;
                    case 3: cheeseName = "Cheddar"; break;
                    case 4: cheeseName = "Swiss"; break;
                    default:
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                        continue;
                }

                while (true) {
                    System.out.println("Would you like extra cheese? 1) Yes  2) No  3) Choose a different cheese");
                    extraChoice = cmdscnr.nextInt();
                    cmdscnr.nextLine();

                    if (extraChoice == 3) {
                        break;
                    } else if (extraChoice == 1 || extraChoice == 2) {
                        boolean extra = (extraChoice == 1);
                        cheeses.add(new Cheese(cheeseName, size, extra));
                        break;
                    } else {
                        System.out.println("\nInvalid choice, please choose 1, 2, or 3.\n");
                    }
                }

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
            System.out.println(" 2) Tomato");
            System.out.println(" 3) Onion");
            System.out.println(" 4) Pickles");
            System.out.println(" 5) Peppers");
            System.out.println(" 6) Cucumbers");
            System.out.println(" 7) Jalapeños");
            System.out.println(" 8) Guacamole");
            System.out.println(" 9) Mushrooms");
            System.out.println(" 0) Done with veggies!\n");
            System.out.print("Please enter the number that corresponds to your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1:
                        veggies.add(new Veggies("Lettuce", size));
                        break;
                    case 2:
                        veggies.add(new Veggies("Tomato", size));
                        break;
                    case 3:
                        veggies.add(new Veggies("Onion", size));
                        break;
                    case 4:
                        veggies.add(new Veggies("Pickles", size));
                        break;
                    case 5:
                        veggies.add(new Veggies("Peppers", size));
                        break;
                    case 6:
                        veggies.add(new Veggies("Cucumbers", size));
                        break;
                    case 7:
                        veggies.add(new Veggies("Jalapeños", size));
                        break;
                    case 8:
                        veggies.add(new Veggies("Guacamole", size));
                        break;
                    case 9:
                        veggies.add(new Veggies("Mushrooms", size));
                        break;
                    case 0:
                        return veggies;
                    default:
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
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
            System.out.println(" 0) Done with condiments!\n");
            System.out.print("Please enter the number that corresponds to your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1:
                        condiments.add(new Condiments("Mayo", 0.0, size, false));
                        break;
                    case 2:
                        condiments.add(new Condiments("Mustard", 0.0, size, false));
                        break;
                    case 3:
                        condiments.add(new Condiments("Ketchup", 0.0, size, false));
                        break;
                    case 4:
                        condiments.add(new Condiments("Ranch", 0.0, size, false));
                        break;
                    case 5:
                        condiments.add(new Condiments("Thousand Island", 0.0, size, false));
                        break;
                    case 6:
                        condiments.add(new Condiments("Vinaigrette", 0.0, size, false));
                        break;
                    case 0:
                        addSideSauceOption(size);
                        return condiments;
                    default:
                        System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOops! That's not a valid choice. Please try again.\n");
                cmdscnr.next();
            }
        } while (true);
    }

    private List<Topping> addSideSauceOption(SandwichSize size) {

        List<Topping> condiments = new ArrayList<>();
        int choice;

        do {
            System.out.println("\nWould you like to add a side sauce? Select from the following options:");
            System.out.println(" 1) Mayo");
            System.out.println(" 2) Mustard");
            System.out.println(" 3) Ketchup");
            System.out.println(" 4) Ranch");
            System.out.println(" 5) Thousand Island");
            System.out.println(" 6) Vinaigrette");
            System.out.println(" 7) Au Jus");
            System.out.println(" 0) No side sauce\n");
            System.out.print("Please enter the number that corresponds to your choice: ");

            try {
                choice = cmdscnr.nextInt();
                cmdscnr.nextLine();

                switch (choice) {
                    case 1:
                        condiments.add(new Condiments("Mayo", 0.0, size, true));
                        break;
                    case 2:
                        condiments.add(new Condiments("Mustard", 0.0, size, true));
                        break;
                    case 3:
                        condiments.add(new Condiments("Ketchup", 0.0, size, true));
                        break;
                    case 4:
                        condiments.add(new Condiments("Ranch", 0.0, size, true));
                        break;
                    case 5:
                        condiments.add(new Condiments("Thousand Island", 0.0, size, true));
                        break;
                    case 6:
                        condiments.add(new Condiments("Vinaigrette", 0.0, size, true));
                        break;
                    case 7:
                        condiments.add(new Condiments("Au Jus", 0.0, size, true));
                        break;
                    case 0:
                        System.out.println("\nNo side sauce added.\n");
                        return condiments;
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