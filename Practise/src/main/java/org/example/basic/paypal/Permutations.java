package org.example.basic.paypal;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);

        // Print all permutations
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }

    // Helper function to generate permutations
    private static void permute(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            // Add the current permutation to the result list
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permute(nums, start + 1, result);
                swap(nums, start, i);  // backtrack
            }
        }
    }

    // Helper function to swap elements in an array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
