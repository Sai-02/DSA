
/**
 * 1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells
 of board such that no queen can kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - 
to calculate and print all safe configurations of n-queens. Use sample input
 and output to get more idea.

Note -> The online judge can't force you to write the function recursively but
 that is what the spirit of question is. Write recursive and not iterative logic. 
 The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
Output Format
Safe configurations of queens as suggested in sample output
Question Video

  COMMENTConstraints
1 <= n <= 10
Sample Input
4
Sample Output
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .
 */

import java.util.*;

public class N_Queens {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = 0;
            }
        }
        printNQueens(a, "", 0);
        scan.close();
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if (row == chess.length) {
            System.out.println(qsf + ".");
            return;
        }
        int n = chess.length;
        for (int i = 0; i < n; i++) {
            if (isSafe(chess, row, i)) {

                chess[row][i] = 1;
                printNQueens(chess, qsf + row + "-" + i + ", ", row + 1);
                chess[row][i] = 0;
            }
        }

    }

    public static boolean isSafe(int[][] chess, int i, int j) {
        int n = chess.length;
        int row = i, col = j;
        while (row >= 0) {
            if (chess[row][col] == 1) {
                return false;
            }
            row--;
        }
        row = i;
        while (row >= 0 && col < n) {
            if (chess[row][col] == 1) {
                return false;
            }
            row--;
            col++;
        }
        row = i;
        col = j;
        while (row >= 0 && col >= 0) {
            if (chess[row][col] == 1) {
                return false;
            }
            row--;
            col--;
        }
        return true;

    }
}