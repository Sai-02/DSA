/**
 * Given an n x n array of integers matrix, return the minimum sum of any
 * falling path through matrix.
 * 
 * A falling path starts at any element in the first row and chooses the element
 * in the next row that is either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col
 * - 1), (row + 1, col), or (row + 1, col + 1).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum as shown.
 * Example 2:
 * 
 * 
 * Input: matrix = [[-19,57],[-40,-5]]
 * Output: -59
 * Explanation: The falling path with a minimum sum is shown.
 * 
 * 
 * Constraints:
 * 
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 */
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        int ans = Integer.MAX_VALUE;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == matrix.length - 1) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] += matrix[i][j];
                    int min = dp[i + 1][j];
                    if (j + 1 < matrix[0].length)
                        min = Math.min(min, dp[i + 1][j + 1]);
                    if (j - 1 >= 0)
                        min = Math.min(min, dp[i + 1][j - 1]);
                    dp[i][j] += min;
                }
                if (i == 0)
                    ans = Math.min(ans, dp[i][j]);
            }
        }
        return ans;

    }
}