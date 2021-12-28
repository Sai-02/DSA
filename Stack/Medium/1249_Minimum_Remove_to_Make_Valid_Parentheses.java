
/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * 
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any
 * positions ) so that the resulting parentheses string is valid and return any
 * valid string.
 * 
 * Formally, a parentheses string is valid if and only if:
 * 
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid
 * strings, or
 * It can be written as (A), where A is a valid string.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 * 
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 * 
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105
 * s[i] is either'(' , ')', or lowercase English letter.
 * Accepted
 * 304,630
 * Submissions
 * 467,819
 */
import java.util.Stack;
import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {
        HashSet<Integer> h = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                if (c == '(')
                    st.push(i);
                else {
                    if (st.empty())
                        h.add(i);
                    else
                        st.pop();
                }
            }
        }
        while (!st.empty())
            h.add(st.pop());
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            if (!h.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}