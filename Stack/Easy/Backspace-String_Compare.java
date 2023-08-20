/**
 * Given two strings s and t, return true if they are equal when both are typed
 * into empty text editors. '#' means a backspace character.
 * 
 * Note that after backspacing an empty text, the text will continue empty.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ab#c", t = "ad#c" Output: true Explanation: Both s and t become
 * "ac". Example 2:
 * 
 * Input: s = "ab##", t = "c#d#" Output: true Explanation: Both s and t become
 * "". Example 3:
 * 
 * Input: s = "a##c", t = "#a#c" Output: true Explanation: Both s and t become
 * "c". Example 4:
 * 
 * Input: s = "a#c", t = "b" Output: false Explanation: s becomes "c" while t
 * becomes "b".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length, t.length <= 200 s and t only contain lowercase letters and '#'
 * characters.
 * 
 * 
 * Follow up: Can you solve it in O(n) time and O(1) space?
 * 
 * Accepted 344,846 Submissions 726,988 Seen this question in a real interview
 * before?
 * 
 * Yes
 * 
 * No
 */

// ==================================================
//
// Solution using Stack
//
// ==================================================
import java.util.*;

class Solution11 {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (!st1.empty()) {
                    st1.pop();
                }
            } else {
                st1.push(c);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (!st2.empty()) {
                    st2.pop();
                }
            } else {
                st2.push(c);
            }
        }
        while (true) {
            if (st1.empty() && st2.empty()) {
                break;
            }
            if (st1.empty() || st2.empty()) {
                return false;
            }
            char c1 = st1.pop();
            char c2 = st2.pop();
            if (c1 != c2)
                return false;
        }

        return true;
    }
}

// =================================================================
//
// Solution without using stack (in O(1) space and O(n) time )
//
// ================================================================


