package BackTracking;

class WordDictionary {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }
    private final TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    public void addWord(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }
    public boolean search(String word) {
        return dfs(root, word, 0);
    }
    private boolean dfs(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isEnd;
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (TrieNode child : node.children) {
                if (child != null && dfs(child, word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
        int position = ch - 'a';
        TrieNode child = node.children[position];
        if (child == null) {
            return false;
        }
        return dfs(child, word, index + 1);
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}
