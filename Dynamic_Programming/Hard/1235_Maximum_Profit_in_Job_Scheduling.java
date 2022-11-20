
/**
 * We have n jobs, where every job is scheduled to be done from startTime[i] to
 * endTime[i], obtaining a profit of profit[i].
 * 
 * You're given the startTime, endTime and profit arrays, return the maximum
 * profit you can take such that there are no two jobs in the subset with
 * overlapping time range.
 * 
 * If you choose a job that ends at time X you will be able to start another job
 * that starts at time X.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job.
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 * Example 2:
 * 
 * 
 * 
 * Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit =
 * [20,20,100,70,60]
 * Output: 150
 * Explanation: The subset chosen is the first, fourth and fifth job.
 * Profit obtained 150 = 20 + 70 + 60.
 * Example 3:
 * 
 * 
 * 
 * Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * Output: 6
 * 
 * 
 * Constraints:
 * 
 * 1 <= startTime.length == endTime.length == profit.length <= 5 * 104
 * 1 <= startTime[i] < endTime[i] <= 109
 * 1 <= profit[i] <= 104
 * Accepted
 * 141,662
 * Submissions
 * 276,955
 */
import java.util.*;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int jobs[][] = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int dp[] = new int[jobs.length];
        dp[jobs.length - 1] = jobs[jobs.length - 1][2];
        for (int i = jobs.length - 2; i >= 0; i--) {
            int next = findNext(i, jobs);
            dp[i] = Math.max(jobs[i][2] + (next == -1 ? 0 : dp[next]), dp[i + 1]);
        }
        return dp[0];
    }

    public int findNext(int i, int jobs[][]) {
        int l = i + 1, r = jobs.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (jobs[mid][0] >= jobs[i][1]) {
                if (jobs[mid - 1][0] >= jobs[i][1])
                    r = mid - 1;
                else
                    return mid;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}