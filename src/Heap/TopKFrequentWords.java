package Heap;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {
                "i", "love", "leetcode",
                "i", "love", "coding"
        };
        int k = 2;
        List<String> answer = topKFrequent(words, k);
        System.out.println(answer);
    }

    private static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(!map.get(a).equals(map.get(b))){
                return map.get(a)-map.get(b);
            }
            return b.compareTo(a);
        });
        for (String word : map.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> answer = new ArrayList<>();
        while (!pq.isEmpty()) {
            answer.add(pq.poll());
        }
        Collections.reverse(answer);
        return answer;
    }
}
