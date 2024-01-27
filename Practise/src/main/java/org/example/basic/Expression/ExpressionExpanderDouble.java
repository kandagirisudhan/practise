package org.example.basic.Expression;

import java.util.Stack;

public class ExpressionExpanderDouble {

    public static String expandExpression(String inputStr) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int count = 0;

        for (char ch : inputStr.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + Character.getNumericValue(ch);
            } else if (Character.isAlphabetic(ch)) {
                currentStr.append(ch);
            } else if (ch == '[') {
                strStack.push(currentStr.toString());
                countStack.push(count);
                currentStr = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                String prevStr = strStack.pop();
                int prevCount = countStack.pop();
                StringBuilder repeatedStr = new StringBuilder();
                for (int i = 0; i < prevCount; i++) {
                    repeatedStr.append(currentStr);
                }
                currentStr = new StringBuilder(prevStr + repeatedStr);
            }
        }

        return currentStr.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String output1 = expandExpression("3[a5[c]]4[b]");
        String output2 = expandExpression("2[a3[1b]]c");

        System.out.println(output1);  // Output: acccccaccccaccccbbbbb
        System.out.println(output2);  // Output: abbbabbbc
    }
}
