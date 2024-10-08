package org.example.basic.Altimetrik;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ALtimetrik {

    public static void main(String args[]) {

        String valInput = "aabbc"; //aabbc

        List<Character> valList = valInput.chars().mapToObj(e -> (char) e).collect(Collectors.toList());


        Map<Character, Long> mapValue = valList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        Optional<Character> resultVal = mapValue.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst();

        try{
            System.out.println("---------->" + resultVal.get());
        }catch (Exception e){
            System.out.println(e);
        }



        List<Integer> intVal = Arrays.asList(1,2,3,4,5,6,7);

        Map<Boolean,List<Integer>> mapintValList =intVal.stream().collect(Collectors.partitioningBy(e->e%2 ==0));

        intVal= mapintValList.get(true);

        int val =intVal.stream().mapToInt(Integer::intValue).sum();

        System.out.println(val);





    }
}
