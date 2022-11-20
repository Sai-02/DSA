
/**
 * Given a string s representing a valid expression, implement a basic
 * calculator to evaluate it, and return the result of the evaluation.
 * 
 * Note: You are not allowed to use any built-in function which evaluates
 * strings as mathematical expressions, such as eval().
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 * 
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 * 
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 3 * 105
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
 * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
 * There will be no two consecutive operators in the input.
 * Every number and running calculation will fit in a signed 32-bit integer.
 * Accepted
 * 351,741
 * Submissions
 * 837,359
 */

import java.util.*;

class Solution {
    public int calculate(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (sb.length() != 0) {
                    st.push(sb.toString());
                    sb.setLength(0);
                }
                if (c == ' ')
                    continue;
                else if (c == ')') {
                    int val = 0;
                    while (!st.empty()) {
                        String val1 = st.pop();
                        if (val1.equals("("))
                            break;
                        int v = Integer.parseInt(val1);
                        String op = st.pop();
                        if (op.equals("(")) {
                            val += v;
                            break;
                        }
                        if (op.equals("-"))
                            v = -v;
                        val += v;
                    }
                    st.push(val + "");
                } else {
                    st.push(c + "");
                }
            }

        }
        if (sb.length() != 0) {
            st.push(sb.toString());
        }
        int ans = 0;
        while (!st.empty()) {
            int val = Integer.parseInt(st.pop());
            if (st.empty()) {
                ans += val;
                break;
            }
            String op = st.pop();
            if (op.equals("-"))
                val = -val;
            ans += val;
        }
        return ans;
    }

    public int evalString(String val1, String op, String val2) {
        if (op.equals("+"))
            return Integer.parseInt(val1) + Integer.parseInt(val2);
        else
            return Integer.parseInt(val1) - Integer.parseInt(val2);

    }

    public String getOppositeOp(String str) {
        if (str.equals("+"))
            return "-";
        return "+";
    }
}