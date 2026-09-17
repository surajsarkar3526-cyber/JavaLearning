package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                char[] characters = currentWord.toCharArray();
                for (int j = 0; j < characters.length; j++) {
                    char original = characters[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        characters[j] = ch;
                        String newWord = new String(characters);
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    characters[j] = original;
                }
            }
            level++;
        }
        return 0;
    }
    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList( "hot", "dot","dog","lot","log","cog");
        int answer = solution.ladderLength(beginWord,endWord, wordList);
        System.out.println("Shortest Transformation Length: " + answer);
    }
}
