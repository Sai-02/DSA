
/**
 * In a warehouse, there is a row of barcodes, where the ith barcode is
 * barcodes[i].
 * 
 * Rearrange the barcodes so that no two adjacent barcodes are equal. You may
 * return any answer, and it is guaranteed an answer exists.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: barcodes = [1,1,1,2,2,2]
 * Output: [2,1,2,1,2,1]
 * Example 2:
 * 
 * Input: barcodes = [1,1,1,1,2,2,3,3]
 * Output: [1,3,1,3,1,2,1,2]
 * 
 * 
 * Constraints:
 * 
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 */

import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int val, freq;

        Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        public int compareTo(Pair o) {
            return o.freq - this.freq;
        }
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int bar : barcodes) {
            hm.put(bar, hm.getOrDefault(bar, 0) + 1);
        }
        for (int key : hm.keySet()) {
            pq.add(new Pair(key, hm.get(key)));
        }
        int ans[] = new int[barcodes.length];
        int index = 0;
        while (pq.size() > 0) {
            Pair pair = pq.remove();
            if (index == 0 || ans[index - 1] != pair.val) {
                ans[index++] = pair.val;
                pair.freq--;
                if (pair.freq > 0)
                    pq.add(pair);
            } else {
                Pair secPair = pq.remove();
                ans[index++] = secPair.val;
                secPair.freq--;
                if (secPair.freq > 0)
                    pq.add(secPair);
                pq.add(pair);
            }
        }
        return ans;
    }
}