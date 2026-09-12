package HashMap;

import java.util.HashMap;

public class EqualPairs {

    public static void main(String[] args) {

        String str = "abacaba";

        System.out.println(countEqualPairs(str));
    }

    static int countEqualPairs(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ele : str.toCharArray()){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        int pairs = 0;
        for(int num : map.values()){
            pairs += num * (num - 1)/2;
        }

        return pairs;
    }
}
