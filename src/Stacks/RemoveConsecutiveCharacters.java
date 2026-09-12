package Stacks;

import java.util.Scanner;

public class RemoveConsecutiveCharacters {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String : ");
        String str = sc.nextLine();

        String result = removeConsecutiveCharacters(str);
        System.out.println("After Removing Consecutive Characters: " + result);

        sc.close();
    }

    private static String removeConsecutiveCharacters(String str) {

        StringBuilder result = new StringBuilder();

        result.append(str.charAt(0));

        for(int i=1; i<str.length(); i++){

            if(str.charAt(i) != str.charAt(i-1)){
                result.append(str.charAt(i));

            }
        }

        return result.toString();
    }
}
