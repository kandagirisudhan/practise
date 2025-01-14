package org.example.basic;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Occurrences {

    public static void main(String args[]) {
        String input = "Kanda Giri Sudhan";

        List<Character> inputList = input.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        System.out.println("<------------occurance--------->");
        //Occurance of each character
        Map<Character, Long> resultMap = inputList.stream().filter(p -> !p.toString().trim().isEmpty() && (p != null) ).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        resultMap.forEach((k, v) -> System.out.println(k + "=" + v));
        //OR
        TreeMap<Character, Integer> mapVal = new TreeMap<>(); //To maintain order LinkedHashMap & to sort TreeMAp
        for (int i = 0; i < input.length(); i++) {
            if (mapVal.containsKey(input.charAt(i))){
                mapVal.put(input.charAt(i),mapVal.get(input.charAt(i))+1);
            }else{
                mapVal.put(input.charAt(i),1);
            }
        }
        System.out.println("Frequency----->"+mapVal);


        System.out.println("<------------To find Unique elements--------->");
        List<Character> resultUniqueList = inputList.stream().filter(p -> Collections.frequency(inputList, p) == 1).collect(Collectors.toList());
        System.out.println("------To find Unique elements ----->" + resultUniqueList);

        Set<Character> UniqueElement =new HashSet<>();
        List<Character> uniqueval=inputList.stream().filter(p-> !p.toString().trim().isEmpty()).filter(p -> !UniqueElement.add(p)).collect(Collectors.toList());

        System.out.println("------Duplicate elements Val---->" + uniqueval);
        Set<Character> setVal= inputList.stream().filter(p-> !p.toString().trim().isEmpty()).collect(Collectors.toSet());
        List<Character> sortList= setVal.stream().sorted().collect(Collectors.toList());

        System.out.println("------Remove Duplicate--------"+sortList);

        List<Character> setValList= inputList.stream().filter(p-> !p.toString().trim().isEmpty()).distinct().sorted().collect(Collectors.toList());
        System.out.println("------Remove Duplicate--------"+setValList);

        List<Character> charVal=inputList.stream().filter(e->!e.toString().trim().isEmpty()).distinct().collect(Collectors.toList());
        System.out.println(charVal);
    }



}
