
/**
 * You are given an array of events where events[i] = [startDayi, endDayi].
 * Every event i starts at startDayi and ends at endDayi.
 * 
 * You can attend an event i at any day d where startTimei <= d <= endTimei. You
 * can only attend one event at any time d.
 * 
 * Return the maximum number of events you can attend.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: events = [[1,2],[2,3],[3,4]]
 * Output: 3
 * Explanation: You can attend all the three events.
 * One way to attend them all is as shown.
 * Attend the first event on day 1.
 * Attend the second event on day 2.
 * Attend the third event on day 3.
 * Example 2:
 * 
 * Input: events= [[1,2],[2,3],[3,4],[1,2]]
 * Output: 4
 * 
 * 
 * Constraints:
 * 
 * 1 <= events.length <= 105
 * events[i].length == 2
 * 1 <= startDayi <= endDayi <= 105
 * Accepted
 * 72,360
 * Submissions
 * 224,196
 */

import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            return a[0] - b[0];
        });
        int index = 0, count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int d = 1; d <= 100000; d++) {
            while (!pq.isEmpty() && pq.peek() < d)
                pq.remove();
            while (index < events.length && events[index][0] == d) {
                pq.add(events[index][1]);
                index++;
            }
            if (pq.size() > 0) {
                count++;
                pq.remove();
            }
        }
        return count;
    }
}