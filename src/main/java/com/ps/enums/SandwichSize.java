package com.ps.enums;

public enum SandwichSize {
    SMALL(5.50),
    MEDIUM(7.00),
    LARGE(8.50);

    private final double price;

    SandwichSize(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String formattedName = name().replace('_', ' ').toLowerCase();
        String[] words = formattedName.split(" ");

        StringBuilder capitalizedWords = new StringBuilder();
        for (String word : words) {
            capitalizedWords.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }

        return capitalizedWords.toString().trim();
    }
}