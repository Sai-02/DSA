/**
 * You are given a string s consisting of the characters 'a', 'b', and 'c' and a
 * non-negative integer k. Each minute, you may take either the leftmost
 * character of s, or the rightmost character of s.
 * 
 * Return the minimum number of minutes needed for you to take at least k of
 * each character, or return -1 if it is not possible to take k of each
 * character.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aabaaaacaabc", k = 2
 * Output: 8
 * Explanation:
 * Take three characters from the left of s. You now have two 'a' characters,
 * and one 'b' character.
 * Take five characters from the right of s. You now have four 'a' characters,
 * two 'b' characters, and two 'c' characters.
 * A total of 3 + 5 = 8 minutes is needed.
 * It can be proven that 8 is the minimum number of minutes needed.
 * Example 2:
 * 
 * Input: s = "a", k = 1
 * Output: -1
 * Explanation: It is not possible to take one 'b' or 'c' so return -1.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105
 * s consists of only the letters 'a', 'b', and 'c'.
 * 0 <= k <= s.length
 * Accepted
 * 5,959
 * Submissions
 * 19,775
 */

class Solution {
    public int takeCharacters(String s, int k) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a')
                a++;
            else if (ch == 'b')
                b++;
            else
                c++;
        }
        if (a < k || b < k || c < k)
            return -1;
        a -= k;
        b -= k;
        c -= k;
        int i = 0, j = 0, counta = 0, countb = 0, countc = 0;
        int maxLength = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (ch == 'a')
                counta++;
            else if (ch == 'b')
                countb++;
            else
                countc++;
            while ((counta > a || countb > b || countc > c)) {
                ch = s.charAt(i);
                if (ch == 'a')
                    counta--;
                else if (ch == 'b')
                    countb--;
                else
                    countc--;
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return s.length() - maxLength;
    }
}

// ================================================================
//
// Approach :
// https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/discuss/2948008/Easy-Sliding-window-with-explanation-oror-C%2B%2B
//
// ================================================================
