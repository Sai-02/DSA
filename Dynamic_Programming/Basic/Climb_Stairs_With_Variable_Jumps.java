
/**
 * 1. You are given a number n, representing the number of stairs in a
 * staircase. 2. You are on the 0th step and are required to climb to the top.
 * 3. You are given n numbers, where ith element's value represents - till how
 * far from the step you could jump to in a single move. You can of course jump
 * fewer number of steps in the move. 4. You are required to print the number of
 * different paths via which you can climb to the top. Input Format A number n
 * .. n more elements Output Format A number representing the number of ways to
 * climb the stairs from 0 to top. Question Video
 * 
 * COMMENTConstraints 0 <= n <= 20 0 <= n1, n2, .. <= 20 Sample Input 10 3 3 0 2
 * 1 2 4 2 0 0 Sample Output 5
 * 
 * 
 * Asked in Companies Related Topics
 */
import java.util.*;

public class Climb_Stairs_With_Variable_Jumps {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int jumps[] = new int[n];
        for (int i = 0; i < n; i++) {
            jumps[i] = scan.nextInt();
        }
        int qb[] = new int[n + 1];
        qb[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (jumps[i] == 0) {
                continue;
            } else {
                for (int j = 1; j <= jumps[i]; j++) {
                    if (i + j <= n) {
                        qb[i] += qb[i + j];
                    }
                }

            }

        }
        System.out.println(qb[0]);
        scan.close();
    }

}
