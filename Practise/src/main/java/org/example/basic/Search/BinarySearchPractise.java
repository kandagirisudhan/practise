package org.example.basic.Search;

import java.util.Arrays;
import java.util.List;

public class BinarySearchPractise {

    public static void main(String args[]) {
        List<Integer> inputList = Arrays.asList(5, 10, 20, 30, 40, 50, 90); //Should be in sorted order ,try to find with the mid value

        int x = 50;
        int start = 0;
        int mid=0;
        int last = inputList.size()-1;

        while (start <=last) {
             mid = (start + last) / 2;
            if (inputList.get(mid) == x) {
                System.out.println((mid + 1));
            }

            if (inputList.get(mid) > x) {
                last = mid - 1;
            } else {
                start = mid + 1;
            }
        }


    }
}
