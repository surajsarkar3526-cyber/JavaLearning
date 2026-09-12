package HashMap;

import java.util.HashSet;
import java.util.Set;

public class TwoSumUsingHashSet {

    public static void main(String[] args) {

        int[] arr = {0, -1, 2, -3, 1};
        int target = -2;
        boolean found = false;

        Set<Integer> set = new HashSet<>();

        for(int num : arr){
            int rem = target - num;
            if(set.contains(rem)){
                found = true;
                break;
            }

            set.add(num);
        }

        System.out.println(found);
    }
}
