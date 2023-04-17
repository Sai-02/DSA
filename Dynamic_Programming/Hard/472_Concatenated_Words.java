
/**
 * Given an array of strings words (without duplicates), return all the
 * concatenated words in the given list of words.
 * 
 * A concatenated word is defined as a string that is comprised entirely of at
 * least two shorter words (not necesssarily distinct) in the given array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words =
 * ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Example 2:
 * 
 * Input: words = ["cat","dog","catdog"]
 * Output: ["catdog"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 104
 * 1 <= words[i].length <= 30
 * words[i] consists of only lowercase English letters.
 * All the strings of words are unique.
 * 1 <= sum(words[i].length) <= 105
 * Accepted
 * 206,922
 * Submissions
 * 414,257
 * Seen this question in a real inter
 */

import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> h = new HashSet<>();
        for (String word : words)
            h.add(word);
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (isConcatenated(word, h))
                ans.add(word);
        }
        return ans;
    }

    public boolean isConcatenated(String str, HashSet<String> h) {
        int dp[] = new int[str.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= str.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (h.contains(str.substring(j, i)) && dp[j] > 0) {
                    dp[i] += dp[j];
                }
            }
        }
        return dp[str.length()] > 1;
    }
}