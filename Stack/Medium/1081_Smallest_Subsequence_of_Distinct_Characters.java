
/**
 * Given a string s, return the lexicographically smallest subsequence of s that
 * contains all the distinct characters of s exactly once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "bcabc"
 * Output: "abc"
 * Example 2:
 * 
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 * 
 * 
 * Note: This question is the same as 316:
 * https://leetcode.com/problems/remove-duplicate-letters/
 * Accepted
 * 30,936
 * Submissions
 * 56,691
 */
import java.util.*;
import java.util.Stack;

class Solution {
    public String smallestSubsequence(String s) {
        HashSet<Character> h = new HashSet<>();
        Stack<Character> st = new Stack<>();
        int freq[] = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++)
            freq[s.charAt(i) - 97]++;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (st.empty()) {
                st.push(c);
                h.add(c);
            } else {
                if (!h.contains(c)) {
                    while (!st.empty() && freq[st.peek() - 97] > 0 && st.peek() >= c) {
                        h.remove(st.pop());
                    }
                    st.push(c);
                    h.add(c);
                }
            }
            freq[c - 97]--;
        }
        StringBuilder sb = new StringBuilder("");
        while (!st.empty())
            sb.append(st.pop());
        sb.reverse();
        return sb.toString();
    }
}