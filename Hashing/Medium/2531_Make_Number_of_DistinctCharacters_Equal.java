
/**
 * You are given two 0-indexed strings word1 and word2.

A move consists of choosing two indices i and j such that 0 <= i < word1.length and 0 <= j < word2.length and swapping word1[i] with word2[j].

Return true if it is possible to get the number of distinct characters in word1 and word2 to be equal with exactly one move. Return false otherwise.

 

Example 1:

Input: word1 = "ac", word2 = "b"
Output: false
Explanation: Any pair of swaps would yield two distinct characters in the first string, and one in the second string.
Example 2:

Input: word1 = "abcc", word2 = "aab"
Output: true
Explanation: We swap index 2 of the first string with index 0 of the second string. The resulting strings are word1 = "abac" and word2 = "cab", which both have 3 distinct characters.
Example 3:

Input: word1 = "abcde", word2 = "fghij"
Output: true
Explanation: Both resulting strings will have 5 distinct characters, regardless of which indices we swap.
 

Constraints:

1 <= word1.length, word2.length <= 105
word1 and word2 consist of only lowercase English letters.
Accepted
11,076
Submissions
44,932
 */
import java.util.*;

class Solution {
    public boolean isItPossible(String word1, String word2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : word1.toCharArray())
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        for (char c : word2.toCharArray())
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                char c1 = (char) (i + 97);
                char c2 = (char) (j + 97);
                if (map1.containsKey(c1) && map2.containsKey(c2)) {
                    map1.put(c1, map1.get(c1) - 1);
                    map1.put(c2, map1.getOrDefault(c2, 0) + 1);
                    if (map1.get(c1) == 0)
                        map1.remove(c1);
                    map2.put(c2, map2.get(c2) - 1);
                    map2.put(c1, map2.getOrDefault(c1, 0) + 1);
                    if (map2.get(c2) == 0)
                        map2.remove(c2);
                    if (map1.size() == map2.size())
                        return true;
                    map1.put(c1, map1.getOrDefault(c1, 0) + 1);
                    map1.put(c2, map1.get(c2) - 1);
                    if (map1.get(c2) == 0)
                        map1.remove(c2);
                    map2.put(c2, map2.getOrDefault(c2, 0) + 1);
                    map2.put(c1, map2.get(c1) - 1);
                    if (map2.get(c1) == 0)
                        map2.remove(c1);
                }
            }
        }
        return false;

    }
}