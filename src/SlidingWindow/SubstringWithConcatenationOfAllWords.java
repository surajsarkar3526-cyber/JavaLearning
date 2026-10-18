package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words));
    }

    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(words.length==0){
            return result;
        }
        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalCount = wordLength * wordCount;
        if(s.length() < totalCount){
            return result;
        }
        Map<String, Integer> wordFrequency = new HashMap<>();
        for(String word : words){
            wordFrequency.put(word, wordFrequency.getOrDefault(word,0)+1);
        }
        for (int offset = 0; offset < wordLength; offset++) {
            int left = offset;
            int count = 0;
            Map<String, Integer> window = new HashMap<>();
            for (int right = offset; right + wordLength <= s.length(); right += wordLength) {
                String word = s.substring(right, right + wordLength);
                if(!wordFrequency.containsKey(word)){
                    window.clear();
                    count = 0;
                    left = right + wordLength;
                    continue;
                }
                window.put(word, window.getOrDefault(word,0)+1);
                count++;
                while (window.get(word) > wordFrequency.get(word)) {
                    String leftWord = s.substring(left, left + wordLength);
                    window.put(leftWord, window.get(leftWord) - 1);
                    left += wordLength;
                    count--;
                }
                if (count == wordCount) {
                    result.add(left);
                    String leftWord = s.substring(left, left + wordLength);
                    window.put(leftWord, window.get(leftWord) - 1);
                    left += wordLength;
                    count--;
                }
            }
        }
        return result;
    }
}
