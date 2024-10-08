//package org.example.basic.Altimetrik;// Input: nums = [-1,0,1,2,-1,-4] ;
//// target = 0
//// Output: [[-1,-1,2],[-1,0,1]]
//
//
////-4,-1,-1,0,1,2
//
//-4 -1+2 =-5+2 = 7   (7!=0)  > left++
//
//        -4-1+2 = 7
//        -4+0+1 = -3       < 0 right --
//
//
//
//
//
//
//
//
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//public class TwoPointer {
//
//    public static void main(String[] args) {
//        List<Integer> nums = List.of(-1,0,1,2,-1,-4);
//
//        int target =0;
//
//        List<List<Integer>> threeSum=  sum(nums,target);
//
//    }
//
//    private static List<List<Integer>> sum(List<Integer> nums ,int target) {
//
//        List<Integer> numsVal =nums.stream().sorted().toList();
//
//        List<List<Integer>> result = new ArrayList<>();
//
//        //-4,-1,-1,0,1,2
//
//        // i=-4
//        // left =-1
//        // right=2
//
//
//        for(int i =0 ;i<numsVal.size();i++){
//
//
//
//            int left = i+1;
//            int right = numsVal.size()-1;
//
//            while(left<right){
//                int sum =numsVal.get(i)+numsVal.get(left)+numsVal.get(right);
//                // -4-1+2=-3
//
//                if(sum == target ){
//
//                    result.add(List.of(numsVal.get(i),numsVal.get(left),numsVal.get(right)));
//
//
//                    left ++;
//                    right --;
//                }
//
//                if(sum<target){
//                    left ++;
//
//                }
//                else if(sum>target){
//
//                    right --;
//                }
//
//
//            }
//
//        }
//
//
//    }
//}
