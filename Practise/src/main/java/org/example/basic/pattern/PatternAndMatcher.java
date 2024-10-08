package org.example.basic.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndMatcher {

    public static void main(String arg[]) {

//        Pattern pattern = Pattern.compile("[a-z]",Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher("Giri");
//         if (matcher.find()){
//             System.out.println("Match Found"+matcher.start());
//         } else{
//             System.out.println("match does not found");
//        }

        System.out.println(Pattern.matches("[^abc]","g"));
    }
}