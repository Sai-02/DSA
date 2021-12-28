
/**
 * You are given a string s and an integer k, a k duplicate removal consists of
 * choosing k adjacent and equal letters from s and removing them, causing the
 * left and the right side of the deleted substring to concatenate together.
 * 
 * We repeatedly make k duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made. It
 * is guaranteed that the answer is unique.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * Example 2:
 * 
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * Example 3:
 * 
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105
 * 2 <= k <= 104
 * s only contains lower case English letters.
 * Accepted
 * 138,286
 * Submissions
 * 246,343
 */
import java.util.Stack;

class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Integer> stNum = new Stack<>();
        Stack<Character> stChar = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (stNum.empty()) {
                stChar.push(c);
                stNum.push(1);
            } else if (stChar.peek() == c) {
                if (stNum.peek() + 1 == k) {
                    stNum.pop();
                    stChar.pop();
                } else {
                    stNum.push(stNum.pop() + 1);
                }
            } else {
                stChar.push(c);
                stNum.push(1);
            }
        }
        StringBuilder sb = new StringBuilder("");
        while (!stNum.empty()) {
            int num = stNum.pop();
            char c = stChar.pop();
            while (num-- > 0)
                sb.append(c);
        }
        return sb.reverse().toString();
    }
}