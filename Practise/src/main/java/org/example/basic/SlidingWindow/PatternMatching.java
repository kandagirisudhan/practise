package org.example.basic.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class PatternMatching {

    public static List<Integer> findPattern(String text, String pattern) {
        int patternLength = pattern.length();
        int textLength = text.length();
        List<Integer> result = new ArrayList<>();

        // Loop through the text
        for (int i = 0; i <= textLength - patternLength; i++) {
            // Check the substring of length equal to pattern
            String substring = text.substring(i, i + patternLength);
            if (substring.equals(pattern)) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";
        List<Integer> matches = findPattern(text, pattern);

        System.out.println("Pattern found at indices: " + matches);
    }
}
