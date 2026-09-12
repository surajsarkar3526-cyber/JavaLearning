package Arrays;

import java.util.ArrayList;

public class RemoveDuplicatesSortedArray {
    public static void main(String[] args){
        int[] arr = {2, 2, 2, 3, 3, 5};
        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(arr[i] != arr[i-1]){
                result.add(arr[i]);
            }
        }
        System.out.println(result);
    }
}
