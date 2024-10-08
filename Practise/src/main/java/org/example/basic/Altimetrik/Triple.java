package org.example.basic.Altimetrik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Triple {
//    Sort the array to use the two-pointer approach effectively.
//    Iterate through the array using a variable i from 0 to length-3:
//    Skip duplicates: If the current element is the same as the previous element (for i > 0), continue to the next iteration to avoid duplicate triplets.
//    For each element, use two pointers:
//    Set left pointer to i+1 and right pointer to length-1.
//    While left is less than right:
//    Calculate the sum of the elements at i, left, and right.
//    If the sum is 0, add the triplet to the result list.
//    Move the left pointer to the right past any duplicate elements.
//    Move the right pointer to the left past any duplicate elements.
//    If the sum is less than 0, move the left pointer to the right to increase the sum.
//    If the sum is greater than 0, move the right pointer to the left to decrease the sum.
    public static void main(String args[]) {
       List<Integer> nums= List.of(-1, 0, 1, 2, -1, -4);
        int k = 0;

        List<List<Integer>> triplet = threesum(nums, k);
        triplet.stream().forEach(System.out::println);

    }

    private static List<List<Integer>> threesum(  List<Integer> nums, int k) {

        List<List<Integer>> results = new ArrayList<>();

        if (nums.size() < 3) {
            System.out.println("Since triplet length should be minimum three 3 element in list");
            return results;
        }

//Sort the array to use the two-pointer approach effectively
        nums= nums.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted"+nums); //-4,-1,-1,0,1,2


        // Iterate through the array using a variable i from 0 to length-3
        for(int i=0 ;i<nums.size()-2;i++){

//            if(i>0 && nums.get(i).equals(nums.get(i-1))){ //-4 skip
//                System.out.println(nums.get(i) +"+"+ nums.get(i-1));
//                continue;
//            }

//            Skip duplicates: If the current element is the same as the previous element (for i > 0), continue to the next iteration to avoid duplicate triplets.
            if (i > 0 && nums.get(i).equals(nums.get(i - 1))) {
                continue;
            }

            int left =i+1;
            int right = nums.size()-1;

            while(left<right){
                int sum = nums.get(i) + nums.get(left) + nums.get(right);

                if(sum == k){

                    results.add(List.of(nums.get(i), nums.get(left) ,nums.get(right)));
                    // Skip the same elements to avoid duplicate triplets
                    while (left < right && nums.get(left) == nums.get(left+1)) left++;
                    while (left < right && nums.get(right) ==nums.get(right-1)) right--;
                    left++;
                    right--;
                }

                if(sum<k){
                    left++;
                } else if (sum > k) {
                    right--;
                }


            }

//            For each i, use two pointers: left starting from i + 1 and right starting from the end of the list.
//                    Calculate the sum of elements at i, left, and right.
//                    If the sum is equal to k, add the triplet to the results list.
//            Skip over duplicate elements by moving the left and right pointers.
//                    If the sum is less than k, move the left pointer to the right to increase the sum.
//            If the sum is greater than k, move the right pointer to the left to decrease the sum.
//            Example Walkthrough with Input [-1, 0, 1, 2, -1, -4]
//            Sorted List: [-4, -1, -1, 0, 1, 2]
//
//            Iteration:
//
//            i = 0, nums[i] = -4
//            left = 1, right = 5
//            sum = -4 + (-1) + 2 = -3 (less than 0, move left to 2)
//            sum = -4 + (-1) + 2 = -3 (less than 0, move left to 3)
//            sum = -4 + 0 + 2 = -2 (less than 0, move left to 4)
//            sum = -4 + 1 + 2 = -1 (less than 0, move left to 5)
//            i = 1, nums[i] = -1
//            left = 2, right = 5
//            sum = -1 + (-1) + 2 = 0 (equal to 0, add [-1, -1, 2])
//            Move left to 3, right to 4
//            sum = -1 + 0 + 1 = 0 (equal to 0, add [-1, 0, 1])
//            Move left to 4, right to 3
//            i = 2, nums[i] = -1 (duplicate, skip)
//            i = 3, nums[i] = 0
//            left = 4, right = 5
//            sum = 0 + 1 + 2 = 3 (greater than 0, move right to 4)


        }

        return results;
    }
}
