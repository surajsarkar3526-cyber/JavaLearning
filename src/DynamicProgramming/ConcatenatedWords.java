package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

public class ConcatenatedWords {
    public static void main(String[] args) {
        String[] words = {
                "cat", "cats", "catsdogcats", "dog",
                "dogcatsdog", "hippopotamuses", "rat",
                "ratcatdogcat"
        };
        List<String> result = findAllConcatenatedWordsInADict(words);
        System.out.println(result);
    }

    private static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> dictionary = new HashSet<>(Arrays.asList(words));
        for(String word : words){
            dictionary.remove(word);
            int n = word.length();
            boolean[] dp = new boolean[n+1];
            dp[0] = true;
            for(int i=1; i<=n; i++){
                for(int j=0; j<i; j++){
                    if(dp[j] && dictionary.contains(word.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            if(dp[n]){
                result.add(word);
            }
            dictionary.add(word);
        }
        return result;
    }
}
