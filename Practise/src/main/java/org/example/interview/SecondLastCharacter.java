package org.example.interview;

import java.util.List;

public class SecondLastCharacter {

    public static void main(String args[]) {
        System.out.println("Second last character");
        List<String> inputVal = List.of("apple", "mango", "orange", "pomo", "banana");
        inputVal.stream().map(s -> s.length() >= 2 ? s.charAt(s.length() - 2) : null).forEach(System.out::println);

        System.out.println("reverse");
        inputVal.stream().forEach(e->{
            String v =new StringBuilder(e).reverse().toString();
            System.out.println(v);
        });
    }
}
