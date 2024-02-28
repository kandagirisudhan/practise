package org.example.interview;

import java.util.*;
import java.util.stream.Collectors;

public class Walmart {

//    Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//    Example 1:
//    Input: strs = ["eat","tea","tan","ate","nat","bat"]
//    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

//    Example 2:
//    Input: strs = [""]
//    Output: [[""]]

//    Example 3:
//    Input: strs = ["a"]
//    Output: [["a"]]

    public static void main(String args[]) {

        List<String> inputList = List.of("eat", "tea", "tan", "ate", "nat", "bat");
        List<List<String>> result = anagram(inputList);

        System.out.println("O/P:" + result);

    }

    private static List<List<String>> anagram(List<String> inputList) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < inputList.size(); i++) {

            String value = inputList.get(i);
            char[] charArray = value.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if (!map.containsKey(sortedString)) {
                map.put(sortedString.toString(), new ArrayList<>());
            }

            map.get(sortedString).add(value);

        }

        return new ArrayList<>(map.values());
    }


}
