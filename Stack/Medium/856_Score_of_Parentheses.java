
/**
 * Given a balanced parentheses string s, return the score of the string.
 * 
 * The score of a balanced parentheses string is based on the following rule:
 * 
 * "()" has score 1.
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "()"
 * Output: 1
 * Example 2:
 * 
 * Input: s = "(())"
 * Output: 2
 * Example 3:
 * 
 * Input: s = "()()"
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 2 <= s.length <= 50
 * s consists of only '(' and ')'.
 * s is a balanced parentheses string.
 * Accepted
 * 89,647
 * Submissions
 * 136,627
 */
import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(-1);
            } else {
                if (st.peek() == -1) {
                    st.pop();
                    st.push(1);
                } else {
                    while (!st.empty() && st.peek() != -1) {
                        count += st.pop();
                    }
                    st.pop();
                    st.push(count * 2);
                    count = 0;
                }
            }
        }
        while (!st.empty()) {
            count += st.pop();
        }
        return count;

    }
}