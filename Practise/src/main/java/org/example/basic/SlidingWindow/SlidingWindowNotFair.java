package org.example.basic.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowNotFair {

    public static void main(String args[]) {
        List<Integer> inputVal = List.of(4, 2, 1, 7, 8, 1, 2, 8, 1, 20);
        System.out.println(inputVal.size());
        System.out.println(inputVal.get(9));
        int k = 4;
        int n = inputVal.size();
        int max_Sum = contiguousSummingArray(inputVal, k, n);
        System.out.println("Max Sum:" + max_Sum);
        int max_Sum_Val = contiguousSummingArraySecondApproch(inputVal, k, n);
        System.out.println("Max Sum:" + max_Sum_Val);

    }

    private static int contiguousSummingArraySecondApproch(List<Integer> inputVal, int k, int n) {
        int max_Sum = Integer.MIN_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
            int currentSum = 0;
            for (int j = i; j < i + k; j++) {
                currentSum = currentSum + inputVal.get(j);
            }
            max_Sum = Math.max(currentSum, max_Sum);
        }
        return max_Sum;
    }

    private static int contiguousSummingArray(List<Integer> inputVal, int k, int n) {
        int max_Sum = Integer.MIN_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
            int currentSum = 0;
            for (int j = 0; j < k; j++) {
                currentSum = currentSum + inputVal.get(i + j);
            }
            max_Sum = (currentSum >= max_Sum) ? currentSum : max_Sum;                              //Math.max(currentSum ,max_Sum);
        }
        return max_Sum;
    }
}
