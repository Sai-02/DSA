
/**
 * You are visiting a farm that has a single row of fruit trees arranged from
 * left to right. The trees are represented by an integer array fruits where
 * fruits[i] is the type of fruit the ith tree produces.
 * 
 * You want to collect as much fruit as possible. However, the owner has some
 * strict rules that you must follow:
 * 
 * You only have two baskets, and each basket can only hold a single type of
 * fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from
 * every tree (including the start tree) while moving to the right. The picked
 * fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must
 * stop.
 * Given the integer array fruits, return the maximum number of fruits you can
 * pick.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * Example 2:
 * 
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * Example 3:
 * 
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 * 
 * 
 * Constraints:
 * 
 * 1 <= fruits.length <= 105
 * 0 <= fruits[i] < fruits.length
 * Accepted
 * 231,960
 * Submissions
 * 545,019
 */

import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int i = 0;
        while (i < fruits.length) {
            int count = 1;
            while (i < fruits.length - 1 && fruits[i] == fruits[i + 1]) {
                i++;
                count++;
            }
            list.add(fruits[i]);
            hm.put(list.size() - 1, count);
            i++;
        }
        int val1 = -1, val2 = -1;
        int count = 0, maxCount = 0;
        for (i = 0; i < list.size(); i++) {
            if (val1 == -1 && val2 == -1) {
                val1 = list.get(i);
                count += hm.get(i);
            } else if (val2 == -1) {
                count += hm.get(i);
                val2 = list.get(i);
            } else if (val1 == list.get(i) || val2 == list.get(i)) {
                count += hm.get(i);
            } else {
                maxCount = Math.max(maxCount, count);
                count = hm.get(i - 1) + hm.get(i);
                val1 = list.get(i - 1);
                val2 = list.get(i);
            }
        }
        maxCount = Math.max(count, maxCount);
        return maxCount;

    }
}