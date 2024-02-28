package org.example.basic.SlidingWindow;

public class SubArrayGivenSum {

    public static void main(String args[]) {

        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int sum = 24;

        int n = arr.length;
        System.out.println(maxSum(arr, n, k, sum));
    }

    private static String maxSum(int[] arr, int n, int k, int sum) {

        // n must be greater
        if (n < k) {
            return "Invalid";
        }

        int max_sum=0;
        for (int i = 0; i < k; i++) {
            max_sum += arr[i];
        }

        int window_sum = max_sum;
        for (int i = k; i < n; i++) {
            window_sum += arr[i] - arr[i - k];
            if (window_sum == sum)
                return "Yes SUM Matches " + window_sum;
        }

        return "";
    }
}
