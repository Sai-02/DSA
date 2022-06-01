
/**
 * Medium
 * 
 * 1191
 * 
 * 184
 * 
 * Add to List
 * 
 * Share
 * A string s is called happy if it satisfies the following conditions:
 * 
 * s only contains the letters 'a', 'b', and 'c'.
 * s does not contain any of "aaa", "bbb", or "ccc" as a substring.
 * s contains at most a occurrences of the letter 'a'.
 * s contains at most b occurrences of the letter 'b'.
 * s contains at most c occurrences of the letter 'c'.
 * Given three integers a, b, and c, return the longest possible happy string.
 * If there are multiple longest happy strings, return any of them. If there is
 * no such string, return the empty string "".
 * 
 * A substring is a contiguous sequence of characters within a string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: a = 1, b = 1, c = 7
 * Output: "ccaccbcc"
 * Explanation: "ccbccacc" would also be a correct answer.
 * Example 2:
 * 
 * Input: a = 7, b = 1, c = 0
 * Output: "aabaa"
 * Explanation: It is the only correct answer in this case.
 * 
 * 
 * Constraints:
 * 
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 */

import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int freq;
        char c;

        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        public int compareTo(Pair o) {
            return o.freq - this.freq;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        if (a > 0)
            pq.add(new Pair('a', a));
        if (b > 0)
            pq.add(new Pair('b', b));
        if (c > 0)
            pq.add(new Pair('c', c));
        StringBuilder sb = new StringBuilder("");
        while (pq.size() > 0) {
            Pair pair = pq.remove();
            if (sb.length() < 2) {
                sb.append(pair.c + "");
                pair.freq--;
                if (pair.freq > 0)
                    pq.add(pair);
            } else if (sb.charAt(sb.length() - 1) == pair.c && sb.charAt(sb.length() - 2) == pair.c) {
                if (pq.size() == 0)
                    break;
                Pair secPair = pq.remove();
                sb.append(secPair.c);
                secPair.freq--;
                if (secPair.freq > 0)
                    pq.add(secPair);
                pq.add(pair);
            } else {
                sb.append(pair.c + "");
                pair.freq--;
                if (pair.freq > 0)
                    pq.add(pair);
            }
        }
        return sb.toString();

    }
}