package org.example.basic.paypal;

import java.util.ArrayList;
import java.util.List;

//import org.joda.time.format.PeriodFormat;

/*
The next permutation of an array of integers is the next lexicographically greater permutation of its integer

Question :
Input: nums = [1,2,3]
Output: 1,3,2
What is the next permutation :

Question 2 :
What all the possible permutation ?

[1,2,3]
[2,3,1]
[2,1,3]
[3,2,1]
[1,3,2]
[3,1,2]
*/
// 2,3,1 ->   3,1,2
// 1<2 swapping 1

// 2,1,3

// 1<3  swapping 1

// 2,3,1

// 2<3  swap 2

// 3,2,1


// 1,3,2
// [3,1,2]

// [1,2,3]   greatest int list 3

// [1,3,2]



//   List<Integer> inputValue=List.of(1,2,3);

class Permutaion{


    public static void main(String args[]){

        int [] nums ={1,2,3};

        int startIndex = 0 ;

        List<List<Integer>> result =new ArrayList<>();

        permute(nums,startIndex,result);

        for(List<Integer> Permutaion : result){
            System.out.println(Permutaion);
        }

    }
    private static void permute(int[] nums, int startIndex, List<List<Integer>> result) {

        if(startIndex == nums.length){
            List<Integer> permutation =new ArrayList<>();
            for(int num :nums){
                permutation.add(num);

            }
result.add(permutation);

        }


        for(int i=startIndex;i<nums.length;i++){

            swap(nums,startIndex,i);
            permute(nums,startIndex+1,result); // callback 1,2,3
            swap(nums,startIndex,i); // backtrack
        }
    }

    private static void swap(int[] nums, int i, int j) {
        //swap
        int temp = nums[i];  // nam[0] 1
        nums[i]  =nums[j] ;   //
        nums[j] =temp;

    }
}











