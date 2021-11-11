
/**
 * 1. You are given a number n, representing the count of items. 2. You are
 * given n numbers, representing the values of n items. 3. You are given n
 * numbers, representing the weights of n items. 3. You are given a number
 * "cap", which is the capacity of a bag you've. 4. You are required to
 * calculate and print the maximum value that can be created in the bag without
 * overflowing it's capacity.
 * 
 * Note -> Each item can be taken 0 or 1 number of times. You are not allowed to
 * put the same item again and again. Input Format A number n v1 v2 .. n number
 * of elements w1 w2 .. n number of elements A number cap Output Format A number
 * representing the maximum value that can be created in the bag without
 * overflowing it's capacity
 */
import java.util.*;

public class Zero_One_Knapsack {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int values[] = new int[n];
        int weight[] = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            values[i] = scan.nextInt();
        }

        int capacity = scan.nextInt();
        int dp[][] = new int[n + 1][capacity + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (j < values[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - values[i - 1]] + weight[i - 1]);
                }
            }
        }
        System.out.println(dp[n][capacity]);

        scan.close();

    }
}

// ======================================================================================
//
// Explanation: https://www.youtube.com/watch?v=bUSaenttI24&ab_channel=Pepcoding
//
// ======================================================================================