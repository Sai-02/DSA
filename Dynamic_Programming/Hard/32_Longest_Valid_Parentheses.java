/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 * 
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 * 
 * Input: s = ""
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 */
class Solution {
    public int longestValidParentheses(String s) {
        int max = 0, l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                l++;
            else
                r++;
            if (l == r)
                max = Math.max(max, 2 * r);
            if (r > l)
                l = r = 0;
        }
        l = r = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(')
                l++;
            else
                r++;
            if (l == r)
                max = Math.max(max, 2 * l);
            if (l > r)
                l = r = 0;
        }
        return max;
    }
}