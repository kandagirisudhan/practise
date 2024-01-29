package org.example.basic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Difference {

//    [3,1,4,1,5]
//    Diff:2
//    O/p:2   pair
//
//    [3,5,5,5,2,2,2,3,4] diff: 2
//    Op:2 pair

    public static void main(String arg[]) {

        int a[] = {3, 1, 4, 1, 5};
        int b[] = {3, 5, 5, 5, 2, 2, 2, 3, 4};

        int Op1 = DifferenceInput(a, 2);
        int Op2 = DifferenceInput(b, 2);
        System.out.println("diff pair:" + Op1);
        System.out.println("diff pair:" + Op2);
//        o/p:2 pair         

    }

    private static int DifferenceInput(int[] a, int diff) {
        int count = 0;
        Set<Integer> removeDuplicate = new HashSet<>();


        for (int i = 0; i < a.length; i++) {
            removeDuplicate.add(a[i]);
        }
        if(removeDuplicate.size() < 2){
            System.out.println("Invalid input to find difference");
        }
        System.out.println("------>" + removeDuplicate);
        List<Integer> inputList = removeDuplicate.stream().collect(Collectors.toList());
        for (int i = 0; i < inputList.size(); i++) {
            int num = inputList.get(i);
            int diffCheck = num - diff;

            if (inputList.contains(diffCheck))
                count++;
        }
        return count;
    }
}
