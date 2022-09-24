package Trie.Implemenation;

public class Trie {
    class TrieNode {
        boolean isEndOfWord;
        TrieNode children[];

        public TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return isMatch(word, root, 0, true);
    }

    public boolean startsWith(String prefix) {
        return isMatch(prefix, root, 0, false);
    }

    public boolean isMatch(String s, TrieNode node, int index, boolean isFullMatch) {
        if (node == null)
            return false;
        if (index == s.length())
            return !isFullMatch || node.isEndOfWord;
        return isMatch(s, node.children[s.charAt(index) - 'a'], index + 1, isFullMatch);
    }
}