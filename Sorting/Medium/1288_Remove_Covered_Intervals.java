
/**
 * 1288. Remove Covered Intervals
 * Medium
 * 
 * 1238
 * 
 * 34
 * 
 * Add to List
 * 
 * Share
 * Given an array intervals where intervals[i] = [li, ri] represent the interval
 * [li, ri), remove all intervals that are covered by another interval in the
 * list.
 * 
 * The interval [a, b) is covered by the interval [c, d) if and only if c <= a
 * and b <= d.
 * 
 * Return the number of remaining intervals.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,4],[3,6],[2,8]]
 * Output: 2
 * Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
 * Example 2:
 * 
 * Input: intervals = [[1,4],[2,3]]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= intervals.length <= 1000
 * intervals[i].length == 2
 * 0 <= li <= ri <= 105
 * All the given intervals are unique.
 * Accepted
 * 68,217
 * Submissions
 * 118,224
 */
import java.util.*;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            else
                return b[1] - a[1];
        });
        int size = intervals.length;
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (left <= intervals[i][0] && right < intervals[i][1]) {
                right = intervals[i][1];
            } else
                size--;
        }
        return size;
    }
}