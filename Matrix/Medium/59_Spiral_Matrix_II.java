/**
 * Given a positive integer n, generate an n x n matrix filled with elements
 * from 1 to n2 in spiral order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 * 
 * Input: n = 1
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 20
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int ans[][] = new int[n][n];
        int val = 1;
        int minRow = 0, minCol = 0, maxRow = n - 1, maxCol = n - 1;
        for (val = 1; val <= n * n;) {
            for (int j = minCol; j <= maxCol; j++) {
                if (val > n * n)
                    return ans;
                ans[minRow][j] = val++;
            }
            minRow++;
            for (int j = minRow; j <= maxRow; j++) {
                if (val > n * n)
                    return ans;
                ans[j][maxCol] = val++;
            }
            maxCol--;
            for (int j = maxCol; j >= minCol; j--) {
                if (val > n * n)
                    return ans;
                ans[maxRow][j] = val++;
            }
            maxRow--;
            for (int j = maxRow; j >= minRow; j--) {
                if (val > n * n)
                    return ans;
                ans[j][minCol] = val++;
            }
            minCol++;
        }
        return ans;
    }
}