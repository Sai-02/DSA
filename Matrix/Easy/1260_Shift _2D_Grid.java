
/**
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k
 * times.
 * 
 * In one shift operation:
 * 
 * Element at grid[i][j] moves to grid[i][j + 1].
 * Element at grid[i][n - 1] moves to grid[i + 1][0].
 * Element at grid[m - 1][n - 1] moves to grid[0][0].
 * Return the 2D grid after applying shift operation k times.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * Output: [[9,1,2],[3,4,5],[6,7,8]]
 * Example 2:
 * 
 * 
 * Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * Example 3:
 * 
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * Output: [[1,2,3],[4,5,6],[7,8,9]]
 * 
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 * Accepted
 * 60,202
 * Submissions
 * 90,154
 */
import java.util.*;
// ======================================================================
//
// Using a Arraylist to store all the values and then reverse it.
//
// =====================================================================

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> list = new ArrayList<>();
        for (int a[] : grid) {
            for (int val : a)
                list.add(val);
        }
        k = k % list.size();
        reverse(list, 0, list.size() - 1);
        reverse(list, 0, k - 1);
        reverse(list, k, list.size() - 1);

        int index = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for (int a[] : grid) {
            ans.add(new ArrayList<Integer>());
            for (int i = 0; i < a.length; i++) {
                ans.get(ans.size() - 1).add(list.get(index++));
            }
        }
        return ans;

    }

    public void reverse(List<Integer> ans, int l, int r) {
        if (l < 0 || r >= ans.size())
            return;
        while (l < r) {
            int temp = ans.get(l);
            ans.set(l, ans.get(r));
            ans.set(r, temp);
            l++;
            r--;
        }
    }
}

// ===============================================================
//
// Reversing without using extra space
//
// ================================================================

class Solution1 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length, col = grid[0].length;
        k = k % (row * col);
        reverse(grid, 0, row * col - 1);
        reverse(grid, 0, k - 1);
        reverse(grid, k, row * col - 1);
        List<List<Integer>> ans = new ArrayList<>();
        for (int a[] : grid) {
            ans.add(new ArrayList<Integer>());
            for (int val : a)
                ans.get(ans.size() - 1).add(val);
        }
        return ans;
    }

    public void reverse(int[][] grid, int l, int r) {
        while (l < r) {
            int row1 = l / grid[0].length, col1 = l % grid[0].length;
            int row2 = r / grid[0].length, col2 = r % grid[0].length;
            int temp = grid[row1][col1];
            grid[row1][col1] = grid[row2][col2];
            grid[row2][col2] = temp;
            l++;
            r--;
        }
    }
}
