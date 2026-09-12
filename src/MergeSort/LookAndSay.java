package MergeSort;

import Strings.StringBuilders;

import java.util.Scanner;

public class LookAndSay {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Terms : ");
        int n = sc.nextInt();

        String term = "1";
        for(int i=1; i<=n; i++){
            System.out.println(term);
            term  = generateLookSay(term);
        }
    }

    private static String generateLookSay(String term) {

        StringBuilder nextTerm = new StringBuilder();

        int count = 1;

        for(int i=1; i<term.length(); i++){

            if(term.charAt(i) == term.charAt(i-1)){
                count++;
            }
            else{

                nextTerm.append(count);
                nextTerm.append(term.charAt(i - 1));

                count = 1;
            }
        }
        nextTerm.append(count);
        nextTerm.append(term.charAt(term.length() - 1));

        return nextTerm.toString();
    }
}
