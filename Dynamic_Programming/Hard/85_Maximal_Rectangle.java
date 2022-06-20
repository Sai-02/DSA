
/**
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest
 * rectangle containing only 1's and return its area.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix =
 * [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * Example 2:
 * 
 * Input: matrix = [["0"]]
 * Output: 0
 * Example 3:
 * 
 * Input: matrix = [["1"]]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * rows == matrix.length
 * cols == matrix[i].length
 * 1 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 * Accepted
 * 301,042
 * Submissions
 * 698,331
 */

// Hint : Application of largest area in histogram

import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                dp[i][j] = matrix[i][j] - '0';
                if (i + 1 < dp.length && dp[i][j] > 0) {
                    dp[i][j] += dp[i + 1][j];
                }
            }
        }
        int ans = 0;
        for (int a[] : dp) {
            ans = Math.max(ans, largestRectangleArea(a));
        }
        return ans;

    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = -1;
        for (int i = 0; i < heights.length; i++) {
            while (!st.empty() && heights[st.peek()] > heights[i]) {
                int area = heights[st.pop()] * (i - (st.empty() ? -1 : st.peek()) - 1);
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }
        while (!st.empty()) {
            int area = heights[st.pop()] * (heights.length - (st.empty() ? -1 : st.peek()) - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}