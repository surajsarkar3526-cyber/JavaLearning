package Arrays;

import java.util.ArrayList;

public class FirstAndSecondSmallest {
    public static void main(String[] args){
        int[] arr = {3, 4, 5, 2, 6};
        ArrayList<Integer> result = minAnd2ndMin(arr);
        System.out.println(result.toString());
    }

    private static ArrayList<Integer> minAnd2ndMin(int[] arr) {
        int secondSmallest = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;
        for(int num : arr){
            if(num < smallest){
                secondSmallest = smallest;
                smallest = num;
            }
            else if(num > smallest && secondSmallest > num){
                secondSmallest = num;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if(secondSmallest == Integer.MAX_VALUE){
            result.add(-1);
        }
        else{
            result.add(smallest);
            result.add(secondSmallest);
        }
        return result;
    }
}
