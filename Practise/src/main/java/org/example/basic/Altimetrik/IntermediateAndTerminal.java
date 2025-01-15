package org.example.basic.Altimetrik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateAndTerminal {
    public static void main(String args[]) {
//        Intermediate Operation:
//        map() Converts each element in the stream into another form.
        List<String> names = Arrays.asList("John", "Jane", "Doe");
        List<Integer> nameLength = names.stream().map(String::length).collect(Collectors.toList());
        System.out.println(nameLength);

        //flatmap() Converts each element in the stream into another form.
        List<List<Integer>> namesList = new ArrayList<>();
        namesList.add(Arrays.asList(1, 2));
        namesList.add(Arrays.asList(3, 4));
        List<Integer> number = namesList.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
        System.out.println(number);

        //filter() Filters elements based on a predicate.
        List<Integer> evenNumber = number.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumber);

        //distinct() Removes duplicate elements.
        List<Integer> numbersDup = Arrays.asList(1, 2, 2, 3, 4, 4);
        List<Integer> unique = numbersDup.stream().distinct().collect(Collectors.toList());
        System.out.println(unique);

        //sorted() Sorts elements in natural order or using a comparator.
        List<Integer> numbersSort = Arrays.asList(4, 2, 3, 1);
        numbersSort = numbersSort.stream().sorted().collect(Collectors.toList());
        System.out.println(numbersSort);
        numbersSort = numbersSort.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(numbersSort);
        List<Integer> num = numbersSort.stream().limit(3).skip(2).collect(Collectors.toList());
        System.out.println(num);

//        Terminal Operations

//        forEach() Performs an action for each element.
        names.stream().forEach(System.out::println);

        //toArray() Converts the stream to an array.
        List<Integer> numbersArr = Arrays.asList(1, 2, 3);
        Integer[] r = numbersArr.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(r));

//      reduce() Reduces elements to a single value using an accumulator.
        List<Integer> reducer = Arrays.asList(1, 2, 3, 4);
        int sum = reducer.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        int min = reducer.stream().min(Integer::compare).orElseThrow();
        int max = reducer.stream().max(Integer::compare).orElseThrow();
        System.out.println(min + " " + max);

        //count() Counts the number of elements in the stream.
        long count=names.stream().count();
        System.out.println(count);

        //anyMatch() Checks if any element matches a predicate.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        boolean hasEven = numbers.stream().anyMatch(n ->  2 == 2);
        System.out.println(hasEven);

//        allMatch() Checks if all elements match a predicate.
        List<Integer> oddList = Arrays.asList(2, 4, 6);
        boolean allodd = numbers.stream().allMatch(n -> n % 2 == 0);
        System.out.println(allodd);

//        noneMatch() Checks if no elements match a predicate.
        List<Integer> numbersMatch = Arrays.asList(1, 3, 5);
        boolean noEven = numbersMatch.stream().noneMatch(n -> n % 2 == 0);
        System.out.println(noEven); // Output: true

        //findFirst() Returns the first element.
        List<Integer> numbersfirst = Arrays.asList(4, 3, 2, 1);
        int first = numbersfirst.stream().findFirst().orElseThrow();
        System.out.println(first); // Output: 4

        //findAny() Returns any element (useful in parallel streams).
        List<Integer> numbersany = Arrays.asList(4, 3, 2, 1);
        int any = numbersany.stream().findAny().orElseThrow();
        System.out.println(any); // Output: (any one element, e.g., 4)





    }
}
