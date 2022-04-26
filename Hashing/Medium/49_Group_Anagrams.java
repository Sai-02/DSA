
/**
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 * 
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * 
 * Input: strs = ["a"]
 * Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 * Accepted
 * 1,322,148
 * Submissions
 * 2,063,253
 */

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String str : strs) {
            char c[] = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (hm.containsKey(key)) {
                hm.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hm.put(key, list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (String key : hm.keySet()) {
            ans.add(hm.get(key));
        }
        return ans;
    }
}