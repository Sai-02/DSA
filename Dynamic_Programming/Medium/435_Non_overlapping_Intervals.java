
/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

Constraints:

1 <= intervals.length <= 105
intervals[i].length == 2
-5 * 104 <= starti < endi <= 5 * 104
Accepted
239,335
Submissions
497,067
 */
import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> {
            if (a1[0] == a2[0])
                return a1[1] - a2[1];
            return a1[0] - a2[0];
        });
        int count = 0;
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (start == intervals[i][0])
                count++;
            else if (end > intervals[i][0]) {
                end = Math.min(end, intervals[i][1]);
                count++;
            } else {
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        return count;
    }
}