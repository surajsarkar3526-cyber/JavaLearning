package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter A String : ");
        String str = sc.nextLine();

        String result = removeDuplicates(str);

        System.out.print("After Removing Adjacent Duplicates: " + result);

        sc.close();

    }

    private static String removeDuplicates(String str) {

        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){

            char ch = str.charAt(i);

            if(!st.isEmpty() && st.peek() == ch){
                st.pop();

            }
            else{
                st.push(ch);

            }
        }
        StringBuilder result = new StringBuilder();

        for(char ele : st){
            result.append(ele);

        }


        return result.toString();
    }
}
