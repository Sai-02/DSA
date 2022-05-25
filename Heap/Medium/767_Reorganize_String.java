
/**
 * Given a string s, rearrange the characters of s so that any two adjacent
 * characters are not the same.
 * 
 * Return any possible rearrangement of s or return "" if not possible.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aab"
 * Output: "aba"
 * Example 2:
 * 
 * Input: s = "aaab"
 * Output: ""
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 */

import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        char c;
        int freq;

        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        public int compareTo(Pair o) {
            return o.freq - this.freq;
        }
    }

    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder("");
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
            if (hm.get(c) > (s.length() + 1) / 2)
                return "";
        }
        for (char c : hm.keySet()) {
            pq.add(new Pair(c, hm.get(c)));
        }
        while (pq.size() > 0) {
            Pair pair = pq.remove();
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != pair.c) {
                sb.append(pair.c + "");
                pair.freq--;
                if (pair.freq > 0)
                    pq.add(pair);
            } else {
                Pair secPair = pq.remove();
                sb.append(secPair.c + "");
                secPair.freq--;
                if (secPair.freq > 0)
                    pq.add(secPair);
                pq.add(pair);
            }
        }
        return sb.toString();
    }
}