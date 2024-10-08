package org.example.basic.Altimetrik;

import java.util.Stack;

public class Expression {

    public static void main(String args[]) {


//        String a = "3[a5[c]]4[b]";
        String b = "2[a3[1b]]c";
        Stack<Object> stack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int count = 0;

        for (char ch : b.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + Character.getNumericValue(ch);
            } else if (Character.isAlphabetic(ch)) {
                currentString.append(ch);
            } else if (ch == '[') {
                stack.push(currentString.toString());
                stack.push(count);

                count=0;
                currentString =new StringBuilder();

            } else if (ch == ']') {

                System.out.println(stack);
                int prevCount = (int) stack.pop();
                String prevString = (String) stack.pop();
                StringBuilder repeatedOccurence =new StringBuilder();
                for(int i=0 ;i < prevCount;i++){

                    repeatedOccurence.append(currentString);
                }
                currentString = new StringBuilder(prevString + repeatedOccurence);


            }
        }
        System.out.println(currentString);
    }

}
