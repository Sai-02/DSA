
/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to
 * construct a sentence where each word is a valid dictionary word. Return all
 * such possible sentences in any order.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 * Example 2:
 * 
 * Input: s = "pineapplepenapple", wordDict =
 * ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 * Input is generated in a way that the length of the answer doesn't exceed 105.
 * Accepted
 * 510,933
 * Submissions
 * 1,127,155
 */

import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict)
            trie.insert(word);
        List<List<String>> dp = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++)
            dp.add(new ArrayList<String>());
        dp.get(0).add("");
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (trie.search(s.substring(j, i))) {
                    if (j == 0)
                        dp.get(i).add(s.substring(j, i));
                    else {
                        for (String str : dp.get(j)) {
                            dp.get(i).add(str + " " + s.substring(j, i));
                        }
                    }
                }
            }
        }
        return dp.get(dp.size() - 1);
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