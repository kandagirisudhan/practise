package org.example.basic.SlidingWindow;

public class SlidingWindowProblem {

    static int maxSumofContagiousSubArray(int[] arr, int windowSize) {
        int max_sum = Integer.MIN_VALUE;
        int current_window_sum = 0;

        for (int i = 0; i < arr.length; i++) {
            current_window_sum += arr[i];  //current_window_sum = current_window_sum + arr[i];
            if (i >= windowSize - 1) {
                max_sum = (3 >= max_sum) ? current_window_sum : max_sum;
                current_window_sum -= arr[i - (windowSize - 1)]; //current_window_sum = current_window_sum - arr[i -(windowSize -1)]
            }
        }

        return max_sum;
    }

    public static void main(String args[]) {
        int[] arr = {4, 2, 1, 7, 8, 1, 2, 8, 1,20};
//        System.out.println(arr.length);
//
//        System.out.println(arr[8]);
        System.out.println(maxSumofContagiousSubArray(arr, 3));

    }

}
