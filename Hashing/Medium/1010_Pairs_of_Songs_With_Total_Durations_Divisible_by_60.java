/**
 * You are given a list of songs where the ith song has a duration of time[i]
 * seconds.
 * 
 * Return the number of pairs of songs for which their total duration in seconds
 * is divisible by 60. Formally, we want the number of indices i, j such that i
 * < j with (time[i] + time[j]) % 60 == 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: time = [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * Example 2:
 * 
 * Input: time = [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible
 * by 60.
 * 
 * 
 * Constraints:
 * 
 * 1 <= time.length <= 6 * 104
 * 1 <= time[i] <= 500
 * Accepted
 * 155,269
 * Submissions
 * 291,400
 */
import java.util.*;
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int val : time) {
            val = val % 60;
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        for (int val : time) {
            val = val % 60;
            if (hm.containsKey(60 - val)) {
                count += hm.get(60 - val);
                if (val == 60 - val)   //if val=30
                    count--;
            }
        }
        if (hm.containsKey(0))
            count += (hm.get(0) * (hm.get(0) - 1)); 
        return count / 2;
    }
}