
/**
 * You are given a string s and two integers x and y. You can perform two types
 * of operations any number of times.
 * 
 * Remove substring "ab" and gain x points.
 * For example, when removing "ab" from "cabxbae" it becomes "cxbae".
 * Remove substring "ba" and gain y points.
 * For example, when removing "ba" from "cabxbae" it becomes "cabxe".
 * Return the maximum points you can gain after applying the above operations on
 * s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "cdbcbbaaabab", x = 4, y = 5
 * Output: 19
 * Explanation:
 * - Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5
 * points are added to the score.
 * - Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4
 * points are added to the score.
 * - Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points
 * are added to the score.
 * - Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are
 * added to the score.
 * Total score = 5 + 4 + 5 + 5 = 19.
 * Example 2:
 * 
 * Input: s = "aabbaaxybbaabb", x = 5, y = 4
 * Output: 20
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105
 * 1 <= x, y <= 104
 * s consists of lowercase English letters.
 * Accepted
 * 8,188
 * Submissions
 * 18,842
 */
import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> st = new Stack<>();
        char firstChar = '?', secChar = '?';
        int score = 0, n = s.length();
        if (x > y) {
            firstChar = 'a';
            secChar = 'b';
        } else {
            firstChar = 'b';
            secChar = 'a';
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == secChar) {
                if (!st.empty() && st.peek() == firstChar) {
                    st.pop();
                    score += Math.max(x, y);
                } else {
                    st.push(c);
                }
            } else
                st.push(c);
        }
        Stack<Character> st2 = new Stack<>();
        while (!st.empty()) {
            char c = st.pop();
            if (!st2.empty() && c == secChar && st2.peek() == firstChar) {
                score += Math.min(x, y);
                st2.pop();
            } else
                st2.push(c);

        }
        return score;
    }
}