package org.example.basic;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Duplicate {


    private static boolean hasRepeatingCharacters(String word) {
        return word.length() != word.chars().distinct().count();
    }


//    Print top 5 longest word that should not have repeating character.
//
//    The tournament will feature 10 teams, and follow the same format as the 2019 edition, with a round-robin stage followed by the knockouts. All 10 teams will compete against each other once in the round-robin stage. A victory earns the winning side two points in every match, while a no-result will mean the sides share a point each. The top four teams at the end of the round-robin stage will qualify for the semi-finals. The winners of the two subsequent semi-finals will contest in the final, where the champion will be crowned.


    public static void main (String args[]) {

                String text = "The tournament will feature 10 teams, and follow the same format as the 2019 edition, with a round-robin stage followed by the knockouts. All 10 teams will compete against each other once in the round-robin stage. A victory earns the winning side two points in every match, while a no-result will mean the sides share a point each. The top four teams at the end of the round-robin stage will qualify for the semi-finals. The winners of the two subsequent semi-finals will contest in the final, where the champion will be crowned.";

                List<String> words = Arrays.asList(text.split("\\s+"));

                System.out.println(words);
                List<String> uniqueWords = words.stream()
                        .filter(word -> !hasRepeatingCharacters(word))
                        .sorted(Comparator.comparingInt(String::length).reversed())
                        .limit(5)
                        .collect(Collectors.toList());

                uniqueWords.forEach(System.out::println);
    }
}
