/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 * 
 * In other words, return true if one of s1's permutations is the substring of
 * s2.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * 
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int freq[] = new int[26];
        int check[] = new int[26];
        int i = 0;
        for (i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            check[s2.charAt(i) - 'a']++;
        }
        int left = 0;
        while (i < s2.length()) {
            if (isMatch(freq, check))
                return true;
            check[s2.charAt(i) - 'a']++;
            check[s2.charAt(left) - 'a']--;
            left++;
            i++;
        }
        if (isMatch(freq, check))
            return true;
        return false;
    }

    public boolean isMatch(int freq[], int check[]) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] != check[i])
                return false;
        }
        return true;
    }
}