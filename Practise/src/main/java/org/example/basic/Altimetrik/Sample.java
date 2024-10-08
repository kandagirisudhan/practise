package org.example.basic.Altimetrik;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {


    public static  void main  (String args[]){


        List<Integer> inputVal= List.of(1,2,3,4,5);
        inputVal.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

    }
}
