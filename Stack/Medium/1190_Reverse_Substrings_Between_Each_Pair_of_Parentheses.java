
/**
 * You are given a string s that consists of lower case English letters and
 * brackets.
 * 
 * Reverse the strings in each pair of matching parentheses, starting from the
 * innermost one.
 * 
 * Your result should not contain any brackets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "(abcd)"
 * Output: "dcba"
 * Example 2:
 * 
 * Input: s = "(u(love)i)"
 * Output: "iloveu"
 * Explanation: The substring "love" is reversed first, then the whole string is
 * reversed.
 * Example 3:
 * 
 * Input: s = "(ed(et(oc))el)"
 * Output: "leetcode"
 * Explanation: First, we reverse the substring "oc", then "etco", and finally,
 * the whole string.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 2000
 * s only contains lower case English characters and parentheses.
 * It is guaranteed that all parentheses are balanced.
 * Accepted
 * 42,609
 * Submissions
 * 65,141
 */
import java.util.*;
import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                Queue<Character> q = new LinkedList<>();
                while (!st.empty() && st.peek() != '(') {
                    q.add(st.pop());
                }
                st.pop();
                while (!q.isEmpty())
                    st.push(q.remove());
            } else {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder("");
        while (!st.empty())
            sb.append(st.pop());
        sb.reverse();
        return sb.toString();

    }
}