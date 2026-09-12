package HashMap;

import java.util.HashMap;

public class MostFrequentCharacter {

    public static void main(String[] args) {

        String str = "banana";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        char ans = ' ';
        int maxFreq = 0;

        for(char ele : map.keySet()){
            if(map.get(ele) > maxFreq){
                maxFreq = map.get(ele);
                ans = ele;
            }
        }
        System.out.println("Most Frequent Character : " + ans);
        System.out.println("Frequency : " + maxFreq);
    }
}
