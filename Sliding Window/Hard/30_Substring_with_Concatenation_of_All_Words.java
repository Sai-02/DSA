
/**
 * You are given a string s and an array of strings words of the same length.
 * Return all starting indices of substring(s) in s that is a concatenation of
 * each word in words exactly once, in any order, and without any intervening
 * characters.
 * 
 * You can return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar"
 * respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 * 
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Example 3:
 * 
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s consists of lower-case English letters.
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] consists of lower-case English letters.
 * Accepted
 * 261,834
 * Submissions
 * 923,059
 * Seen this question in a real interview before?
 * 
 * Yes
 */

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        for (String word : words)
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        int wordLength = words[0].length();
        for (int i = 0; i < s.length() - (words.length * wordLength) + 1; i++) {
            String str = s.substring(i, i + (words.length * wordLength));
            if (isEqual(hm, str, wordLength))
                ans.add(i);
        }
        return ans;
    }

    public boolean isEqual(HashMap<String, Integer> hm, String str, int wordLength) {
        HashMap<String, Integer> window = new HashMap<>();
        for (int i = 0; i < str.length(); i += wordLength) {
            String word = str.substring(i, i + wordLength);
            window.put(word, window.getOrDefault(word, 0) + 1);
        }
        return window.equals(hm);

    }
}