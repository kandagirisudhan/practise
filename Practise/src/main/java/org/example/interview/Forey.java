package org.example.interview;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;
import java.util.List;

public class Forey {

    // Input val : 200000000000000 + 1000000000000

    //Eg. "1000" + "2000"


    public static void main(String args[]) {

        String a = "199";
        String b = "188";
        String result = " "; //    000
        String output = SumOfTwo(a, b);

        System.out.println("Result Value :" + output);

    }

    private static String SumOfTwo(String a, String b) {

        String temp;

        List<String> firstStringList = new ArrayList<>();
        List<String> secondStringList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();
        StringBuilder resultVal = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            firstStringList.add(String.valueOf(a.charAt(i)));

        }

        for (int i = b.length() - 1; i >= 0; i--) {

            secondStringList.add(String.valueOf(b.charAt(i)));
        }
        System.out.println(firstStringList);
        System.out.println(secondStringList);

        if (firstStringList.size() == secondStringList.size()) {
            int size = firstStringList.size();
            int carry = 0;

            for (int i = 0; i < size; i++) {
                int first = Integer.valueOf(firstStringList.get(i));
                int second = Integer.valueOf(secondStringList.get(i));

                int result = first + second + carry;
                carry = result / 10;
                int res = result % 10;

                resultVal.append(String.valueOf(res));
            }

            if (carry > 0) {
                resultVal.append(String.valueOf(carry));
            }
        }

        return resultVal.reverse().toString();
    }

}
