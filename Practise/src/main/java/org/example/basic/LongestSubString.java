package org.example.basic;

import java.util.HashMap;

public class LongestSubString {

    public static void main(String args[]) {

        String s = "abcabdcdaabdc";

//        if (s = null || s.length() == 0) {
//            System.out.println();
//        }

        if (s == null || s.length() == 0) {
            System.out.println("Invalid Input");
        }

        int start = 0;
        int maxlength = 0;
        int maxstart = 0;

        HashMap<Character,Integer> map =new HashMap<>();
        for(int end =0 ; end<s.length();end++){
           char currentChar=s.charAt(end);
            if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
                start = map.get(currentChar) + 1;
            }
            map.put(currentChar,end);

            int currentLength = end - start + 1;
                    if(currentLength > maxlength){
                        maxlength =currentLength;
                        maxstart = start;
                    }

            System.out.println("" +s.substring(maxstart,maxstart+maxlength));
        }

        System.out.println(maxstart);




    }
//
//    Initial Setup
//    Input String: s = "abcabdcdaabdc"
//    Initial Variables:
//    start = 0
//    maxlength = 0
//    maxstart = 0

//    map = {} (an empty HashMap)
//    Iteration Steps
//    Iteration 1 (end = 0)
//    Current Character: a
//    Check Map: map does not contain a.

//    Update Map: map = {'a': 0}
//    Calculate Length: currentLength = 0 - 0 + 1 = 1
//    Update Max: maxlength = 1, maxstart = 0
//    Print Substring: "a"
//    Output: a
//    Iteration 2 (end = 1)
//    Current Character: b
//    Check Map: map does not contain b.
//    Update Map: map = {'a': 0, 'b': 1}
//    Calculate Length: currentLength = 1 - 0 + 1 = 2
//    Update Max: maxlength = 2, maxstart = 0
//    Print Substring: "ab"
//    Output: ab
//    Iteration 3 (end = 2)
//    Current Character: c
//    Check Map: map does not contain c.
//    Update Map: map = {'a': 0, 'b': 1, 'c': 2}
//    Calculate Length: currentLength = 2 - 0 + 1 = 3
//    Update Max: maxlength = 3, maxstart = 0
//    Print Substring: "abc"
//    Output: abc
//    Iteration 4 (end = 3)
//    Current Character: a
//    Check Map: map contains a and map.get('a') = 0 which is >= start.
//    Update Start: start = 0 + 1 = 1
//    Update Map: map = {'a': 3, 'b': 1, 'c': 2}
//    Calculate Length: currentLength = 3 - 1 + 1 = 3
//    Max Unchanged: maxlength = 3, maxstart = 0
//    Print Substring: "abc"
//    Output: abc
//    Iteration 5 (end = 4)
//    Current Character: b
//    Check Map: map contains b and map.get('b') = 1 which is >= start.
//    Update Start: start = 1 + 1 = 2
//    Update Map: map = {'a': 3, 'b': 4, 'c': 2}
//    Calculate Length: currentLength = 4 - 2 + 1 = 3
//    Max Unchanged: maxlength = 3, maxstart = 0
//    Print Substring: "abc"
//    Output: abc
//    Iteration 6 (end = 5)
//    Current Character: d
//    Check Map: map does not contain d.
//    Update Map: map = {'a': 3, 'b': 4, 'c': 2, 'd': 5}
//    Calculate Length: currentLength = 5 - 2 + 1 = 4
//    Update Max: maxlength = 4, maxstart = 2
//    Print Substring: "cabd"
//    Output: cabd
//    Iteration 7 (end = 6)
//    Current Character: c
//    Check Map: map contains c and map.get('c') = 2 which is >= start.
//    Update Start: start = 2 + 1 = 3
//    Update Map: map = {'a': 3, 'b': 4, 'c': 6, 'd': 5}
//    Calculate Length: currentLength = 6 - 3 + 1 = 4
//    Max Unchanged: maxlength = 4, maxstart = 2
//    Print Substring: "cabd"
//    Output: cabd
//    Iteration 8 (end = 7)
//    Current Character: d
//    Check Map: map contains d and map.get('d') = 5 which is >= start.
//    Update Start: start = 5 + 1 = 6
//    Update Map: map = {'a': 3, 'b': 4, 'c': 6, 'd': 7}
//    Calculate Length: currentLength = 7 - 6 + 1 = 2
//    Max Unchanged: maxlength = 4, maxstart = 2
//    Print Substring: "cabd"
//    Output: cabd
//    Iteration 9 (end = 8)
//    Current Character: a
//    Check Map: map does not contain a within the current window.
//    Update Map: map = {'a': 8, 'b': 4, 'c': 6, 'd': 7}
//    Calculate Length: currentLength = 8 - 6 + 1 = 3
//    Max Unchanged: maxlength = 4, maxstart = 2
//    Print Substring: "cabd"
//    Output: cabd
//    Iteration 10 (end = 9)
//    Current Character: a
//    Check Map: map contains a and map.get('a') = 8 which is >= start.
//    Update Start: start = 8 + 1 = 9
//    Update Map: map = {'a': 9, 'b': 4, 'c': 6, 'd': 7}
//    Calculate Length: currentLength = 9 - 9 + 1 = 1
//    Max Unchanged: maxlength = 4, maxstart = 2
//    Print Substring: "cabd"
//    Output: cabd
//    Iteration 11 (end = 10)
//    Current Character: b
//    Check Map: map does not contain b within the current window.
//    Update Map: map = {'a': 9, 'b': 10, 'c': 6, 'd': 7}
//    Calculate Length: currentLength = 10 - 9 + 1 = 2
//    Max Unchanged: maxlength = 4, maxstart = 2
//    Print Substring: "cabd"
//    Output: cabd
//    Iteration 12 (end = 11)
//    Current Character: d
//    Check Map: map contains d and map.get('d') = 7 which is < start.
//    Update Map: map = {'a': 9, 'b': 10, 'c': 6, 'd': 11}
//    Calculate Length: currentLength = 11 - 9 + 1 = 3
//    Max Unchanged: maxlength = 4, maxstart = 2
//    Print Substring: "cabd"
//    Output: cabd
//    Iteration 13 (end = 12)
//    Current Character: c
//    Check Map: map does not contain c within the current window.
//    Update Map: map = {'a': 9, 'b': 10, 'c': 12, 'd': 11}
//    Calculate Length: currentLength = 12 - 9 + 1 = 4
//    Max Unchanged: maxlength = 4, maxstart = 2
//    Print Substring: "cabd"
//    Output: cabd
//    Final Output
//    The longest substring without repeating characters is "cabd" with a length of 4, starting at index 2.
//
//    Full Outputs During Execution
//a
//        ab
//    abc
//            abc
//    abc
//            cabd
//    cabd
//            cabd
//    cabd
//            cabd
//    cabd
//            cabd
//    cabd

}
