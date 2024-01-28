package org.example.basic.Search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class LinearAndBinary {

    public static void main(String args[]) {
        List<Integer> inputArray = List.of(2, 4, 5, 9, 6, 7, 19, 10,11);
        int x = 9;
        int resultLinear = linearSearch(inputArray, x);
        System.out.println("Found in the location :" + resultLinear);
        inputArray = inputArray.stream().sorted().collect(Collectors.toList());
        int resultBinary = binarySearch(inputArray, x);
        System.out.println("Found in the location :" +resultBinary);
    }

    private static int binarySearch(List<Integer> inputArray, int x) {

        System.out.println(inputArray);
        int mid = 0;
        int start = 0;
        int last = inputArray.size()-1;
        System.out.println(last);
        while (start <= last) {
            mid = start +(last -start)/2;  // start +(last -start)/2
//            System.out.println("----------->" + inputArray.get(mid));
            if (inputArray.get(mid) == x) {
                return mid+1;
            }
            if (x > inputArray.get(mid)) { // given element x greater than mid ,element will be in the right sub array
                start = mid + 1;
            } else {
                last = mid - 1; //given element x lesser than mid ,element will be in the left sub array
            }

        }
        return -1;
    }

    private static int linearSearch(List<Integer> inputArray, int x) {
        for (int i = 0; i < inputArray.size(); i++) {
            if (inputArray.get(i) == x) {
                return i + 1;

            }
        }
        return 0;
    }
}