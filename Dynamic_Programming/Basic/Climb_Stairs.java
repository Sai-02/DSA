
/**
 * 1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
4. You are required to print the number of different paths via which you can climb to the top.
Input Format
A number n
Output Format
A number representing the number of ways to climb the stairs from 0 to top.
Question Video

  COMMENTConstraints
0 <= n <= 20
Sample Input
4
Sample Output
7
 */
import java.util.*;

public class Climb_Stairs {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int qb[] = new int[n + 1];
        // System.out.println(getStairPaths(n, qb));

        // Solution using Tabulation
        qb[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    qb[i] += qb[i - j];
                }
            }

        }
        System.out.println(qb[n]);
        scan.close();
    }

    // Solution using memoization
    public static int getStairPaths(int n, int[] qb) {
        if (n < 0)
            return 0;
        if (n == 1 || n == 0)
            return 1;
        if (qb[n] != 0) {
            return qb[n];
        }
        int p1 = getStairPaths(n - 1, qb);
        int p2 = getStairPaths(n - 2, qb);
        int p3 = getStairPaths(n - 3, qb);
        qb[n] = p1 + p2 + p3;
        return qb[n];
    }

}