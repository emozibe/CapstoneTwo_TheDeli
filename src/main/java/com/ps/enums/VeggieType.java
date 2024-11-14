package com.ps.enums;

public enum VeggieType {
    LETTUCE,
    PEPPERS,
    ONION,
    TOMATO,
    JALAPENOS,
    CUCUMBER,
    PICKLES,
    GUACAMOLE,
    MUSHROOMS;

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