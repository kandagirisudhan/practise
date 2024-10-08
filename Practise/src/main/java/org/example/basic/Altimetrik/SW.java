package org.example.basic.Altimetrik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SW {

    public static void main(String args[]) {
        List<Integer> arrayList = Arrays.asList(1, 4, 2, 10, 2, 3, 1, 20);
        int k = 4;
        int maxSum = Integer.MIN_VALUE;
        getMaxSum(arrayList, k, maxSum);
        getMaxSumAnotherImplementation(arrayList, k, maxSum);

    }


    private static void getMaxSum(List<Integer> arrayList, int k, int maxSum) {
        for (int i = 0; i < arrayList.size() - k + 1; i++) { //this will go till 6th index 9-4+1 =6 loop till 6
            int currentSum = 0;
            for (int j = 0; j < k; j++) {  // iterate till 0 to 3
                currentSum = currentSum + arrayList.get(i + j);
            }
            maxSum = Math.max(currentSum, maxSum);

        }
        System.out.println("Max SUM " + maxSum);
    }

    private static void getMaxSumAnotherImplementation(List<Integer> arrayList, int k, int maxSum) {
        for (int i = 0; i < arrayList.size() - k+1; i++) {//this will go till 6th index 9-4+1 =6 loop till 6
            int currentSum = 0;
            for (int j = i; j < k + i; j++) { //will iterate will define the starting and ending window .
                currentSum = currentSum + arrayList.get(j);
            }
            maxSum = Math.max(currentSum, maxSum);
        }
        System.out.println("Max SUM second " + maxSum);
    }
}
