
/**
 * Given a string s, remove duplicate letters so that every letter appears once
 * and only once. You must make sure your result is the smallest in
 * lexicographical order among all possible results.
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
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 * 
 * 
 * Note: This question is the same as 1081:
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 * 
 * Accepted
 * 143,687
 * Submissions
 * 352,215
 */

import java.util.*;
import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int freq[] = new int[26];
        HashSet<Character> h = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            freq[c - 97]++;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (st.empty()) {
                st.push(c);
                freq[c - 97]--;
                h.add(c);
            } else if (!h.contains(c)) {
                if (st.peek() < c) {
                    st.push(c);
                    freq[c - 97]--;
                    h.add(c);
                } else {
                    while (!st.empty() && st.peek() > c && freq[st.peek() - 97] > 0) {
                        h.remove(st.peek());
                        st.pop();
                    }
                    st.push(c);
                    freq[c - 97]--;
                    h.add(c);
                }
            } else {
                freq[c - 97]--;
            }
        }
        StringBuilder ans = new StringBuilder("");
        while (!st.empty()) {
            ans.append(st.pop());
        }
        ans.reverse();
        return ans.toString();
    }
}