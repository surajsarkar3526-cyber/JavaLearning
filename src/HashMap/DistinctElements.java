package HashMap;

import java.util.HashSet;

public class DistinctElements {

    public static void main(String[] args) {

        int[] arr1 = {2, 2, 3, 2};
        System.out.println("Distinct Count = " + distinctCount(arr1));

        int[] arr2 = {12, 1, 14, 3, 16};
        System.out.println("Distinct Count = " + distinctCount(arr2));
    }

    private static int distinctCount(int[] arr) {
        HashSet<Integer> set = new HashSet();

        for(int ele : arr){
            set.add(ele);
        }

        return set.size();
    }
}
