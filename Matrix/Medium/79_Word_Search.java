/**
 * iven an m x n grid of characters board and a string word, return true if word
 * exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCCED"
 * Output: true
 * Example 2:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "SEE"
 * Output: true
 * Example 3:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCB"
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 * 
 * 
 * Follow up: Could you use search pruning to make your solution faster with a
 * larger board?
 * 
 * Accepted
 * 1,176,745
 * Submissions
 * 2,934,495
 */

class Solution {
    int dirs[][] = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    char c = board[i][j];
                    board[i][j] = '.';
                    if (dfs(board, i, j, word, 1))
                        return true;
                    board[i][j] = c;
                }
            }
        }
        return false;
    }

    public boolean dfs(char board[][], int i, int j, String word, int index) {
        if (index == word.length())
            return true;
        char c = board[i][j];
        board[i][j] = '.';
        for (int dir[] : dirs) {
            int row = dir[0] + i, col = dir[1] + j;
            if (0 <= row && row < board.length && 0 <= col && col < board[0].length
                    && word.charAt(index) == board[row][col]) {
                if (dfs(board, row, col, word, index + 1)) {
                    return true;
                }
            }
        }
        board[i][j] = c;
        return false;
    }
}