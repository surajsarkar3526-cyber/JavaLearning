package Recursion;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int number = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }
            else if (ch == '[') {
                countStack.push(number);
                stringStack.push(currentString);
                number = 0;
                currentString = "";
            }
            else if (ch == ']') {
                int repeatCount = countStack.pop();
                String previousString = stringStack.pop();
                StringBuilder repeatedString = new StringBuilder();
                for (int i = 0; i < repeatCount; i++) {
                    repeatedString.append(currentString);
                }
                currentString = previousString + repeatedString;
            }
            else {
                currentString += ch;
            }
        }
        return currentString;
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        String result = decodeString(s);
        System.out.println(result);
    }
}
