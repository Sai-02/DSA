
/**
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * 
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * 
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 * 
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */
import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        int count = 0;
        Stack<Integer> stNum = new Stack<>();
        Stack<StringBuilder> stString = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        stNum.push(0);
        stString.push(sb);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stNum.push(count);
                StringBuilder n = new StringBuilder("");
                stString.push(n);
                count = 0;
            } else if (c == ']') {
                StringBuilder build = stString.pop();
                int num = stNum.pop();
                while (num-- > 0) {
                    stString.peek().append(build.toString());
                }
            } else if (Character.isDigit(c)) {
                count = (count * 10) + c - '0';
            } else {
                stString.peek().append(c);
            }

        }
        return stString.peek().toString();
    }
}