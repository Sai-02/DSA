
/**
 * Given a string s which represents an expression, evaluate this expression and
 * return its value.
 * 
 * The integer division should truncate toward zero.
 * 
 * You may assume that the given expression is always valid. All intermediate
 * results will be in the range of [-231, 231 - 1].
 * 
 * Note: You are not allowed to use any built-in function which evaluates
 * strings as mathematical expressions, such as eval().
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 * 
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 * 
 * Input: s = " 3+5 / 2 "
 * Output: 5
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 3 * 105
 * s consists of integers and operators ('+', '-', '*', '/') separated by some
 * number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range [0,
 * 231 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 * Accepted
 * 339,431
 * Submissions
 * 844,906
 * Seen this question in a real interview before?
 */
import java.util.*;
import java.util.Stack;

class Solution {
    public int calculate(String s) {
        ArrayList<String> postfix = getPostfix(getList(s));
        Stack<Integer> st = new Stack<>();
        for (String c : postfix) {
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                if (c.equals("+")) {
                    st.push(a + b);
                } else if (c.equals("-")) {
                    st.push(b - a);
                } else if (c.equals("/")) {
                    st.push(b / a);
                } else {
                    st.push(a * b);
                }
            } else {
                st.push(Integer.parseInt(c));
            }
        }
        return st.peek();
    }

    public ArrayList<String> getPostfix(ArrayList<String> a) {
        ArrayList<String> ans = new ArrayList<>();
        Stack<String> st = new Stack<>();
        for (String c : a) {
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                if (st.empty()) {
                    st.push(c);
                } else {
                    while (!st.empty() && getPrecedence(st.peek()) >= getPrecedence(c)) {
                        ans.add(st.pop());
                    }
                    st.push(c);
                }
            } else {
                ans.add(c);
            }
        }
        while (!st.empty()) {
            ans.add(st.pop());
        }
        return ans;
    }

    public int getPrecedence(String c) {
        if (c.equals("+") || c.equals("-"))
            return 1;
        return 2;
    }

    public ArrayList<String> getList(String s) {
        ArrayList<String> ans = new ArrayList<>();
        int n = s.length();
        int lastNumIndex = -1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '/' || c == '*') {
                ans.add(s.substring(lastNumIndex, i).trim());
                ans.add(c + "");
                lastNumIndex = -1;
            } else {
                if (lastNumIndex == -1) {
                    lastNumIndex = i;
                }
            }

        }
        ans.add(s.substring(lastNumIndex, s.length()).trim());
        return ans;
    }
}

// ==============================================================
//
// Optimized Solution
//
// ==============================================================

class Solution2 {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        char sign = '+';
        int value = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                value = (value * 10) + c - '0';
            } else if (c != ' ') {
                if (sign == '+')
                    st.push(value);
                else if (sign == '-')
                    st.push(-value);
                else if (sign == '/') {
                    int a = st.pop();
                    st.push(a / value);
                } else {
                    int a = st.pop();
                    st.push(a * value);
                }
                value = 0;
                sign = c;

            }
        }
        if (sign == '+')
            st.push(value);
        else if (sign == '-')
            st.push(-value);
        else if (sign == '/') {
            int a = st.pop();
            st.push(a / value);
        } else {
            int a = st.pop();
            st.push(a * value);
        }
        value = 0;
        int ans = 0;
        while (!st.empty())
            ans += st.pop();
        return ans;

    }
}