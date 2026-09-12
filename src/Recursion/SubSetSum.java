package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SubSetSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("\n------------- C Code(Source Code) --------------\n\n");
        
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1); arr.add(2); arr.add(3); arr.add(4); arr.add(5);
        
        ArrayList<Integer> ans = new ArrayList<>();

        SubsetSum(arr,0,0,ans);

        Collections.sort(ans);
        System.out.print(ans);

    }

    private static void SubsetSum(ArrayList<Integer> arr, int idx, int sum, ArrayList<Integer> ans) {

        if(idx == arr.size()){
            ans.add(sum);
            return;
        }

        SubsetSum(arr,idx+1,sum+arr.get(idx),ans);

        SubsetSum(arr,idx+1,sum,ans);
    }
}
