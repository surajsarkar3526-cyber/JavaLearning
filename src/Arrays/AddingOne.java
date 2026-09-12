package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class AddingOne {
    static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a size : ");
        int n = sc.nextInt();
        ArrayList<Integer>arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
        System.out.print(plusOne(arr));
    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> arr) {
        int n = arr.size();
        for(int i=n-1; i>=0; i--){
            if(arr.get(i) < 9){
                arr.set(i,arr.get(i)+1);
                return arr;
            }
            else{
                arr.set(i,0);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int i=0; i<n; i++){
            ans.add(0);
        }
        return ans;
    }
}
