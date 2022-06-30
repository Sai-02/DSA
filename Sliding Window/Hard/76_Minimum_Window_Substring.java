
/**
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window substring of s such that every character in t (including duplicates)
 * is included in the window. If there is no such substring, return the empty
 * string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
 * from string t.
 * Example 2:
 * 
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 * 
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * 
 * 
 * Constraints:
 * 
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 * 
 * 
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 * Accepted
 * 787,694
 * Submissions
 * 2,002,462
 */
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        int length = t.length(), minLength = Integer.MAX_VALUE;
        int startIndex = 0, endIndex = s.length() + 1;
        int i = 0, j = 0, count = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while (j < s.length()) {
            if (count < length) {
                char c = s.charAt(j);
                window.put(c, window.getOrDefault(c, 0) + 1);
                j++;
                count++;
            } else {
                if (containString(hm, window)) {
                    if (minLength >= j - i) {
                        minLength = j - i;
                        startIndex = i;
                        endIndex = j;
                    }
                    char c = s.charAt(i);
                    window.put(c, window.get(c) - 1);
                    if (window.get(c) == 0)
                        window.remove(c);
                    i++;
                } else {
                    char c = s.charAt(j);
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    j++;
                    count++;
                }

            }
        }
        while (i < s.length()) {
            if (containString(hm, window)) {
                if (minLength >= j - i) {
                    minLength = j - i;
                    startIndex = i;
                    endIndex = j;
                }
                char c = s.charAt(i);
                window.put(c, window.get(c) - 1);
                if (window.get(c) == 0)
                    window.remove(c);
                i++;
            } else
                break;
        }
        if (endIndex == s.length() + 1)
            return "";
        return s.substring(startIndex, endIndex);
    }

    public boolean containString(HashMap<Character, Integer> hm, HashMap<Character, Integer> window) {
        for (Character key : hm.keySet()) {
            if (hm.get(key) > window.getOrDefault(key, 0))
                return false;
        }
        return true;
    }

}