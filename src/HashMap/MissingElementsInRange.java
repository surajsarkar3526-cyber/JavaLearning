package HashMap;

import java.util.HashSet;

public class MissingElementsInRange {

    public static void main(String[] args) {

        int[] arr = {2, 4, 7, 10};
        int low = 1;
        int high = 10;

        HashSet<Integer> set = new HashSet<>();
        for(int ele : arr){
            set.add(ele);
        }

        for(int i=low; i <= high; i++){
            if(!set.contains(i)){
                System.out.println(i);
            }
        }
    }
}
