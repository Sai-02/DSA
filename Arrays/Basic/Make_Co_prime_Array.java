/* Given an array of N elements,
 find the minimum number of insertions to convert 
 the given array into a co-prime array pair-wise.

Input:
The first line of the input contains an integer T,
 denoting number of test cases. 
 The first line of each test case contains an integer N denoting the size of the array. 
 The second line of each test cases N space separated integers.

Output:
For each test case, print  a single line of output containing minimum no. of insertions.

Constraints:
1<=T<=100
1<=N<=100
1<=arr<=1000

Example:
Input:
2
3
2 7 28
3
5 10 20
Output:
1
2

Explanation:
Testcase 1:
Here, 1st pair = {2, 7} are co-primes( gcd(2, 7) = 1).
2nd pair = {7, 28} are not co-primes, insert 9
between them. gcd(7, 9) = 1 and gcd(9, 28) = 1.

Testcase 2:
Here, there is no pair which are co-primes.
Insert 7 between (5, 10) and 1 between (10, 20).
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Make_Co_prime_Array {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      int sum = 0;
      for (int i = 0; i < n - 1; i++) {
        int k = gcd(a[i], a[i + 1]);
        if (k != 1) {
          sum++;
        }
      }

      System.out.println(sum);
    }
  }

  public static int gcd(int a, int b) {
    if (a > b) {
      int temp = a;
      a = b;
      b = temp;
    }
    if (a == 0) {
      return b;
    }
    return gcd(b % a, a);
  }
}
