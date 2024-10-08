package org.example.basic.Altimetrik;

import java.util.Arrays;

public class Pointer {



    public static void  main(String args[]){

        int arr[] = { 2, 3, 5, 8, 9, 10, 11 };

        int k=17;
        Arrays.sort(arr); //sort the array
        System.out.println(arr);

        int left =0;

        int right=arr.length-1;

        while(left<right){

            int sum =arr[left] +arr[right];

            if(sum == k){

                System.out.println(arr[left]+"+" +arr[right] +" = " +sum);
                break;
            }

            if(sum < k){
                left ++;
            } else if (sum > k) {

                right--;

            }

        }
//        2, 3, 5, 8, 9, 10, 11

//                i=0 ; right = 6
//                left =0
//                right =6
//                arr[0] +arr[6]
//                2+11=13

//                13<17
//                left++ 1

//                  arr[1] + arr[6]
//                   3+11=14;
//        left++

//                 arr[2]+arr[6]
//                         5+11 =16

//                 16<17
//                 left++


//        arr[3]+arr[6]
////
////                8+11=19
////                        right--;
////        arr[3]+arr[5]
////        8+10=18
////                18>17
////        right--;

//        arr[3]+arr[4] =8+9 = 17(17==k)

    }
}
