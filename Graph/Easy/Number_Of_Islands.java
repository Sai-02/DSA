
/**
 * 1. You are given a 2d array where 0's represent land and 1's represent water.
 * Assume every cell is linked to it's north, east, west and south cell.
 * 2. You are required to find and count the number of islands.
 * 
 * Constraints
 * None
 * 
 * Format
 * Input
 * Input has been managed for you
 * 
 * Output
 * Number of islands
 * 
 * Example
 * Sample Input
 * 
 * 8
 * 8
 * 0 0 1 1 1 1 1 1
 * 0 0 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 0
 * 1 1 0 0 0 1 1 0
 * 1 1 1 1 0 1 1 0
 * 1 1 1 1 0 1 1 0
 * 1 1 1 1 1 1 1 0
 * 1 1 1 1 1 1 1 0
 * 
 * Sample Output
 * 3
 * 
 * Question Video
 * 
 * 
 */

import java.io.*;

public class Number_Of_Islands {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    traverse(arr, i, j, visited);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    public static void traverse(int arr[][], int row, int col, boolean visited[][]) {
        if (row < 0 || row >= arr.length || col < 0 || col >= arr.length || visited[row][col] || arr[row][col] == 1)
            return;
        visited[row][col] = true;
        traverse(arr, row + 1, col, visited);
        traverse(arr, row - 1, col, visited);
        traverse(arr, row, col + 1, visited);
        traverse(arr, row, col - 1, visited);
    }

}