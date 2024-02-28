package org.example.interview;

import java.util.*;

public class AnagramGroupsFinder {

    public static List<List<String>> groupAnagrams(String[] strs) {
        // Create a HashMap to store anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through the array of strings
        for (String str : strs) {
            // Sort the characters of the current string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // If the sorted string is not in the map, create a new list
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }

            // Add the original string to the list associated with the sorted string
            map.get(sortedStr).add(str);
        }

        // Collect all the values from the map as the result
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};
        String[] strs2 = {""};
        String[] strs3 = {"a"};

        System.out.println("Example 1:");
        System.out.println("Input: " + Arrays.toString(strs1));
        System.out.println("Output: " + groupAnagrams(strs1));

        System.out.println("\nExample 2:");
        System.out.println("Input: " + Arrays.toString(strs2));
        System.out.println("Output: " + groupAnagrams(strs2));

        System.out.println("\nExample 3:");
        System.out.println("Input: " + Arrays.toString(strs3));
        System.out.println("Output: " + groupAnagrams(strs3));
    }
}
