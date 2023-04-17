
/**
 * Given a list of contacts contact[] of length n where each contact is a string
 * which exist in a phone directory and a query string s. The task is to
 * implement a search query for the phone directory. Run a search query for each
 * prefix p of the query string s (i.e. from index 1 to |s|) that prints all the
 * distinct contacts which have the same prefix as p in lexicographical
 * increasing order. Please refer the explanation part for better understanding.
 * Note: If there is no match between query and contacts, print "0".
 * 
 * Example 1:
 * 
 * Input:
 * n = 3
 * contact[] = {"geeikistest", "geeksforgeeks",
 * "geeksfortest"}
 * s = "geeips"
 * Output:
 * geeikistest geeksforgeeks geeksfortest
 * geeikistest geeksforgeeks geeksfortest
 * geeikistest geeksforgeeks geeksfortest
 * geeikistest
 * 0
 * 0
 * Explaination: By running the search query on
 * contact list for "g" we get: "geeikistest",
 * "geeksforgeeks" and "geeksfortest".
 * By running the search query on contact list
 * for "ge" we get: "geeikistest" "geeksforgeeks"
 * and "geeksfortest".
 * By running the search query on contact list
 * for "gee" we get: "geeikistest" "geeksforgeeks"
 * and "geeksfortest".
 * By running the search query on contact list
 * for "geei" we get: "geeikistest".
 * No results found for "geeip", so print "0".
 * No results found for "geeips", so print "0".
 * Your Task:
 * You do not need to read input or print anything. Your task is to complete the
 * function displayContacts() which takes n, contact[ ] and s as input
 * parameters and returns a list of list of strings for required prefixes. If
 * some prefix has no matching contact return "0" on that list.
 * 
 * Expected Time Complexity: O(|s| * n * max|contact[i]|)
 * Expected Auxiliary Space: O(n * max|contact[i]|)
 * 
 * Constraints:
 * 1 ≤ T ≤ 100, T = number of test cases
 * 1 ≤ n ≤ 50
 * 1 ≤ |contact[i]| ≤ 50
 * 1 ≤ |s| ≤ 6
 */

import java.util.*;

class Solution {
    static ArrayList<ArrayList<String>> displayContacts(int n,
            String contact[], String s) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Trie trie = new Trie();
        for (String str : contact)
            trie.add(str);
        for (int i = 0; i < s.length(); i++) {
            ans.add(trie.getResults(s.substring(0, i + 1)));
        }
        return ans;
    }

    static class Trie {
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
            this.root = new TrieNode();
        }

        public void add(String str) {
            TrieNode node = root;
            for (char c : str.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEndOfWord = true;

        }

        public ArrayList<String> getResults(String str) {
            TrieNode node = root;
            for (char c : str.toCharArray()) {
                node = node.children[c - 'a'];
                if (node == null) {
                    ArrayList<String> a = new ArrayList<>();
                    a.add("0");
                    return a;
                }
            }
            ArrayList<String> ans = new ArrayList<>();
            ArrayList<String> temp = search(node);
            for (String s : temp)
                ans.add(str + s);
            return ans;

        }

        public ArrayList<String> search(TrieNode node) {
            if (node == null)
                return new ArrayList<String>();
            ArrayList<String> ans = new ArrayList<>();
            if (node.isEndOfWord)
                ans.add("");
            for (int i = 0; i < 26; i++) {
                ArrayList<String> child = search(node.children[i]);
                for (String str : child)
                    ans.add((char) (i + 97) + str);
            }

            return ans;
        }
    }

}