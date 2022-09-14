
/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * 
 * Input: n = 1
 * Output: ["()"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 8
 * Accepted
 * 1,199,345
 * Submissions
 * 1,677,596
 */

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        HashSet<String> h = new HashSet<>();
        List<String> ans = new ArrayList<>();
        if (n == 1) {
            ans.add("()");
            return ans;
        }
        List<String> prev = generateParenthesis(n - 1);
        for (String str : prev) {
            String s = str + "()";
            if (!h.contains(s)) {
                ans.add(s);
                h.add(s);
            }
            s = "()" + str;
            if (!h.contains(s)) {
                ans.add(s);
                h.add(s);
            }
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ')')
                    continue;
                int count = 1;
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == ')')
                        count--;
                    else
                        count++;
                    if (count == 0) {
                        String p = str.substring(0, i) + "(" + str.substring(i, j + 1) + ")" + str.substring(j + 1);
                        if (!h.contains(p)) {
                            h.add(p);
                            ans.add(p);
                        }
                    }
                }
            }
        }
        return ans;
    }
}