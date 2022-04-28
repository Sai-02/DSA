
/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome. Return all possible palindrome partitioning of s.
 * 
 * A palindrome string is a string that reads the same backward as forward.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 * 
 * Input: s = "a"
 * Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 * Accepted
 * 446,200
 * Submissions
 * 751,105
 */
import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        solver(s, ans, list);
        return ans;
    }

    public void solver(String s, List<List<String>> ans, List<String> list) {
        if (s.length() == 0) {
            List<String> l = new ArrayList<>(list);
            ans.add(l);
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (isPalindrome(sub)) {
                list.add(sub);
                solver(s.substring(i), ans, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}