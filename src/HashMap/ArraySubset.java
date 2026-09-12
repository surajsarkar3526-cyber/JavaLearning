package HashMap;

import java.util.HashMap;

public class ArraySubset {

    public static void main(String[] args) {

        int[] a = {11, 7, 1, 13, 21, 3, 7, 3};
        int[] b = {11, 3, 7, 1, 7};

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : a){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        boolean subset = true;
        for(int ele : b){
            if(!map.containsKey(ele) || map.get(ele) == 0){
                subset = false;
                break;
            }
            map.put(ele, map.get(ele) - 1);
        }

        System.out.println(subset);
    }
}
