package org.example.basic;

public class ReverseString {

    public static void main(String args[]) {
        String inputString = "Khishanth";
        StringBuilder result = new StringBuilder();
        for (int i = inputString.length()-1; i >= 0; i--) {
            result.append(inputString.charAt(i));
        }
        System.out.println("-----String reverse ------>"+result);
    }
}
