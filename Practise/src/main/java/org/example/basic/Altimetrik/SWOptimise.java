package org.example.basic.Altimetrik;

import java.util.Arrays;
import java.util.List;

public class SWOptimise {

    public static void main(String args[]) {
        List<Integer> arrayList = Arrays.asList( 1, 4, 2, 10, 2, 3, 1, 0, 20);
        int k = 4;
        if (arrayList.size() < k) {
            System.out.println("Invalid");
        }

        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum = maxSum + arrayList.get(i);
        }

        int currentSum = maxSum;
        for (int i = k; i < arrayList.size(); i++) {
            currentSum = currentSum + (arrayList.get(i) - arrayList.get(i - k));
            maxSum = Math.max(maxSum, currentSum);

        }
        System.out.println(maxSum);
    }
}
