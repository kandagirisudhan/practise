package org.example.basic.Expression;

import java.util.Stack;

public class ExpressionProblemDoubleStack {

    public static String expandExpression(String inputString) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int count = 0;
        for (char ch : inputString.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + Character.getNumericValue(ch);
            } else if (Character.isAlphabetic(ch)) {
                currentString.append(ch);
            } else if ('[' == ch) {
                countStack.push(count);
                stringStack.push(currentString.toString());

                count = 0;
                currentString = new StringBuilder();
            } else if (']' == ch) {
                int prevCount = countStack.pop();
                String prevString = stringStack.pop();

                StringBuilder repeatedOccuranceString = new StringBuilder();
                for (int i = 0; i < prevCount; i++) {
                    repeatedOccuranceString.append(currentString);
                }
                currentString = new StringBuilder(prevString + repeatedOccuranceString);
            }
        }
        return currentString.toString();
    }

    public static void main(String args[]) {
        String output1 = expandExpression("3[a5[c]]4[b]");
        String output2 = expandExpression("2[a3[1b]]c");
        System.out.println(output1);
        System.out.println(output2);
    }
}
