package org.example.basic.Search;

import java.util.Arrays;
import java.util.List;

public class LineaSearchPractise {

    public static void main(String args[]){

        List<Integer> inputList = Arrays.asList(5,10,20,30,40,50,90);
        int x = 50;
        int [] array = {1,2,3,4,5,6,7};
        System.out.println(inputList.size());
        System.out.println(array.length);

        for(int i=0;i<inputList.size();i++){
            if(inputList.get(i) == x ){
                System.out.println("index "+(i+1)+" Element "+inputList.get(i));
            }

        }





    }
}
