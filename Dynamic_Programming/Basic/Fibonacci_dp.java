
/**
 * 
 * 1. You are given a number n.
2. You are required to print the nth element of fibonnaci sequence.

Note -> Notice precisely how we have defined the fibonnaci sequence
0th element -> 0
1st element -> 1
2nd element -> 1
3rd element -> 2
4th element -> 3
5th element -> 5
6th element -> 8
Input Format
A number n
Output Format
A number representing the nth element of fibonnaci sequence
Question Video

  COMMENTConstraints
0 <= n <= 45
Sample Input
10
Sample Output
55
 */
import java.util.*;

public class Fibonacci_dp {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int qb[] = new int[n + 1];
        System.out.println(getFib(n, qb));
        scan.close();
    }

    public static int getFib(int n, int qb[]) {
        if (n == 0 || n == 1)
            return n;
        if (qb[n] != 0)
            return qb[n];

        int fib1 = getFib(n - 1, qb);
        int fib2 = getFib(n - 2, qb);
        qb[n] = fib1 + fib2;
        return fib1 + fib2;
    }

}