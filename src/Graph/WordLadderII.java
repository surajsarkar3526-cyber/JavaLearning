package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Queue;
import java.util.Arrays;

public class WordLadderII {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot", "dog","lot","log","cog");
        WordLadderII solution = new WordLadderII();
        List<List<String>> answer = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(answer);
    }
    public List<List<String>> findLadders(String beginWord,String endWord,List<String> wordList) {
        List<List<String>> answer = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return answer;
        }
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> parents = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                int currentDistance = distance.get(currentWord);
                char[] characters = currentWord.toCharArray();
                for (int j = 0; j < characters.length; j++) {
                    char originalCharacter = characters[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == originalCharacter) {
                            continue;
                        }
                        characters[j] = ch;
                        String nextWord = new String(characters);
                        if (!wordSet.contains(nextWord)) {
                            continue;
                        }
                        int nextDistance = currentDistance + 1;
                        if (!distance.containsKey(nextWord)) {
                            distance.put(nextWord, nextDistance);
                            parents.put(nextWord,new ArrayList<>());
                            parents.get(nextWord).add(currentWord);
                            queue.offer(nextWord);
                        }
                        else if (distance.get(nextWord) == nextDistance) {
                            parents.get(nextWord).add(currentWord);
                        }
                        if (nextWord.equals(endWord)) {
                            found = true;
                        }
                    }
                    characters[j] = originalCharacter;
                }
            }
        }
        if (!distance.containsKey(endWord)) {
            return answer;
        }
        List<String> path = new ArrayList<>();
        path.add(endWord);
        buildPaths(endWord,beginWord,parents,path,answer);
        return answer;
    }
    private void buildPaths(String currentWord,String beginWord,Map<String, List<String>> parents,List<String> path,List<List<String>> answer) {
        if (currentWord.equals(beginWord)) {
            List<String> completePath = new ArrayList<>(path);
            Collections.reverse(completePath);
            answer.add(completePath);
            return;
        }
        for (String parent : parents.get(currentWord)) {
            path.add(parent);
            buildPaths(parent,beginWord,parents,path,answer);
            path.remove(path.size() - 1);
        }
    }
}
