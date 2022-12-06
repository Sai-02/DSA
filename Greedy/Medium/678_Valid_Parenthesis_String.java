/**
 * Given a string s containing only three types of characters: '(', ')' and '*',
 * return true if s is valid.
 * 
 * The following rules define a valid string:
 * 
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left
 * parenthesis '(' or an empty string "".
 * 
 * 
 * Example 1:
 * 
 * Input: s = "()"
 * Output: true
 * Example 2:
 * 
 * Input: s = "(*)"
 * Output: true
 * Example 3:
 * 
 * Input: s = "(*))"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 100
 * s[i] is '(', ')' or '*'.
 * Accepted
 * 193,278
 * Submissions
 * 569,177
 */

class Solution {
    public boolean checkValidString(String s) {
        int max = 0, min = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                max++;
                min++;
            } else if (c == ')') {
                max--;
                min--;
            } else {
                max++;
                min--;
            }
            if (max < 0)
                return false;
            min = Math.max(min, 0);
        }
        return min == 0;
    }
}