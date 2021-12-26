
/**
 * Given a string s, determine if it is valid.
 * 
 * A string s is valid if, starting with an empty string t = "", you can
 * transform t into s after performing the following operation any number of
 * times:
 * 
 * Insert string "abc" into any position in t. More formally, t becomes tleft +
 * "abc" + tright, where t == tleft + tright. Note that tleft and tright may be
 * empty.
 * Return true if s is a valid string, otherwise, return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aabcbc"
 * Output: true
 * Explanation:
 * "" -> "abc" -> "aabcbc"
 * Thus, "aabcbc" is valid.
 * Example 2:
 * 
 * Input: s = "abcabcababcc"
 * Output: true
 * Explanation:
 * "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
 * Thus, "abcabcababcc" is valid.
 * Example 3:
 * 
 * Input: s = "abccba"
 * Output: false
 * Explanation: It is impossible to get "abccba" using the operation.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 2 * 104
 * s consists of letters 'a', 'b', and 'c'
 * Accepted
 * 37,494
 * Submissions
 * 65,184
 */
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'b')
                st.push(c);
            else {
                if (st.size() >= 2) {
                    char b = st.pop();
                    char a = st.pop();
                    if (a == 'a' && b == 'b') {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return st.empty();
    }
}