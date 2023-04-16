
/**
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * 
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict)
            trie.insert(word);
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[i] || (dp[j] && trie.search(s.substring(j, i)));
            }
        }
        return dp[dp.length - 1];
    }

    class Trie {
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
            if (index == s.length()) {
                return !isFullMatch || node.isEndOfWord;
            }
            return isMatch(s, node.children[s.charAt(index) - 'a'], index + 1, isFullMatch);
        }
    }

}