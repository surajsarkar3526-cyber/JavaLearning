package HashMap;

import java.util.HashSet;

public class PairWithDifferenceK {

    public static void main(String[] args) {

        int[] arr = {5, 20, 3, 2, 50, 80};
        int k = 78;

        System.out.println(findPair(arr, k));
    }

    private static boolean findPair(int[] arr, int k) {

        HashSet<Integer> set = new HashSet<>();
        for(int ele : arr){
            if(set.contains(ele + k) || set.contains(ele-k)){
                return true;
            }

            set.add(ele);
        }

        return false;
    }
}
