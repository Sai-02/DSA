/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as
 * shown.
 * Example 2:
 * 
 * Input: n = 1
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 9
 * Accepted
 * 271,791
 * Submissions
 * 387,460
 */

class Solution {
    int ans = 0;

    public int totalNQueens(int n) {
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solver(board, 0, n);
        return ans;
    }

    public void solver(char board[][], int row, int n) {
        if (row == n) {
            ans++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(board, row, j, n)) {
                board[row][j] = 'Q';
                solver(board, row + 1, n);
                board[row][j] = '.';
            }
        }

    }

    public boolean isValid(char board[][], int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q')
                return false;
        }
        int i = row - 1, j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }
        return true;
    }
}