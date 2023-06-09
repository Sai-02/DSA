/**
 * Easy
 * 
 * 3463
 * 
 * 2082
 * 
 * Add to List
 * 
 * Share
 * You are given an array of characters letters that is sorted in non-decreasing
 * order, and a character target. There are at least two different characters in
 * letters.
 * 
 * Return the smallest character in letters that is lexicographically greater
 * than target. If such a character does not exist, return the first character
 * in letters.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * Explanation: The smallest character that is lexicographically greater than
 * 'a' in letters is 'c'.
 * Example 2:
 * 
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 * Explanation: The smallest character that is lexicographically greater than
 * 'c' in letters is 'f'.
 * Example 3:
 * 
 * Input: letters = ["x","x","y","y"], target = "z"
 * Output: "x"
 * Explanation: There are no characters in letters that is lexicographically
 * greater than 'z' so we return letters[0].
 * 
 * 
 * Constraints:
 * 
 * 2 <= letters.length <= 104
 * letters[i] is a lowercase English letter.
 * letters is sorted in non-decreasing order.
 * letters contains at least two different characters.
 * target is a lowercase English letter.
 * Accepted
 * 346,849
 * Submissions
 * 709,057
 */

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int index = 0, l = 0, r = letters.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (letters[mid] < target) {
                l = mid + 1;
            } else if (letters[mid] == target) {
                l = mid + 1;
            } else {
                r = mid - 1;
                index = mid;
            }
        }
        return letters[index];
    }
}